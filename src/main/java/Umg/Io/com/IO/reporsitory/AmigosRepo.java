package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.amigos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmigosRepo extends MongoRepository<amigos,String> {

    List<amigos> findByCorreo(String correo);
    List<amigos> findByCorreoAndCorreoAmigo(String correo,String correoAmigo);



}
