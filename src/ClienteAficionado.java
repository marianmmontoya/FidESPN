package fidespn;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteAficionado {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 5000;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Servidor dice: " + in.readLine()); // BIENVENIDO

            // LOGIN
            System.out.print("Usuario: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();
            out.println("LOGIN;" + u + ";" + p);
            String resp = in.readLine();
            System.out.println("Respuesta login: " + resp);
            if (!"OK".equalsIgnoreCase(resp)) {
                System.out.println("Login fallido. Fin.");
                out.println("SALIR");
                return;
            }

            // Menú simple
            while (true) {
                System.out.println("\n--- MENU AFICIONADO ---");
                System.out.println("1) Guardar partido");
                System.out.println("2) Ver partidos");
                System.out.println("3) Salir");
                System.out.print("Elige: ");
                String op = sc.nextLine();

                if ("1".equals(op)) {
                    System.out.print("Equipo 1: ");
                    String e1 = sc.nextLine();
                    System.out.print("Equipo 2: ");
                    String e2 = sc.nextLine();
                    System.out.print("Resultado (ej: 2-1): ");
                    String r = sc.nextLine();
                    out.println("GUARDAR_PARTIDO;" + e1 + ";" + e2 + ";" + r);
                    System.out.println("Servidor: " + in.readLine());
                } else if ("2".equals(op)) {
                    out.println("VER_PARTIDOS");
                    String line = in.readLine();
                    if ("SIN_PARTIDOS".equals(line)) {
                        System.out.println("(no hay partidos)");
                    } else if ("LISTA_INICIO".equals(line)) {
                        System.out.println("=== PARTIDOS ===");
                        while (!(line = in.readLine()).equals("LISTA_FIN")) {
                            System.out.println(line);
                        }
                    } else {
                        System.out.println("Servidor: " + line);
                    }
                } else if ("3".equals(op)) {
                    out.println("SALIR");
                    System.out.println("Servidor: " + in.readLine());
                    break;
                } else {
                    System.out.println("Opción inválida.");
                }
            }

        } catch (IOException e) {
            System.err.println("Error cliente: " + e.getMessage());
        }
    }
}
