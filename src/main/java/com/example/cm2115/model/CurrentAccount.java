package com.example.cm2115.model;

import java.io.IOException;

/**
 * The CurrentAccount interface represents the functionality expected in a current bank account.
 * It declares a method for processing card transactions, which must be implemented by classes that implement this interface.
 * Current accounts typically have features related to card transactions, overdrafts, and other modern banking functionalities.
 */
interface CurrentAccount {

    /**
     * Processes a card transaction for the current bank account.
     *
     * @param amount The amount of the card transaction.
     */
    void processCardTransaction(int amount);

    // Additional methods specific to current accounts can be added here
    // For example, methods related to overdrafts, card management, etc.
}
