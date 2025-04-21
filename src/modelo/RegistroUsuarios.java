package modelo;

import java.util.HashMap;

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
}