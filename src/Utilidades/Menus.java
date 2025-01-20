package Utilidades;

import java.util.Scanner;

/**
 * Clase que contiene los menús interactivos para diferentes tipos de usuarios
 * en la aplicación FernanStarter. Ofrece opciones de inicio de sesión, gestión
 * de proyectos, configuraciones y más.
 *
 * @author José Luis López Martos, Alejandro Vergara Pozo
 * @version 1.0
 * @since 3.0
 */
public class Menus {
    /**
     * Muestra el menú inicial para que el usuario elija el tipo de perfil con el que desea iniciar sesión.
     *
     * @return Un entero que representa la selección del usuario:
     *         1 para administrador, 2 para gestor, 3 para inversor, 4 para salir.
     */


    public static int menuInicial(){
        int tipoUsuario;
        Scanner lecturaDatos = new Scanner(System.in);
//0. LOGIN
        //Elección de perfil de usuario y log-in
        System.out.println("""
                    Inicia sesión:
                    1. Como administrador
                    2. Como gestor
                    3. Como inversor
                    4. Salir""");

        tipoUsuario = Integer.parseInt(lecturaDatos.nextLine());

        return tipoUsuario;
    }

    /**
     * Muestra el menú principal para un administrador con opciones como panel de control y configuración.
     *
     * @return Un entero que representa la selección del administrador.
     */
    public static int menuAdmin(){
        Scanner lecturaDatos = new Scanner(System.in);
        System.out.println("""
                            \n--- MENÚ PRINCIPAL ---
                            Seleccione una opción:
                            1. Panel de control
                            2. Proyectos
                            3. Configuración
                            4. Cerrar sesión""");
        int seleccionAdmin = Integer.parseInt(lecturaDatos.nextLine());
        return seleccionAdmin;
    }

    /**
     * Muestra un menú para bloquear o desbloquear usuarios.
     *
     * @return Un entero que representa la elección del administrador:
     *         1 para bloquear usuario, 2 para desbloquear usuario.
     */
    public static int menubloqueoDesbloqueo(){
        Scanner lecturaDatos = new Scanner(System.in);
        System.out.println("Bienvenido al panel de control, ¿qué deseas hacer?:");
        System.out.println("""
                                    \n--- PANEL DE CONTROL ---
                                    1. Bloquear usuario
                                    2. Desbloquear usuario""");

        int eleccionBloqueo = Integer.parseInt(lecturaDatos.nextLine());
        return eleccionBloqueo;
    }

    /**
     * Permite seleccionar qué usuario será bloqueado.
     *
     * @param usuarioGestorBlocked Estado inicial del bloqueo del usuario gestor.
     * @param usuarioNPC1Blocked Estado inicial del bloqueo del usuario inversor 1.
     * @param usuarioNPC2Blocked Estado inicial del bloqueo del usuario inversor 2.
     */
    public static void menuBloqueo(boolean usuarioGestorBlocked,boolean usuarioNPC1Blocked, boolean usuarioNPC2Blocked ){
        String usuarioGestor="tornaceitor", usuarioNPC1="soyunnpc1", usuarioNPC2="npcsisoy";
        usuarioGestorBlocked=usuarioGestorBlocked;
        usuarioNPC1Blocked=usuarioNPC1Blocked;
        usuarioNPC2Blocked=usuarioNPC2Blocked;
        Scanner lecturaDatos = new Scanner(System.in);

        System.out.println("¿A qué usuario deseas bloquear?");
        System.out.println("1. Usuario gestor: " + usuarioGestor);
        System.out.println("2. Usuario inversor: " + usuarioNPC1);
        System.out.println("3. Usuario inversor 2: " + usuarioNPC2);

        int usuarioBloqueado = Integer.parseInt(lecturaDatos.nextLine());
        switch (usuarioBloqueado) {
            case 1:
                if (usuarioGestorBlocked) {
                    System.out.println("Este usuario ya está bloqueado");
                    break;
                } else {
                    System.out.println("Usuario gestor bloqueado con éxito");
                    usuarioGestorBlocked = true;
                    break;
                }
            case 2:
                if (usuarioNPC1Blocked) {
                    System.out.println("Este usuario ya está bloqueado");
                    break;
                } else {
                    System.out.println("Usuario inversor 1 bloqueado con éxito");
                    usuarioNPC1Blocked = true;
                    break;
                }
            case 3:
                if (usuarioNPC2Blocked) {
                    System.out.println("Este usuario ya está bloqueado");
                    break;
                } else {
                    System.out.println("Usuario inversor 2 bloqueado con éxito");
                    usuarioNPC2Blocked = true;
                    break;
                }
        }
    }

