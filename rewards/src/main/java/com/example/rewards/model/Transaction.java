package com.example.rewards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Table(name="transaction")
public class Transaction {

    @Id
    private String transaction_id;
    private String userId;
    private String userName;
    private double amount;
    private LocalDate date;
}
