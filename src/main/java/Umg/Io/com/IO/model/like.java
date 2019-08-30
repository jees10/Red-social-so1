package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;

public class like {

    @Id
    private String id;
    private String id_estado;
    private String correo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
