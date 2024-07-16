package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.enums.SectorType;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CampaignRepository {

    private List<Campaign> campaignList = new ArrayList<>();



    public void save(Campaign campaign){
        campaignList.add(campaign);
    }

    public List<Campaign> getAll(){
        return campaignList;
    }

    public void delete(Campaign campaign){
        campaignList.remove(campaign);
    }

    public Optional<Campaign> findByTitle(String title){
        return campaignList.stream()
                .filter(campaign -> campaign.getTitle().equals(title))
                .findFirst();
    }

    public void loadData(){
        CreditCardRepository creditCardRepository = new CreditCardRepository();
        CreditCard creditCard = creditCardRepository.getCreditCardList().get(0);
        CreditCard creditCard2 = creditCardRepository.getCreditCardList().get(1);
        CreditCard creditCard3 = creditCardRepository.getCreditCardList().get(2);


        Campaign campaign = new Campaign("Kampanya", "Öğrenci Kartı", LocalDate.of(2024, 2, 15), LocalDate.of(2024, 2, 20), LocalDate.of(2024, 2, 25), SectorType.EDUCATION);
        Campaign campaign1 = new Campaign("Kampanya1", "Vergi İadesi", LocalDate.of(2024, 2, 16), LocalDate.of(2024, 2, 21), LocalDate.of(2024, 2, 26), SectorType.FINANCE);
        Campaign campaign2 = new Campaign("Kampanya2", "Yaz Tatili İndirimi", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 15), SectorType.TRAVEL);
        Campaign campaign3 = new Campaign("Kampanya3", "Eğitim Desteği", LocalDate.of(2024, 3, 5), LocalDate.of(2024, 3, 15), LocalDate.of(2024, 3, 20), SectorType.EDUCATION);
        Campaign campaign4 = new Campaign("Kampanya4", "İşe Yeni Başlayanlara Özel", LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 20), LocalDate.of(2024, 3, 25), SectorType.JOB);
        Campaign campaign5 = new Campaign("Kampanya5", "Aile Paketi", LocalDate.of(2024, 3, 15), LocalDate.of(2024, 3, 25), LocalDate.of(2024, 3, 30), SectorType.TECHNOLOGY);
        Campaign campaign6 = new Campaign("Kampanya6", "Yeni Kart Bonusu", LocalDate.of(2024, 2, 17), LocalDate.of(2024, 2, 22), LocalDate.of(2024, 2, 27), SectorType.FINANCE);



       campaignList.addAll(List.of(campaign, campaign1, campaign2, campaign3, campaign4, campaign5, campaign6));





    }
}
