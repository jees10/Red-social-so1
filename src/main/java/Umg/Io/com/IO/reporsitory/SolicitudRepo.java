package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.solicitud;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SolicitudRepo extends MongoRepository<solicitud,String> {

    List<solicitud> findByCorreo(String correo);
    List<solicitud> findByCorreoAmigo(String correoAmigo);
}
