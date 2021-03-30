import java.sql.Connection;
import java.sql.DriverManager;

public class SQLDatabaseConnection {
    public static Connection getConnection() {

        Connection connection = null;
        String connectionUrl =
                "jdbc:sqlserver://localhost;"
                        + "database=Bank;"
                        + "user=BartekSQL;"
                        + "password=SQLserver123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";


        try {
            Class.forName("com.mssql.jdbc.Driver");
           connection = DriverManager.getConnection(connectionUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
