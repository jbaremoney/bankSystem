import java.util.ArrayList;

public class Customer {
    String name;
    String address;
    String email;
    String phone;
    ArrayList<Account> accounts = new ArrayList<>();

    void createAccount(String accountType, double initialDeposit)
    {
        Account account = new Account();
        account.accountType = accountType;
        account.balance = initialDeposit;
        accounts.add(account);
    }


    void removeAccount(Account account)
    {
        accounts.remove(account);
    }
}
