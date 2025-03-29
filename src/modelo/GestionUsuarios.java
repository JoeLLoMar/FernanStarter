package modelo;

import java.util.ArrayList;

public class GestionUsuarios {
    private ArrayList<Usuario> listaUsuarios;

    public GestionUsuarios() {
        this.listaUsuarios = new ArrayList<Usuario>();
    }

    public Usuario agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }
    public Usuario buscarUsuario(int posicion) {
        if (posicion >= 0 && posicion < listaUsuarios.size())
            return listaUsuarios.get(posicion);
        return null;
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equals(nombre)) {
                return u;
            }
        }
        return null;
    }

    public void desbloquearUsuario(Bloqueable usuario) { usuario.desbloquear(); }

    public int buscarPosicion(int id) {
        for (int i = 0; i < listaUsuarios.size(); i++)
            if (listaUsuarios.get(i).getId() == id)
                return i;
        return -1;
    }

    public int buscarPosicion(Usuario usuario) {
        return listaUsuarios.indexOf(usuario);
    }

    //¿Se ejecuta el método remove() en la definición de la condición?
    public Usuario eliminarProyecto(Usuario usuario) {
        if(listaUsuarios.contains(usuario)) {
            listaUsuarios.remove(usuario);
            return usuario;
        }
        return null;
    }

    public Usuario eliminarProyecto(int posicion) {
        if(listaUsuarios.contains(listaUsuarios.get(posicion))) {
            return listaUsuarios.remove(posicion);
        }
        return null;
    }

    public Usuario modificaProyecto(int posicion, Usuario usuario) {
        if (posicion >= 0 && posicion < listaUsuarios.size())
            return listaUsuarios.set(posicion, usuario);
        return null;
    }

    public void mostrarProyectos() {
        for (Usuario p : listaUsuarios)
            System.out.println(p);
    }

}
