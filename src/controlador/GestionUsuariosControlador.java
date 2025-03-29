package controlador;

import modelo.Bloqueable;
import modelo.GestionUsuarios;
import modelo.Usuario;
import vista.GestionUsuariosVista;

public class GestionUsuariosControlador {
    private GestionUsuarios modelo;
    private GestionUsuariosVista vista;
    private int intentosFallidos;

    public GestionUsuariosControlador(GestionUsuarios modelo, GestionUsuariosVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.intentosFallidos = 0;
    }

    public boolean login(String nombre, String contraseña) {
        Usuario usuario = modelo.buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            if (usuario instanceof Bloqueable && ((Bloqueable) usuario).estaBloqueado()) {
                return false;
            }
            if (usuario.validarContraseña(contraseña)) {
                intentosFallidos = 0;
                return true;
            } else {
                intentosFallidos++;
                if (usuario instanceof Bloqueable && intentosFallidos >= 3) {
                    ((Bloqueable) usuario).bloquear();
                }
            }
        }
        return false;
    }
}
