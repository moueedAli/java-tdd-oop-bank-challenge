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
        bankAccount.withdraw(100);

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

    @Test
    public void testExtensionBalanceMethod() {
        BankAccount bankAccount = new CurrentAccount();
        bankAccount.deposit(1000);
        bankAccount.deposit(5000);
        bankAccount.withdraw(200);

        Assertions.assertEquals(5800.0, bankAccount.getBalanceExt());

        //System.out.println(bankAccount.generateStatement());
    }

    @Test
    public void testExtensionGetAndSetBranch() {
        BankAccount bankAccount = new CurrentAccount();
        BankAccount bankAccount1 = new SavingsAccount();

        Branch newBranch = Branch.BERGEN;

        Assertions.assertEquals(Branch.OSLO, bankAccount.getDEFAULT_BRANCH());
        Assertions.assertEquals(Branch.OSLO, bankAccount1.getDEFAULT_BRANCH());

        bankAccount1.setNewBranch(newBranch);

        Assertions.assertEquals(newBranch, bankAccount1.getDEFAULT_BRANCH());
    }

    @Test
    public void testExtensionApprovalOfOverdraft() {
        CurrentAccount bankAccount = new CurrentAccount();
        bankAccount.deposit(100);
        Overdraft overdraft = bankAccount.requestOverdraft(150);
        boolean approve = overdraft.approvedOrDenied(overdraft);

        //System.out.println(bankAccount.getBalance());

        Assertions.assertEquals(true, approve);

        Overdraft overdraft1 = bankAccount.requestOverdraft(1000);
        boolean deny = overdraft1.approvedOrDenied(overdraft1);

        Assertions.assertEquals(false, deny);
    }
}
