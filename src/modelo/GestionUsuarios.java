package modelo;

import java.util.HashMap;

public class GestionUsuarios {
    private HashMap<String, Usuario> listaUsuarios;

    public GestionUsuarios() {
        listaUsuarios = new HashMap<>();
    }

    public HashMap<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario agregarUsuario(String nombre, Usuario usuario) {
        listaUsuarios.put(nombre, usuario);
        return usuario;
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        return listaUsuarios.get(nombre);
    }

    public boolean bloquearUsuario(Bloqueable usuario) {
        return usuario.bloquear();
    }

    public boolean desbloquearUsuario(Bloqueable usuario) {
        return usuario.desbloquear();
    }

    public Usuario invitaAmigo(Usuario usuario, String nombre) {
        Usuario amigo = buscarUsuarioPorNombre(nombre);
        usuario.invitarAmigo(nombre, amigo);
        return amigo;
    }

    //¿Se ejecuta el método remove() en la definición de la condición?
    public Usuario eliminarUsuario(String nombre) {
        if(listaUsuarios.containsKey(nombre)) {
            return listaUsuarios.remove(nombre);
        }
        return null;
    }


    public Usuario modificarUsuario(String nombre, Usuario usuario) {
        if (listaUsuarios.containsKey(nombre)) {
            return listaUsuarios.put(nombre, usuario);
        }
        return null;
    }

    public Proyecto agregarProyectoGestor(Gestor gestor, Proyecto proyecto) {
        return gestor.agregarProyecto(proyecto);
    }
}
