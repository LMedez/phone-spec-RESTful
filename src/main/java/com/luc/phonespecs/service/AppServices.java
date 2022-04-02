package com.luc.phonespecs.service;

import com.luc.phonespecs.models.phone.production.PhoneDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class AppServices {

    @Autowired
    private FirestoreService firestoreService;

    public List<PhoneDetails> getLatestReleases(Integer limit) {
        return firestoreService.getLatestReleases(limit);
    }

    public List<PhoneDetails> search(String query, Integer limit) {
        return firestoreService.search(query, limit);
    }

    public List<PhoneDetails> getWithBestCamera(Integer limit) {
        return firestoreService.getWithBestCamera(limit);
    }

    public List<PhoneDetails> getWithBestCameraByBrand(Integer limit, String brand) {
        return firestoreService.getWithBestCameraByBrand(limit, StringUtils.capitalize(brand));
    }
}
