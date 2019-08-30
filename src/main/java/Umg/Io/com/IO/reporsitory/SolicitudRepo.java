package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.solicitud;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SolicitudRepo extends MongoRepository<solicitud,String> {

    List<solicitud> findByCorreo(String correo);
    List<solicitud> findByCorreoAmigo(String correoAmigo);
}
