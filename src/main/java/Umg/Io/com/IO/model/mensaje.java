package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;

public class mensaje {

    @Id
    private String id;
    private String remitente;
    private String mensaje;
    private String recibidor;
    private String canal;

    public mensaje(String id, String remitente, String mensaje, String recibidor, String canal) {
        this.id = id;
        this.remitente = remitente;
        this.mensaje = mensaje;
        this.recibidor = recibidor;
        this.canal = canal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRecibidor() {
        return recibidor;
    }

    public void setRecibidor(String recibidor) {
        this.recibidor = recibidor;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }
}
