import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 1000.00, 200.00,0.05));
        accounts.add(new SavingsAccount("SAV-002", 500.00, 100.00,0.03));
        accounts.add(new CurrentAccount("CUR-001", 300.00, 500.00, 10.00));
        accounts.add(new CurrentAccount("CUR-002", 100.00, 200.00, 5.00));

        System.out.println("=== Opening balances ===");
        for (Account acc : accounts) {
            System.out.printf("  %-15s %s  balance: %.2f%n",
                    acc.getClass().getSimpleName(), acc.getAccountNumber(), acc.getBalance());
        }

        System.out.println("\n=== Deposit validation (concrete method in Account) ===");
        accounts.get(0).deposit(250.00);
        accounts.get(0).deposit(-50.00);

        System.out.println("\n=== Polymorphic loop 1: withdraw(700.00) on every account ===");
        for (Account acc : accounts) {
            acc.withdraw(700.00);
        }

        System.out.println("\n=== Polymorphic loop 2: endOfMonth() on every account ===");
        for (Account acc : accounts) {
            acc.endOfMonth();
        }

        System.out.println("\n=== Final balances ===");
        for (Account acc : accounts) {
            System.out.printf("  %-15s %s  balance: %.2f%n",
                    acc.getClass().getSimpleName(), acc.getAccountNumber(), acc.getBalance());
        }
    }
}