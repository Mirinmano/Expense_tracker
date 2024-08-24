package com.example.expense_tracker;

import java.util.Date;

public class Home {

    private int income;
    private int savings;
    private int balance;
    private int budget;
    private String user;
    private String pass;
    private Date date;
    private String name;
    private String phone;
    private String email;

    public Home(int income, int savings, int balance, int budget) {
        this.income = income;
        this.savings = savings;
        this.balance = balance;
        this.budget = budget;
    }

    public Home(String user, String pass, Date date, String name, String phone, String email) {
        this.user = user;
        this.pass = pass;
        this.date = date;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Home(int income, int savings, int balance, int budget, String user, String pass, Date date, String name, String phone, String email) {
        this.income = income;
        this.savings = savings;
        this.balance = balance;
        this.budget = budget;
        this.user = user;
        this.pass = pass;
        this.date = date;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
