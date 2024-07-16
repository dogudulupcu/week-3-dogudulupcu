package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;

import java.math.BigDecimal;

public  class Loan implements Product {

    private BigDecimal amount;

    private long loanId;
    private Integer installment;
    private Bank bank;
    private Double interestRate;

    private LoanType loanType;
    // private Campaign campaign; // kampanyalı kredileri üstte çıkart

    //sponsorlu kampanyaları üstte çıkart

    public Loan() {
    }

    public Loan(BigDecimal amount,long loanId, Integer installment, Double interestRate) {
        this.amount = amount;
        this.loanId = loanId;
        this.installment = installment;
        this.interestRate = interestRate;
    }



    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "amount=" + amount +
                ", installment=" + installment +
                ", bank=" + bank +
                ", interestRate=" + interestRate +
                '}';
    }


    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }
}
