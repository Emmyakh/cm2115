package com.example.cm2115.model;

import java.io.IOException;

/**
 * The SavingsAccount interface defines methods related to savings accounts and interest rates.
 * Classes implementing this interface are expected to provide functionality for applying,
 * getting, and setting interest rates on savings accounts.
 */
public interface SavingsAccount {

    /**
     * Applies interest to the savings account based on a specified file path.
     *
     * @param filePath The file path where account information is stored.
     * @throws IOException If an I/O error occurs during the interest application.
     */
    public static void applyInterest(String filePath) throws IOException {
        // The implementing class should define how interest is applied to the savings account.
        // This method is responsible for updating account balances based on the interest rate.
    }

    /**
     * Gets the current interest rate associated with the savings account from a specified file path.
     *
     * @param filePath The file path where interest rate information is stored.
     * @return The current interest rate.
     * @throws IOException If an I/O error occurs during the retrieval of the interest rate.
     */
    public static int getinterestRate(String filePath) throws IOException {
        // The implementing class should specify how to retrieve the current interest rate.
        // This method should return the obtained interest rate.
        return 0; // Placeholder value, replace with actual implementation.
    }

    /**
     * Sets the interest rate for the savings account.
     *
     * @param rate The new interest rate to be set.
     * @throws IOException If an I/O error occurs during the setting of the interest rate.
     */
    public static void setinterestRate(int rate) throws IOException {
        // The implementing class should specify how to set the interest rate for the savings account.
        // This method is responsible for updating the interest rate information.
    }
}
