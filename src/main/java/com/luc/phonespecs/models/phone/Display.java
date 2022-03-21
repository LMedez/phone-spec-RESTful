package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Display {

    private String type;
    private String hz;
    private String aspectRatio;
    private String inch;
    private int ppi;
    private String resolution;


    public void setInch(String inch) {
        String[] splited = inch.split("\\s+");
        this.inch = splited[0];
    }

    public void setHz(String hz) {
        String[] splited = hz.split(",");

        this.hz = splited[1].replaceAll(" ","");
    }

    public void setType(String type) {
        if(type.isEmpty()) return;
        String[] splited = type.split(",");
        this.type = splited[0];
    }

    public void setAspectRatio(String aspectRatio) {
        if(aspectRatio.isEmpty()) return;
        String[] splited = aspectRatio.split(",");
        this.aspectRatio = splited[1].split("\\s+")[1];
    }

    public void setPpi(String ppi) {
        String[] splited = ppi.split("~");
        this.ppi = Integer.parseInt(splited[1].split("\\s+")[0]);
    }

    public void setResolution(String resolution) {
        if(resolution.isEmpty()) return;
        String[] splited = resolution.split(",");
        this.resolution = splited[0];
    }
}
