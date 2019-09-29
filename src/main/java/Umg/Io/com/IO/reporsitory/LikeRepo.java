package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepo extends MongoRepository<like,String> {

    List<like> findByidEstado(String idEstado);
}
