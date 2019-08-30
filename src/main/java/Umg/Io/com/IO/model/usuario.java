package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;

public class usuario implements Serializable {

    @Id
    private String id;
    private String nombre;
    private String correo;
    private String clave;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {{}
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


}
