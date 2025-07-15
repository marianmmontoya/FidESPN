package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear un aficionado
        List<String> favoritos = Arrays.asList("Argentina", "España");
        Aficionado aficionado = new Aficionado("marian123", "1234", favoritos);

        // Crear un periodista
        List<String> asignados = Arrays.asList("Partido 1", "Partido 2");
        Periodista periodista = new Periodista("periodista1", "abcd", asignados);

        // Crear administrador
        Administrador admin = new Administrador("admin", "admin123");

        // Simular algunas acciones
        aficionado.verPartidos();
        aficionado.participarEnChat("¡Vamos Argentina!");
        periodista.reportarGol("España");
        admin.crearPartido();

        // Usar colección
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(aficionado);
        usuarios.add(periodista);
        usuarios.add(admin);

        for (Usuario u : usuarios) {
            u.iniciarSesion();
        }

        // Lanzar GUI
        LoginGUI gui = new LoginGUI();
        gui.setVisible(true);
    }
}
