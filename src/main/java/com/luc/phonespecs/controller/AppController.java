package com.luc.phonespecs.controller;

import com.luc.phonespecs.auth.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AppController {

    @GetMapping(path = "/test")
    public ResponseEntity<User> test(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }
}