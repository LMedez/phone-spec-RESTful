package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Wireless {
    private String[] bluetooth;
    private String[] wifi;
    private String[] usb;

    public void setWifi(String wifi) {
        String wifi2 = wifi.replaceAll(" ","");
        this.wifi = wifi2.split(",");
    }

    public void setBluetooth(String bluetooth) {
        String bluetooth2 = bluetooth.replaceAll(" ","");
        this.bluetooth = bluetooth2.split(",");
    }

    public void setUsb(String usb) {
        String usb2 = usb.replaceAll(" ","");
        this.usb = usb2.split(",");
    }
}
