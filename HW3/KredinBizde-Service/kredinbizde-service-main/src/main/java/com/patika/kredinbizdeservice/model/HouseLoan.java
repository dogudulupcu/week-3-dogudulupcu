package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;

import java.math.BigDecimal;

public class HouseLoan extends Loan {

    private final LoanType loanType = LoanType.KONUT_KREDISI;
    private String city;

    public HouseLoan() {

    }

    public HouseLoan(BigDecimal amount,Long loanId ,Integer installment, Double interestRate, String city) {
        super(amount,loanId, installment, interestRate);
        this.city = city;
    }

    public LoanType getLoanType() {
        return loanType;
    }


    void calculate(BigDecimal amount, int installment) {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
