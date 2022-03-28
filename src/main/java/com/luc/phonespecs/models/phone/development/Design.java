package com.luc.phonespecs.models.phone.development;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Design {

    private String height;
    private String width;
    private String thickness;
    private String weight;
    private String[] colors;
}
