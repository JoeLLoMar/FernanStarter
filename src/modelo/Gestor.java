package modelo;

import java.util.ArrayList;

public class Gestor extends Usuario implements Bloqueable {
    private static int contadorGestor = 0;
    private int idGestor;
    private ArrayList<Proyecto> listaProyectos;
    private int iniciosSesionFallidos;
    private boolean bloqueado;

    public Gestor(String nombre, String clave, String email) {
        super(nombre, clave, email);
        this.idGestor = ++contadorGestor;
        this.listaProyectos = new ArrayList<Proyecto>();
        this.iniciosSesionFallidos = 0;
        bloqueado = false;
    }

    public static int getContadorGestor() {
        return contadorGestor;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public ArrayList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(ArrayList<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Proyecto agregarProyecto(Proyecto proyecto) {
        listaProyectos.add(proyecto);
        return proyecto;
    }

    public Proyecto eliminarProyecto(int posicion) {
        if(listaProyectos.contains(listaProyectos.get(posicion))) {
            return listaProyectos.remove(posicion);
        }
        return null;
    }

    public int getIniciosSesionFallidos() {
        return iniciosSesionFallidos;
    }

    public void setIniciosSesionFallidos(int iniciosSesionFallidos) {
        this.iniciosSesionFallidos = iniciosSesionFallidos;
    }

    public void incrementarIntentos() {
        this.iniciosSesionFallidos += 1;
    }

    @Override
    public boolean bloquear() {
        if (bloqueado = false && iniciosSesionFallidos >= 3) {
            bloqueado = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean desbloquear() {
        if (bloqueado = true) {
            bloqueado = false;
            return true;
        }
        return false;

    }

    @Override
    public boolean estaBloqueado() { return bloqueado; }

    @Override
    public String toString() {
        return "\n\nUSUARIO GESTOR" +
                super.toString() +
                "\nID de gestor: " + idGestor +
                "\nProyectos creados: " + listaProyectos +
                "\n=============================================";
    }
}
