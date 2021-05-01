package udemy_exercises.bank.src;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch (String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return this.branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    // adding new customer
    public boolean newCustomer(String customerName, double initialDeposit) {
        if (findCustomer(customerName) == null ) {
            customers.add(new Customer(customerName, initialDeposit));
            return true;
        }
        return false;
    }

    // new transactions
    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer thisCusomer = findCustomer(customerName);
        if (thisCusomer != null ) {
            thisCusomer.addTransaction(amount);
            return true;
        }

        return false;
    }

    // finding customer
    private Customer findCustomer(String customerName) {
        for ( int i = 0; i<customers.size(); i++ ) {
            Customer foundCustomer = customers.get(i);
            if ( foundCustomer.getCustomerName().equals(customerName)) {
                return foundCustomer;
            }
        }
        return null;
    }
}













