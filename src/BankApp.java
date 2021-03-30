public class BankApp {
    public static void main(String[] args) {

        Client client = new Client("Jan", "Kowalski", "43120434322", "1943-12-04");
        Account acc = new Account(client, true);
        System.out.println(acc.toString());
        System.out.println();
        System.out.println(client.toString());
        Client client1 = new Client();
        Account account1 = new Account(client, false);

    }
}
