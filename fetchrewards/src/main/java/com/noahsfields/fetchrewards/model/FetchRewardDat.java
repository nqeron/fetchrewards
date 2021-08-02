package com.noahsfields.fetchrewards.model;

import java.util.*;

public class FetchRewardDat {

    private static FetchRewardDat instance = new FetchRewardDat();
    private List<FetchReward> fetchRewards;
    private HashMap<String, Integer> payerAmount;

    private FetchRewardDat(){
        fetchRewards = new LinkedList<>();
        payerAmount = new HashMap<>();
    }

    public static FetchRewardDat getInstance() {
        return instance;
    }

    public void addFetchReward(FetchReward fr){
            int index = Collections.binarySearch(fetchRewards, fr);
            fetchRewards.add(Math.abs(index + 1), fr);
        int newAmount = payerAmount.getOrDefault(fr.getPayer(), 0) + fr.getPoints();
        if (newAmount < 0){
            throw new IllegalArgumentException("Fetch Rewards amount must result in a positive amount for the payer");
        }
        payerAmount.put(fr.getPayer(), newAmount);
    }

    public HashMap<String, Integer> deductRewards(int amount){
        HashMap<String, Integer> deductPerPayer = new HashMap<>();
        if (amount > getTotalAmount()){
            return deductPerPayer;
        }
        Iterator<FetchReward> fetchRewardIterator = fetchRewards.listIterator();
        FetchReward fr = null;
        while(fetchRewardIterator.hasNext()){
            fr = fetchRewardIterator.next();
                int left = fr.subtractPoints(amount);
                int pA = payerAmount.getOrDefault(fr.getPayer(), 0);
                payerAmount.put(fr.getPayer(), pA - (amount - left) >= 0? pA - (amount - left) : 0);
                deductPerPayer.put(fr.getPayer(), deductPerPayer.getOrDefault(fr.getPayer(), 0) - (amount - left));
                if (pA - (amount - left) < 0){
                    return deductPerPayer;
                }
                amount = left;
                if (fr.getPoints() <=0 ){
                    fetchRewardIterator.remove();
                }
                if (amount <= 0){
                    break;
                }
            }

        return deductPerPayer;
    }

    public HashMap<String, Integer> getRewards(){
        return this.payerAmount;
    }

    private int getTotalAmount(){
        return payerAmount.entrySet().stream().map((x) -> x.getValue()).reduce(0, (a, b)-> a + b);
    }
}
