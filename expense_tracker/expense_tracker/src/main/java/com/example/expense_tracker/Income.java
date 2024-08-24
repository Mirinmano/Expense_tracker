package com.example.expense_tracker;

public class Income {
    private String username;
    private int income;
    private int savings;
    private int balance;
    private int budget;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Income(String username, int income, int savings, int balance, int budget) {
        this.username = username;
        this.income = income;
        this.savings = savings;
        this.balance = balance;
        this.budget=budget;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.savings = (income*savings)/100;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Income{" +
                "username='" + username + '\'' +
                ", income=" + income +
                ", savings=" + savings +
                ", balance=" + balance +
                '}';
    }
}
