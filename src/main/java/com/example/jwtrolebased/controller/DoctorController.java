package com.example.jwtrolebased.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {

    @GetMapping
    @PreAuthorize("hasAuthority('doctor:read')")
    public String get(){
        return "GET:: doctor Controller";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('doctor:create')")
    public String post(){
        return "POST:: doctor Controller";
    }

    @PutMapping
    @PreAuthorize("hasAuthority('doctor:update')")
    public String put(){
        return "PUT:: doctor Controller";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('doctor:delete')")
    public String delete(){
        return "DELETE:: doctor Controller";
    }

}
