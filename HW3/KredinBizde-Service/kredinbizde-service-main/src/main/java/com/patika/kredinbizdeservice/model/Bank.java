package com.patika.kredinbizdeservice.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;

    private double bankInterestRate;

    public Bank() {
    }

    public Bank(String name, double banInterestRate) {
        this.name=name;
        this.bankInterestRate=banInterestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                '}';
    }

    public double getBankInterestRate() {
        return bankInterestRate;
    }

    public void setBankInterestRate(double banInterestRate) {
        this.bankInterestRate = banInterestRate;
    }


}
