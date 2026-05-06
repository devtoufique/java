import java.util.Scanner;

class Account {

    private double balance;
    private int rateOfInterest;

    public Account(double balance, int rateOfInterest) {
        this.balance = balance;
        this.rateOfInterest = rateOfInterest;
    }

    public double get_balance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected int getRateOfInterest() {
        return rateOfInterest;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful");
        } else {
            System.out.println("Invalid or insufficient balance");
        }
    }

    public void addInterest() {
        balance += balance * rateOfInterest / 100;
        System.out.println("Interest added");
    }

    public void get_details() {
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + rateOfInterest + "%");
    }
}

class Savings extends Account {

    public Savings(double balance, int rateOfInterest) {
        super(balance, rateOfInterest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= get_balance()) {
            setBalance(get_balance() - amount);
            System.out.println("Savings: Withdraw successful");
        } else {
            System.out.println("Savings: Insufficient balance");
        }
    }

    @Override
    public void get_details() {
        System.out.println("Account Type: Savings");
        super.get_details();
    }
}

class Credit extends Account {

    public Credit(double balance, int rateOfInterest) {
        super(balance, rateOfInterest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            setBalance(get_balance() - amount);
            System.out.println("Credit: Withdraw successful");
        } else {
            System.out.println("Invalid withdrawal");
        }
    }

    @Override
    public void get_details() {
        System.out.println("Account Type: Credit");
        super.get_details();
    }
}

public class BankAccount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account acc;

        System.out.println("Choose Account Type:");
        System.out.println("1. Savings");
        System.out.println("2. Credit");
        int choice = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter interest rate: ");
        int rate = sc.nextInt();

        if (choice == 1) {
            acc = new Savings(balance, rate);
        } else {
            acc = new Credit(balance, rate);
        }

        int option;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest");
            System.out.println("4. Show Details");
            System.out.println("5. Exit");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                    break;

                case 3:
                    acc.addInterest();
                    break;

                case 4:
                    acc.get_details();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (option != 5);

        sc.close();
    }
}