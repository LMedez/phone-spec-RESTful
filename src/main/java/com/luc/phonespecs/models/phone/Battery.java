package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Battery {
    @SerializedName("Type")
    private String type;
    @SerializedName("Capacity")
    private String capacity;
    @SerializedName("Life")
    private String life;
    @SerializedName("Charging Power")
    private String chargingPower;
    @SerializedName("Energy")
    private String energy;
    @SerializedName("Standby Time")
    private String standByTime;
    @SerializedName("Voltage")
    private String voltage;

}
