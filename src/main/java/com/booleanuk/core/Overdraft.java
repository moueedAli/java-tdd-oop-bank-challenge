package com.booleanuk.core;

public class Overdraft {
    private double amountRequested;
    private double balance;
    private boolean approved = false;
    private CurrentAccount currentAccount;
    private double MAX_OVERDRAFT = -500;

    public Overdraft(CurrentAccount currentAccount, double amount, double balance) {
        this.currentAccount = currentAccount;
        this.amountRequested = amount;
        this.balance = balance;
    }

    public boolean approvedOrDenied(Overdraft overdraft) {
        if ((overdraft.balance - overdraft.amountRequested) < MAX_OVERDRAFT ) {
            approved = false;
        }
        else {
            currentAccount.withdrawWithOverdraft(overdraft.amountRequested);
            approved = true;
        }
        return approved;
    }

    public double getMAX_OVERDRAFT() {
        return MAX_OVERDRAFT;
    }

    public void setMAX_OVERDRAFT(double MAX_OVERDRAFT) {
        this.MAX_OVERDRAFT = MAX_OVERDRAFT;
    }
}
