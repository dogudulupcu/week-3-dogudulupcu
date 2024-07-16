package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BankRepository {

    private List<Bank> bankList = new ArrayList<>();



    public void save(Bank bank) {
        bankList.add(bank);
    }

    public List<Bank> getAll() {
        return bankList;
    }

    public Optional<Bank> findByBankName(String bankName) {
        return bankList.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .findFirst();
    }

    public void delete(Bank bank) {
        bankList.remove(bank);
    }

    public void loadData() {
        Bank bank = new Bank("Akbank", 1.67);
        Bank bank2 = new Bank("Garanti", 1.25);
        Bank bank3 = new Bank("Ziraat", 2.5);
        bankList.addAll(List.of(bank, bank2, bank3));
    }

}
