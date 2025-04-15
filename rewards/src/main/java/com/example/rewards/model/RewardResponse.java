package com.example.rewards.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class RewardResponse {

    private String userId;
    private String userName;
    private Map<String, Integer> monthlyRewards;
    private int totalRewards;
}
