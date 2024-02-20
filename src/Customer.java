import java.util.ArrayList;

public class Customer {
   //CUSTOMER ATTRIBUTES
    String name;
    String address;
    String email;
    String phone;
    ArrayList<Account> accounts = new ArrayList<>();

   //CUSTOMER METHODS
    void createAccount(String accountType, double initialDeposit)
    {
        Account account = new Account();
        account.accountType = accountType;
        account.balance = initialDeposit;
        accounts.add(account);
    }


    void removeAccount(Account account)
    {
        accounts.remove(account);
    }
    
    void viewBankAccount(Account account)
    {
    //Will do something with this, potentially write to file/xcel file
    }
    
    void viewAllBankAccounts() //will call viewBankAccount on all accounts
    {
      for(Account account : accounts){
         viewBankAccount(account);
      }
    }
}
