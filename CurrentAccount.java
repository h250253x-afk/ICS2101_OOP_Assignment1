public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double monthlyFee;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit, double monthlyFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  [" + accountNumber + "] Withdrawal rejected: Input a valid withdrawal amount greater than 0.");
            return;
        }
        // Reject if the balance after the withdrawal would be under the overdraft limit
        if (this.balance - amount < -overdraftLimit) {
            System.out.printf("[" + accountNumber + "] Withdrawal of REJECTED: balance would fall below the overdraft limit of %.2f (current balance: %.2f).%n",
                accountNumber, amount, overdraftLimit, this.balance);
            return;
        }
        this.balance -= amount;
        System.out.printf ("[%s] Withdrew %.2f. New balance: %.2f%n", accountNumber, amount, balance);
    }

    @Override
    public void endOfMonth() {
        this.balance -= monthlyFee;
        System.out.printf("  [%s] Current month-end: maintenance fee of %.2f deducted. New balance: %.2f%n",
                accountNumber, monthlyFee, balance);
    }
}