package Umg.Io.com.IO.Controller;

import Umg.Io.com.IO.model.mensaje;
import Umg.Io.com.IO.reporsitory.MensajeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;


import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/mensajes")
@Slf4j
public class MensajeController {

    @Autowired
    private MensajeRepo mensajeRepo;

    public static List<mensaje> listaMensajes = new ArrayList<>();
    private EmitterProcessor<mensaje> notificacion;

    @PostConstruct
    private void crearNotificacion(){ notificacion = EmitterProcessor.<mensaje>create();}


    @RequestMapping(
            path = "/all",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<mensaje> findAll(){
        return mensajeRepo.findAll();
    }

    @RequestMapping(
            path = "/chat/{canal}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<mensaje>findByCanal(@PathVariable("canal") String canal){
        return  mensajeRepo.findByCanal(canal);
    }

    @RequestMapping(
            path = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<?>create(@RequestBody mensaje Mensaje){
        mensajeRepo.save(Mensaje);
        listaMensajes.add(Mensaje);
        System.out.println("notificando Mensaje"+Mensaje.getMensaje());
        notificacion.onNext(Mensaje);
        return new ResponseEntity<>(Mensaje,HttpStatus.OK);
    }

    private Flux<ServerSentEvent<mensaje>> getMensajeSSE(){
        return notificacion
                .log().map(
                        (mensaje -> {
                            System.out.println("enviando Mensaje"+mensaje.getRemitente());
                            return ServerSentEvent.<mensaje>builder()
                                    .id(UUID.randomUUID().toString())
                                    .event("mensaje-result")
                                    .data(mensaje)
                                    .build();
                        })
                ).concatWith(Flux.never());
    }

    private Flux<ServerSentEvent<mensaje>> getNotificationHeartbeat() {
        return Flux.interval(Duration.ofSeconds(15))
                .map(i -> {
                    System.out.println(String.format("sending heartbeat [%s] ...", i.toString()));
                    return ServerSentEvent.<mensaje>builder()
                            .id(String.valueOf(i))
                            .event("heartbeat-result")
                            .data(null)
                            .build();
                });
    }

    @GetMapping(
            value = "/notification/sse"
    )
    public Flux<ServerSentEvent<mensaje>> getJobResultNotification() {

        return Flux.merge(getNotificationHeartbeat(), getMensajeSSE());

    }





}
