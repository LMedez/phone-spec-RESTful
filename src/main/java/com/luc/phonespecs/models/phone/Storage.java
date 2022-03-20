package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Storage {
    @SerializedName("Capacity")
    private String capacity;
    @SerializedName("Type")
    private String type;
    @SerializedName("Bus Speed")
    private String busSpeed;
    @SerializedName("Expansion")
    private String expansion;
}
