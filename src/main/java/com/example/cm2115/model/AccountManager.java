package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;

import java.io.IOException;
import java.util.List;

/**
 * The AccountManager class provides functionality to manage customer data by interacting with
 * CSV files using the CSVHandler class. It includes a method to add new customers and their
 * corresponding accounts to the CSV files.
 */
public class AccountManager {

    // File paths for customer and account CSV files
    private static String filePath = "src/main/resources/com/example/cm2115/customer.csv";
    private static String filePath1 = "src/main/resources/com/example/cm2115/account.csv";

    /**
     * Adds a new customer and their account to the CSV files.
     *
     * @param customerToWrite List of String arrays containing customer data to be written to the CSV.
     * @param accountToWrite  List of String arrays containing account data to be written to the CSV.
     */
    public static void addcustomer(List<String[]> customerToWrite, List<String[]> accountToWrite) {
        try {
            // Append customer data to the customer CSV file
            CSVHandler.appendtoCSV(filePath, customerToWrite);
            // Append account data to the account CSV file
            CSVHandler.appendtoCSV(filePath1, accountToWrite);

            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error message)
        }
    }
}
