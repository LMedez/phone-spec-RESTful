package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Memory {
    private ArrayList<String> internal;
    private String cardSlot;
    private String[] ram;

    public void setInternal(String internal) {
        String[] splited = internal.split("/");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(splited[0]);
        arrayList.add(splited[1].split("\\s+")[0]);
        this.internal = arrayList;
    }

    public void setCardSlot(String cardSlot) {
        String[] splited = cardSlot.split("\\(");
        this.cardSlot = splited[0].replaceAll(" ", "");
    }

    public void setRam(String ram) {
        String[] splited = ram.split(",");
        ArrayList<String> splited2 = new ArrayList<>();
        for (String s : splited) {
            if (s.startsWith(" "))
                splited2.add(s.replaceFirst(" ", "").split("\\s+")[1]);
            else
                splited2.add(s.split("\\s+")[1]);
        }

        this.ram = splited2.stream().distinct().toArray(String[]::new);
    }
}
