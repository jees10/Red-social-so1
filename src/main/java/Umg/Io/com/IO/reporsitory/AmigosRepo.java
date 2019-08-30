package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.amigos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface AmigosRepo extends MongoRepository<amigos,String> {

    List<amigos> findByCorreo(String correo);
    List<amigos> findByCorreoAndCorreoAmigo(String correo,String correoAmigo);



}
