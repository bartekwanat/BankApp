

public class BankOperations {
    public static String insertSQL = "";

    public static void getClientID() {
        insertSQL =  "SELECT * FROM Clients"  ;
        SQLDatabaseConnection.getConnection(insertSQL);




    }




}
