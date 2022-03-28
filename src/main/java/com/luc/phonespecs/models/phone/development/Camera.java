package com.luc.phonespecs.models.phone.development;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Camera {
    private List<String> features;
    private List<String> video;
    private List<String> mp;

    public void setFeatures(String features) {
        String features2 = features.replaceAll(" ", "");
        this.features = new ArrayList<>(Arrays.asList(features2.split(",")));
    }

    public void setVideo(String video) {
        String videoSplited = video.replaceAll(" ", "");
        if (video.contains(";"))
            videoSplited = video.replace(";", ",").replaceAll(" ", "");
        this.video = new ArrayList<>(Arrays.asList(videoSplited.split(",")));
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
