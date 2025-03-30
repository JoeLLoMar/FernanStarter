import controlador.GestionProyectosControlador;
import controlador.GestionUsuariosControlador;
import controlador.MenusControlador;
import modelo.GestionProyectos;
import modelo.GestionUsuarios;
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

//============================================================
// INICIO DE SESIÓN
/*Contiene dentro de su bucle los tres menús según el usuario,
faltaría hacer que mediante la función de login y, por ejemplo, un "if",
te llevara al menú correspondiente.
 */
//============================================================
        boolean salirMenuInicio = false;

        while (!salirMenuInicio) {
            menusControlador.menuInicioSesion();
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
    // COMO ADMINISTRADOR
    //====================================================
                case 1 -> {

                }
    // COMO GESTOR
    //====================================================
                case 2 -> {

                }
    // COMO INVERSOR
    //====================================================
                case 3 -> {

                }
    // SALIR
    //====================================================
                case 4 -> {
                    usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Saliendo de la aplicación.");
                    salirMenuInicio = true;
                }
                default -> proyectosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: el valor que has elegido no es válido.");
            }

    //============================================================
    // AQUÍ EMPIEZA MENÚ ADMINISTRADOR
    //============================================================
            boolean salirMenuPrincipalAdmin = false;

            while (!salirMenuPrincipalAdmin) {
                menusControlador.menuPrincipalAdmin();
                int opcion2 = sc.nextInt();
                sc.nextLine();

                switch (opcion2) {
        //PANEL DE CONTROL
        //====================================================
                    case 1 -> {

                    }
        // PROYECTOS
        //====================================================
                    case 2 -> {

                    }
        // CONFIGURACION
        //====================================================
                    case 3 -> {

                    }
        // CERRAR SESION
        //====================================================
                    case 4 -> {
                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Saliendo de la aplicación.");
                        salirMenuInicio = true;
                    } default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: el valor que has elegido no es válido.");
                }
            }

    //============================================================
    // AQUÍ EMPIEZA MENÚ GESTOR
    //============================================================
            boolean salirMenuPrincipalGestor = false;

            while (!salirMenuPrincipalGestor) {
                menusControlador.menuPrincipalGestor();
                int opcion2 = sc.nextInt();
                sc.nextLine();

                switch (opcion2) {
        // MIS PROYECTOS
        //====================================================
                    case 1 -> {

                    }
        // CONFIGURACION
        //====================================================
                    case 2 -> {

                    }
        // CERRAR SESIÓN
        //====================================================
                    case 3 -> {
                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Saliendo de la aplicación.");
                        salirMenuInicio = true;
                    } default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: el valor que has elegido no es válido.");
                }
            }

    //====================================================
    // AQUÍ EMPIEZA MENÚ INVERSOR
    //====================================================
            boolean salirMenuPrincipalInversor = false;

            while (!salirMenuPrincipalInversor) {
                menusControlador.menuPrincipalInversor();
                int opcion2 = sc.nextInt();
                sc.nextLine();

                switch (opcion2) {
        // MIS INVERSIONES
        //====================================================
                    case 1 -> {

                    }
        // PROYECTOS
        //====================================================
                    case 2 -> {

                    }
        // CARTERA DIGITAL
        //====================================================
                    case 3 -> {

                    }
        // INVITA A UN AMIGO
        //====================================================
                    case 4 -> {

                    }
        // CONFIGURACIÓN
        //====================================================
                    case 5 -> {

                    }
        // CERRAR SESIÓN
        //====================================================
                    case 6 -> {
                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Saliendo de la aplicación.");
                        salirMenuInicio = true;
                    }
                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: el valor que has elegido no es válido.");
                }
            }
        }
    }
}
