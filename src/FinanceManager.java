

public class FinanceManager {

    private static final FinanceManager instance =
            new FinanceManager();

    private int totalMoneyEarned = 0;
    private int totalMoneySpent = 0;

    private FinanceManager() {
    }

    public static FinanceManager getInstance() {
        return instance;
    }

    public void recordFees(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid fee amount");
        }

        totalMoneyEarned += amount;
    }

    public void recordSalary(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid salary amount");
        }

        totalMoneySpent += amount;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public int getBalance() {
        return totalMoneyEarned - totalMoneySpent;
    }
}