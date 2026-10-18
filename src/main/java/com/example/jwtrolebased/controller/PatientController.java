package com.example.jwtrolebased.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/v1/patient")
@PreAuthorize("hasRole('PATIENT')")
public class PatientController {

    @GetMapping
    @PreAuthorize("hasAuthority('patient:read')")
    public String get(){
        return "GET:: patient Controller";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('patient:create')")
    public String post(){
        return "POST:: patient Controller";
    }

    @PutMapping
    @PreAuthorize("hasAuthority('patient:update')")
    public String put(){
        return "PUT:: patient Controller";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('patient:delete')")
    public String delete(){
        return "DELETE:: patient Controller";
    }

}
