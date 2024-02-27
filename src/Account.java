import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

public class Account
{
    Random rand = new Random();//For randomized accountNumber
   
    // ACCOUNT ATTRIBUTES
    int accountNumber;
    String accountType;
    double balance;
    ArrayList<Transaction> transactions = new ArrayList<>(); //List of transactions that allows access to it
    HashMap<String, Double> datedBalances = new HashMap<String, Double>(); //This is mainly for the Statement class to see how the balances change each transaction
    
    Account(String accountType, double initialDeposit)
    {
        accountNumber = rand.nextInt(100000); //Just a random account number
        this.accountType = accountType;
        balance = initialDeposit;
        datedBalances.put("0/0/0", initialDeposit); //Initial deposit with a fake date so the initial deposit doesn't show up in the Statement
    }


    // ACCOUNT METHODS
    void deposit(double amount, String date)
    {
        balance += amount;
        Transaction transaction = new Transaction("Deposit ", amount, date); //Every transaction (deposit, withdraw, etc) needs to create a transaction
        this.transactions.add(transaction); //Then the transactions have to be added to the transaction list for the account
        datedBalances.put(date, balance); //Then add to the datedBalances to show how the balance changes each time.
    }

    void withdraw(double amount, String date) throws InsufficientFundsException //given account has enough money
    {
       if (this.balance >= amount){
          balance -= amount;
          Transaction transaction = new Transaction("Withdraw", amount, date); //Same rules for withdraw as deposit
          this.transactions.add(transaction);
          datedBalances.put(date, balance);
       }
       else {
            throw new InsufficientFundsException("Insufficient funds for transfer: required " + amount + ", available " + this.balance);
        }
    }

    void transferIn(Account fromAccount, double amount, String date)
    {
    //This just adds a transaction that has the type as In
        this.balance += amount;
        Transaction transaction = new Transaction(amount, fromAccount, "in", date);
        this.transactions.add(transaction);
        datedBalances.put(date, balance);

    }

    void transferOut(Account toAccount, double amount, String date) throws InsufficientFundsException{
        if (this.balance >= amount){
            // given account has enough money
            //1. make new transaction type Transfer Out
            Transaction transaction = new Transaction(amount, toAccount, "out", date);
            //2. add that to the (account making the transfer)'s list
            this.transactions.add(transaction);
            //3. call the transferIn method of the account we are sending the money to
            // the fromAccount argument will be account sending money (this)
            toAccount.transferIn(this, amount, date);
            this.balance -= amount;
            datedBalances.put(date, balance);
        }
        else {
            throw new InsufficientFundsException("Insufficient funds for transfer: required " + amount + ", available " + this.balance);
        }
    }

    void purchase(double amount, String purchaseBusiness, String date) throws InsufficientFundsException
    {
        if (this.balance >= amount){
        //Simulates making a purchase
            Transaction transaction = new Transaction(amount, purchaseBusiness, date);
            this.transactions.add(transaction);
            this.balance -= amount;
            datedBalances.put(date, balance);
        }
        else {
            throw new InsufficientFundsException("Insufficient funds for purchase: required " + amount + ", available " + this.balance);
        }
    }



    void viewTransactions()
    {
        System.out.println(accountNumber + " Transactions: ");
        for (Transaction transaction : transactions) {
        //So many if statements because we need to print out different things based on the different types of transaction
            if (transaction.type.equalsIgnoreCase("deposit ") | transaction.type.equalsIgnoreCase("withdraw")) //deposit and withdraw have the same amount of attributes to print
            {
                System.out.println("    Transaction type: " + transaction.type + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
            
            else if (transaction.type.equalsIgnoreCase("Transfer Out")) //Transfer out needs to see which account the money got transfered to
            {
                System.out.println("    Transaction type: " + transaction.type + ", Transfered to account number " + transaction.to.accountNumber + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
            
            else if (transaction.type.equalsIgnoreCase("Transfer In")) //Transfer in needs to see which account the money came from
            {
                System.out.println("    Transaction type: " + transaction.type + ", Transfered from account number " + transaction.from.accountNumber + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
            
            else if (transaction.type.equalsIgnoreCase("purchase")) //Purchase needs to show where the purchase took place. 
            {
                System.out.println("    Transaction type: " + transaction.type + ", Purchased from " + transaction.purchaseBusiness + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
        }
    }

}
