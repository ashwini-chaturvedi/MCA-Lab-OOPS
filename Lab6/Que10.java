package Lab6;
import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}

class BankAccount {

    private double balance;
    private boolean locked = false;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Lock account
    public void lock() {
        locked = true;
    }

    // Unlock account
    public void unlock() {
        locked = false;
    }

    public void deposit(double amount) throws InvalidAmountException, AccountLockedException {
        if (locked)
            throw new AccountLockedException("Account is locked! Cannot deposit.");

        if (amount < 0)
            throw new InvalidAmountException("Invalid amount! Deposit must be positive.");

        balance += amount;
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException, AccountLockedException {

        if (locked)
            throw new AccountLockedException("Account is locked! Cannot withdraw.");

        if (amount < 0)
            throw new InvalidAmountException("Invalid amount! Withdrawal must be positive.");

        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds! Balance: " + balance);

        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Remaining Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class Que10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000); // Initial balance

        while (true) {
            System.out.println("\n====== BANKING MENU ======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Lock Account");
            System.out.println("4. Unlock Account");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    try {
                        account.deposit(dep);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    try {
                        account.withdraw(wd);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    account.lock();
                    System.out.println("Account locked.");
                    break;

                case 4:
                    account.unlock();
                    System.out.println("Account unlocked.");
                    break;

                case 5: // Check balance
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 6: // Exit
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
