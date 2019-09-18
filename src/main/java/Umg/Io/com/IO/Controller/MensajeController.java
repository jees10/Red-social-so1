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
import java.util.List;
import java.util.UUID;
import org.springframework.util.StringUtils;


@RestController
@RequestMapping(value = "/mensajes")
@Slf4j
public class MensajeController {


    @Autowired
    private MensajeRepo mensajeRepo;


    private EmitterProcessor<mensaje> notificacion;

    @PostConstruct
    private void crearNotificacion(){
        notificacion = EmitterProcessor.<mensaje>create();
    }

    @RequestMapping(
            path = "/todos",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<mensaje> findAll(){
        return mensajeRepo.findAll();
    }

    @RequestMapping(
            path = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<?>create(@RequestBody mensaje Mensaje){
            Mensaje.setCanal(UUID.randomUUID().toString());
            System.out.println("mensaje a guardar: "+Mensaje);
        mensajeRepo.save(Mensaje);
        System.out.println("Notificando nuveo Mensaje: "+Mensaje.getMensaje());
        notificacion.onNext(Mensaje);
        return new ResponseEntity<>(Mensaje, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/chats/{remitente}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<mensaje> findByRemitente(@PathVariable("remitente")String remitente){
        return mensajeRepo.findByRemitente(remitente);
    }
    
    @RequestMapping(
            path = "/recibidos/{recibidor}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<mensaje> findByRecibidor(@PathVariable("recibidor")String recibidor){
        return  mensajeRepo.findByRecibidor(recibidor);
    }

    @RequestMapping(
            path = "/chat/{canal}",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<mensaje> findByCanal(@PathVariable("canal")String canal){
        return mensajeRepo.findByCanal(canal);
    }


    private Flux<ServerSentEvent<mensaje>> getMensajeSSE(){
        return notificacion
                .log().map(
                        (mensaje -> {
                            System.out.println("Enviando Mensaje:"+mensaje.getRemitente());
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






