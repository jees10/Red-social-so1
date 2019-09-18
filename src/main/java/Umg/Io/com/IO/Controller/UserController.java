package Umg.Io.com.IO.Controller;

import Umg.Io.com.IO.model.usuario;
import Umg.Io.com.IO.reporsitory.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public usuario saveUsuario(@Valid @RequestBody usuario usuario) {
        if (StringUtils.isEmpty(usuario.getId())) {
            usuario.setId(UUID.randomUUID().toString());
        }
        return usuarioRepo.save(usuario);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public usuario getById(@PathVariable("id") String usuarioId) {
        Optional<usuario> usuarioOpt = usuarioRepo.findById(usuarioId);
        return usuarioOpt.get();
    }

    @RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        usuarioRepo.delete(usuarioRepo.findById(id).get());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<usuario> GetAllUsers() {
        return usuarioRepo.findAll();
    }

    @RequestMapping(value = "/correo/{correo}", method = RequestMethod.GET)
    public usuario getByCorreo(@PathVariable("correo") String usuarioCorreo) {
        Optional<usuario> usuarioOpt = Optional.ofNullable(usuarioRepo.findByCorreo(usuarioCorreo));
        return usuarioOpt.get();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public usuario Lgon(usuario usuario) {
        System.out.println( usuario.getCorreo() );
        List<usuario> usuarioLogin = usuarioRepo.findByClaveAndCorreo(usuario.getClave(), usuario.getCorreo());
        if (usuarioLogin.isEmpty()) {
            return null;
        } else {
            return usuarioLogin.get(0);
        }

    }

}

