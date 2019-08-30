package Umg.Io.com.IO.reporsitory;


import Umg.Io.com.IO.model.estado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EstadoRepo extends MongoRepository<estado,String> {

    List<estado> findByCorreo(String correo);

}
