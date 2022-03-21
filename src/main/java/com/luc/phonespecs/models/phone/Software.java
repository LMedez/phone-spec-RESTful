package com.luc.phonespecs.models.phone;

import lombok.Data;

@Data
public class Software {
    private String OS;
    private String osVersion;

    public void setOS(String OS) {
        String[] splited = OS.split("\\s+");
        this.OS = splited[0];
    }

    public void setOsVersion(String osVersion) {
        String[] splited = osVersion.split("\\s+");
        this.osVersion = splited[1];
    }
}
