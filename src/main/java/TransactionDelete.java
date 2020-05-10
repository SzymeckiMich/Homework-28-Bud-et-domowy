import java.util.Scanner;

public class TransactionDelete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz usunąć");
        long id = scanner.nextLong();
        scanner.nextLine();

        TransactionDao dao = new TransactionDao();
        dao.delete(id);
        System.out.println("Usunięto");

    }

}
