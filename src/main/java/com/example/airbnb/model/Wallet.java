package com.example.airbnb.model;

import com.example.airbnb.model.user.User;
import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String icon;

    @Column(nullable = false)
    private Long amountMoney;

    @ManyToOne
    private MoneyType moneyType;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private int status;

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(Long amountMoney) {
        this.amountMoney = amountMoney;
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(MoneyType moneyType) {
        this.moneyType = moneyType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
