package Umg.Io.com.IO.model;

import org.springframework.data.annotation.Id;


public class alumno {
    @Id
    private String id;
    private String name;
    private int carnet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
