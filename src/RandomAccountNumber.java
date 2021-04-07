import java.util.Random;

public class RandomAccountNumber {


    private String numberAccount = "";

    public String getRandomNumberAccount() {

            for (int i = 0; i < 23; i++) {
                Random random = new Random();
                int x = random.nextInt(10);
                numberAccount += String.valueOf(x);
            }
            return numberAccount;
        }

    }





