import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountId;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        recordTransaction("Account created with initial balance: " + formatAmount(initialBalance));
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        recordTransaction("Deposited " + formatAmount(amount) + ", New balance: " + formatAmount(balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Available balance: " + formatAmount(balance));
            recordTransaction("Failed withdrawal of " + formatAmount(amount) + " due to insufficient funds");
            return;
        }
        balance -= amount;
        recordTransaction("Withdrew " + formatAmount(amount) + ", New balance: " + formatAmount(balance));
    }

    private void recordTransaction(String description) {
        // time stamp
        LocalDateTime now = LocalDateTime.now();
        String ts = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        transactionHistory.add(ts + " — " + description);
    }

    private String formatAmount(double amt) {
        return String.format("%.2f", amt);
    }

    public void printStatement() {
        System.out.println("Statement for account: " + accountId);
        for (String rec : transactionHistory) {
            System.out.println(rec);
        }
        System.out.println("Current balance: " + formatAmount(balance));
    }
}

// A simple driver / demo class
public class BankAccountDemo {
    public static void main(String[] args) {
        Account acc = new Account("ACC1001", 1000.0);
        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000);  // should fail
        acc.deposit(-50);    // invalid
        acc.printStatement();
    }
}
