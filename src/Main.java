import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/task_manager"; // адрес и порт базы данных, а также её имя
        String username = "root"; // имя пользователя базы данных
        String password = "admin"; // пароль для доступа к базе данных
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
        }
    }