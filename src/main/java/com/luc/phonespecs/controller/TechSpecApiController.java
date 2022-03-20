package com.luc.phonespecs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.luc.phonespecs.client.TechSpecClient;
import com.luc.phonespecs.models.phone.PhoneDetails;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
