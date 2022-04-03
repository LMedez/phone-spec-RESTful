package com.luc.phonespecs.models.phone.development;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Memory {
    private ArrayList<String> internal;
    private String cardSlot;
    private List<String> ram;

    public void setInternal(String internal) {
        String[] splited = internal.split("/");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(splited[0]);
        if (splited.length > 1)
            arrayList.add(splited[1].split("\\s+")[0]);
        this.internal = arrayList;
    }

    public void setCardSlot(String cardSlot) {
        String[] splited = cardSlot.split("\\(");
        this.cardSlot = splited[0].replaceAll(" ", "");
    }

    public void setRam(String ram) {
        if (ram.contains("(")) return;
        String[] splited = ram.split(",");
        ArrayList<String> splited2 = new ArrayList<>();
        for (String s : splited) {
            if (s.startsWith(" ") && s.replaceFirst(" ", "").split("\\s+").length > 1)
                splited2.add(s.replaceFirst(" ", "").split("\\s+")[1]);
            else if (splited2.size() > 1)
                splited2.add(s.split("\\s+")[1]);
        }

        this.ram = splited2.stream().distinct().collect(Collectors.toList());
    }
}
