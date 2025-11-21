import java.util.Scanner;

public class ATMSystem {

    // Initial balance
    static double balance = 5000.00;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("===== ATM BANKING SYSTEM =====");

        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit(sc);
                    break;

                case 3:
                    withdraw(sc);
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    // Method to deposit money
    public static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Method to withdraw money
    public static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
}

