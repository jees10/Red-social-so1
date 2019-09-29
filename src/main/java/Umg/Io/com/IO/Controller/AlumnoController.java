package Umg.Io.com.IO.Controller;

import Umg.Io.com.IO.model.alumno;
import Umg.Io.com.IO.reporsitory.AlumnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoRepo alumnoRepo;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public alumno saveAmigos(@Valid @RequestBody alumno alumno) {
        if (StringUtils.isEmpty(alumno.getId())) {
            alumno.setId(UUID.randomUUID().toString());
        }
        return alumnoRepo.save(alumno);
    }

    @RequestMapping(value = "lista",method = RequestMethod.GET)
    public List<alumno> findall(){
        return  alumnoRepo.findAll();
    }



}
