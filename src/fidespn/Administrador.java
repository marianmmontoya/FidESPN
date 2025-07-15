package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

public class Administrador extends Usuario {

    public Administrador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena, "administrador");
    }

    public void crearPartido() {
        System.out.println("Administrador creó un nuevo partido.");
    }

    public void asignarPeriodista(String periodista) {
        System.out.println("Se asignó a " + periodista + " como periodista del partido.");
    }

    public void editarAlineaciones() {
        System.out.println("Administrador está editando alineaciones.");
    }
}
