package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.service.BankService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Qualifier(value = "bankService")
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public Bank create(@RequestBody Bank bank) {
        return bankService.save(bank);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Bank> getAll() {
        return bankService.getAll();
    }

    @GetMapping("/{name}")
    public Bank findByName(@PathVariable String name) {
        return bankService.findByName(name);
    }

}
