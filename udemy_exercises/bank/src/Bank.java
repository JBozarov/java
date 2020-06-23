package udemy_exercises.bank.src;

import java.util.ArrayList;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;
    // constructor
    public Bank (String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    // Adding new branch
    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null ) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    // Adding new customer
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch thisBranch = findBranch(branchName);
        if (thisBranch != null ) {
            return thisBranch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    // Adding customer transactionss
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch thisBranch = findBranch(branchName);
        if ( thisBranch != null ) {
            thisBranch.addCustomerTransaction(branchName, amount);
            return true;
        }
        return false;
    }

    // finding a branch if so returning it
    public Branch findBranch(String branchName) {
        for ( int i = 0; i<this.branches.size(); i++ ) {
            Branch branch = this.branches.get(i);
            if ( branch.getBranchName().equals(branchName) ) {
                return branch;
            }
        }
        return null;
    }

    // print branch customers and transactions
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for this branch: " + branch.getBranchName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for ( int i = 0; i<branchCustomers.size(); i++ ) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer name is " + branchCustomer.getCustomerName());
                if (showTransactions) {
                    ArrayList<Double> transactions = branchCustomer.getTransaction();
                    for ( int j = 0; i<transactions.size(); j++ ) {
                        System.out.println("Transaction is " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

}

/*
**Banking w/ Java Classes**
   - **Bank class**
       - List of Branches
   - **Branch class**
     - List of Customers
     - List of Transactions
   - **Customer Class**:
     - Customer Name
   - **Branch Class**:
     - addCustomer and initial transaction amount.
     - Also needs to add additional transactions for that customer/branch
   - **Bank:**
     - Add a new branch
     - Add a customer to that branch with initial transaction
     - Add a transaction for an existing customer for that branch
     - Show a list of customers for a particular branch and optionally a list of their transactions
   - Demonstration autoboxing and unboxing in your code
   - Think about where you are adding the code to perform certain actions
*/