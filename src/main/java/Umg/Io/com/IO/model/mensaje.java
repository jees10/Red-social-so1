package Umg.Io.com.IO.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class mensaje {

    @Id
    private String id;
    private String remitente;
    private String mensaje;
    private String recibidor;
    private String canal;

}
