package com.example.rewards.service;


import com.example.rewards.model.RewardResponse;
import com.example.rewards.model.Transaction;
import com.example.rewards.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardService {
    @Autowired
    private TransactionRepo transactionRepo;

    public RewardResponse getRewards(String userId, String userName) {
        List<Transaction> transactions = new ArrayList<>();

        if(userId != null) {
            transactions = transactionRepo.findByUserId(userId);
        }
        else if(userName != null) {
           transactions = transactionRepo.findByUserName(userName);
        }
        Map<String,Integer> monthlyRewards = new HashMap<>();
        int totalRewards = 0;

        for(Transaction t : transactions) {
            int rewards=calculatePoints(t.getAmount());
            String month=t.getDate().getMonth().toString();

            monthlyRewards.put(month, monthlyRewards.getOrDefault(month,0)+rewards);
            totalRewards+=rewards;
        }
        return new RewardResponse(userId,userName,monthlyRewards,totalRewards);
    }

    private int calculatePoints(double amount) {
        if(amount > 100) return (int)(amount - 100)*2+50;
        else if (amount > 50) return (int)(amount - 50);
        return 0;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }
}
