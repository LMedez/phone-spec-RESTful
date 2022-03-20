package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Processor {
    @SerializedName("CPU")
    private String CPU;
    @SerializedName("CPU Clock Speed")
    private String CPUClockSpeed;
    @SerializedName("GPU")
    private String GPU;
    @SerializedName("GPU Clock Speed")
    private String GPUClockSpeed;
    @SerializedName("GPU Dedicated Memory")
    private String GPUDedicatedMemory;
}
