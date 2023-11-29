package com.example.cm2115;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.cm2115.model.ISA;
import com.example.cm2115.model.customer;
import com.example.cm2115.model.BasicAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * The AccountManagerController class handles user interactions and logic for the
 * "Account Manager" view. It communicates with the customer and account models to
 * retrieve and update customer information and perform banking operations.
 */
public class AccountManagerController {

    // Lists to store customer and account data
    private List<String> customerList = new ArrayList<>();
    private String acctnumbliist;
    private List<String> accountsList = new ArrayList<>();
    private List<String[]> accounts = new ArrayList<>();
    private List<String[]> customers = new ArrayList<>();

    // Stage and Scene variables
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Variables to store user-inputted and retrieved data
    public String acctname;
    private String cid;
    public String acctype;
    private int rowindex;
    private String name;
    private String address;
    private String custype;
    private String balupdate;
    private String id;
    private String bid;
    private String actnums;
    private String rate;
    private String balance;
    private String acctnumber;

    // FXML-annotated UI components
    @FXML
    TextField acctnamelabel;
    @FXML
    Label namelabel;
    @FXML
    Label acctnumberlabel;
    @FXML
    Label balancevalue;
    @FXML
    Label custotype;
    @FXML
    Label addresslabel;
    @FXML
    TextField withdraw;
    @FXML
    TextField depositlabel;
    @FXML
    TextField acctfocus;
    @FXML
    TextField changerate;
    @FXML
    Label sortid;
    @FXML
    Label intratelabel;

    /**
     * Changes the interest rate for ISA accounts.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the rate change process.
     */
    public void changerate(ActionEvent event) throws IOException {
        rate = changerate.getText();
        ISA.setinterestRate(Integer.parseInt(rate));
        intratelabel.setText("Current Rate:" + ISA.getinterestRate() + "%");
    }

    /**
     * Retrieves customer and account information based on the provided account name.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the retrieval process.
     */
    public void retrieve(ActionEvent event) throws IOException {
        String acctname = acctnamelabel.getText().toLowerCase();
        customerList = customer.getcustomer(acctname);
        accountsList = customer.getaccount(acctname);
        acctnumbliist = customer.getaccountlist(acctname);
        name = customerList.get(1);
        cid = customerList.get(0);
        address = customerList.get(2);
        custype = customerList.get(3);
        balance = accountsList.get(3);
        displayCutomers(name, address, custype, acctnumbliist, balance);
    }

    /**
     * Navigates to the user registration page to add a new customer.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the navigation process.
     */
    public void gotoreg(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Navigates to the card processing page.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the navigation process.
     */
    public void gotocard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("card.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Navigates to the transfer page.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the navigation process.
     */
    public void gototransfer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("transfer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles withdrawal operation and updates the UI with the new balance.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the withdrawal process.
     */
    public void withdrawal(ActionEvent event) throws IOException {
        String num = withdraw.getText();
        String thisaza = acctfocus.getText().toLowerCase();
        int bal = Integer.parseInt(balance);
        int withdraw = Integer.parseInt(num);
        balupdate = BasicAccount.withdraw(withdraw, bal, thisaza);
        displayCutomers(name, address, custype, acctnumber, balupdate);
    }

    /**
     * Navigates to the customer page for further updates.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the navigation process.
     */
    public void update(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Customer.fxml"));
        root = loader.load();
        CustomerController scene3Controller = loader.getController();
        scene3Controller.displayCust(name, address, custype, acctnumbliist);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles deposit operation and updates the UI with the new balance.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the deposit process.
     */
    public void deposital(ActionEvent event) throws IOException {
        String thisaza = acctfocus.getText().toLowerCase();
        String num1 = depositlabel.getText();
        int deposit = Integer.parseInt(num1);
        int bal = Integer.parseInt(balance);
        balupdate = BasicAccount.deposit(deposit, bal, thisaza);
        displayCutomers(name, address, custype, thisaza, balupdate);
    }

    /**
     * Displays customer information on the UI.
     *
     * @param actname    Account name.
     * @param address    Customer address.
     * @param cusType    Customer type.
     * @param acctNumber Account numbers.
     * @param bal        Account balance.
     */
    public void displayCutomers(String actname, String address, String cusType, String acctNumber, String bal) {
        namelabel.setText("Account Name :" + actname);
        acctnumberlabel.setText("Account Numbers :" + acctNumber);
        addresslabel.setText("Address :" + address);
        custotype.setText("Customer Type :" + cusType);
        balancevalue.setText("Balance :" + bal);
    }
}
