import java.sql.*;

public class Account extends Client {

    private Client client;
    private String accountNumber;
    private int accountBalance;
    private boolean creditCard;
    private RandomAccountNumber randomAccountNumber = new RandomAccountNumber();


    public Account(Client client, boolean creditCard) {
        this.client = client;
        this.accountNumber = randomAccountNumber.getRandomNumberAccount();
        this.accountBalance = 0;
        this.creditCard = creditCard;

        String connectionUrl =
                "jdbc:sqlserver://localhost;"
                        + "database=Bank;"
                        + "user=BartekSQL;"
                        + "password=SQLserver123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        String insertSql = "" +
                "INSERT INTO Accounts (Account_Number, Account_Balance, Credit_Card, ClientID) VALUES "
                + "(getAccountNumber() + getAccountBalance() + isCreditCard() + getClient());";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
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


    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
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
        return "Account: " + '\n' +
                "Owner: " + client.getFirstName() + " " + client.getLastName() + '\n' +
                "Number: " + getAccountNumber() + '\n' +
                "Balance: " + getAccountBalance() + "$" + '\n' +
                "Credit Card: " + isCreditCard();
    }
}
