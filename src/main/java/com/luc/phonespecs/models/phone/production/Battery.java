package com.luc.phonespecs.models.phone.production;

import lombok.Data;

@Data
public class Battery {
    private String type;
    private String life;
    private String chargingPower;
}
