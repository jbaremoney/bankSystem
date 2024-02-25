import java.util.ArrayList;

public class Customer {
   //CUSTOMER ATTRIBUTES
    String name;
    String address;
    String email;
    String phone;
    int numOfAccounts;
    ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
    ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
    ArrayList<CD> cdAccounts = new ArrayList<>();

   //CUSTOMER METHODS
    void createAccount(String accountType, double initialDeposit)
    {
        if (accountType.equalsIgnoreCase("savings"))
        {
            SavingsAccount account = new SavingsAccount(accountType, initialDeposit);
            savingsAccounts.add(account);
            numOfAccounts += 1;
        }
        else if (accountType.equalsIgnoreCase("checking"))
        {
            CheckingAccount account = new CheckingAccount(accountType, initialDeposit);
            checkingAccounts.add(account);
            numOfAccounts += 1;
        }
    }
    
    void createAccount(String accountType, double initialDeposit, String withdrawDate) //This is for CD accounts only because they need a withdraw date
    {
        CD account = new CD(accountType, initialDeposit, withdrawDate);
        cdAccounts.add(account);   
        numOfAccounts += 1;
    }


    void removeAccount(SavingsAccount account) //Overloading because theres three types of accounts so theres three lists of accounts.
    {
        savingsAccounts.remove(account);
        numOfAccounts -= 1;
    }
    
    void removeAccount(CheckingAccount account)
    {
        checkingAccounts.remove(account);
        numOfAccounts -= 1;
    }
    
    void removeAccount(CD account)
    {
        cdAccounts.remove(account);
        numOfAccounts -= 1;
    }
    
    void viewBankAccount(Account account) //Just prints the account details to the console
    {
        
    }
    
    void viewAllBankAccounts() //will call viewBankAccount on all accounts
    {
      //for(Account account : accounts){
      //   viewBankAccount(account);
      
    }
}
