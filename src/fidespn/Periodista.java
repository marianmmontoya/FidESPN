package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

import java.util.List;

public class Periodista extends Usuario {
    private List<String> partidosAsignados;

    public Periodista(String nombreUsuario, String contrasena, List<String> partidosAsignados) {
        super(nombreUsuario, contrasena, "periodista");
        this.partidosAsignados = partidosAsignados;
    }

    public void verPartidosAsignados() {
        System.out.println("Partidos asignados a " + nombreUsuario + ": " + partidosAsignados);
    }

    public void reportarGol(String equipo) {
        System.out.println("¡Gol reportado por " + nombreUsuario + " del equipo " + equipo + "!");
    }

    public void reportarTarjeta(String jugador, String tipo) {
        System.out.println("Tarjeta " + tipo + " reportada para " + jugador + " por " + nombreUsuario);
    }

    public void reportarOtroEvento(String evento) {
        System.out.println(nombreUsuario + " reporta: " + evento);
    }

    public List<String> getPartidosAsignados() {
        return partidosAsignados;
    }

    public void setPartidosAsignados(List<String> partidosAsignados) {
        this.partidosAsignados = partidosAsignados;
    }
}
