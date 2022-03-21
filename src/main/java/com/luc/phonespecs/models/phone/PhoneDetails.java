package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.luc.phonespecs.models.utils.PhoneDetailDeserializer;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;

@Data
@JsonDeserialize(using = PhoneDetailDeserializer.class)
public class PhoneDetails {
    static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private String id;
    private Camera frontCamera;
    private Camera backCamera;
    private String brand;
    private String model;
    private Date released;
    private String version;
    private Software software;
    private Hardware hardware;
    private Image image;
    private int[] price;
    private Ports ports;
    private Audio audio;
    private Design design;
    private Display display;

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
