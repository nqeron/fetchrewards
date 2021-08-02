package com.noahsfields.fetchrewards.model.services;

import com.noahsfields.fetchrewards.model.FetchReward;
import com.noahsfields.fetchrewards.model.FetchRewardDat;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FetchRewardService {

    FetchRewardDat fetchRewardDat = FetchRewardDat.getInstance();

    public void addFetchReward(FetchReward fr){
        fetchRewardDat.addFetchReward(fr);
    }

    public HashMap<String, Integer> getFetchRewards(){
        return fetchRewardDat.getRewards();
    }

    public HashMap<String, Integer> deduct(Integer amount) {
        return fetchRewardDat.deductRewards(amount);
    }
}
