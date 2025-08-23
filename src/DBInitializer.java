package fidespn;

import java.sql.*;

public class DBInitializer {
    public static void init() {
        try (Connection conn = ConexionBD.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS aficionados (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(50) UNIQUE NOT NULL,
                    password VARCHAR(100) NOT NULL
                )
            """);

            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS partidos (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    equipo1 VARCHAR(60) NOT NULL,
                    equipo2 VARCHAR(60) NOT NULL,
                    resultado VARCHAR(20) NOT NULL,
                    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
            """);

            // Usuario demo para login: maria / 1234
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT id FROM aficionados WHERE username = ?")) {
                ps.setString(1, "maria");
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    try (PreparedStatement ins = conn.prepareStatement(
                            "INSERT INTO aficionados (username, password) VALUES (?, ?)")) {
                        ins.setString(1, "maria");
                        ins.setString(2, "1234"); // En un proyecto real: usa hashing
                        ins.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error inicializando BD: " + e.getMessage());
        }
    }
}
