package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transactions {
    private LocalDateTime dateTime;
    private double creditAmount;
    private double debitAmount;
    private double amount;

    public LocalDateTime getDateTime() {
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
