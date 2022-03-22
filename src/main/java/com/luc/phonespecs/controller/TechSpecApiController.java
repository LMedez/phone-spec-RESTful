package com.luc.phonespecs.controller;

import com.luc.phonespecs.client.TechSpecClient;
import com.luc.phonespecs.models.phone.PhoneBrandWrapper;
import com.luc.phonespecs.models.phone.phonedetail.PhoneDetails;
import com.luc.phonespecs.service.FirestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
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
    public ResponseEntity<PhoneBrandWrapper> getAllPhoneBrands() {
        firestoreService.saveBrand(techSpecClient.getAllPhoneBrand().getBody().getPhoneBrands());
        return ResponseEntity.ok(techSpecClient.getAllPhoneBrand().getBody());
    }

    @GetMapping("brands/firestore")
    public ResponseEntity<PhoneBrandWrapper> getAllPhoneBrandsForFirestore() throws ExecutionException, InterruptedException {

        return ResponseEntity.ok(new PhoneBrandWrapper(firestoreService.getAllBrands()));
    }


}
