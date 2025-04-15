package com.example.rewards.controller;


import com.example.rewards.model.RewardResponse;
import com.example.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    RewardService rewardService;
    @GetMapping("/api/rewards")
    public ResponseEntity<RewardResponse> getRewards(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String userName) {

        if (userId == null && userName == null)
            return ResponseEntity.badRequest().build();

        RewardResponse response = rewardService.getRewards(userId, userName);
        return ResponseEntity.ok(response);
    }
}
