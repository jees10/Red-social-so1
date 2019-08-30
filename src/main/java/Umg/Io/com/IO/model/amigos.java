package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class amigos implements Serializable {

    @Id
    private String id;
    private String amigo;
    private String correoAmigo;
    private String correo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmigo() {
        return amigo;
    }

    public void setAmigo(String amigo) {
        this.amigo = amigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreoAmigo() {
        return correoAmigo;
    }

    public void setCorreoAmigo(String correoAmigo) {
        this.correoAmigo = correoAmigo;
    }
}
