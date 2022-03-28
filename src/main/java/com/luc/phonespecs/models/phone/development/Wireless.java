package com.luc.phonespecs.models.phone.development;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Wireless {
    private List<String> bluetooth;
    private List<String> wifi;
    private List<String> usb;

    public void setWifi(String wifi) {
        String wifi2 = wifi.replaceAll(" ","");
        this.wifi = new ArrayList<>(Arrays.asList(wifi2.split(",")));
    }

    public void setBluetooth(String bluetooth) {
        String bluetooth2 = bluetooth.replaceAll(" ","");
        this.bluetooth =new ArrayList<>(Arrays.asList(bluetooth2.split(",")));
    }

    public void setUsb(String usb) {
        String usb2 = usb.replaceAll(" ","");
        this.usb = new ArrayList<>(Arrays.asList(usb2.split(",")));
    }
}
