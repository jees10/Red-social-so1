package Umg.Io.com.IO.Controller;


import Umg.Io.com.IO.model.amigos;
import Umg.Io.com.IO.model.estado;
import Umg.Io.com.IO.reporsitory.AmigosRepo;
import Umg.Io.com.IO.reporsitory.EstadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepo estadoRepo;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public estado SaveEstado(@Valid @RequestBody estado Estado){
        if(StringUtils.isEmpty(Estado.getId())){
            Estado.setId(UUID.randomUUID().toString());
        }
        return estadoRepo.save(Estado);
    }

    @RequestMapping(value = "/misEstados/{correo}",method = RequestMethod.GET)
    public List<estado> MisEstados(@PathVariable("correo") String correo){
        return estadoRepo.findByCorreo(correo);

    }

    @RequestMapping(value = "/todos",method = RequestMethod.GET)
    public List<estado> findAll(){
        return estadoRepo.findAll();
    }

    @RequestMapping(value = "/amigos/{correo}",method = RequestMethod.GET)
    public List<estado> findEataods(@PathVariable("correo") String correo){

        List<estado> est = new LinkedList<>();
        List<amigos> am = findAmigos(correo);

        for(amigos a : am){

            List<estado> t = estadoRepo.findByCorreo(a.getCorreoAmigo());

            est.addAll(t);
        }

        return est;
    }


    @RequestMapping(value = "/like/{id_post}",method = RequestMethod.PUT)
    public estado likeEstado(@PathVariable("id_post") String id_post, @Valid @RequestBody estado Estados){
    Estados.setId(id_post);
    return estadoRepo.save(Estados);
    }

    @Autowired
    private AmigosRepo amigosRepo;

    public List<amigos> findAmigos(String correo){
        return amigosRepo.findByCorreo(correo);
    }
}
