package com.sametakgul.custom_anotation.controller;

import com.sametakgul.custom_anotation.anotation.HasRole;
import com.sametakgul.custom_anotation.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    @HasRole(role = "USER")
    public String getUser(@RequestParam Long id) {
        return "Kullanıcı ID: " + id;
    }

    @GetMapping("/admin")
    @HasRole(role = "ADMIN", required = true)
    public String getAdmin(@RequestParam Long id) {
        try {
            return "Admin ID: " + id;
        } catch (Exception e) {
            throw new CustomException("Bir hata oluştu: " + e.getMessage());
        }
    }
}