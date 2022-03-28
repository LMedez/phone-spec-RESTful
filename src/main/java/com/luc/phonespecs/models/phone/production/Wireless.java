package com.luc.phonespecs.models.phone.production;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Wireless {
    private List<String> bluetooth;
    private List<String> wifi;
    private List<String> usb;
}
