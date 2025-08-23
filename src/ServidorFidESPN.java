package fidespn;

import java.io.*;
import java.net.*;
import java.sql.*;

public class ServidorFidESPN {
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor FidESPN escuchando en puerto " + PUERTO + " ...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + socket.getInetAddress());

                new Thread(() -> manejarCliente(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void manejarCliente(Socket socket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("BIENVENIDO_FIDESPN");

            String usuario = in.readLine();
            String contrasena = in.readLine();

            if (autenticarUsuario(usuario, contrasena)) {
                out.println("OK");
                System.out.println("Login correcto de usuario: " + usuario);
            } else {
                out.println("ERROR");
                System.out.println("Intento fallido de usuario: " + usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean autenticarUsuario(String usuario, String contrasena) {
        boolean valido = false;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:fidespn.db")) {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                valido = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valido;
    }
}
