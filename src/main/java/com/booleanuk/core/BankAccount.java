package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.TreeMap;

abstract class BankAccount {
    protected double balance;
    protected int accountNumber;
    protected HashMap<LocalDateTime, Transactions> transactions;

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public HashMap<LocalDateTime, Transactions> getTransactions() {
        return transactions;
    }

    void deposit(double amount) {
        ;
    }

     boolean withdraw(double amount) {
        return false;
     }

     String generateStatement() {
        return "";
     }
}
