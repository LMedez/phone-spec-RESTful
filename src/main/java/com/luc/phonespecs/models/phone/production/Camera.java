package com.luc.phonespecs.models.phone.production;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Camera {
    private List<String> features;
    private List<String> video;
    private List<String> mp;

}
