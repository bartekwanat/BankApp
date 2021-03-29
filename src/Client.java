import java.time.LocalDate;

public class Client {
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate dateOfBirthday;


    public Client(String firstName, String lastName, String pesel, String dateOfBirthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.dateOfBirthday = LocalDate.parse(dateOfBirthday);

        String insertSql = "INSERT INTO Accounts (Account_Number, Account_Balance, Credit_Card, ClientID) VALUES "
                + "(" + firstName + "," +   lastName + "," + pesel + "," + dateOfBirthday + ");";

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

    public String getPesel() {
        if (Character.getNumericValue(pesel.charAt(2)) > 1 || Character.getNumericValue(pesel.charAt(3)) > 2 ||
                Character.getNumericValue(pesel.charAt(4)) > 3 || pesel.length() != 11) return "pesel nieprawidłowy";

        else return pesel;
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
        return "Client: " + '\n' +
                "Name: " + getFirstName() + " " + getLastName() + '\n' +
                "PESEL: " + getPesel() + '\n' +
                "Date of birth: " + getDateOfBirthday();
    }

}


