package Budget.Dao.DaoFunctions;

import Budget.Dao.TransactionDao;
import Budget.TransactionsElements.Transaction;

import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz edytować");
        long id = scanner.nextLong();
        scanner.nextLine();

        Transaction transaction = DaoUtils.editTransaction(id);

        TransactionDao dao = new TransactionDao();
        dao.update(transaction);
    }
}
