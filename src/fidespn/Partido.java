package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

import java.util.ArrayList;
import java.util.List;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String fecha;
    private String hora;
    private List<String> alineacionLocal;
    private List<String> alineacionVisitante;
    private String periodistaAsignado;
    private List<String> eventosReportados;
    private ChatEnVivo chat;

    public Partido(String equipoLocal, String equipoVisitante, String fecha, String hora, String periodistaAsignado) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.hora = hora;
        this.periodistaAsignado = periodistaAsignado;
        this.alineacionLocal = new ArrayList<>();
        this.alineacionVisitante = new ArrayList<>();
        this.eventosReportados = new ArrayList<>();
        this.chat = new ChatEnVivo();
    }

    public void agregarEvento(String evento) {
        eventosReportados.add(evento);
        System.out.println("Evento agregado: " + evento);
    }

    public void mostrarPartido() {
        System.out.println("Partido: " + equipoLocal + " vs " + equipoVisitante);
        System.out.println("Fecha: " + fecha + ", Hora: " + hora);
        System.out.println("Periodista: " + periodistaAsignado);
        System.out.println("Eventos: " + eventosReportados);
    }

    public ChatEnVivo getChat() {
        return chat;
    }
}
