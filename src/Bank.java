import java.util.ArrayList;

public class Bank {
    String name;
    ArrayList<Customer> customers = new ArrayList<>();

    void addCustomer(Customer customer)
    {
        customers.add(customer);
    }

    void removeCustomer(Customer customer)
    {
        customers.remove(customer);
    }
}
