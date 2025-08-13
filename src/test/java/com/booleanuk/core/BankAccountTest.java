package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    public void testDepositToAccount() {
        BankAccount bankAccount = new CurrentAccount();
        bankAccount.deposit(100);

        Assertions.assertEquals(100, bankAccount.getBalance());

        bankAccount.deposit(1234);
        Assertions.assertEquals(1334, bankAccount.getBalance());

        BankAccount bankAccount1 = new SavingsAccount();
        bankAccount1.deposit(250);

        Assertions.assertEquals(250, bankAccount1.getBalance());
    }

    @Test
    public void testWithdrawFromAccount() {
        BankAccount bankAccount = new CurrentAccount();
        bankAccount.deposit(10000);
        bankAccount.withdraw(2000);

        Assertions.assertEquals(8000, bankAccount.getBalance());

        Assertions.assertEquals(8000, bankAccount.getBalance());
    }

    @Test
    public void testGetTransaction() {
        BankAccount bankAccount = new CurrentAccount();
        bankAccount.deposit(1000);
        bankAccount.deposit(300);
        bankAccount.withdraw(500);

        String transStat = bankAccount.generateStatement();
        boolean test = transStat.isEmpty();

        Assertions.assertEquals(false, transStat.isEmpty());
    }
}
