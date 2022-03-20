package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Ports {
    private String USBType;
    private String USBVersion;
    private String modem;
    private String ethernet;
}
