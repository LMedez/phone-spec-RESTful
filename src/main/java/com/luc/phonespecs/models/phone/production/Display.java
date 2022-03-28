package com.luc.phonespecs.models.phone.production;

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


}
