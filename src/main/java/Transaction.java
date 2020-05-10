import java.util.Date;

public class Transaction {
    private Long id;
    private TransactionType type;
    private String description;
    private double amount;
    private Date date;


    public Transaction(Long id, TransactionType type, String description, double amount, Date date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(TransactionType type, String description, double amount, Date date) {
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

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return type.name() + " " + description + " " + amount + " " + date;
    }
}
