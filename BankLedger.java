import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
class BankLedger {
    TreeMap<Integer, Account> accounts = new TreeMap<>();
    Scanner sc = new Scanner(System.in);
    int getChoice() {
        System.out.print("Select Option: ");
        return sc.nextInt();
    }
    void addAccount() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        Account account = new Account(id, name, balance);
        accounts.put(id, account);
        System.out.println("[SUCCESS] Account created.");
    }
    void addMoney() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("[ERROR] Account not found.");
            return;
        }
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Date-Time (YYYY-MM-DDTHH:MM:SS): ");
        LocalDateTime time = LocalDateTime.parse(sc.nextLine());
        System.out.print("Enter Description: ");
        String description = sc.nextLine();
        acc.setBalance(acc.getBalance() + amount);
        Transaction transaction =
                new Transaction(time, "CREDIT", amount, description);
        acc.getTransactions().put(time, transaction);
        System.out.println("[SUCCESS] Money deposited.");
        System.out.println("New Balance: ₹" + acc.getBalance());
    }
    void debitMoney() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("[ERROR] Account not found.");
            return;
        }
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        if (acc.getBalance() < amount) {
            System.out.println("[ERROR] Insufficient funds.");
            return;
        }
        sc.nextLine();
        System.out.print("Enter Date-Time (YYYY-MM-DDTHH:MM:SS): ");
        LocalDateTime time = LocalDateTime.parse(sc.nextLine());
        System.out.print("Enter Description: ");
        String description = sc.nextLine();
        acc.setBalance(acc.getBalance() - amount);
        Transaction transaction =
                new Transaction(time, "DEBIT", amount, description);
        acc.getTransactions().put(time, transaction);
        System.out.println("[SUCCESS] Money withdrawn.");
        System.out.println("New Balance: ₹" + acc.getBalance());
    }

    void displayStatement() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("[ERROR] Account not found.");
            return;
        }
        System.out.print("Enter Start Date-Time: ");
        LocalDateTime startDate =
                LocalDateTime.parse(sc.nextLine());
        System.out.print("Enter End Date-Time: ");
        LocalDateTime endDate =
                LocalDateTime.parse(sc.nextLine());
        NavigableMap<LocalDateTime, Transaction> statement =
                acc.getTransactions().subMap(
                        startDate, true,
                        endDate, true
                );
        System.out.println("\n==============================================");
        System.out.println("ACCOUNT STATEMENT");
        System.out.println("Account ID: " + acc.getId());
        System.out.println("Customer: " + acc.getCustomerName());
        System.out.println("==============================================");
        for (Transaction t : statement.values()) {
            String sign = "";
            if (t.getType().equals("CREDIT")) {
                sign = "+";
            } else {
                sign = "-";
            }
            System.out.println(
                    t.getTimestamp() + " | " +
                    t.getType() + " | " +
                    sign + "₹" + t.getAmount() + " | " +
                    t.getDescription()
            );
        }
        System.out.println("==============================================");
        System.out.println(
                statement.size() +
                " transaction(s) found"
        );
    }
}