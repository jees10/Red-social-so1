package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlumnoRepo extends MongoRepository<alumno,String> {
}
