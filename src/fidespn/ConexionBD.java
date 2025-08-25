package fidespn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DB_NAME = "fidespn_db";
    private static final String DB_USER = "root";       
    private static final String DB_PASSWORD = "1234"; 

    private static Connection connection;

    
    public static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) return connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ignored) {}

        // 1) Conectar al servidor (sin BD) y crear la base si no existe
        String serverUrl = String.format("jdbc:mysql://%s:%d/?useSSL=false&serverTimezone=UTC", HOST, PORT);
        try (Connection conn = DriverManager.getConnection(serverUrl, DB_USER, DB_PASSWORD);
             Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
        }

        // 2) Conectar a la base creada
        String dbUrl = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC", HOST, PORT, DB_NAME);
        connection = DriverManager.getConnection(dbUrl, DB_USER, DB_PASSWORD);
        return connection;
    }
}
