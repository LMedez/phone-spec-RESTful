package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Display {

    private String diagonal;
    private String height;
    private String width;
    private String screenToBodyRatio;
    private String refreshRate;
    private String resolution;
    private String pixelDensity;
}
