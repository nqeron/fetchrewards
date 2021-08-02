package com.noahsfields.fetchrewards.controllers;

import com.noahsfields.fetchrewards.model.FetchReward;
import com.noahsfields.fetchrewards.model.services.FetchRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class MainController {

    @Autowired
    FetchRewardService fetchRewardService;

    @PostMapping("/add")
    public void addFetchReward(@RequestBody  FetchReward fr){
        fetchRewardService.addFetchReward(fr);
    }

    @GetMapping("/get")
    public HashMap<String, Integer> getFetchRewards(){
        return fetchRewardService.getFetchRewards();
    }

    @PostMapping("/deduct")
    public HashMap<String, Integer> deductAmount(@RequestBody int amount){
        return fetchRewardService.deduct(amount);
    }

}
