package Factory;

import Utils.SQLDatabaseOperations;

import java.sql.SQLException;
import java.time.LocalDate;


public class Client {
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate dateOfBirthday;



    public Client(String firstName, String lastName, String pesel, String dateOfBirthday) throws SQLException, ClassNotFoundException {

        if (SQLDatabaseOperations.getPeselList().contains(pesel)) {
            System.out.println("This client already exist.");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.pesel = pesel;
            this.dateOfBirthday = LocalDate.parse(dateOfBirthday);


            String insertSql = "INSERT INTO Clients (First_Name, Last_Name, PESEL, Date_of_Birthday) VALUES "
                    + "('" + this.firstName + "' , '" + this.lastName + "' , '" + this.pesel + "' , '" + this.dateOfBirthday + "')";

            SQLDatabaseOperations.addData(insertSql);
        }
    }

    public Client() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Client(String pesel) {
        this.pesel = pesel;
    }

    public String getPesel() {
       return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }


    @Override
    public String toString() {
        return "Factory.Client: " + '\n' +
                "Name: " + getFirstName() + " " + getLastName() + '\n' +
                "PESEL: " + getPesel() + '\n' +
                "Date of birth: " + getDateOfBirthday();
    }

}


