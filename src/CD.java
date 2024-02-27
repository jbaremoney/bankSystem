public class CD extends Account {
    double interestRate = .05;
    String withdrawDate;
    
    CD(String accountType, double initialBalance, String withdrawDate)
    {
        super(accountType, initialBalance);
        this.withdrawDate = withdrawDate;
    }

    //gets the withdraw date
    String getWithdrawDate()
    {
        return withdrawDate;
    }
}
