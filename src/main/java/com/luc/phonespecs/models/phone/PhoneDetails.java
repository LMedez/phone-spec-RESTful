package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;
import com.luc.phonespecs.models.utils.PhoneDetailDeserializer;
import lombok.Data;

import java.util.List;

@Data
@JsonDeserialize(using = PhoneDetailDeserializer.class)
public class PhoneDetails {
    private String id;
    private Camera frontCamera;
    private Camera backCamera;
    private String brand;
    private String model;
    private String released;
    private String version;
    private Software software;
    private Hardware hardware;
    private Image image;
    private int[] price;
    private Ports ports;
    private Audio audio;
    private Design design;
    private Display display;

}
