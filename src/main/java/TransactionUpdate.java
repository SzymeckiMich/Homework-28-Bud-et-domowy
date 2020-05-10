import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz edytować");
        long id = scanner.nextLong();
        scanner.nextLine();

        Transaction transaction = TransactionUtils.editTransaction(id);

        TransactionDao dao = new TransactionDao();
        dao.update(transaction);
    }
}
