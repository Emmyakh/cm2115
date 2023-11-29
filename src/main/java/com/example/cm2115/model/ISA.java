package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ISA class represents an Individual Savings Account and extends the BankAccount class.
 * It also implements the SavingsAccount interface.
 */
public class ISA extends BankAccount implements SavingsAccount {

    // Private fields
    private static int index;
    public static List<String[]> irate = new ArrayList<>();
    private static String ratefilePath = "src/main/resources/com/example/cm2115/rate.csv";

    /**
     * Applies interest to the specified ISA account.
     *
     * @param thisaza1 The account number for which interest is to be applied.
     * @throws IOException If an I/O error occurs while reading or writing to the CSV file.
     */
    public static void applyInterest(String thisaza1) throws IOException {
        String[] row1 = irate.get(0);
        int intrate = Integer.parseInt(row1[0]);
        String inibalance;
        float ir = intrate / 100;
        for (int j = 0; j < accounts.size(); j++) {
            String[] row = accounts.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(thisaza1)) {
                    inibalance = row[3];
                    row[3] = String.valueOf(ir * Integer.parseInt(inibalance));
                    index = j;
                    accounts.set(index, row);// Return the index when acctname is found
                }
            }
        }
    }

    /**
     * Gets the current interest rate from the CSV file.
     *
     * @return The interest rate as a string.
     * @throws IOException If an I/O error occurs while reading from the CSV file.
     */
    public static String getinterestRate() throws IOException {
        try {
            irate = CSVHandler.readCSV(ratefilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] row1 = irate.get(0);
        return row1[0];
    }

    /**
     * Sets the interest rate and writes it to the CSV file.
     *
     * @param rate The new interest rate to be set.
     * @throws IOException If an I/O error occurs while writing to the CSV file.
     */
    public static void setinterestRate(int rate) throws IOException {
        irate.add(new String[]{String.valueOf(rate)});
        try {
            CSVHandler.writeCSV(ratefilePath, irate);
            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error message)
        }
    }

    /**
     * Gets the balance of the specified ISA account.
     *
     * @param account The account number for which the balance is to be retrieved.
     * @return The balance as a string.
     * @throws IOException If an I/O error occurs while reading from the CSV file.
     */
    public static String getbalance(String account) throws IOException {
        String balance = null;
        for (int j = 0; j < accounts.size(); j++) {
            String[] row = accounts.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(account)) {
                    balance = row[3];
                }
            }
        }

        return balance;
    }
}
