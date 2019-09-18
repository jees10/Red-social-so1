package Umg.Io.com.IO.Controller;

import Umg.Io.com.IO.model.amigos;
import Umg.Io.com.IO.reporsitory.AmigosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/amigos")
public class AmigosController {

    @Autowired
    private AmigosRepo amigosRepo;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public amigos saveAmigos(@Valid @RequestBody amigos amigos) {
        if (StringUtils.isEmpty(amigos.getId())) {
            amigos.setId(UUID.randomUUID().toString());
        }
        return amigosRepo.save(amigos);
    }

    @RequestMapping(value = "/lista/{correo}", method = RequestMethod.GET)
    public List<amigos> ListaAmigos(@PathVariable ("correo") String amigosCorreo){
        return amigosRepo.findByCorreo(amigosCorreo);
    }

    @RequestMapping(value = "/buscador/{correo}/{correoAmigo}",method = RequestMethod.GET)
    public List<amigos> Buscados(@PathVariable ("correo") String amigosCorreo, @PathVariable("correoAmigo") String correoAmigo){
        return amigosRepo.findByCorreoAndCorreoAmigo(amigosCorreo,correoAmigo);
    }

    @RequestMapping(value ="/borrar/{id}",method = RequestMethod.DELETE)
    public void borrarAmigo(@PathVariable String id){
        amigosRepo.delete(amigosRepo.findById(id).get());
    }






}
