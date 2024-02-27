import java.io.*;
import java.util.ArrayList;

public class Statement {
    
    //If we want to print all accounts for a customer and list of transactions, we need to call on the customer class.
    Customer accountHolder;
    String firstDate;
    String lastDate;

    
    Statement(Customer accountHolder, String firstDate, String lastDate) //Statement constructor
    {
        this.accountHolder = accountHolder;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }
    
    void printMonthlyStatement()
    {
        //This should print the monthly statement of the account
        String fileName = "monthlyStatement.txt"; //This is what the filename will be
        String[] month = firstDate.split("/", 2); //The first part of the firstDate will be the month
        
        try //This has to be in a try just in case there's an error
        {
            FileWriter fileWriter = new FileWriter(fileName); //Filewriter and bufferedwriter are for writing to files
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Customer: " + accountHolder.name + "\t"); //prints the customer and dates the statement will have
            bufferedWriter.write("Statement printed: " + firstDate + " to " + lastDate);
            bufferedWriter.newLine();
            
            //iterate through each account and print the transactions
            for(int i = 0; i < accountHolder.savingsAccounts.size(); i++)
            {
                bufferedWriter.write("Account Number: " + accountHolder.savingsAccounts.get(i).accountNumber + "\t"); 
                bufferedWriter.write("Account Type: " + accountHolder.savingsAccounts.get(i).accountType + "\n");
                bufferedWriter.write("Date\t\t\tTransaction Type\t\tAmount\t\tBalance\n");  //This is just a title for the columns
                for(int j = 0; j < accountHolder.savingsAccounts.get(i).transactions.size(); j++) //This iterates through every transaction in each account
                {
                    if (accountHolder.savingsAccounts.get(i).transactions.get(j).date.split("/", 2)[0].equals(month[0])) //This long parameter is basically just checking if the transaction is in this statement period
                    {
                        String tempDate = accountHolder.savingsAccounts.get(i).transactions.get(j).date; //Because the date is used twice, we give it it's own variable
                        bufferedWriter.write(tempDate + "\t\t"); //prints the date
                        bufferedWriter.write(accountHolder.savingsAccounts.get(i).transactions.get(j).type + "\t\t\t"); //prints the type of transaction
                        bufferedWriter.write(accountHolder.savingsAccounts.get(i).transactions.get(j).amount + "\t\t");//prints the amount of the transaction
                        bufferedWriter.write(accountHolder.savingsAccounts.get(i).datedBalances.get(tempDate) + "\t"); //This prints the balance on the certain date
                        bufferedWriter.newLine();
                    }
                }
                bufferedWriter.newLine();
            }
            
            bufferedWriter.newLine(); //adds spacing to the statement
            
            for(int i = 0; i < accountHolder.checkingAccounts.size(); i++) //This is the same as the above for loop, but for checking account instead of savings account
            {
                bufferedWriter.write("Account Number: " + accountHolder.checkingAccounts.get(i).accountNumber + "\t");
                bufferedWriter.write("Account Type: " + accountHolder.checkingAccounts.get(i).accountType + "\n");
                bufferedWriter.write("Date\t\t\tTransaction Type\t\tAmount\t\tBalance\n");
                for(int j = 0; j < accountHolder.checkingAccounts.get(i).transactions.size(); j++)
                {
                    if (accountHolder.checkingAccounts.get(i).transactions.get(j).date.split("/", 2)[0].equals(month[0]))
                    {
                        String tempDate = accountHolder.checkingAccounts.get(i).transactions.get(j).date;
                        bufferedWriter.write(tempDate + "\t\t");
                        bufferedWriter.write(accountHolder.checkingAccounts.get(i).transactions.get(j).type + "\t\t\t");
                        bufferedWriter.write(accountHolder.checkingAccounts.get(i).transactions.get(j).amount + "\t\t");
                        bufferedWriter.write(accountHolder.checkingAccounts.get(i).datedBalances.get(tempDate) + "\t");
                        bufferedWriter.newLine();
                    }
                }
                bufferedWriter.newLine();
            }
            
            bufferedWriter.newLine();
            
            for(int i = 0; i < accountHolder.cdAccounts.size(); i++) //This is the same as the two above for statements but for cd accounts
            {
                bufferedWriter.write("Account Number: " + accountHolder.cdAccounts.get(i).accountNumber + "\t");
                bufferedWriter.write("Account Type: " + accountHolder.cdAccounts.get(i).accountType + "\n");
                bufferedWriter.write("Date\t\t\tTransaction Type\t\tAmount\t\tBalance\n");
                for(int j = 0; j < accountHolder.cdAccounts.get(i).transactions.size(); j++)
                {
                    if (accountHolder.cdAccounts.get(i).transactions.get(j).date.split("/", 2)[0].equals(month[0]))
                    {
                        String tempDate = accountHolder.cdAccounts.get(i).transactions.get(j).date;
                        bufferedWriter.write(tempDate + "\t\t");
                        bufferedWriter.write(accountHolder.cdAccounts.get(i).transactions.get(j).type + "\t\t\t");
                        bufferedWriter.write(accountHolder.cdAccounts.get(i).transactions.get(j).amount + "\t\t");
                        bufferedWriter.write(accountHolder.cdAccounts.get(i).datedBalances.get(tempDate) + "\t");
                        bufferedWriter.newLine();
                    }
                }
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }
        catch(IOException ex) { //Just for error in case it happens.
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
