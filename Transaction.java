import java.time.LocalDateTime;
class Transaction {
    private LocalDateTime timestamp;
    private String type;
    private double amount;
    private String description;
    public Transaction(
            LocalDateTime timestamp,
            String type,
            double amount,
            String description) {
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getType() {
        return type;
    }
    public double getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
}