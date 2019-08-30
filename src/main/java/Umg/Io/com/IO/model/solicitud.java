package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class solicitud implements Serializable {

    @Id
    private String id;
    private String correo;
    private String nombreAmigo;
    private String correoAmigo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreAmigo() {
        return nombreAmigo;
    }

    public void setNombreAmigo(String nombreAmigo) {
        this.nombreAmigo = nombreAmigo;
    }

    public String getCorreoAmigo() {
        return correoAmigo;
    }

    public void setCorreoAmigo(String correoAmigo) {
        this.correoAmigo = correoAmigo;
    }
}
