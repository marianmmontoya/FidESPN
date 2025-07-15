package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

import java.util.ArrayList;
import java.util.List;

public class ChatEnVivo {
    private List<String> mensajes;

    public ChatEnVivo() {
        mensajes = new ArrayList<>();
    }

    public void enviarMensaje(String usuario, String texto) {
        String mensaje = usuario + ": " + texto;
        mensajes.add(mensaje);
        System.out.println(mensaje);
    }

    public void verMensajes() {
        for (String mensaje : mensajes) {
            System.out.println(mensaje);
        }
    }
}
