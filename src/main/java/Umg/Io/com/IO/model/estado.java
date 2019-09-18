package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;

public class estado {

     @Id
     private String id;
     private String correo;
     private String imagen;
     private String texto;
     private int like;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public estado(String id, String correo, String imagen, String texto, int like) {
        this.id = id;
        this.correo = correo;
        this.imagen = imagen;
        this.texto = texto;
        this.like = like;
    }
}
