package controlador;

import modelo.GestionUsuarios;
import vista.GestionUsuariosVista;

public class GestionUsuariosControlador {
    private GestionUsuarios modelo;
    private GestionUsuariosVista vista;

    public GestionUsuariosControlador(GestionUsuarios modelo, GestionUsuariosVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
}
