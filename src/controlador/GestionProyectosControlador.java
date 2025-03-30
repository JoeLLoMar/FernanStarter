package controlador;

import modelo.GestionProyectos;
import modelo.Proyecto;
import vista.GestionProyectosVista;

public class GestionProyectosControlador {
    private GestionProyectos modelo;
    private GestionProyectosVista vista;

    public GestionProyectosControlador(GestionProyectos modelo, GestionProyectosVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void mostrarMensaje(String colorTexto, String mensaje) {
        vista.setColorTexto(colorTexto);
        vista.mostrarMensaje(mensaje);
    }

    public void agregarProyecto(Proyecto proyecto) {
        Proyecto proyectoAgregado = modelo.agregarProyecto(proyecto);
        if (proyectoAgregado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto agregado con éxito: " + proyecto);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo agregar el proyecto");
        }
    }

    public Proyecto buscarProyecto(int posicion) {
        Proyecto proyectoBuscado = modelo.buscarProyecto(posicion);
        if (proyectoBuscado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto encontrado en la posición " + posicion + ": " + proyectoBuscado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo encontrar el proyecto: no hay nada en la posición " + posicion);
        }
        return proyectoBuscado;
    }

    public int buscarPosicion(int idProyecto) {
        int posicionProyecto = modelo.buscarPosicion(idProyecto);
        if (posicionProyecto != -1) {
            mostrarMensaje(GestionProyectosVista.VERDE, "La posición del proyecto con ID " + idProyecto + " es: " + posicionProyecto);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo encontrar la posición: el proyecto con ID " + idProyecto + " no existe.");
        }
        return posicionProyecto;
    }

    public int buscarPosicion(Proyecto proyecto) {
        int posicionProyecto = modelo.buscarPosicion(proyecto);
        if (posicionProyecto != -1) {
            mostrarMensaje(GestionProyectosVista.VERDE, "La posición del proyecto " + proyecto.getNombre() + " es: " + posicionProyecto);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo encontrar la posición: el proyecto " + proyecto.getNombre() + " no existe.");
        }
        return posicionProyecto;
    }

    public void modificarProyecto(int posicion, Proyecto proyecto) {
        Proyecto proyectoModificado = modelo.modificaProyecto(posicion, proyecto);
        if (proyectoModificado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto modificado con éxito: " + proyectoModificado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo modificar el proyecto: no hay ningún proyecto en la posición: " + posicion);
        }
    }

    public void eliminarProyecto(int posicion) {
        Proyecto proyectoEliminado = modelo.eliminarProyecto(posicion);
        if (proyectoEliminado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto eliminado con éxito: " + proyectoEliminado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo eliminar el proyecto: no hay ningún proyecto en la posición: " + posicion);
        }
    }

    public void eliminarProyecto(Proyecto proyecto) {
        Proyecto proyectoEliminado = modelo.eliminarProyecto(proyecto);
        if (proyectoEliminado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto eliminado con éxito: " + proyectoEliminado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo eliminar el proyecto: el proyecto no existe.");
        }
    }
}
