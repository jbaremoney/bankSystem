/*
 * Max Barrett, Jack Baretz, and Owen Reilly
 * CS-280
 * Project 1
 * 02/27/2024
 *
 * TODO : Make subclasses for each type of account (checking, savings, cd), and implement them fully, make statement class work, figure out how to write to a document for things like viewAccount.
 */


public class BankSystemTest
{
    public static void main(String[] args) throws InsufficientFundsException {
   //Testing various things to see if they work
        Customer customer = new Customer();
        customer.name = "Max Barrett";
        customer.address = "1234 Main St";
        customer.email = "something@gmail.com";
        customer.phone = "123-456-7890";

        customer.createAccount("Checking", 1000);
        customer.createAccount("Savings", 1000);
        customer.createAccount("CD", 1000, "1/1/2025");
        
        CheckingAccount account1 = customer.checkingAccounts.get(0);
        SavingsAccount account2 = customer.savingsAccounts.get(0);
        CD account3 = customer.cdAccounts.get(0);
        
        //customer.viewBankAccount(account1); //Viewing each account individually
        //customer.viewBankAccount(account2);
        //customer.viewBankAccount(account3);
        customer.viewAllBankAccounts();  //Viewing all accounts at once

        account1.deposit(100, "1/1/2024");
        System.out.println("\nAccount 1 balance: " + account1.balance);

        account2.withdraw(50, "1/12/2024");
        System.out.println("Account 2 balance: " + account2.balance);
        
        // testing transfer system. should transfer 1000 dollars from account 1 to account 2
        account1.transferOut(account2, 1000, "1/20/2024");
        
        System.out.println("\nAccount 1 balance:  " + account1.balance);
        System.out.println("Account 2 balance:  " + account2.balance);
        System.out.println("Account 1 account number: " + account1.accountNumber);
        System.out.println("Account 2 account number: " + account2.accountNumber + "\n");

        account1.viewTransactions(); //This is to see there are two transactions in account 1 so far.

        System.out.println("\nCustomer has " + customer.numOfAccounts + " accounts before removal");


        //account1.withdraw(101, "1/22/2024"); //This is to show the InsufficientFundsException
        account1.deposit(50.05, "1/22/2024");
        account1.purchase(10, "Scheels", "1/1/2024");
        
        
        Statement testStatement = new Statement(customer, "1/1/2024", "2/1/2024");
        testStatement.printMonthlyStatement();
        
        customer.removeAccount(account1);
        System.out.println("Customer has " + customer.numOfAccounts + " accounts after removal");
    }


}



