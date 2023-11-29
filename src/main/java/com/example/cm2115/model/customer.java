package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer class represents customer data and provides methods to retrieve information from CSV files.
 */
public class customer {

    // Properties for JavaFX binding
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty customerType = new SimpleStringProperty();

    // Lists to store retrieved data
    private List<String> customerList = new ArrayList<>();
    private List<String> acctnumbliist = new ArrayList<>();
    private List<String> accountsList = new ArrayList<>();

    // Static lists to store account and customer data
    public static List<String[]> accounts = new ArrayList<>();
    public static List<String[]> customers = new ArrayList<>();

    // File paths for CSV files
    private static String filePath = "src/main/resources/com/example/cm2115/customer.csv";
    private static String filePath1 = "src/main/resources/com/example/cm2115/account.csv";

    // Customer ID obtained during retrieval
    private static String cid;

    /**
     * Retrieves customer information based on the account name.
     *
     * @param acctname The account name to search for in the CSV files.
     * @return List of customer details (CID, name, address, customer type).
     */
    public static List<String> getcustomer(String acctname) {
        List<String> customerList = new ArrayList<>();
        try {
            customers = CSVHandler.readCSV(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Check in customer CSV
        for (String[] row : customers) {
            for (String value : row) {
                if (value.toLowerCase().equals(acctname)) {
                    for (String value1 : row) {
                        customerList.add(value1);
                    }
                }
            }
        }
        // Set CID for further use
        cid = customerList.get(0);
        return customerList;
    }

    /**
     * Retrieves account details based on the account number.
     *
     * @param accountnumber The account number to search for in the CSV files.
     * @return List of account details (SID, account number, CID, balance, account type).
     */
    public static List<String> getaccountdetails(String accountnumber) {
        List<String> fetchedaccount = new ArrayList<>();
        for (String[] row : accounts) {
            for (String value : row) {
                if (value.toLowerCase().equals(accountnumber)) {
                    for (String value1 : row) {
                        fetchedaccount.add(value1);
                    }
                }
            }
        }
        return fetchedaccount;
    }

    /**
     * Retrieves account details based on the customer ID.
     *
     * @param acctname The account name used to find the customer ID.
     * @return List of account details (SID, account number, CID, balance, account type) based on CID.
     */
    public static List<String> getaccount(String acctname) {
        try {
            accounts = CSVHandler.readCSV(filePath1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> accountsList = new ArrayList<>();
        // Check in account CSV
        for (String[] row : accounts) {
            for (String value : row) {
                if (value.toLowerCase().equals(cid)) {
                    for (String value1 : row) {
                        accountsList.add(value1);
                    }
                }
            }
        }
        return accountsList;
    }

    /**
     * Retrieves account numbers based on the account name.
     *
     * @param acctname The account name used to find associated account numbers.
     * @return Comma-separated string of account numbers associated with the given account name.
     */
    public static String getaccountlist(String acctname) {
        List<String> acctnumbliist = new ArrayList<>();
        for (int j = 0; j < customers.size(); j++) {
            String[] row = accounts.get(j);
            String[] row1 = customers.get(j);
            for (int i = 0; i < row1.length; i++) {
                if (row1[i].toLowerCase().equals(acctname)) {
                    acctnumbliist.add(row[1]);
                }
            }
        }
        // Join account numbers into a comma-separated string
        String out = String.join(", ", acctnumbliist);
        return out;
    }
}
