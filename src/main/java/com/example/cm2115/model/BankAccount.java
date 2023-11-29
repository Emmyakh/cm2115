package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The BankAccount class is an abstract class representing a generic bank account. It includes methods
 * for withdrawing and depositing funds, as well as shared attributes like account number, balance, and
 * account name. This class is designed to be extended by specific account types.
 */
abstract class BankAccount {
    // File paths for customer and account CSV files
    private static String filePath = "src/main/resources/com/example/cm2115/customer.csv";
    private static String filePath1 = "src/main/resources/com/example/cm2115/account.csv";

    // Shared attributes for all bank accounts
    int accountNumber;
    int sortcode;
    int balance;
    String accountName;

    // Lists for storing accounts and customers (shared across all instances)
    public static List<String[]> accounts = customer.accounts;
    public static List<String[]> customers = new ArrayList<>();

    /**
     * Handles the withdrawal of funds from the bank account.
     *
     * @param amount   The amount to withdraw.
     * @param balance  The current balance of the account.
     * @param thisaza  The account number to perform the withdrawal.
     * @return String representation of the updated balance after withdrawal.
     * @throws IOException If an I/O error occurs during CSV file handling.
     */
    public static String withdraw(int amount, int balance, String thisaza) throws IOException {
        int balupdate = 0;

        if (amount <= balance) {
            balupdate = balance - amount;

            // Update the balance in the accounts list
            for (int j = 0; j < accounts.size(); j++) {
                String[] row = accounts.get(j);
                for (int i = 0; i < row.length; i++) {
                    String value = row[i];
                    if (value.equals(thisaza)) {
                        row[3] = String.valueOf(balupdate);
                        accounts.set(j, row); // Update the account information
                    }
                }
            }

            // Write the updated data to the CSV file
            try {
                CSVHandler.writeCSV(filePath1, accounts);
                System.out.println("Data written to CSV file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately (e.g., show an error message)
            }
        }

        if (amount <= balance) {
            return String.valueOf(balupdate);
        } else {
            return "insufficient funds";
        }
    }

    /**
     * Handles the deposit of funds into the bank account.
     *
     * @param amount   The amount to deposit.
     * @param balance  The current balance of the account.
     * @param thisaza  The account number to perform the deposit.
     * @return String representation of the updated balance after deposit.
     * @throws IOException If an I/O error occurs during CSV file handling.
     */
    public static String deposit(int amount, int balance, String thisaza) throws IOException {
        int balupdate = amount + balance;
        String.valueOf(balupdate);

        // Update the balance in the accounts list
        for (int j = 0; j < accounts.size(); j++) {
            String[] row = accounts.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(thisaza)) {
                    row[3] = String.valueOf(balupdate);
                    accounts.set(j, row); // Update the account information
                }
            }
        }

        // Write the updated data to the CSV file
        try {
            CSVHandler.writeCSV(filePath1, accounts);
            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error message)
        }

        return String.valueOf(balupdate);
    }
}
