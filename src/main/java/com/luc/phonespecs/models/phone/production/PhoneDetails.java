package com.luc.phonespecs.models.phone.production;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PhoneDetails {
    private String thumbnail;
    private String name;
    private String dimension;
    private ArrayList<String> phoneImages;
    private Camera frontCamera;
    private Camera backCamera;
    private Wireless wireless;
    private String brand;
    private List<String> models;
    private Date released;
    private Software software;
    private Hardware hardware;
    private List<String> price;
    private Audio audio;
    private Display display;
    private String weight;
}
