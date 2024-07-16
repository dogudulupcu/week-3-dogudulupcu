package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.repository.CampaignRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CampaignService {

    private CampaignRepository campaignRepository = new CampaignRepository();

    public Campaign save(Campaign campaign){
        campaignRepository.save(campaign);
        return campaign;
    }

    public List<Campaign> getAll(){
        return campaignRepository.getAll();
    }

    public Campaign findByTitle(String title){
        Optional<Campaign> foundCampaign = campaignRepository.findByTitle(title);
        Campaign campaign = null;
        if(foundCampaign.isPresent()){
             campaign = foundCampaign.get();
        }
        return campaign;

    }

    public Campaign update(String title, Campaign campaign){
        Optional<Campaign> foundCampaign = campaignRepository.findByTitle(title);
        if(foundCampaign.isPresent()){
            foundCampaign.get().setContent(campaign.getContent());
            foundCampaign.get().setTitle(campaign.getTitle());
            foundCampaign.get().setCreateDate(campaign.getCreateDate());
            foundCampaign.get().setUpdateDate(campaign.getUpdateDate());
            foundCampaign.get().setDueDate(campaign.getDueDate());
            foundCampaign.get().setSector(campaign.getSector());

            campaignRepository.delete(campaign);
            campaignRepository.save(foundCampaign.get());

            return foundCampaign.get();
        }
        return null;
    }

    public Campaign delete(Campaign campaign){
        campaignRepository.delete(campaign);
        return campaign;
    }

    public List<Campaign> getAllAscendingCreationDate(){
        List<Campaign> campaigns = campaignRepository.getAll();
        campaigns.sort((c1,c2)->c2.getCreateDate().compareTo(c1.getCreateDate()));
        return campaigns;

    }




}
