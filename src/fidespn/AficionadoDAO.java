package fidespn;

import java.sql.*;

public class AficionadoDAO {
    public static boolean login(String username, String password) {
        String sql = "SELECT id FROM aficionados WHERE username = ? AND password = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password); // (Demo) En real, compara hash
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error login: " + e.getMessage());
            return false;
        }
    }

    public static boolean registrar(String username, String password) {
        String sql = "INSERT INTO aficionados (username, password) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error registrar: " + e.getMessage());
            return false;
        }
    }
}
