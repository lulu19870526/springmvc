package com.example.model;

public class Account {
    private int id;
    private String name;
    private int balance;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
