package modelo;

import utilidades.FuncionesFechas;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionProyectos {
    private ArrayList<Proyecto> listaProyectos;

    public GestionProyectos() {
        this.listaProyectos = new ArrayList<Proyecto>();
    }

    public ArrayList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public Proyecto agregarProyecto(Proyecto proyecto) {
        listaProyectos.add(proyecto);
        return proyecto;
    }
    public Proyecto buscarProyecto(int posicion) {
        if (posicion >= 0 && posicion < listaProyectos.size())
            return listaProyectos.get(posicion);
        return null;
    }

    public int buscarPosicion(int idProyecto) {
        for (int i = 0; i < listaProyectos.size(); i++)
            if (listaProyectos.get(i).getIdProyecto() == idProyecto)
                return i;
        return -1;
    }

    public int buscarPosicion(Proyecto proyecto) {
        return listaProyectos.indexOf(proyecto);
    }

    //¿Se ejecuta el método remove() en la definición de la condición?
    public Proyecto eliminarProyecto(Proyecto proyecto) {
        if(listaProyectos.contains(proyecto)) {
            listaProyectos.remove(proyecto);
            return proyecto;
        }
        return null;
    }

    public Proyecto eliminarProyecto(int posicion) {
        if(listaProyectos.contains(listaProyectos.get(posicion))) {
            return listaProyectos.remove(posicion);
        }
        return null;
    }

    public Proyecto eliminarProyectoGestor(Gestor gestor, int posicion) {
        Proyecto proyectoEliminado = gestor.eliminarProyecto(posicion);
        return proyectoEliminado;
    }

    public Proyecto modificarNombre(Proyecto proyecto, String nombre) {
        proyecto.setNombre(nombre);
        return proyecto;
    }

    public Proyecto modificarDescripcion(Proyecto proyecto, String descripcion) {
        proyecto.setDescripcion(descripcion);
        return proyecto;
    }

    public Proyecto modificarCategoria(Proyecto proyecto, Categoria categoria) {
        proyecto.setCategoria(categoria);
        return proyecto;
    }

    public Proyecto modificarFechaInicio(Proyecto proyecto, LocalDate fecha) {
        proyecto.setFechaInicio(fecha);
        return proyecto;
    }

    public Proyecto modificarFechaFin(Proyecto proyecto, LocalDate fecha) {
        proyecto.setFechaFin(fecha);
        return proyecto;
    }

    public Proyecto modificarCantidadNecesaria(Proyecto proyecto, float cantidad) {
        proyecto.setCantidadNecesaria(cantidad);
        return proyecto;
    }


    public Proyecto modificaProyecto(int posicion, Proyecto proyecto) {
        if (posicion >= 0 && posicion < listaProyectos.size())
            return listaProyectos.set(posicion, proyecto);
        return null;
    }

    public boolean validarCategoria(String categoria) {
        return Categoria.validarCategoria(categoria);
    }

    public Categoria getCategoria(String categoria) {
        if (validarCategoria(categoria)) {
            return Categoria.valueOf(categoria.toUpperCase());
        } else {
            return null;
        }
    }

    public Proyecto agregarRecompensa(Proyecto proyecto, Recompensa recompensa) {
        proyecto.agregarRecompensa(recompensa);
        recompensa.setIdRecompensa(proyecto);
        return proyecto;
    }
}
