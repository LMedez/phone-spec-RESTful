package com.luc.phonespecs.models.phone.phonedetail;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Camera {
    private String[] features;
    private String[] video;
    private ArrayList<String> mp;

    public void setFeatures(String features) {
        String features2 = features.replaceAll(" ","");
        this.features = features2.split(",");
    }

    public void setVideo(String video) {
        String videoSplited = video.replaceAll(" ","");
        if (video.contains(";"))
            videoSplited = video.replace(";", ",").replaceAll(" ","");
        this.video = videoSplited.split(",");
    }

    public void setMp(String mp) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] splited = mp.split("\n");
        for (String s : splited) {
            arrayList.add(s.split(",")[0]);
        }
        this.mp = arrayList;
    }

}
