package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface MensajeRepo extends MongoRepository<mensaje,String> {

    public List<mensaje> findByCanal(String canal);
    public List<mensaje> findByRemitente(String remitente);
    public List<mensaje> findByRecibidor(String recibidor);
}
