import java.util.ArrayList;
import java.util.Random;

public class Account
{
    Random rand = new Random();//For randomized accountNumber
   
    // ACCOUNT ATTRIBUTES
    int accountNumber;
    String accountType;
    double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();
    
    Account(String accountType, double initialDeposit)
    {
        accountNumber = rand.nextInt(100000);
        this.accountType = accountType;
        balance = initialDeposit;
    }


    // ACCOUNT METHODS
    void deposit(double amount, String date)
    {
        balance += amount;
        Transaction transaction = new Transaction("Deposit ", amount, date);
        this.transactions.add(transaction);
    }

    void withdraw(double amount, String date) throws InsufficientFundsException //given account has enough money
    {
       if (this.balance >= amount){
          balance -= amount;
          Transaction transaction = new Transaction("Withdraw", amount, date);
          this.transactions.add(transaction);
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
        }
        else {
            throw new InsufficientFundsException("Insufficient funds for purchase: required " + amount + ", available " + this.balance);
        }
    }



    void viewTransactions()
    {
        System.out.println(accountNumber + " Transactions: ");
        for (Transaction transaction : transactions) {
            if (transaction.type.equalsIgnoreCase("deposit ") | transaction.type.equalsIgnoreCase("withdraw")) //deposit and withdraw have the same amount of attributes to print
            {
                System.out.println("    Transaction type: " + transaction.type + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
            
            else if (transaction.type.equalsIgnoreCase("Transfer Out"))
            {
                System.out.println("    Transaction type: " + transaction.type + ", Transfered to " + transaction.to.accountNumber + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
            
            else if (transaction.type.equalsIgnoreCase("Transfer In"))
            {
                System.out.println("    Transaction type: " + transaction.type + ", Transfered from " + transaction.from.accountNumber + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
            
            else if (transaction.type.equalsIgnoreCase("purchase"))
            {
                System.out.println("    Transaction type: " + transaction.type + ", Purchased from " + transaction.purchaseBusiness + ", Transaction amount: " + transaction.amount + ", Date: " + transaction.date);
            }
        }
    }

}
