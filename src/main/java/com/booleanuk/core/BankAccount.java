package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract class BankAccount {
    protected double balance;
    protected static int accountNumber = 0;
    protected List<Transactions> transactions = new ArrayList<>();

    public BankAccount() {
        accountNumber++;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public String formatDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        String formatted = date.format(formattedDate);

        return formatted;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            return;
        }

        balance += amount;

        String formatted = formatDate();
        Transactions newTrans = new Transactions(formatted, amount, 0.0, balance);
        transactions.add(newTrans);
    }

     void withdraw(double amount) {
        if (amount > balance) {
            return;
        }

        balance -= amount;

        String formatted = formatDate();
        Transactions newTrans = new Transactions(formatted, 0.0, amount, balance);
        transactions.add(newTrans);
     }

    String generateStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("date                || credit  || debit  || balance\n");

        for (Transactions t : transactions) {

            String date = t.getDateTime();
            String credit = t.getCreditAmount() > 0 ? String.format("%.2f", t.getCreditAmount()) : "       ";
            String debit = t.getDebitAmount() > 0 ? String.format("%.2f", t.getDebitAmount()) : "       ";
            String balanceStr = String.format("%.2f", t.getAmount());

            statement.append(String.format("%s || %s || %s || %s\n", date, credit, debit, balanceStr));
        }

        return statement.toString();
    }

}
