import java.io.*;
import java.util.ArrayList;

public class Statement {
    
    //If we want to print all accounts for a customer and list of transactions, we need to call on the customer class.
    Customer accountHolder;
    String firstDate;
    String lastDate;
    ArrayList<Transaction> thisMonthsTransactions = new ArrayList<Transaction>();
    int savingsCounter = 0;
    int checkingCounter = 0;
    int cdCounter = 0;
    
    /*
    for (Transaction transaction : accountHolder.savingsAccounts.transactions)
    {
        String[] tempString = transaction.date.split("/", 2);
        if (tempString.get(0).equals(month.get(0)))
        {
            thisMonthsTransactions.add(transaction);
            savingsCounter += 1;
        }
    }
    
    for (Transaction transaction : accountHolder.checkingAccounts.transactions)
    {
        String[] tempString = transaction.date.split("/", 2);
        if (tempString.get(0).equals(month.get(0)))
        {
            thisMonthsTransactions.add(transaction);
            checkingCounter += 1;
        }
    }
    
    for (Transaction transaction : accountHolder.cdAccounts.transactions)
    {
        String[] tempString = transaction.date.split("/", 2);
        if (tempString.get(0).equals(month.get(0)))
        {
            thisMonthsTransactions.add(transaction);
            cdCounter += 1;
        }
    }
    */
    
    Statement(Customer accountHolder, String firstDate, String lastDate)
    {
        this.accountHolder = accountHolder;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }
    
    void printMonthlyStatement()
    {
        //This should print the monthly statement of the account
        String fileName = "monthlyStatement.txt";
        String[] month = firstDate.split("/", 2);
        
        try
        {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Customer: " + accountHolder.name + "\t");
            bufferedWriter.write("Statement printed: " + firstDate + " to " + lastDate);
            bufferedWriter.newLine();
            
            //iterate through each account and print the transactions
            for(int i = 0; i < accountHolder.savingsAccounts.size(); i++)
            {
                bufferedWriter.write("Account Number: " + accountHolder.savingsAccounts.get(i).accountNumber + "\t");
                bufferedWriter.write("Account Type: " + accountHolder.savingsAccounts.get(i).accountType + "\n");
                bufferedWriter.write("Date\t\t\tTransaction Type\t\tAmount\t\tBalance\n");
                for(int j = 0; j < accountHolder.savingsAccounts.get(i).transactions.size(); j++)
                {
                    if (accountHolder.savingsAccounts.get(i).transactions.get(j).date.split("/", 2)[0].equals(month[0]))
                    {
                        bufferedWriter.write(accountHolder.savingsAccounts.get(i).transactions.get(j).date + "\t\t");
                        bufferedWriter.write(accountHolder.savingsAccounts.get(i).transactions.get(j).type + "\t\t\t");
                        bufferedWriter.write(accountHolder.savingsAccounts.get(i).transactions.get(j).amount + "\t\t");
                        bufferedWriter.write(accountHolder.savingsAccounts.get(i).balance + "\t");
                        bufferedWriter.newLine();
                    }
                }
            }
            
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            
            for(int i = 0; i < accountHolder.checkingAccounts.size(); i++)
            {
                bufferedWriter.write("Account Number: " + accountHolder.checkingAccounts.get(i).accountNumber + "\t");
                bufferedWriter.write("Account Type: " + accountHolder.checkingAccounts.get(i).accountType + "\n");
                bufferedWriter.write("Date\t\t\tTransaction Type\t\tAmount\t\tBalance\n");
                for(int j = 0; j < accountHolder.checkingAccounts.get(i).transactions.size(); j++)
                {
                    if (accountHolder.checkingAccounts.get(i).transactions.get(j).date.split("/", 2)[0].equals(month[0]))
                    {
                        bufferedWriter.write(accountHolder.checkingAccounts.get(i).transactions.get(j).date + "\t\t");
                        bufferedWriter.write(accountHolder.checkingAccounts.get(i).transactions.get(j).type + "\t\t\t");
                        bufferedWriter.write(accountHolder.checkingAccounts.get(i).transactions.get(j).amount + "\t\t");
                        bufferedWriter.write(accountHolder.checkingAccounts.get(i).balance + "\t");
                        bufferedWriter.newLine();
                    }
                }
            }
            
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            
            for(int i = 0; i < accountHolder.cdAccounts.size(); i++)
            {
                bufferedWriter.write("Account Number: " + accountHolder.cdAccounts.get(i).accountNumber + "\t");
                bufferedWriter.write("Account Type: " + accountHolder.cdAccounts.get(i).accountType + "\n");
                bufferedWriter.write("Date\t\t\tTransaction Type\t\tAmount\t\tBalance\n");
                for(int j = 0; j < accountHolder.cdAccounts.get(i).transactions.size(); j++)
                {
                    if (accountHolder.cdAccounts.get(i).transactions.get(j).date.split("/", 2)[0].equals(month[0]))
                    {
                        bufferedWriter.write(accountHolder.cdAccounts.get(i).transactions.get(j).date + "\t\t");
                        bufferedWriter.write(accountHolder.cdAccounts.get(i).transactions.get(j).type + "\t\t\t");
                        bufferedWriter.write(accountHolder.cdAccounts.get(i).transactions.get(j).amount + "\t\t");
                        bufferedWriter.write(accountHolder.cdAccounts.get(i).balance + "\t");
                        bufferedWriter.newLine();
                    }
                }
            }

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
