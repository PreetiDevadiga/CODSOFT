
import java.util.Scanner;

public class ATM {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private int balance;

    public ATM() {
        this.balance = 1000; // Initial account balance
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(ANSI_GREEN + "Please collect your money." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Insufficient Balance." + ANSI_RESET);
        }
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(ANSI_GREEN + "Your money has been successfully deposited." + ANSI_RESET);
    }

    public void checkBalance() {
        System.out.println(ANSI_GREEN + "Balance: " + balance + ANSI_RESET);
    }

    public static void main(String[] args) {

        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(ANSI_YELLOW + "\n" + "******** Automated Teller Machine *********" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit" + ANSI_RESET);
            System.out.print(ANSI_YELLOW + "Choose the operation you want to perform: "  +ANSI_RESET);

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print(ANSI_GREEN + "Enter amount to be withdrawn: " + ANSI_RESET);
                    int withdrawAmount = sc.nextInt();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print(ANSI_GREEN + "Enter amount to be deposited: " + ANSI_RESET);
                    int depositAmount = sc.nextInt();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println(ANSI_RED + "Invalid choice. Please select a valid option." + ANSI_RESET);
            }
        }
    }
}
