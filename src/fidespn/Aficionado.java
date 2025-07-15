package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

import java.util.List;

public class Aficionado extends Usuario {
    private List<String> equiposFavoritos;

    public Aficionado(String nombreUsuario, String contrasena, List<String> equiposFavoritos) {
        super(nombreUsuario, contrasena, "aficionado");
        this.equiposFavoritos = equiposFavoritos;
    }

    public void verPartidos() {
        System.out.println(nombreUsuario + " está viendo los partidos.");
    }

    public void verMinutoAMinuto() {
        System.out.println(nombreUsuario + " está viendo el minuto a minuto.");
    }

    public void participarEnChat(String mensaje) {
        System.out.println(nombreUsuario + " dice: " + mensaje);
    }

    public List<String> getEquiposFavoritos() {
        return equiposFavoritos;
    }

    public void setEquiposFavoritos(List<String> equiposFavoritos) {
        this.equiposFavoritos = equiposFavoritos;
    }
}
