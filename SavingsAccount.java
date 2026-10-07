public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
         if (amount <= 0) {
            System.out.println("  [" + accountNumber + "] Withdrawal rejected: Input a valid withdrawal amount greater than 0.");
            return;
        }
        // Reject if the balance after the withdrawal would be under the minimum
        if (this.balance - amount < minimumBalance) {
            System.out.printf("[" + accountNumber + "] Withdrawal of REJECTED: balance would fall below the minimum of %.2f (current balance: %.2f).%n",
                accountNumber, amount, minimumBalance, this.balance);
            return;
        }
        this.balance -= amount;
        System.out.printf ("[%s] Withdrew %.2f. New balance: %.2f%n", accountNumber, amount, balance);
    }

    @Override
    public void endOfMonth() {
        double interest = getBalance() * (interestRate / 100);
        balance += interest;
        System.out.printf("  [%s] Savings month-end: interest of %.2f (%.0f%%) added. New balance: %.2f%n",
                accountNumber, interest, interestRate * 100, balance);
    }
}
