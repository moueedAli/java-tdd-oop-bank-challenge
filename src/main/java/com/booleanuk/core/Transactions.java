package com.booleanuk.core;

public class Transactions {
    private String dateTime;
    private double creditAmount;
    private double debitAmount;
    private double amount;

    public Transactions(String dateTime, double creditAmount, double debitAmount, double amount) {
        this.dateTime = dateTime;
        this.creditAmount = creditAmount;
        this.debitAmount = debitAmount;
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public double getCreditAmount() {
        return creditAmount;
    }
}
