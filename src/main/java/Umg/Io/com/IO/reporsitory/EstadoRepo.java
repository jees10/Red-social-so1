package Umg.Io.com.IO.reporsitory;


import Umg.Io.com.IO.model.estado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstadoRepo extends MongoRepository<estado,String> {

    List<estado> findByCorreo(String correo);

}
