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
    
    void viewBankAccount(SavingsAccount account) //Just prints the account details to the console
    {
        System.out.println("Account Details:");
        System.out.print("    Account Number: " + account.accountNumber + ", Account Type: " + account.accountType);
        System.out.printf(", Account Balance: $%.2f, Account Interest Rate: %.2f%%\n", account.balance, account.interestRate);
    }
    
    void viewBankAccount(CheckingAccount account) //Overloaded depending on account type
    {
        System.out.println("Account Details:");
        System.out.print("    Account Number: " + account.accountNumber + ", Account Type: " + account.accountType);
        System.out.printf(", Debit Number: %10d, Account Balance: $%.2f\n", account.debitNumber, account.balance);
    }
    
    void viewBankAccount(CD account) 
    {
        System.out.println("Account Details:");
        System.out.print("    Account Number: " + account.accountNumber + ", Account Type: " + account.accountType + ", Withdraw Date: " + account.getWithdrawDate());
        System.out.printf(", Account Balance: $%.2f, Account Interest Rate: %.2f%%\n", account.balance, account.interestRate);
    }


    
    void viewAllBankAccounts() //will call viewBankAccount on all accounts
    {
        System.out.println("Viewing All Accounts");
        for(SavingsAccount account : savingsAccounts){
           viewBankAccount(account);
        }
      
        for(CheckingAccount account : checkingAccounts){
           viewBankAccount(account);
        }
      
        for(CD account : cdAccounts){
           viewBankAccount(account);
        }
    }
}
