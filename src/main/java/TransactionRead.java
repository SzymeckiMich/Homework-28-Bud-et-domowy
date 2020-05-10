import java.util.Scanner;

public class TransactionRead {
    public static void main(String[] args) {
        final String WYDATEK = "W";
        final String PRZYCHÓD = "P";
        String transactionType;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Podaj typ transakcji");
            System.out.println("'W' - WYDATEK");
            System.out.println("'P' - PRZYCHÓD");
            transactionType = scanner.nextLine().toUpperCase();

        }
        while (!(transactionType.equals(WYDATEK) || transactionType.equals(PRZYCHÓD)));

        BudzetDao dao = new BudzetDao();

        TransactionType type = transactionType.equals(WYDATEK) ? TransactionType.WYDATEK : TransactionType.PRZYCHÓD;


        dao.read(type);

    }
}
