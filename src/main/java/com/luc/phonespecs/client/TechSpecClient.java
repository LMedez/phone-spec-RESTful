package com.luc.phonespecs.client;

import com.luc.phonespecs.models.phone.PhoneDetails;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@FeignClient(name = "techSpecClient", url ="https://api-mobilespecs.azharimm.site/v2/")
public interface TechSpecClient {

    @GetMapping("samsung_galaxy_a72-10469")
    ResponseEntity<PhoneDetails> findUsers();
}
