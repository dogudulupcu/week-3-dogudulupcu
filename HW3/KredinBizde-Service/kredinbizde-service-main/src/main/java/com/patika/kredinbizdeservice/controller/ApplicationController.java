package com.patika.kredinbizdeservice.controller;


import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
//@RequiredArgsConstructor
public class ApplicationController {
    @Autowired
    private  ApplicationService applicationService;

    //Kredi başvurularını kaydeden end-point.
    @PostMapping
    public Application create(@RequestBody Application application) {
        return applicationService.save(application);
    }

    @PostMapping("/createApplication")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationRequest request){
        return ResponseEntity.ok().body(applicationService.createApplication(request));
    }

    @GetMapping("/getAllGarantiBankApplications")
    public ResponseEntity<List<Application>> getAllGarantiBankApplications(){
        return ResponseEntity.ok().body(applicationService.getAllGarantiBankApplications());
    }

    @GetMapping("/getGarantiBankApplicationsByUserId/{userId}")
    public ResponseEntity<List<Application>> getGarantiBankApplicationsByUserId(@PathVariable(value = "userId") long userId){
        return ResponseEntity.ok().body(applicationService.getGarantiBankApplicationsByUserId(userId));
    }

    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAll();
    }

    //email adresi ile kullanıcının bütün başvurularını listeleyen end-point.
    @GetMapping("/{email}")
    public List<Application> findByUserEmail(@PathVariable String email) {
        return applicationService.findByUserEmail(email);
    }

    @GetMapping("/byId/{applicationId}")
    public Application findById(@PathVariable int applicationId) {
        return applicationService.findById(applicationId);
    }

    @PutMapping("/{applicationId}")
    public Application update(@PathVariable int applicationId, @RequestBody Application application) {
        return applicationService.update(applicationId, application);
    }




}
