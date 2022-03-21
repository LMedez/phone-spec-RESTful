package com.luc.phonespecs.controller;

import com.luc.phonespecs.client.TechSpecClient;
import com.luc.phonespecs.models.phone.PhoneDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class TechSpecApiController {

    @Autowired
    private TechSpecClient techSpecClient;

    @GetMapping("phones")
    public ResponseEntity<PhoneDetails> getPhones() {
        return ResponseEntity.ok(techSpecClient.findUsers().getBody());
    }
}
