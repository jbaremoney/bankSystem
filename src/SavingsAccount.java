public class SavingsAccount extends Account{
    double interestRate = .01; 
    
    SavingsAccount(String accountType, double initialBalance)
    {
        super(accountType, initialBalance); //mother class constructor
    }
}
