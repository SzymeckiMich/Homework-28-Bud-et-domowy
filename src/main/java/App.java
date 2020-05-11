import Budget.Dao.DaoFunctions.TransactionDelete;
import Budget.Dao.DaoFunctions.TransactionRead;
import Budget.Dao.DaoFunctions.TransactionSave;
import Budget.Dao.DaoFunctions.TransactionUpdate;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {

                System.out.println("Co chcesz zrobić?");
                System.out.println("1 - dodawanie");
                System.out.println("2 - wyszukiwanie");
                System.out.println("3 - edycja");
                System.out.println("4 - usuwanie");
                System.out.println("0 - koniec programu");

                String userinput = scanner.nextLine();


                switch (userinput) {
                    case "1":
                        TransactionSave.main(new String[0]);
                        break;
                    case "2":
                        TransactionRead.main(new String[0]);
                        break;
                    case "3":
                        TransactionUpdate.main(new String[0]);
                        break;
                    case "4":
                        TransactionDelete.main(new String[0]);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Zły wybór");
                }
            }
        }
    }
}
