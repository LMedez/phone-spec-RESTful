package com.luc.phonespecs.models.phone.phonedetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Processor {
    private String CPU;
    private String chipset;
    private String GPU;

}
