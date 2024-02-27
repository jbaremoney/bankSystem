/*
 * Max Barrett, Jack Baretz, and Owen Reilly
 * CS-280
 * Project 1
 * 02/27/2024
 *
 */


public class BankSystemTest
{
    public static void main(String[] args) throws InsufficientFundsException {
   //Testing various things to see if they work
        Customer customer = new Customer("Max Barrett", "1234 Main St", "something@gmail.com", "123-456-7890");

        customer.createAccount("Checking", 1000); //Initialized accounts
        customer.createAccount("Savings", 1000);
        customer.createAccount("CD", 1000, "1/1/2025");
        customer.createAccount("Checking", 1000); //Just to have multiple checking accounts on a monthly statement
        
        CheckingAccount account1 = customer.checkingAccounts.get(0); //Giving each account a name in the tester to make things easier
        SavingsAccount account2 = customer.savingsAccounts.get(0);
        CD account3 = customer.cdAccounts.get(0);
        CheckingAccount account4 = customer.checkingAccounts.get(1);
        
        //customer.viewBankAccount(account1); //Viewing each account individually
        //customer.viewBankAccount(account2);
        //customer.viewBankAccount(account3);
        customer.viewAllBankAccounts();  //Viewing all accounts at once

        account1.deposit(100, "1/1/2024");
        System.out.println("\nAccount 1 balance: " + account1.balance); //Testing to see if deposit works

        account2.withdraw(50, "1/12/2024");
        System.out.println("Account 2 balance: " + account2.balance); //Testing to see if withdraw works
        
        // testing transfer system. should transfer 1000 dollars from account 1 to account 2
        account1.transferOut(account2, 1000, "1/20/2024");
        
        System.out.println("\nAccount 1 balance:  " + account1.balance);
        System.out.println("Account 2 balance:  " + account2.balance);
        System.out.println("Account 1 account number: " + account1.accountNumber); //This is to show what the account numbers are for view transactions
        System.out.println("Account 2 account number: " + account2.accountNumber + "\n");

        account1.viewTransactions(); //This is to see there are two transactions in account 1 so far.

        System.out.println("\nCustomer has " + customer.numOfAccounts + " accounts before removal");

        //Everything below this is mostly for testing that things show up correctly on the statement, so it's just a bunch of fake transactions
        //account1.withdraw(101, "1/22/2024"); //This is to show the InsufficientFundsException
        account1.deposit(50.05, "1/22/2024");
        account1.purchase(10, "Scheels", "1/25/2024");
        account1.deposit(100, "2/2/2024"); //This shouldn't show up in the current statement.
        account2.transferOut(account1, 500, "3/1/2024"); //This shouldn't show up in the current statement
        account4.withdraw(200, "1/20/2024");
        account4.purchase(150.63, "McDonalds", "1/23/2024");
        account4.withdraw(100, "1/31/2024");
        account4.deposit(100, "2/1/2024"); //This shouldn't show up in the current statement.
        
        
        Statement testStatement = new Statement(customer, "1/1/2024", "2/1/2024"); //This is the statement for the month of January
        testStatement.printMonthlyStatement();
        
        customer.removeAccount(account1); //To show you can remove accounts
        System.out.println("Customer has " + customer.numOfAccounts + " accounts after removal");
    }
}