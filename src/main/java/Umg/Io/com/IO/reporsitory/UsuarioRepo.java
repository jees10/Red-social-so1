package Umg.Io.com.IO.reporsitory;

import Umg.Io.com.IO.model.usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsuarioRepo extends MongoRepository<usuario, String> {

    usuario findByCorreo(String correo);
    List<usuario> findByClaveAndCorreo(String clave , String correo);

}
