import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BudzetDao {
    private static final String URL = "jdbc:mysql://localhost:3306/budzet?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    private Connection connection;

    public BudzetDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Nie udało sie nawiązać połączenia");
        } catch (ClassNotFoundException ex) {
            System.err.println("Nie znaleziono sterownika");
        }
    }

    //CREATE
    public void save(Transaction transaction) {
        String insertTransaction = "INSERT INTO transaction(type, description, amount, date) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(insertTransaction);
            statement.setString(1, transaction.getType().name());
            statement.setString(2, transaction.getDescription());
            statement.setDouble(3, transaction.getAmount());
            statement.setDate(4, (Date) transaction.getDate());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Nie udało się zapisac rekordu");
            ex.printStackTrace();
        }
    }


    // READ
    public Optional<List<Transaction>> read(TransactionType type) {
        List<Transaction> transactions = new ArrayList<>();
        String selectTransactionsWithType = "SELECT * FROM transaction WHERE type = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(selectTransactionsWithType);
            statement.setString(1, type.name());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                TransactionType transactionType = TransactionType.valueOf(resultSet.getString("type"));
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                Date date = resultSet.getDate("date");

                transactions.add(new Transaction(id, transactionType, description, amount, date));
            }

            return Optional.of(transactions);

        } catch (SQLException e) {
            System.err.println("Nie udało się");
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //UPDATE
    public void update(Transaction transaction) {
        String updateTransaction = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(updateTransaction);
            statement.setString(1, transaction.getType().name());
            statement.setString(2, transaction.getDescription());
            statement.setDouble(3, transaction.getAmount());
            statement.setDate(4, (Date) transaction.getDate());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Nie udało się zaktualizować");
            ex.printStackTrace();
        }
    }

    //DELETE
    public void delete(long id) {
        String deleteTransaction = "DELETE FROM transaction WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(deleteTransaction);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Nie udało się usunąć");
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Nie udało się zamknąć");
        }
    }


}
