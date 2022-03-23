package com.luc.phonespecs.client;

import com.luc.phonespecs.models.phone.DataWrapper;
import com.luc.phonespecs.models.phone.ObjectWrapper;
import com.luc.phonespecs.models.phone.PhoneBrand;
import com.luc.phonespecs.models.phone.PhoneBrandWrapper;
import com.luc.phonespecs.models.phone.phonedetail.PhoneDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@FeignClient(name = "techSpecClient", url ="https://api-mobilespecs.azharimm.site/v2/")
public interface TechSpecClient {

    @GetMapping("huawei_nova_8_5g-10645")
    ResponseEntity<PhoneDetails> findUsers();

    @GetMapping("brands")
    ResponseEntity<PhoneBrandWrapper> getAllBrands();

    @GetMapping(path = "brands/{brandSlug}")
    ResponseEntity<ObjectWrapper> getAllPhoneBrand(@PathVariable String brandSlug, @RequestParam(required = false) String page);

    @GetMapping(path = "{slug}")
    ResponseEntity<PhoneDetails> getPhoneDetail(@PathVariable String slug);

    /*@GetMapping("phones")
    ResponseEntity<PhoneBrandWrapper> getAllPhoneByBrand(@RequestParam );*/
}
