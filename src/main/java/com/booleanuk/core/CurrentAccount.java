package com.booleanuk.core;

public class CurrentAccount extends BankAccount {

    public Overdraft requestOverdraft(double amount) {
        if (amount < balance) {
            withdraw(amount);
        }

        Overdraft overdraft = new Overdraft(this, amount, this.balance);
        return overdraft;
    }
}
