package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface MensajeRepo extends MongoRepository<mensaje,String> {
        List<mensaje> findByCanal (String canal);

}
