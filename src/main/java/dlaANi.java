import java.util.Scanner;

public class dlaANi {

    public static void main(String[] args) {

        String transactionType;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Podaj W albo P");
            transactionType = scanner.nextLine().toUpperCase();
        }
        while (!(transactionType.equals("W") || transactionType.equals("P")));

        System.out.println(transactionType);
    }
}
