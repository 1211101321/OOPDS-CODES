import java.io.ObjectInputValidation;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * An Account class represent a saving account in a bank. 
 */

public class account {
    // instance data fields
    private int id;
    private double balance = 100;
    private LocalDate dateCreated = LocalDate.now();
    //static data field
    private static int numberOfObjects; //0

    // constructors
    /**
     * Construct a new Account with specified id and balance values.
     * @param id 
     *        id of account 
     * @param balance 
     *        balance of account
     */
    public account() {
        numberOfObjects++;
    } // no arg constructor

    public account(int id, double balance) { // overloaded constructor
        this.id = id;
        this.balance = balance;
        numberOfObjects++;
    }

    // accessors/getters
    /**
     * return the number of Account object created
     * @return 
     */
    public static int getNumberOfObject(){
        return numberOfObjects;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public double deposit(double amount) {
        if (amount < 0) {
            System.out.println("Error: Amount to deposit must be a positive number");

        } else {
            balance += amount;

        }
        return balance;

    }

    public double witdraw(double amount) {
        if (amount < 0) {
            System.out.println("Error: Amount to witdraw must be a positive number");

        } else {
            balance -= amount;

        }
        return balance;

    }

}

class TestAccount { // user/clients of account
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        

        account[] accounts = new account[3]; // [null,null,null]
        System.out.println(Arrays.toString(accounts));
        System.out.println("Number of objects = "+ account.getNumberOfObject());

        accounts[0] = new account(); // invoke no arg constructor
        System.out.println("Number of objects = "+ account.getNumberOfObject());

        accounts[1] = new account(102, 2000); // invoke overloaded constructor
        System.out.println("Number of objects = "+ account.getNumberOfObject());

        System.out.println("Create the 3rd account");
        System.out.println("Enter account id: ");
        int id = input.nextInt();
        System.out.println("Enter balance:  RM");
        double balance = input.nextDouble();
        accounts[2] = new account(id, balance);
        System.out.println("Number of objects = "+ account.getNumberOfObject());

        System.out.print(Arrays.toString(accounts));
        for (int i = 0; i < accounts.length; i++) {// for each
            System.out.println("Account #" + (i + 1));
            System.out.println("Account id = " + accounts[i].getId());
            System.out.println("Account balance = " + accounts[i].getBalance());
            System.out.println("Created = " + accounts[i].getDateCreated());
            System.out.println();
        }
        System.out.println("Deposit and Withdraw");
        System.out.println("Enter account id: ");
        id = input.nextInt();
        System.out.println("Enter amount to deposit: RM");
        balance = input.nextDouble();

        for (account e : accounts) {
            if (e.getId() == id) {
                System.out.println("Balance = RM" + e.deposit(balance));
            }
        
        }

        System.out.println("Enter amount to withdraw: RM");
        balance = input.nextDouble();

        for (account e : accounts) {
            if (e.getId() == id) {
                System.out.println("Balance = RM" + e.witdraw(balance));
            }
            
        }
    }
}