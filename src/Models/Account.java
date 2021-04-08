package Models;

import Helpers.RandomAccountNumber;
import Utils.SQLDatabaseOperations;

import java.sql.SQLException;

public class Account extends Client {

    private Client client;
    private String accountNumber;
    private double accountBalance;
    private boolean creditCard;
    private final RandomAccountNumber randomAccountNumber = new RandomAccountNumber();


    public Account(Client client, boolean creditCard) throws SQLException, ClassNotFoundException {


            this.client = client;
            this.accountNumber = randomAccountNumber.getRandomNumberAccount();
            this.accountBalance = 0;
            this.creditCard = creditCard;

            int parseCreditCard;
            if (creditCard) {
                parseCreditCard = 1;
            } else parseCreditCard = 0;

            int clientID = SQLDatabaseOperations.getID(client.getPesel());

            String insertSQL = "" +
                    "INSERT INTO Accounts (Account_Number, Account_Balance, Credit_Card, ClientID) VALUES "
                    + "(" + this.accountNumber + ", " + this.accountBalance + ", " + parseCreditCard + ", " + clientID + ");";

            SQLDatabaseOperations.addData(insertSQL);
        }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isCreditCard() {
        return creditCard;
    }

    public void setCreditCard(boolean creditCard) {
        this.creditCard = creditCard;
    }

    public RandomAccountNumber getRandomAccountNumber() {
        return randomAccountNumber;
    }


    @Override
    public String toString() {
        return "Factory.Account: " + '\n' +
                "Owner: " + client.getFirstName() + " " + client.getLastName() + '\n' +
                "Number: " + getAccountNumber() + '\n' +
                "Balance: " + getAccountBalance() + "$" + '\n' +
                "Credit Card: " + isCreditCard();
    }
}
