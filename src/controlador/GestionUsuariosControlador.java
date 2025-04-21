package controlador;

import modelo.*;
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

    public GestionUsuariosControlador(GestionUsuariosVista vista) {
        this.vista = vista;
    }

    public boolean registrarNuevoUsuario(String nombre, String contrasena, String email, String tipo) {
        return RegistroUsuarios.registrarUsuario(nombre, contrasena, email, tipo);
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

    public void agregarUsuario(String nombre, Usuario usuario) {
        Usuario usuarioAgregado = modelo.agregarUsuario(nombre, usuario);
        if (usuarioAgregado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario agregado con éxito: " + usuario);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo agregar el usuario");
        }
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

    /**
     * Método para modificar un usuario.
     * @param usuario El usuario a modificar.
     * @param atributo El nombre del atributo a modificar (por ejemplo: "nombre", "contraseña", "email", etc.)
     * @param valor El nuevo valor en formato String.
     */
    public void modificarUsuario(Usuario usuario, String atributo, String valor) {
        try {
            switch (atributo.toLowerCase().trim()) {
                case "nombre" -> {
                    if (valor != null && !valor.trim().isEmpty()) {
                        usuario.setNombre(valor.trim());
                        mostrarMensaje(GestionUsuariosVista.VERDE,"Nombre modificado correctamente.");
                    } else {
                        mostrarMensaje(GestionUsuariosVista.ROJO,"El valor para 'nombre' es inválido.");
                    }
                }

                case "contraseña" -> {
                    if (valor != null && !valor.trim().isEmpty()) {
                        usuario.setContraseña(valor.trim());
                        mostrarMensaje(GestionUsuariosVista.VERDE,"Contraseña modificada correctamente.");
                    } else {
                        mostrarMensaje(GestionUsuariosVista.ROJO,"El valor para 'descripcion' es inválido.");
                    }
                }

                case "email" -> {
                    if (valor != null && !valor.trim().isEmpty()) {
                        usuario.setEmail(valor.trim());
                        mostrarMensaje(GestionUsuariosVista.VERDE,"Correo electrónico modificado correctamente.");
                    } else {
                        mostrarMensaje(GestionUsuariosVista.ROJO,"El valor para 'email' es inválido.");
                    }
                }

                default -> mostrarMensaje(GestionUsuariosVista.ROJO,"Atributo no reconocido.");

            }
        } catch (NumberFormatException e) {
            mostrarMensaje(GestionUsuariosVista.ROJO,"Error de conversión numérica: " + e.getMessage());
        } catch (Exception e) {
            mostrarMensaje(GestionUsuariosVista.ROJO,"Error al modificar el usuario: " + e.getMessage());
        }
    }

    public void modificarUsuario(String nombre, Usuario usuario) {
        Usuario usuarioModificado = modelo.modificarUsuario(nombre, usuario);
        if (usuarioModificado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario modificado con éxito: " + usuarioModificado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo modificar el usuario: no hay ningún usuario con nombre: " + nombre);
        }
    }

    public void eliminarUsuario(String nombre) {
        Usuario usuarioEliminado = modelo.eliminarUsuario(nombre);
        if (usuarioEliminado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario eliminado con éxito: " + usuarioEliminado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo eliminar el usuario: no hay ningún usuario con nombre " + nombre);
        }
    }

    public void eliminarUsuario(Usuario usuario) {
        Usuario usuarioEliminado = modelo.eliminarUsuario(usuario.getNombre());
        if (usuarioEliminado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Usuario eliminado con éxito: " + usuarioEliminado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo eliminar el usuario: no hay ningún usuario con nombre " + usuario.getNombre());
        }
    }

    public void agregarProyectoGestor(Gestor gestor, Proyecto proyecto) {
        if (gestor != null && proyecto != null) {
            modelo.agregarProyectoGestor(gestor, proyecto);
            mostrarMensaje(GestionUsuariosVista.VERDE, "Proyecto agregado a tu cartera de proyectos.");
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo agregar el proyecto: el proyecto no existe.");
        }
    }

    public void bloquearUsuario(Usuario usuario) {
        if (usuario instanceof Administrador) {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo bloquear: los usuarios Administradores no son bloqueables");
            return;
        }
        if (modelo.bloquearUsuario((Bloqueable) usuario)) {
            modelo.bloquearUsuario((Bloqueable) usuario);
            mostrarMensaje(GestionUsuariosVista.VERDE, "Se ha bloqueado al usuario " + usuario);
        }else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo bloquear: el usuario ya está bloqueado o su número de inicios de sesión fallidos es inferior a 3");
        }
    }

    public void desbloquearUsuario(Usuario usuario) {
        if (usuario instanceof Administrador) {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo desbloquear: los usuarios Administradores no son bloqueables");
            return;
        }
        if (modelo.desbloquearUsuario((Bloqueable) usuario)) {
            modelo.bloquearUsuario((Bloqueable) usuario);
            mostrarMensaje(GestionUsuariosVista.VERDE, "Se ha desbloqueado al usuario " + usuario);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo desbloquear: el usuario ya está desbloqueado.");
        }
    }

    public void invitarAmigo(Usuario usuario, String nombre) {
        Usuario invitado = modelo.invitaAmigo(usuario, nombre);
        if (invitado != null) {
            mostrarMensaje(GestionUsuariosVista.VERDE, "Has invitado a tu grupo de amigos al usuario " + invitado);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo invitar: el nombre es incorrecto o el usuario no existen.");
        }
    }

    public void mostrarSaldo(Inversor inversor) {
        if (inversor.getSaldo() > 0) {
            mostrarMensaje("", "El saldo en tu cartera digital es de: " + inversor.getSaldo() + " €.");
        } else if (inversor.getSaldo() == 0) {
            mostrarMensaje(GestionUsuariosVista.ROJO, "Te has quedado sin saldo en tu cartera digital.");
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "Error: el saldo en tu cartera digital no puede ser negativo.");
        }
    }

    public void aumentarSaldo(Inversor inversor, float cantidad) {
        inversor.aumentaSaldo(cantidad);
        mostrarMensaje(GestionUsuariosVista.VERDE, "Has añadido " + cantidad + " € a tu cartera digital. \nTienes: " + inversor.getSaldo() + " €");
    }

    public void mostrarListaUsuarios() {
        if (!modelo.getListaUsuarios().isEmpty()) {
            vista.mostrarListaUsuarios(modelo.getListaUsuarios());
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No hay usuarios registrados.");
        }
    }

    public void mostrarListaAmigos(Usuario usuario) {
        if (!usuario.getListaAmigos().isEmpty()) {
            vista.mostrarListaAmigos(usuario);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No hay amigos invitados.");
        }
    }
}
