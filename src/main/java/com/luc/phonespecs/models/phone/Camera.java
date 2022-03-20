package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Camera {
    @SerializedName("Resolution")
    private String resolution;
    @SerializedName("Video Resolution")
    private String videoResolution;
    @SerializedName("Zoom")
    private String zoom;
    @SerializedName("Flash")
    private String flash;
    @SerializedName("Image Format")
    private String imageFormat;
}
