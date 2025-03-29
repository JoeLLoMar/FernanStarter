package modelo;

import java.util.ArrayList;

public class Gestor extends Usuario implements Bloqueable {
    private static int contadorGestor = 0;
    private int idGestor;
    private ArrayList<Proyecto> listaProyectos;
    private int contadorLogin;
    private boolean bloqueado;

    public Gestor(String nombre, String clave, String email) {
        super(nombre, clave, email);
        this.idGestor = ++contadorGestor;
        this.listaProyectos = new ArrayList<Proyecto>();
        this.contadorLogin = 0;
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

    public int getContadorLogin() {
        return contadorLogin;
    }

    public void setContadorLogin(int contadorLogin) {
        this.contadorLogin = contadorLogin;
    }

    @Override
    public void bloquear() {
        if (bloqueado = false)
            if (contadorLogin >= 3)
                bloqueado = true;
    }

    @Override
    public void desbloquear() {
        if (bloqueado = true) bloqueado = false;
    }

    @Override
    public boolean estaBloqueado() { return bloqueado; }

    @Override
    public String toString() {
        return "Gestor{" +
                "idGestor=" + idGestor +
                ", listaProyectos=" + listaProyectos +
                ", contadorLogin=" + contadorLogin +
                '}';
    }
}
