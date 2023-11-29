package com.example.cm2115;

import com.example.cm2115.model.ISA;
import com.example.cm2115.model.customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The CustomerController class manages the interaction between the Customer view
 * (FXML) and the underlying data models. It handles user input, updates the UI, and
 * communicates with the Customer model.
 */
public class CustomerController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    // FXML-annotated UI components
    @FXML
    private Label name;
    @FXML
    private Label addresslabel;
    @FXML
    private Label custype;
    @FXML
    private Label blabel;
    @FXML
    private Label sort;
    @FXML
    private Label atype;
    @FXML
    private Label acctnumb;
    @FXML
    private Label hiddensavings;
    @FXML
    private TextField acctget;
    @FXML
    private TextField changename;
    @FXML
    private TextField addresschange;
    @FXML
    private TextField typechange;

    // Lists to store customer and account data
    private List<String> customerList = new ArrayList<>();
    private List<String> acctnumbliist = new ArrayList<>();
    private List<String> accountsList = new ArrayList<>();
    private List<String[]> account = new ArrayList<>();
    private List<String[]> customers = new ArrayList<>();
    private List<String> fetchedacct = new ArrayList<>();

    private String index; // Index used for updating customer information
    private String savingsrate; // Savings interest rate

    /**
     * Handles the "Get Accounts" button action, retrieves account details based on
     * user input, and updates the UI components accordingly.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the process.
     */
    public void getaccounts(ActionEvent event) throws IOException {
        String aza = acctget.getText().toLowerCase();
        fetchedacct = customer.getaccountdetails(aza);

        // Update UI labels with the retrieved account details
        blabel.setText("Account Name :" + fetchedacct.get(3));
        sort.setText("Sort Number :" + fetchedacct.get(0));
        atype.setText("Address :" + fetchedacct.get(4));
    }

    /**
     * Handles the "Update Customer" button action, updates customer information based on
     * user input, and reflects the changes in the UI labels.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the process.
     */
    public void updatecustomer(ActionEvent event) throws IOException {
        String filePath = "src/main/resources/com/example/cm2115/customer.csv";
        String filePath1 = "src/main/resources/com/example/cm2115/account.csv";
        String name1 = changename.getText().toLowerCase();
        String newadd = addresschange.getText().toLowerCase();
        String newtype = typechange.getText().toLowerCase();

        // Iterate through the list of customers to find a match
        for (int j = 0; j < customers.size(); j++) {
            String[] row = customers.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(index)) {
                    // Update customer information
                    row[1] = name1;
                    row[2] = newadd;
                    row[3] = newtype;
                    // Return the index when acctname is found
                }
            }
        }

        // Update UI labels with the new customer information
        addresslabel.setText("Address :" + newadd);
        custype.setText("Customer Type :" + newtype);
        name.setText("Account Name :" + name1);
    }

    /**
     * Navigates back to the Account Manager view when the "Back" button is clicked.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the navigation process.
     */
    public void backtomanager(ActionEvent event) throws IOException {
        // Load the Account Manager view and update the stage
        root = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Displays customer information on the UI based on the provided parameters.
     *
     * @param actname    Account name to be displayed.
     * @param address    Address to be displayed.
     * @param cusType    Customer type to be displayed.
     * @param acctNumber List of accounts associated with the customer.
     * @throws IOException If an I/O error occurs during the process.
     */
    public void displayCust(String actname, String address, String cusType, String acctNumber) throws IOException {
        savingsrate = ISA.getinterestRate();

        // Update UI labels with customer information
        name.setText("Account Name :" + actname);
        acctnumb.setText("Account Number :" + acctNumber);
        addresslabel.setText("Address :" + address);
        custype.setText("Customer Type :" + cusType);

        // Implement initialization logic and other methods as needed
    }
}
