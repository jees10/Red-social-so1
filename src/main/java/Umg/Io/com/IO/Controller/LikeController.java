package Umg.Io.com.IO.Controller;

import Umg.Io.com.IO.model.like;
import Umg.Io.com.IO.reporsitory.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/like")
public class  LikeController {

    @Autowired
    private LikeRepo likeRepo;


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public like saveLike(@Valid @RequestBody like Like){
        return likeRepo.save(Like);
    }

    @RequestMapping(value = "/likes/{idEstado}",method = RequestMethod.GET)
    public List<like> listaLikes(@PathVariable("idEstado") String idEstado){
        return likeRepo.findByidEstado(idEstado);
    }
}
