package com.luc.phonespecs.controller;

import com.luc.phonespecs.auth.models.User;
import com.luc.phonespecs.exceptions.ResourceNotFoundException;
import com.luc.phonespecs.models.phone.production.PhoneDetails;
import com.luc.phonespecs.service.AppServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/v1")
public class AppController {

    @Autowired
    private AppServices appServices;


    @GetMapping("latest-releases")
    public ResponseEntity<List<PhoneDetails>> latestReleases(@RequestParam(required = false) Integer limit) {
        int phonesLimit = 20;
        if (limit != null) {
            phonesLimit = limit;
        }

        return ResponseEntity.ok(appServices.getLatestReleases(phonesLimit));
    }

    @GetMapping("search")
    public ResponseEntity<List<PhoneDetails>> search(@RequestParam String query, @RequestParam(required = false) Integer limit) {
        int phonesLimit = 20;
        if (limit != null) {
            phonesLimit = limit;
        }

        return ResponseEntity.ok(appServices.search(query, phonesLimit));
    }

    @GetMapping("best-camera")
    public ResponseEntity<List<PhoneDetails>> withBestCamera(@RequestParam(required = false) Integer limit, @RequestParam(required = false) String brand) {
        int phonesLimit = 20;
        if (limit != null) {
            phonesLimit = limit;
        }

        if (brand != null) {
            return ResponseEntity.ok(appServices.getWithBestCameraByBrand(phonesLimit, brand));
        }

        return ResponseEntity.ok(appServices.getWithBestCamera(phonesLimit));
    }

}