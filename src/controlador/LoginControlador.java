package controlador;

import Utilidades.Configuracion;
import Utilidades.LoggerSistema;
import modelo.RegistroUsuarios;
import modelo.Usuario;

import java.util.List;
import java.util.Scanner;

public class LoginControlador {

    public static Usuario login() {
        Scanner sc = new Scanner(System.in);
        List<Usuario> usuarios = RegistroUsuarios.getListaUsuarios(); // o como se llame

        while (true) {
            System.out.print("Nombre de usuario: ");
            String nombre = sc.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = sc.nextLine();

            for (Usuario u : usuarios) {
                if (u.getNombre().equals(nombre) && u.getContraseña().equals(contrasena)) {
                    LoggerSistema.registrar("Inicio de sesión", u.getNombre());
                    mostrarUltimoInicio(u.getNombre());
                    actualizarUltimoInicio(u.getNombre());
                    return u;
                }
            }

            System.out.println("Credenciales incorrectas. Intente de nuevo.");
        }
    }

    private static void mostrarUltimoInicio(String nombreUsuario) {
        String fecha = Configuracion.getUltimoInicio(nombreUsuario);
        if (fecha != null) {
            System.out.println("Usted inició sesión por última vez: " + fecha);
        }
    }

    private static void actualizarUltimoInicio(String nombreUsuario) {
        Configuracion.setUltimoInicio(nombreUsuario);
    }
}
