package com.patika.kredinbizdeservice.model;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCard implements Product{

    private String name;

    private BigDecimal fee;
    private Bank bank;

    private List<Campaign> campaignList;


    public CreditCard(String name,BigDecimal fee){
        this.name = name;
        this.fee = fee;
        this.campaignList = new ArrayList<>();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }


    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public void addCampaign(Campaign campaign){
        campaignList.add(campaign);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", fee=" + fee +
                ", bank=" + bank +
                ", campaignList=" + campaignList +
                '}';
    }

}
