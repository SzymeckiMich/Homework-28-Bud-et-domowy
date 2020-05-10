import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

    //CREATE
    public void save(Transaction transaction) {
        Connection connection = connect();
        String insertTransaction = "INSERT INTO transaction(type, description, amount, date) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(insertTransaction);
            statement.setString(1, transaction.getType().name());
            statement.setString(2, transaction.getDescription());
            statement.setDouble(3, transaction.getAmount());
            statement.setDate(4, Date.valueOf(transaction.getDate()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Nie udało się zapisac rekordu");
            ex.printStackTrace();
        }
        closeConnection(connection);
    }

    // READ
    public List<Transaction> read(TransactionType type) {
        Connection connection = connect();
        PreparedStatement statement = null;
        List<Transaction> transactions = new ArrayList<>();
        try {
            String selectTransactionsWithType = "SELECT * FROM transaction WHERE type = ?";
            statement = connection.prepareStatement(selectTransactionsWithType);
            statement.setString(1, type.name());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                TransactionType transactionType = TransactionType.valueOf(resultSet.getString("type"));
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                transactions.add(new Transaction(id, transactionType, description, amount, date));
            }
            closeConnection(connection);
            return transactions;

        } catch (SQLException e) {
            System.err.println("Nie udało się");
            e.printStackTrace();
        }
        closeConnection(connection);
        return null;
    }

    //UPDATE
    public void update(Transaction transaction) {
        Connection connection = connect();
        String updateTransaction = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(updateTransaction);
            statement.setString(1, transaction.getType().name());
            statement.setString(2, transaction.getDescription());
            statement.setDouble(3, transaction.getAmount());
            statement.setDate(4, Date.valueOf(transaction.getDate()));
            statement.setLong(5, transaction.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Nie udało się zaktualizować");
            ex.printStackTrace();
        }
        closeConnection(connection);
    }

    //DELETE
    public void delete(long id) {
        Connection connection = connect();
        String deleteTransaction = "DELETE FROM transaction WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(deleteTransaction);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Nie udało się usunąć");
            ex.printStackTrace();
        }
        closeConnection(connection);
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/budzet?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

