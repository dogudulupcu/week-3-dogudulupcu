package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.enums.SectorType;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Optional;


public class CreditCardRepository {


    private List<CreditCard> creditCardList = new ArrayList<>();



    public void save(CreditCard creditCard) {
        creditCardList.add(creditCard);
    }

    public List<CreditCard> getAll() {
        return creditCardList;
    }

    public Optional<CreditCard> findByName(String name) {
        return creditCardList.stream()
                .filter(creditCard -> creditCard.getName().equals(name))
                .findFirst();
    }

    public void delete(CreditCard creditCard) {
        creditCardList.remove(creditCard);
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }



    public void loadData() {
        BankRepository bankRepository = new BankRepository();
        CreditCard creditCard = new CreditCard("Visa", new BigDecimal(50));
        CreditCard creditCard2 = new CreditCard("MasterCard", new BigDecimal(60));
        CreditCard creditCard3 = new CreditCard("American Express", new BigDecimal(70));

        creditCard.setBank(bankRepository.findByBankName("Akbank").get());
        creditCard2.setBank(bankRepository.findByBankName("Garanti").get());
        creditCard3.setBank(bankRepository.findByBankName("Ziraat").get());


        Campaign campaign = new Campaign("Kampanya", "Öğrenci Kartı", LocalDate.of(2024, 2, 15), LocalDate.of(2024, 2, 20), LocalDate.of(2024, 2, 25), SectorType.EDUCATION);
        Campaign campaign1 = new Campaign("Kampanya1", "Vergi İadesi", LocalDate.of(2024, 2, 16), LocalDate.of(2024, 2, 21), LocalDate.of(2024, 2, 26), SectorType.FINANCE);
        Campaign campaign2 = new Campaign("Kampanya2", "Yaz Tatili İndirimi", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 15), SectorType.TRAVEL);
        Campaign campaign3 = new Campaign("Kampanya3", "Eğitim Desteği", LocalDate.of(2024, 3, 5), LocalDate.of(2024, 3, 15), LocalDate.of(2024, 3, 20), SectorType.EDUCATION);
        Campaign campaign4 = new Campaign("Kampanya4", "İşe Yeni Başlayanlara Özel", LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 20), LocalDate.of(2024, 3, 25), SectorType.JOB);
        Campaign campaign5 = new Campaign("Kampanya5", "Aile Paketi", LocalDate.of(2024, 3, 15), LocalDate.of(2024, 3, 25), LocalDate.of(2024, 3, 30), SectorType.TECHNOLOGY);
        Campaign campaign6 = new Campaign("Kampanya6", "Yeni Kart Bonusu", LocalDate.of(2024, 2, 17), LocalDate.of(2024, 2, 22), LocalDate.of(2024, 2, 27), SectorType.FINANCE);

        creditCard.addCampaign(campaign);
        creditCard.addCampaign(campaign2);
        creditCard2.addCampaign(campaign3);
        creditCard2.addCampaign(campaign4);
        creditCard3.addCampaign(campaign6);
        creditCard3.addCampaign(campaign);
        creditCard3.addCampaign(campaign5);



        creditCardList.addAll(List.of(creditCard, creditCard2, creditCard3));
    }


}
