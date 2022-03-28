package com.luc.phonespecs.controller;

import com.luc.phonespecs.client.TechSpecClient;
import com.luc.phonespecs.models.phone.*;
import com.luc.phonespecs.models.phone.development.PhoneDetails;
import com.luc.phonespecs.service.FirestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
        //firestoreService.saveBrand(techSpecClient.getAllBrands().getBody().getPhoneBrands());

        return ResponseEntity.ok(techSpecClient.getAllBrands().getBody());
    }

    /*
    * All insert data in Firestore will be removed after added all phones data
    *
    * */
    @GetMapping("brands/{slugName}")
    public ResponseEntity<Integer> getAllBrandPhones(@PathVariable String slugName, @RequestParam(required = false) String page) {
        List<String> brands = new ArrayList<>();
        brands.add("Acer");
        brands.add("Amazon");
        brands.add("Apple");
        brands.add("Asus");
        brands.add("BenQ");
        brands.add("BlackBerry");
        brands.add("Cat");
        brands.add("Dell");
        brands.add("Energizer");
        brands.add("Ericsson");
        brands.add("Gigabyte");
        brands.add("Google");
        brands.add("HP");
        brands.add("HTC");
        brands.add("Huawei");
        brands.add("Icemobile");
        brands.add("LG");
        brands.add("Microsoft");
        brands.add("Motorola");
        brands.add("Nokia");
        brands.add("Panasonic");
        brands.add("Philips");
        brands.add("Realme");
        brands.add("Samsung");
        brands.add("Siemens");
        brands.add("Sony");
        brands.add("Siemens");
        brands.add("Sony Ericsson");
        brands.add("Spice");
        brands.add("T-Mobile");
        brands.add("TCL");
        brands.add("vivo");
        brands.add("Vodafone");
        brands.add("Xiaomi");
        brands.add("ZTE");

        List<PhoneDetails> phoneDetails = new ArrayList<>();

        ObjectWrapper objectWrapper = techSpecClient.getAllPhoneBrand(slugName, page).getBody();
        objectWrapper.getDataWrapper().getBrandPhones().forEach(brandPhones -> {
            phoneDetails.add(techSpecClient.getPhoneDetail(brandPhones.getSlug()).getBody());
        });

        //firestoreService.addPhoneDetail(phoneDetails);
        return ResponseEntity.ok(phoneDetails.size());
    }


    @GetMapping("brands/firestore")
    public ResponseEntity<PhoneBrandWrapper> getAllPhoneBrandsForFirestore() throws ExecutionException, InterruptedException {

        return ResponseEntity.ok(new PhoneBrandWrapper(firestoreService.getAllBrands()));
    }


}
