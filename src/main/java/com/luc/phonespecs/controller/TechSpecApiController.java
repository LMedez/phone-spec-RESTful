package com.luc.phonespecs.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luc.phonespecs.client.TechSpecClient;
import com.luc.phonespecs.models.phone.BrandPhones;
import com.luc.phonespecs.models.phone.DataWrapper;
import com.luc.phonespecs.models.phone.PhoneBrand;
import com.luc.phonespecs.models.phone.PhoneBrandWrapper;
import com.luc.phonespecs.models.phone.phonedetail.PhoneDetails;
import com.luc.phonespecs.service.FirestoreService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/v1/")
public class TechSpecApiController {

    @Autowired
    private TechSpecClient techSpecClient;

    @Autowired
    private FirestoreService firestoreService;

    @GetMapping("phones")
    public ResponseEntity<PhoneDetails> getPhones() {
        return ResponseEntity.ok(techSpecClient.findUsers().getBody());
    }

    @GetMapping("brands")
    public ResponseEntity<PhoneBrandWrapper> getAllPhoneBrands() throws ExecutionException, InterruptedException {
        firestoreService.saveBrand(techSpecClient.getAllBrands().getBody().getPhoneBrands());
        return ResponseEntity.ok(techSpecClient.getAllBrands().getBody());
    }

    @GetMapping("brands/{slugName}")
    public ResponseEntity<List<BrandPhones>> getAllBrandPhones(@PathVariable String slugName) {

        DataWrapper phoneBrandWrapper = techSpecClient.getAllPhoneBrand(slugName).getBody().getDataWrapper();
        List<PhoneDetails> phoneDetails = new ArrayList<>();
        phoneBrandWrapper.getBrandPhones().forEach(brandPhones -> {
            phoneDetails.add(techSpecClient.getPhoneDetail(brandPhones.getSlug()).getBody());
        });
        firestoreService.addPhoneDetail(phoneDetails);
        return ResponseEntity.ok(phoneBrandWrapper.getBrandPhones());
    }


    @GetMapping("brands/firestore")
    public ResponseEntity<PhoneBrandWrapper> getAllPhoneBrandsForFirestore() throws ExecutionException, InterruptedException {

        return ResponseEntity.ok(new PhoneBrandWrapper(firestoreService.getAllBrands()));
    }


}
