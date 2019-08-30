package Umg.Io.com.IO.Controller;

import Umg.Io.com.IO.model.solicitud;
import Umg.Io.com.IO.reporsitory.SolicitudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudRepo solicitudRepo;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public solicitud SaveSolicitud(@Valid @RequestBody solicitud Solicitud){
        if(StringUtils.isEmpty(Solicitud.getId())){
            Solicitud.setId(UUID.randomUUID().toString());
        }
        return solicitudRepo.save(Solicitud);
    }


    @RequestMapping(value = "/borrar/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        solicitudRepo.delete(solicitudRepo.findById(id).get());
    }

    @RequestMapping(value = "/misSolicitudes/{correo}",method = RequestMethod.GET)
    public List<solicitud> ListaSolicitudes(@PathVariable("correo") String correo){
        return solicitudRepo.findByCorreo(correo);
    }

    @RequestMapping(value = "/todas",method = RequestMethod.GET)
    public List<solicitud> findAll(){
        return solicitudRepo.findAll();
    }

    @RequestMapping(value = "/enviadas/{correoAmigo}",method = RequestMethod.GET)
    public List<solicitud> findByCorreoAmigo(@PathVariable("correoAmigo")String correoAmigo){
        return solicitudRepo.findByCorreoAmigo(correoAmigo);
    }


}


