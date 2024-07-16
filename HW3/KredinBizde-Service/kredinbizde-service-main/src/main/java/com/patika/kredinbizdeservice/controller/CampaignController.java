package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.service.CampaignService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Qualifier(value = "campaignService")
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping
    public List<Campaign> getAll() {
        return campaignService.getAll();
    }

    @PostMapping
    public Campaign save(@RequestBody Campaign campaign) {
        return campaignService.save(campaign);
    }

    //Sistemdeki bütün kampanyaları en güncelden eski tarihe doğru listeleyen end-point
    @GetMapping("/inOrder")
    public List<Campaign> getAllAscendingCreationDate() {
        return campaignService.getAllAscendingCreationDate();
    }



}
