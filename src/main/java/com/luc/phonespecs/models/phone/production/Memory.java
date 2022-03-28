package com.luc.phonespecs.models.phone.production;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Memory {
    private ArrayList<String> internal;
    private String cardSlot;
    private List<String> ram;


}
