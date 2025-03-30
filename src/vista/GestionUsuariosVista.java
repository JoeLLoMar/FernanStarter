package vista;

import modelo.Usuario;

import java.util.ArrayList;

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

    public void mostrarListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario);
        }
    }
}
