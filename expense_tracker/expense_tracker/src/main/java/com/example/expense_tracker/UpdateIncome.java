package com.example.expense_tracker;

public class UpdateIncome {
    private int income;
    private int savings;

    public UpdateIncome() {
    }

    public UpdateIncome(int income, int savings) {
        this.income = income;
        this.savings = savings;
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

    @Override
    public String toString() {
        return "UpdateIncome{" +
                "income=" + income +
                ", savings=" + savings +
                '}';
    }
}
