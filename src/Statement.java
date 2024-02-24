import java.io.*;
public class Statement {

    //this should get all attributes associated with Account class 
    Customer accountHolder;
    Account accountUsed;
    String firstDate;
    String lastDate;
    
    void printMonthlyStatement()
    {
        String fileName = "monthlyStatement.txt";
        try 
        {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Customer: " + accountHolder.name + "\t");
            bufferedWriter.write("Account Number: " + accountUsed.accountNumber + "\t");
            bufferedWriter.write("Account Type: " + accountUsed.accountType + "\t");
            bufferedWriter.write("Statement printed: " + firstDate + " to " + lastDate);
            bufferedWriter.newLine();
            bufferedWriter.write("Date\t\t\tTransaction Type\t\tAmount\t\tBalance");
            bufferedWriter.newLine();
            for (int i = 0; i < accountUsed.transactions.size(); i++)
            {
                bufferedWriter.write(accountUsed.transactions.get(i).date + "\t");
                bufferedWriter.write(accountUsed.transactions.get(i).type + "\t");
                bufferedWriter.write(accountUsed.transactions.get(i).amount + "\t");
                bufferedWriter.write(accountUsed.balance + "\t");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
