import java.util.Date;
import java.util.Scanner;

public class TransactionSave {
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

        TransactionType type = transactionType.equals(WYDATEK) ? TransactionType.WYDATEK : TransactionType.PRZYCHÓD;


        String description = scanner.nextLine();
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Date date = inputDate(scanner);

        BudzetDao dao = new BudzetDao();
        dao.save(new Transaction(type, description, amount, date));


    }

    private static Date inputDate(Scanner scanner) {
        System.out.println("Wpisz rok transakcji");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Wpisz miesiąc transakcji");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj dzień miesiąca transakcji");
        int day = scanner.nextInt();
        scanner.nextLine();

        return new Date(year, month, day);
    }
}
