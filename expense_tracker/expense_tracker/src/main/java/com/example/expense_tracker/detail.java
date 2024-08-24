package com.example.expense_tracker;

public class detail {
    private String user;
    private int balance;
    private int budget;
    private int income;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public detail(String user, int balance, int budget, int income) {
        this.user = user;
        this.balance = balance;
        this.budget = budget;
        this.income = income;
    }
}
