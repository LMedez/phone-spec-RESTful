package com.luc.phonespecs.client;

import com.luc.phonespecs.models.phone.PhoneBrand;
import com.luc.phonespecs.models.phone.PhoneBrandWrapper;
import com.luc.phonespecs.models.phone.phonedetail.PhoneDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient(name = "techSpecClient", url ="https://api-mobilespecs.azharimm.site/v2/")
public interface TechSpecClient {

    @GetMapping("huawei_nova_8_5g-10645")
    ResponseEntity<PhoneDetails> findUsers();

    @GetMapping("brands")
    ResponseEntity<PhoneBrandWrapper> getAllPhoneBrand();
}
