package controlador;

import modelo.GestionProyectos;
import vista.GestionProyectosVista;

public class GestionProyectosControlador {
    private GestionProyectos modelo;
    private GestionProyectosVista vista;

    public GestionProyectosControlador(GestionProyectos modelo, GestionProyectosVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
}
