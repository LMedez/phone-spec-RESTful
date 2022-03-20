package com.luc.phonespecs.client;

import com.luc.phonespecs.models.phone.PhoneDetails;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "techSpecClient", url ="${api.tech-spec.base-url}")
public interface TechSpecClient {

    @GetMapping("/product/get/60d43a378f19b751ae35436e")
    @Headers("Content-Type: application/json")
    ResponseEntity<PhoneDetails> findUsers();
}
