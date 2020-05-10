import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz edytować");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Podaj opis transakcji");
        String desc = scanner.nextLine();

        System.out.println("Podaj kwotę");
        double amount = scanner.nextDouble();

        System.out.println("Podaj datę transakcji");


    }
}
