package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hardware {
    private Ram ram;
    private Processor processor;
    private Battery battery;
    private Storage storage;
    private Wireless wireless;
}
