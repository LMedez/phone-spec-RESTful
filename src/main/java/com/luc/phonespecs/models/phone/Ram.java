package com.luc.phonespecs.models.phone;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ram {

    @SerializedName("Module")
    private String module;
    @SerializedName("Capacity")
    private String capacity;
    @SerializedName("Type")
    private String type;
    @SerializedName("Clock Speed")
    private String clockSpeed;
}
