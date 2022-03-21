package com.luc.phonespecs.models.phone;

import lombok.Data;

@Data
public class Battery {
    private String type;
    private String life;
    private String chargingPower;

    public void setLife(String life) {
        String s = life.replace("\\n","");
        String[] splited = s.split(" ");
        this.life = splited[2].replaceAll("\n","");
    }
}
