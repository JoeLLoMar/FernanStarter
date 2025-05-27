package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RegistroUsuarios {
    private static HashMap<String, Usuario> usuarios = new HashMap<>();

    public static boolean registrarUsuario(String nombre, String contrasena, String email, String tipo) {
        if (usuarios.containsKey(nombre)) {
            return false; // Usuario ya existe
        }

        Usuario nuevoUsuario;
        switch (tipo.toLowerCase()) {
            case "gestor":
                nuevoUsuario = new Gestor(nombre, contrasena, email);
                break;
            case "inversor":
                nuevoUsuario = new Inversor(nombre, contrasena, email);
                break;
            case "administrador":
                nuevoUsuario = new Administrador(nombre, contrasena, email);
                break;
            default:
                return false; // Tipo inválido
        }

        usuarios.put(nombre, nuevoUsuario);
        return true;
    }

    public static boolean autenticarUsuario(String nombre, String contrasena) {
        Usuario usuario = usuarios.get(nombre);
        return usuario != null && usuario.getContraseña().equals(contrasena);
    }

    public static HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public static List<Usuario> getListaUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    public static void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombre(), usuario);
    }

    public static Usuario getUsuario(String nombre) {
        return usuarios.get(nombre);
    }

    public static void cargarUsuariosPorDefecto() {
        agregarUsuario(new Inversor("inversor1", "clave1","email1@gmail.com"));
        agregarUsuario(new Inversor("inversor2", "clave2","email2@gmail.com"));
        agregarUsuario(new Gestor("gestor1", "clave2","email3@gmail.com"));
    }

}