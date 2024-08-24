package com.example.expense_tracker;

import java.util.Date;

public class Report {
    private int id;
    private Date date;
    private int balance;
    private int budget;
    private int income;
    private int exp;
    private String month;
    private String year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Report(int id, Date date, int balance, int budget, int income, int exp, String month, String year) {
        this.id = id;
        this.date = date;
        this.balance = balance;
        this.budget = budget;
        this.income = income;
        this.exp = exp;
        this.month = month;
        this.year = year;
    }


}
