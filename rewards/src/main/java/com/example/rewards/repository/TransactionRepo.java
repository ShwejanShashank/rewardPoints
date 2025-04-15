package com.example.rewards.repository;

import com.example.rewards.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, String>{
    List<Transaction> findByUserId(String userId);
    List<Transaction> findByUserName(String userName);
}
