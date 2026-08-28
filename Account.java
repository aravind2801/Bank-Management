import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.TreeMap;
class Account {
    private Integer id;
    private String customerName;
    private double balance;
    private NavigableMap<LocalDateTime, Transaction> transactions;
    public Account(Integer id, String customerName, double balance) {
        this.id = id;
        this.customerName = customerName;
        this.balance = balance;
        transactions = new TreeMap<>();
    }
    public Integer getId() {
        return id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public NavigableMap<LocalDateTime, Transaction> getTransactions() {
        return transactions;
    }
}