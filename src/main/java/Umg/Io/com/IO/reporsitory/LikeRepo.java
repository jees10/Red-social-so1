package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepo extends MongoRepository<like,String> {
}
