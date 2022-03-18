package com.luc.phonespecs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/")
public class AppController {

    @GetMapping(path = "/test")
    public String test(Principal principal) {
        return principal.getName();
    }
}