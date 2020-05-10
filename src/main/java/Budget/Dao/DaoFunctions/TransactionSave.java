package Budget.Dao.DaoFunctions;

import Budget.Dao.TransactionDao;
import Budget.TransactionsElements.Transaction;

public class TransactionSave {
    public static void main(String[] args) {

        Transaction transaction = DaoUtils.addNewTransaction();

        TransactionDao dao = new TransactionDao();
        dao.save(transaction);
    }
}
