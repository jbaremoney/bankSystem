/*
 * Max Barrett, Jack Baretz, and Owen Reilly
 * CS-280
 * Project 1
 * 02/27/2024
 *
 * TODO : Make subclasses for each type of account (checking, savings, whatever else), make statement class work. (this is polymorphism)
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
        
        Account account1 = customer.accounts.get(0);
        Account account2 = customer.accounts.get(1);

        account1.deposit(100, "1/1/2024");
        System.out.println("Account 1 balance: " + account1.balance);

        account2.withdraw(50, "1/12/2024");
        System.out.println("Account 2 balance: " + account2.balance);
        
        // testing transfer system. should transfer 1000 dollars from account 1 to account 2
        account1.transferOut(account2, 1000, "1/20/2024");

        System.out.println("Account 1 transactions: " + account1.transactions);
        System.out.println("Account 1 balance:  " + account1.balance);

        account1.viewTransactions(); //This is to see there are two transactions in account 1 so far.

        System.out.println("Customer has " + customer.accounts.size() + " accounts");


        //account1.withdraw(101); //This is to show the InsufficientFundsException

        customer.removeAccount(account1);
        System.out.println("Customer has " + customer.accounts.size() + " accounts");


    }


}



