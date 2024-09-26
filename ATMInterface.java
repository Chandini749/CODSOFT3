import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) { this.balance = balance; }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid deposit amount.");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println(amount > balance ? "Insufficient funds." : "Invalid withdrawal amount.");
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) { this.account = account; }

    public void checkBalance() { System.out.printf("Balance: $%.2f\n", account.getBalance()); }

    public void deposit(double amount) { account.deposit(amount); }

    public void withdraw(double amount) { account.withdraw(amount); }

    public void showMenu() {
        System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(500);  // Default initial balance

        ATM atm = new ATM(account);
        boolean exit = false;

        while (!exit) {
            atm.showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> atm.checkBalance();
                case 2 -> { System.out.print("Deposit amount: "); atm.deposit(scanner.nextDouble()); }
                case 3 -> { System.out.print("Withdraw amount: "); atm.withdraw(scanner.nextDouble()); }
                case 4 -> exit = true;
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
