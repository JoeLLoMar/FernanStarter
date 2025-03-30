package controlador;

import modelo.*;
import vista.MenusVista;

import java.util.ArrayList;

public class MenusControlador {
    private MenusVista vista;

    public MenusControlador(MenusVista vista) {
        this.vista = vista;
    }

    public void menuInicioSesion() {
        vista.menuInicioSesion();
    }

    // MENÚS COMUNES
    public void menuConfiguracion() {
       vista.menuConfiguracion();
    }

    public void menuProyectos() {
        vista.menuProyectos();
    }

    public void mostrarProyectosExistentes(ArrayList<Proyecto> listaProyectos) {
        vista.mostrarProyectosExistentes(listaProyectos);
    }

//    public void menuVistaDetallada(int proyectosCreados, String[][] proyectos, double[][] cantidadesProyectos) {
//        vista.menuVistaDetallada();
//    }

    public void menuGestionProyecto() {
        vista.menuGestionProyecto();
    }

    public void menuModificarProyecto() {
        vista.menuModificarProyecto();
    }

    // MENÚS ADMINISTRADOR
    public void menuPrincipalAdmin() {
        vista.menuPrincipalAdmin();
    }

    public void menuPanelControl() {
        vista.menuPanelControl();
    }

    // MENÚS GESTOR
    public void menuPrincipalGestor() {
        vista.menuPrincipalGestor();
    }

    public void menuMisProyectos() {
        vista.menuMisProyectos();
    }

    public void menuProyectosCreados(Gestor gestor) {
        vista.menuProyectosCreados(gestor);
    }

    // MENÚS INVERSOR
    public void menuPrincipalInversor() {
        vista.menuPrincipalInversor();
    }

    public void menuMisInversiones() {
        vista.menuMisInversiones();
    }

    public void menuProyectosFinanciados(Inversor inversor) {
        vista.menuProyectosFinanciados(inversor);
    }

    public void menuInvertirProyecto() {
        vista.menuInvertirProyecto();
    }

    public void menuInvertirRecompensas(Proyecto proyecto) {
        vista.menuInvertirRecompensas(proyecto);
    }

    public void menuCartera() {
        vista.menuCartera();
    }

    public void menuInvitaAmigo() {
        vista.menuInvitaAmigo();
    }

}
