public class Bank {
    private ArrayList<Branches> branches;

    public ArrayList<Branches> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branches> branches) {
        this.branches = branches;
    }

    // Adding new branch
    public void addBranch(ArrayList<Branches> newBranch) {
        branches.add(newBranch);
    }

    // Add a customer to that branch with initial transaction

    // Add a transaction for an existing customer for that branch


    // Show a list of customers for a particular branch and optionally a list of their transactions

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