    /**
     * Muestra el menú principal para un gestor con opciones relacionadas con proyectos y configuración.
     */
    public static void menuPrincipalGestor() {
        System.out.println("""
                \n--- MENÚ PRINCIPAL ---
                Seleccione una opción:
                1. Mis proyectos
                2. Configuración
                3. Cerrar sesión""");
    }

    /**
     * Muestra un submenú para la gestión de los proyectos del gestor.
     */
    public static void menuMisProyectoslGestor() {
        System.out.println("""
                \n--- MIS PROYECTOS ---
                Seleccione una opción:
                1. Crear un nuevo proyecto
                2. Ver proyectos existentes
                3. Salir""");
    }

    /**
     * Muestra el menú principal para un inversor con opciones como inversiones y proyectos.
     */
    public static void menuPrincipalInversor() {
        System.out.println("""
                \n--- MENÚ PRINCIPAL ---
                Seleccione una opción:
                1. Mis inversiones
                2. Proyectos
                3. Cartera digital
                4. Invita a un amigo
                5. Configuración
                6. Cerrar sesión""");
    }

    /**
     * Muestra un submenú para las inversiones del inversor.
     */
    public static void menuMisInversionesInversor() {
        System.out.println("""
                \n--- PROYECTOS ---
                Seleccione una opción:
                1. Ver proyectos financiados
                2. Salir""");
    }

    /**
     * Muestra un menú con opciones relacionadas con los proyectos existentes.
     */
    public static void menuProyectos() {
        System.out.println("""
                \n--- PROYECTOS ---
                Seleccione una opción:
                1. Ver proyectos existentes
                2. Salir""");
    }

    /**
     * Muestra un menú con opciones para realizar modificaciones relacionadas con el usuario y la contraseña.
     */
    public static void menuConfiguracion() {
        System.out.println("""
                Selecciona que quieres hacer:
                1.- Cambiar mi usuario
                2.- Cambiar mi contraseña
                3.- Salir""");
    }

    /**
     * Muestra una vista detallada de los proyectos creados.
     *
     * @param proyectosCreados Número de proyectos creados.
     * @param nombre1 Nombre del primer proyecto.
     * @param nombre2 Nombre del segundo proyecto.
     * @param nombre3 Nombre del tercer proyecto.
     */
//    public static void menuVistaDetallada(int proyectosCreados, String nombre1, String nombre2, String nombre3) {
//        System.out.println("\nVer vista detallada: ");
//        for (int i = 1; i <= proyectosCreados; i++) {
//            System.out.print(i + ". Proyecto ");
//            if (i == 1) {
//                if (nombre1 != null) System.out.println("1: " + nombre1);
//                else if (nombre2 != null) System.out.println("2: " + nombre2);
//                else if (nombre3 != null) System.out.println("3: " + nombre3);
//            }
//            else if (i == 2) {
//                if (nombre2 != null) System.out.println("2: " + nombre2);
//                else if (nombre3 != null) System.out.println("3: " + nombre3);
//                else if (nombre1 != null) System.out.println("1: " + nombre1);
//            }
//            else if (i == 3) {
//                if (nombre3 != null) System.out.println("3: " + nombre3);
//                else if (nombre1 != null) System.out.println("1: " + nombre1);
//                else if (nombre2 != null) System.out.println("2: " + nombre2);
//            }
//        }
//        if (proyectosCreados == 1) System.out.print("2. ");
//        else if (proyectosCreados == 2) System.out.print("3. ");
//        else if (proyectosCreados == 3) System.out.print("4. ");
//        System.out.println("Salir");
//    }

    public static void menuVistaDetallada(int proyectosCreados, String[][] proyectos, double[][] cantidadesProyectos) {
        // Mostrar menú con los proyectos disponibles
        System.out.println("\n--- SELECCIONA UN PROYECTO PARA VER EN DETALLE ---");
        for (int i = 0; i < proyectosCreados; i++) {
            System.out.println((i + 1) + ". " + proyectos[i][0]); // Mostrar solo los nombres
        }
        System.out.println((proyectosCreados + 1) + ". Salir"); // Opción para salir
    }


