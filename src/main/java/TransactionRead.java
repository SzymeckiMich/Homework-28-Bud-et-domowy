import java.util.List;

public class TransactionRead {
    public static void main(String[] args) {

        TransactionType type = TransactionUtils.inputTransactionType();

        TransactionDao dao = new TransactionDao();
        List<Transaction> transactions = dao.read(type);

        if (transactions.isEmpty()) {
            System.out.println("Lista jest pusta");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
        }

    }
}
