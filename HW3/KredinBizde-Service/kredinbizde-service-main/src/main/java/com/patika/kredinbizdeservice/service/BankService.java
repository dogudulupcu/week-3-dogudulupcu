package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.repository.BankRepository;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private BankRepository bankRepository = new BankRepository();
    private CreditCardRepository creditCardRepository = new CreditCardRepository();

    public Bank save(Bank bank){
        bankRepository.save(bank);
        return bank;
    }

    public List<Bank> getAll(){
        return bankRepository.getAll();
    }

    public Bank findByName(String name){
        Optional<Bank> foundBank= bankRepository.findByBankName(name);

        Bank bank=null;

        if(foundBank.isPresent()){
            bank=foundBank.get();
        }

        return bank;

    }

    public Bank update(String name, Bank bank){
        Optional<Bank> bankToUpdate = bankRepository.findByBankName(name);
        if(bankToUpdate.isPresent()){
            bankToUpdate.get().setName(bank.getName());
            bankToUpdate.get().setBankInterestRate(bank.getBankInterestRate());
            bankRepository.delete(bank);
            bankRepository.save(bankToUpdate.get());
            return bankToUpdate.get();
        }
        return null;
    }





}
