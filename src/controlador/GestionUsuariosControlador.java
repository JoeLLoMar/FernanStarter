package controlador;

import modelo.Bloqueable;
import modelo.GestionUsuarios;
import modelo.Proyecto;
import modelo.Usuario;
import vista.GestionProyectosVista;
import vista.GestionUsuariosVista;

public class GestionUsuariosControlador {
    private GestionUsuarios modelo;
    private GestionUsuariosVista vista;
    private int intentosFallidos;

    public GestionUsuariosControlador(GestionUsuarios modelo, GestionUsuariosVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.intentosFallidos = 0;
    }

    public boolean login(String nombre, String contraseña) {
        Usuario usuario = modelo.buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            if (usuario instanceof Bloqueable && ((Bloqueable) usuario).estaBloqueado()) {
                return false;
            }
            if (usuario.validarContraseña(contraseña)) {
                intentosFallidos = 0;
                return true;
            } else {
                intentosFallidos++;
                if (usuario instanceof Bloqueable && intentosFallidos >= 3) {
                    ((Bloqueable) usuario).bloquear();
                }
            }
        }
        return false;
    }

    public void mostrarMensaje (String colorTexto, String mensaje) {
        vista.setColorTexto(colorTexto);
        vista.mostrarMensaje(mensaje);
    }

    public void agregarUsuario(Usuario usuario) {
        Usuario usuarioAgregado = modelo.agregarUsuario(usuario);
        if (usuarioAgregado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario agregado con éxito: " + usuario);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo agregar el usuario");
        }
    }

    public Usuario buscarUsuario(int posicion) {
        Usuario usuarioBuscado = modelo.buscarUsuario(posicion);
        if (usuarioBuscado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario encontrado en la posición " + posicion + ": " + usuarioBuscado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo encontrar el usuario: no hay nada en la posición " + posicion);
        }
        return usuarioBuscado;
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        Usuario usuarioBuscado = modelo.buscarUsuarioPorNombre(nombre);
        if (usuarioBuscado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario encontrado con el nombre " + nombre + ": " + usuarioBuscado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo encontrar el usuario: no existen usuarios con el nombre " + nombre);
        }
        return usuarioBuscado;
    }

    public int buscarPosicion(int idUsuario) {
        int posicionUsuario = modelo.buscarPosicion(idUsuario);
        if (posicionUsuario != -1) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "La posición del usuario con ID " + idUsuario + " es: " + posicionUsuario);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo encontrar la posición: el usuario con ID " + idUsuario + " no existe.");
        }
        return posicionUsuario;
    }

    public int buscarPosicion(Usuario usuario) {
        int posicionUsuario = modelo.buscarPosicion(usuario);
        if (posicionUsuario != -1) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "La posición del usuario " + usuario.getNombre() + " es: " + posicionUsuario);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo encontrar la posición: el usuario " + usuario.getNombre() + " no existe.");
        }
        return posicionUsuario;
    }

    public void modificarUsuario(int posicion, Usuario usuario) {
        Usuario usuarioModificado = modelo.modificarUsuario(posicion, usuario);
        if (usuarioModificado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario modificado con éxito: " + usuarioModificado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo modificar el usuario: no hay ningún usuario en la posición: " + posicion);
        }
    }

    public void eliminarUsuario(int posicion) {
        Usuario usuarioEliminado = modelo.eliminarUsuario(posicion);
        if (usuarioEliminado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario eliminado con éxito: " + usuarioEliminado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo eliminar el usuario: no hay ningún usuario en la posición: " + posicion);
        }
    }

    public void eliminarUsuario(Usuario usuario) {
        Usuario usuarioEliminado = modelo.eliminarUsuario(usuario);
        if (usuarioEliminado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario eliminado con éxito: " + usuarioEliminado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo eliminar el usuario: el usuario no existe.");
        }
    }
}
