package fidespn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidoDAO {
    public static boolean insertar(String equipo1, String equipo2, String resultado) {
        String sql = "INSERT INTO partidos (equipo1, equipo2, resultado) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, equipo1);
            ps.setString(2, equipo2);
            ps.setString(3, resultado);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar partido: " + e.getMessage());
            return false;
        }
    }

    public static List<String> listar() {
        String sql = "SELECT id, equipo1, equipo2, resultado, creado_en FROM partidos ORDER BY id DESC";
        List<String> out = new ArrayList<>();
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                out.add(String.format("#%d %s vs %s -> %s (%s)",
                        rs.getInt("id"),
                        rs.getString("equipo1"),
                        rs.getString("equipo2"),
                        rs.getString("resultado"),
                        rs.getTimestamp("creado_en").toString()));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar partidos: " + e.getMessage());
        }
        return out;
    }
}
