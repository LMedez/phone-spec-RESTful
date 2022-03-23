package com.luc.phonespecs.models.phone.phonedetail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.luc.phonespecs.models.utils.PhoneDetailDeserializer;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@JsonDeserialize(using = PhoneDetailDeserializer.class)
public class PhoneDetails {
    static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

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

    public void setDimension(String dimension) {
        this.dimension = dimension.split("\\(")[0];
    }

    public void setWeight(String weight) {
        this.weight = weight.split("\\(")[0];
    }

    public void setPrice(String price) {
        if (price.contains("About")) return;
        String price2 = price.replaceAll(" ", "");
        this.price = new ArrayList<>(Arrays.asList(price2.split("/")));
    }

    public void setModels(String models) {
        String models2 = models.replaceAll(" ","");
        this.models = new ArrayList<>(Arrays.asList(models2.split(",")));
    }

    public void setReleased(String released) {
        try {
            String announcedClear = released.replaceAll("[^a-zA-Z0-9] ", " ");
            String[] announcedSplit = announcedClear.split(" ");
            String finalAnnounced = announcedSplit[0] + "-" + getMonthNumber(announcedSplit[1]) + "-" + announcedSplit[2];
            this.released = format.parse(finalAnnounced);
        }catch (Exception e) {

        }
    }

    private String getMonthNumber(String monthName) {
        String montValue = String.valueOf(Month.valueOf(monthName.toUpperCase()).getValue());
        if (montValue.length() == 1) montValue = "0" + montValue;
        return montValue;
    }
}
