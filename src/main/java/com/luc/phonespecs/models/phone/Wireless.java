package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wireless {
    @SerializedName("Bluetooth Version")
    private String bluetoothVersion;
    @SerializedName("WiFi")
    private String wifi;
}
