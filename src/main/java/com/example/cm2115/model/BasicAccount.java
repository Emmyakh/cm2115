package com.example.cm2115.model;

import java.io.IOException;

/**
 * The BasicAccount class extends the BankAccount class and implements the CurrentAccount interface.
 * It represents a basic bank account and includes methods for transferring funds and processing card transactions.
 */
public class BasicAccount extends BankAccount implements CurrentAccount {

    /**
     * Performs a fund transfer between two bank accounts.
     *
     * @param targetAccount The account number of the target account.
     * @param senderAccount The account number of the sender's account.
     * @param amount        The amount to transfer.
     * @param balance       The current balance of the sender's account.
     * @param balance1      The current balance of the target account.
     * @throws IOException If an I/O error occurs during the withdrawal and deposit operations.
     */
    public static void transfer(String targetAccount, String senderAccount, int amount, int balance, int balance1) throws IOException {
        // Withdraw funds from the sender's account
        BasicAccount.withdraw(amount, balance, senderAccount);

        // Deposit funds into the target account
        BasicAccount.deposit(amount, balance1, targetAccount);
    }

    /**
     * Processes a card transaction for the basic bank account.
     *
     * @param amount The amount of the card transaction.
     */
    @Override
    public void processCardTransaction(int amount) {
        // Implementation of card transaction processing for the basic account (if needed)
        // This method is part of the CurrentAccount interface
    }

    // Additional methods specific to BasicCurrentAccount can be added here
}
