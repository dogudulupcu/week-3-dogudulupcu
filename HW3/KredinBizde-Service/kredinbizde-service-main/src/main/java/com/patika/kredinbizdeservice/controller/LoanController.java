package com.patika.kredinbizdeservice.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.model.ConsumerLoan;
import com.patika.kredinbizdeservice.model.HouseLoan;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.VehicleLoan;
import com.patika.kredinbizdeservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/loans")
@RestController
public class LoanController {

    @Autowired
    @Qualifier(value = "loanService")
    private LoanService loanService ;

    @PostMapping("/houseLoan")
    @ResponseStatus(HttpStatus.CREATED)
    public HouseLoan create(@RequestBody HouseLoan loan) {
        loanService.save(loan);
        return loan;
    }

    @PostMapping("/consumerLoan")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumerLoan create(@RequestBody ConsumerLoan loan) {
        loanService.save(loan);
        return loan;
    }

    @PostMapping("/vehicleLoan")
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleLoan create(@RequestBody VehicleLoan loan) {
        loanService.save(loan);
        return loan;
    }

    @GetMapping
    public List<Loan> getAll() {
        return loanService.getAll();
    }

    @GetMapping("/{loanType}")
    public List<Loan> findByLoanType(@PathVariable String loanType) {
        return loanService.findByLoanType(loanType);
    }

    @DeleteMapping
    public void delete(@RequestBody Loan loan) {
        loanService.delete(loan);
    }




}
