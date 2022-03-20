package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Software {
    @SerializedName("OS")
    private String OS;
    @SerializedName("OS Version")
    private String OSVersion;
    @SerializedName("Kernel Version")
    private String kernelVersion;
}
