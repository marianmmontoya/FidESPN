package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

public abstract class Usuario {
    protected String nombreUsuario;
    protected String contrasena;
    protected String tipoUsuario;

    public Usuario(String nombreUsuario, String contrasena, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void iniciarSesion() {
        System.out.println(nombreUsuario + " ha iniciado sesión.");
    }

    public void cerrarSesion() {
        System.out.println(nombreUsuario + " ha cerrado sesión.");
    }
}
