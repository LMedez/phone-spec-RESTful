package com.luc.phonespecs.models.phone.development;

import lombok.Data;

@Data
public class Audio {
    private String output = "3.5mm jack";
    private boolean hasOutput;

    public void setHasOutput(String hasOutput) {
        this.hasOutput = hasOutput.startsWith("Y");

    }
}
