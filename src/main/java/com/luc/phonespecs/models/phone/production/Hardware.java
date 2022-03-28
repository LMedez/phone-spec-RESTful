package com.luc.phonespecs.models.phone.production;

import lombok.Data;

@Data
public class Hardware {
    private Processor processor;
    private Battery battery;
    private Memory memory;
}
