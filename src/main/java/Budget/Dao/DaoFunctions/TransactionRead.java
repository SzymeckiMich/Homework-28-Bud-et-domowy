package Budget.Dao.DaoFunctions;

import Budget.Dao.TransactionDao;
import Budget.TransactionsElements.Transaction;
import Budget.TransactionsElements.TransactionType;

import java.util.List;

public class TransactionRead {
    public static void main(String[] args) {

        TransactionType type = DaoUtils.inputTransactionType();

        TransactionDao dao = new TransactionDao();
        List<Transaction> transactions = dao.read(type);

        if (transactions.isEmpty()) {
            System.out.println("Brak transakcji");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
        }
    }
}
