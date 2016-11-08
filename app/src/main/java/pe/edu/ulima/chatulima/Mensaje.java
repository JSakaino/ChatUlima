package pe.edu.ulima.chatulima;

/**
 * Created by hernan on 11/7/16.
 */
public class Mensaje {
    private String usuario;
    private String mensaje;

    public Mensaje() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Mensaje(String mensaje, String usuario) {

        this.mensaje = mensaje;
        this.usuario = usuario;
    }
}
