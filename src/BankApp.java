import Factory.Account;
import Factory.Client;
import Utils.SQLDatabaseOperations;

import java.sql.*;

public class BankApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Client client = new Client("Jan", "Kowalski", "43120434322", "1943-12-04");
        Account acc = new Account(client, true);
        Client client1 = new Client("Bartek", "Nowak", "95010245647", "1995-01-02");
        Account account1 = new Account(client, false);
        SQLDatabaseOperations.showAllFromTable();
        SQLDatabaseOperations.showAccounts();
        SQLDatabaseOperations.payment(acc, 500);
        SQLDatabaseOperations.withdraw(acc, 200);
        System.out.println(SQLDatabaseOperations.getPeselList());
        SQLDatabaseOperations.getClientAccounts("43120434322");
        SQLDatabaseOperations.removeAccount(account1);
        SQLDatabaseOperations.removeClient(client1);
    }
}
