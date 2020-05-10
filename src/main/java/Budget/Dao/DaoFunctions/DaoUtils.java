package Budget.Dao.DaoFunctions;

import Budget.TransactionsElements.Transaction;
import Budget.TransactionsElements.TransactionType;

import java.time.LocalDate;
import java.util.Scanner;

public class DaoUtils {

    public static Transaction addNewTransaction() {
        Transaction transaction = inputTransactionInformation();
        return transaction;
    }

    public static Transaction editTransaction(long id) {
        Transaction transaction = inputTransactionInformation();
        transaction.setId(id);
        return transaction;
    }

    private static Transaction inputTransactionInformation() {
        Scanner scanner = new Scanner(System.in);
        TransactionType type = inputTransactionType();
        System.out.println("Dodaj opis transakcji");
        String description = scanner.nextLine();
        System.out.println("Podaj kwote");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        LocalDate date = inputDate(scanner);

        return new Transaction(type, description, amount, date);
    }

    public static TransactionType inputTransactionType() {
        Scanner scanner = new Scanner(System.in);

        String type;

        while (true) {
            System.out.println("Podaj typ transakcji. 'W' jeśli wydatek, 'P' jeśli przychód");
            type = scanner.nextLine();
            switch (type.toUpperCase()) {
                case "W":
                    return TransactionType.WYDATEK;
                case "P":
                    return TransactionType.PRZYCHÓD;
            }
        }
    }

    public static LocalDate inputDate(Scanner scanner) {
        System.out.println("Wpisz rok transakcji");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Wpisz miesiąc transakcji");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj dzień miesiąca transakcji");
        int day = scanner.nextInt();
        scanner.nextLine();

        LocalDate date = LocalDate.of(year, month, day);

        return date;
    }
}
