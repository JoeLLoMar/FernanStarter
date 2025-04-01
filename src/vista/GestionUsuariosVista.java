package vista;

import modelo.Usuario;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuariosVista {
    private String colorTexto;
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public void setColorTexto(String colorTexto) {
        this.colorTexto = colorTexto;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(colorTexto + mensaje + RESET);
    }

    public void mostrarListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
        for (Map.Entry pareja : listaUsuarios.entrySet()) {
            System.out.println(pareja.getValue());
        }
    }

    public void mostrarListaAmigos(Usuario usuario) {
        for (Map.Entry pareja : usuario.getListaAmigos().entrySet()) {
            System.out.println(pareja.getValue());
        }
    }
}
