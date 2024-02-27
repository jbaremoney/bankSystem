import java.util.Random;

public class CheckingAccount extends Account {
    Random rand = new Random();//For randomized debitNumber that's 12 numbers long
    
    int debitNumber = 1234560000 + rand.nextInt(10000000); //This is done because random can't create numbers this big.
    CheckingAccount(String accountType, double initialBalance)
    {
        super(accountType, initialBalance);
    }

}