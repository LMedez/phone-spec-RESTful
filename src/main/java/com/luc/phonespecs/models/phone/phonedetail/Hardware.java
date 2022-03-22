package com.luc.phonespecs.models.phone.phonedetail;

import lombok.Data;

@Data
public class Hardware {
    private Processor processor;
    private Battery battery;
    private Memory memory;
}
