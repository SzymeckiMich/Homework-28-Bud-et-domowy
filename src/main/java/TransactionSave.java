public class TransactionSave {
    public static void main(String[] args) {

        Transaction transaction = TransactionUtils.addNewTransaction();

        TransactionDao dao = new TransactionDao();

        dao.save(transaction);
    }
}
