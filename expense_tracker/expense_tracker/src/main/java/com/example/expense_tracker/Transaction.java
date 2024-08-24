package com.example.expense_tracker;


import java.util.Date;

public class Transaction {
    private String username="mirin";
    private double amount;
    private String category;
    private String desc;
    private int id;
    private Date date;

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transaction(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(String username, double amount, String category, String desc) {
        this.username = username;
        this.amount = amount;
        this.category = category;
        this.desc = desc;
    }

    public Transaction(String username, double amount, String category, String desc, Date date,int id) {
        this.username = username;
        this.amount = amount;
        this.category = category;
        this.desc = desc;
        this.date = date;
        this.id=id;
    }

    public Transaction() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "username='" + username + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
