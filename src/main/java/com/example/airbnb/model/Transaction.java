package com.example.airbnb.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int amountSpent;

    @ManyToOne
    private CategorySpending categorySpending;

    @ManyToOne
    private Wallet wallet;

    @Column(nullable = false)
    private String note;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String time;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(int amountSpent) {
        this.amountSpent = amountSpent;
    }

    public CategorySpending getCategorySpending() {
        return categorySpending;
    }

    public void setCategorySpending(CategorySpending categorySpending) {
        this.categorySpending = categorySpending;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