    /**
     * Muestra una vista detallada de los proyectos financiados por un inversor.
     *
     * @param proyectosFinanciados Número de proyectos financiados.
     * @param nombre1 Nombre del primer proyecto.
     * @param nombre2 Nombre del segundo proyecto.
     * @param nombre3 Nombre del tercer proyecto.
     * @param participaProyecto1 Indica si el inversor participa en el primer proyecto.
     * @param participaProyecto2 Indica si el inversor participa en el segundo proyecto.
     * @param participaProyecto3 Indica si el inversor participa en el tercer proyecto.
     */
    public static void menuVistaDetalladaInversor(int proyectosFinanciados, String nombre1, String nombre2, String nombre3, boolean participaProyecto1, boolean participaProyecto2, boolean participaProyecto3) {
        System.out.println("\nVer vista detallada: ");
        for (int i = 1; i <= proyectosFinanciados; i++) {
            System.out.print(i + ". Proyecto ");
            if (i == 1) {
                if (nombre1 != null && participaProyecto1) System.out.println("1: " + nombre1);
                else if (nombre2 != null && participaProyecto2) System.out.println("2: " + nombre2);
                else if (nombre3 != null && participaProyecto3) System.out.println("3: " + nombre3);

            } else if (i == 2) {
                if (nombre2 != null && participaProyecto2) System.out.println("2: " + nombre2);
                else if (nombre3 != null && participaProyecto3) System.out.println("3: " + nombre3);
                else if (nombre1 != null && participaProyecto1) System.out.println("1: " + nombre1);

            } else if (i == 3) {
                if (nombre3 != null && participaProyecto3) System.out.println("3: " + nombre3);
                else if (nombre1 != null && participaProyecto1) System.out.println("1: " + nombre1);
                else if (nombre2 != null && participaProyecto2) System.out.println("2: " + nombre2);
            }
        }

        if (proyectosFinanciados == 1) System.out.print("2. ");
        else if (proyectosFinanciados == 2) System.out.print("3. ");
        else if (proyectosFinanciados == 3) System.out.print("4. ");
        System.out.println("Salir");
    }

    /**
     * Muestra las opciones de gestión de proyectos para un administrador o gestor.
     */
    public static void menuGestionProyecto() {
        System.out.println("""
                \nOpciones de gestión:
                1. Modificar proyecto
                2. Eliminar proyecto
                3. Salir""");
    }

    /**
     * Muestra el menú de gestión de proyectos para un inversor.
     */
    public static void menuGestionProyectoInversor() {
        System.out.println("""
                \nSeleccione una opción:
                1. Salir""");
    }

    /**
     * Muestra un menú para invertir en un proyecto.
     */
    public static void menuInvertirProyecto() {
        System.out.println("""
                 \nSeleccione una opción:
                 1. Invertir en el proyecto
                 2. Salir""");
    }

    /**
     * Muestra las opciones de inversión disponibles, junto con sus recompensas y precios.
     *
     * @param recompensa1 Descripción de la primera recompensa.
     * @param precio1 Precio de la primera recompensa.
     * @param recompensa2 Descripción de la segunda recompensa.
     * @param precio2 Precio de la segunda recompensa.
     * @param recompensa3 Descripción de la tercera recompensa.
     * @param precio3 Precio de la tercera recompensa.
     */
    public static void menuInvertirRecompensa(String recompensa1, double precio1, String recompensa2, double precio2, String recompensa3, double precio3) {
        System.out.println("\nSelecciona la inversión: ");
        System.out.println("1. Recompensa 1: " + recompensa1 + " (" + precio1 + " €)");
        System.out.println("2. Recompensa 2: " + recompensa2 + " (" + precio2 + " €)");
        System.out.println("3. Recompensa 3: " + recompensa3 + " (" + precio3 + " €)");
        System.out.println("4. Salir");
    }

    /**
     * Muestra el menú para modificar los apartados de un proyecto.
     */
    public static void menuModificarProyecto() {
        System.out.println("""
                \nElige el apartado que vas a modificar:
                1. Nombre
                2. Descripción
                3. Categoría
                4. Fecha inicio
                5. Fecha fin
                6. Cantidad necesaria
                7. Cantidad financiada
                8. Recompensas
                9. Salir""");
    }

    /**
     * Muestra el menú de la cartera digital con opciones como ver saldo o añadir saldo.
     */
    public static void menuCartera() {
        System.out.println("""
                \n --- CARTERA DIGITAL ---
                Seleccione una opción:
                1. Ver saldo actual
                2. Añadir saldo
                3. Salir""");
    }

    /**
     * Muestra el menú para invitar a amigos y ver la lista de amigos.
     */
    public static void menuInvitaAmigo() {
        System.out.println("""
                \n--- INVITA A UN AMIGO ---
                Seleccione una opción:
                1. Lista de amigos
                2. Invitar amigo
                3. Salir""");
    }
}