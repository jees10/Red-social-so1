package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;

public class like {

    @Id
    private String id;
    private String idEstado;
    private String correo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
