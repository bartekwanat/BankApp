import java.sql.*;

public class BankApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Client client = new Client("Jan", "Kowalski", "43120434322", "1943-12-04");
        Account acc = new Account(client, true);
        Client client1 = new Client("Bartek", "Nowak", "9501024567", "1995-01-02");
        Account account1 = new Account(client, false);
        SQLDatabaseConnection.showAllFromTable();
        SQLDatabaseConnection.showAccounts();
        SQLDatabaseConnection.payment(acc, 500);


    }

}
