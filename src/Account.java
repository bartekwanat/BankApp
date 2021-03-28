public class Account extends Client {
    private Client client;
    private String accountNumber;
    private int accountBalance;
    private boolean creditCard;
    private RandomAccountNumber randomAccountNumber = new RandomAccountNumber();


    public Account(Client client, boolean creditCard) {
        this.client = client;
        this.accountNumber = randomAccountNumber.getNumberAccount();
        this.accountBalance = 0;
        this.creditCard = creditCard;
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
