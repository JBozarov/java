
import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transaction;

    public Customer(String customerName, Double initialAmount) {
        this.customerName = customerName;
        this.transaction = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    // adding new transactions
    public void addTransaction(Double amount) {
        this.transaction.add(amount);
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public ArrayList<Double> getTransaction() {
        return this.transaction;
    }
}