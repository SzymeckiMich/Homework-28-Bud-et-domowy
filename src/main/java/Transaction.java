import java.time.LocalDate;

public class Transaction {
    private Long id;
    private TransactionType type;
    private String description;
    private double amount;
    private LocalDate date;


    public Transaction(Long id, TransactionType type, String description, double amount, LocalDate date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public Transaction(TransactionType type, String description, double amount, LocalDate date) {
        this(null, type, description, amount, date);
    }

    public TransactionType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return type.name() + " " + description + " " + amount + " " + date;
    }
}
