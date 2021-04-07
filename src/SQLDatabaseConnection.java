import java.sql.*;

public class SQLDatabaseConnection {

    private static final String CONNECTION_URL =
            "jdbc:sqlserver://localhost;"
                    + "database=Bank;"
                    + "user=BartekSQL;"
                    + "password=SQLserver123;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30;";
    private static final String JDBC_DRIVER = "com.mssql.jdbc.Driver";
    private static Connection con = null;


    public static void dbConnect() throws ClassNotFoundException, SQLException {

        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(CONNECTION_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int getID(String getPesel) throws SQLException {
        int result = 0;
        ResultSet rs;
        try {
            PreparedStatement pst = null;
            con = DriverManager.getConnection(CONNECTION_URL);
            pst = con.prepareStatement("SELECT ClientID FROM Clients WHERE PESEL =  " + " '" + getPesel + " '" + ";");

            rs = pst.executeQuery();

            while (rs.next()) {
                result = rs.getInt("ClientID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static void addData(String querySQL) {
        ResultSet rs;
        try {
            con = DriverManager.getConnection(CONNECTION_URL);
            PreparedStatement prepsInsertProduct = con.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            rs = prepsInsertProduct.getGeneratedKeys();

            while (rs.next()) {
                System.out.println("Generated: " + rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showAllFromTable () {
        ResultSet rs;
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT First_Name, Last_Name, PESEL  FROM Clients;" ;
            rs = statement.executeQuery(selectSql);

            // Print results from select statement
            while (rs.next()) {
                String pesel = rs.getString(3);
                System.out.println(
                        "Client ID: " + getID(pesel) + "\n"
                       + "Name: " + rs.getString(1) + " " + rs.getString(2) + "\n"
                       + "PESEL: " + rs.getString(3)
                       + "\n"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showAccounts () {
        ResultSet rs;
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT Account_Number, Account_Balance as Balance, Credit_Card, First_Name, Last_Name\n" +
                    "FROM Accounts, Clients;" ;
            rs = statement.executeQuery(selectSql);

            // Print results from select statement
            while (rs.next()) {
                System.out.println(
                        "Account Number: " + rs.getString("Account_Number") + "\n"
                        + "Balance: " + rs.getString("Balance") + "\n"
                        + "Credit Card: " + rs.getString("Credit_Card") + "\n"
                        + "Owner: " + rs.getString("First_Name") + " " + rs.getString("Last_Name")
                        + "\n"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void payment (Account account, double amount) {

        account.setAccountBalance(account.getAccountBalance() + amount);
         double balance = account.getAccountBalance();

        ResultSet rs;
        String sql = "UPDATE Accounts SET Account_Balance =" + balance + "WHERE Account_Number = " + account.getAccountNumber() + ";";


        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.executeUpdate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }


    }

