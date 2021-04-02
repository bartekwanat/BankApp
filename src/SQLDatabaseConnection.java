import java.sql.*;


public class SQLDatabaseConnection {
    public static Connection getConnection(String insertSQL) {

        String connectionUrl =
                "jdbc:sqlserver://localhost;"
                        + "database=Bank;"
                        + "user=BartekSQL;"
                        + "password=SQLserver123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";


        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            resultSet = prepsInsertProduct.getGeneratedKeys();

            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

            return null;
    }

    }



