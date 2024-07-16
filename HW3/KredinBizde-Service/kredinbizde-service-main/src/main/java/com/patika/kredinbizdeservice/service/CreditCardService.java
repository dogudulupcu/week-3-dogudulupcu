package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private CreditCardRepository creditCardRepository = new CreditCardRepository();

    public CreditCard save(CreditCard creditCard) {
        if(creditCard == null){
            return null;
        }
        creditCardRepository.save(creditCard);
        return creditCard;
    }

    public List<CreditCard> getAll() {
        return creditCardRepository.getAll();
    }

    public CreditCard findByName(String name) {
        Optional<CreditCard> foundCreditCard = creditCardRepository.findByName(name);
        CreditCard creditCard = null;
        if (foundCreditCard.isPresent()) {
            creditCard = foundCreditCard.get();
        }
        return creditCard;
    }

    public CreditCard update(String cardName, CreditCard creditCard) {
        Optional<CreditCard> foundCreditCard= creditCardRepository.findByName(cardName);
        if(foundCreditCard.isPresent()){
            foundCreditCard.get().setName(creditCard.getName());

            foundCreditCard.get().setFee(creditCard.getFee());

            creditCardRepository.delete(creditCard);

            creditCardRepository.save(foundCreditCard.get());

            return foundCreditCard.get();

        }

        return null;

    }
}
