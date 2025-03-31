import controlador.GestionProyectosControlador;
import controlador.GestionUsuariosControlador;
import controlador.MenusControlador;
import modelo.*;
import vista.GestionProyectosVista;
import vista.GestionUsuariosVista;
import vista.MenusVista;

import java.util.Scanner;

public class FernanStarterMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionUsuarios usuariosModelo = new GestionUsuarios();
        GestionProyectos proyectosModelo = new GestionProyectos();
        GestionUsuariosVista usuariosVista = new GestionUsuariosVista();
        GestionProyectosVista proyectosVista = new GestionProyectosVista();
        MenusVista menusVista = new MenusVista();
        GestionUsuariosControlador usuariosControlador = new GestionUsuariosControlador(usuariosModelo, usuariosVista);
        GestionProyectosControlador proyectosControlador = new GestionProyectosControlador(proyectosModelo, proyectosVista);
        MenusControlador menusControlador = new MenusControlador(menusVista);

        usuariosModelo.agregarUsuario(new Administrador("admin", "admin123", "admin@mail.com"));
        usuariosModelo.agregarUsuario(new Gestor("gestor", "gestor123", "gestor@mail.com"));
        usuariosModelo.agregarUsuario(new Inversor("inversor", "inversor123", "inversor@mail.com"));

//============================================================
// INICIO DE SESIÓN
/*Contiene dentro de su bucle los tres menús según el usuario,
faltaría hacer que mediante la función de login y, por ejemplo, un "if",
te llevara al menú correspondiente.
 */
//============================================================
        boolean salirMenuInicio = false;
        boolean loginExitoso = false;
        Usuario usuario = null;
        int opcion=0;

        while (!loginExitoso) {
            do {
                System.out.println("Seleccione el tipo de usuario:");
                System.out.println("1. Administrador");
                System.out.println("2. Gestor");
                System.out.println("3. Inversor");
                System.out.println("4. Salir");
                while (!sc.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.");
                    sc.next();
                }
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción no válida. Por favor, seleccione un número entre 1 y 4.");
                }
            } while (opcion < 1 || opcion > 4);

            if (opcion == 4) {
                System.out.println("Saliendo del sistema...");
                return;
            }

            System.out.print("Ingrese su nombre de usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String clave = sc.nextLine();

            usuario = usuariosModelo.buscarUsuarioPorNombre(nombre);
            if (usuario != null && usuario.getContraseña().equals(clave) && !(usuario instanceof Bloqueable && ((Bloqueable) usuario).estaBloqueado())) {
                loginExitoso = true;
            } else {
                System.out.println("Credenciales incorrectas o usuario bloqueado. Intente de nuevo.");
                if (usuario instanceof Bloqueable) {
                    ((Bloqueable) usuario).incrementarIntentos();
                }
            }
        }

        //============================================================
        // MENÚS SEGÚN EL TIPO DE USUARIO
        //============================================================
        boolean salirMenu = false;
        while (!salirMenu) {
            if (usuario instanceof Administrador) {
                menusControlador.menuPrincipalAdmin();
                int opcion2 = sc.nextInt();
                sc.nextLine();
                switch (opcion2) {
                    case 1 ->{}
                    case 2 ->{}
                    case 3 ->{}
                    case 4 -> {
                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE,"Saliendo de la aplicación...");
                        salirMenu = true;
                    }
                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO,"Error: El valor introducido no es válido");
                }
            } else if (usuario instanceof Gestor) {
                menusControlador.menuPrincipalGestor();
                int opcion2 = sc.nextInt();
                sc.nextLine();
                switch (opcion2) {
                    case 1 ->{}
                    case 2 ->{}
                    case 3 ->{
                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE,"Saliendo de la aplicación...");
                        salirMenu = true;
                    }
                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO,"Error: El valor introducido no es válido");
                }
            } else if (usuario instanceof Inversor) {
                menusControlador.menuPrincipalInversor();
                int opcion2 = sc.nextInt();
                sc.nextLine();
                switch (opcion2) {
                    case 1 ->{}
                    case 2 ->{}
                    case 3 ->{}
                    case 4 ->{}
                    case 5 ->{}
                    case 6 -> {
                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE,"Saliendo de la aplicación...");
                        salirMenu = true;
                    }
                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO,"Error: El valor introducido no es válido");
                }
            }
        }
    }
}

