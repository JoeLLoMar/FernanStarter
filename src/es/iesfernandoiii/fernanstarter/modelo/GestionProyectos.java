package es.iesfernandoiii.fernanstarter.modelo;

import java.awt.*;
import java.util.ArrayList;

public class GestionProyectos {
    private ArrayList<Proyecto> listaProyectos;

    public GestionProyectos() {
        this.listaProyectos = new ArrayList<Proyecto>();
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

    public Proyecto modificaProyecto(int posicion, Proyecto proyecto) {
        if (posicion >= 0 && posicion < listaProyectos.size())
            return listaProyectos.set(posicion, proyecto);
        return null;
    }

    public void mostrarProyectos() {
        for (Proyecto p : listaProyectos)
            System.out.println(p);
    }
}
