package Utilidades;

import java.util.Scanner;

public class Menus {
    //Funcion del primero log-in
    public static int menuInicial(){
        int tipoUsuario;
        Scanner lecturaDatos = new Scanner(System.in);

        System.out.println("----------------------------");
        System.out.println("¡Bienvenido a FernanStarter!");
        System.out.println("----------------------------");
        System.out.println();
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

    //Menu bloqueo-desbloqueo usuarios
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

    //Menu bloqueo usuarios
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

    public static void menuPrincipalGestor() {
        System.out.println("""
                \n--- MENÚ PRINCIPAL ---
                Seleccione una opción:
                1. Mis proyectos
                2. Configuración
                3. Cerrar sesión""");
    }

    public static void menuMisProyectoslGestor() {
        System.out.println("""
                \n--- MIS PROYECTOS ---
                Seleccione una opción:
                1. Crear un nuevo proyecto
                2. Ver proyectos existentes
                3. Salir""");
    }

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

    public static void menuMisInversionesInversor() {
        System.out.println("""
                \n--- PROYECTOS ---
                Seleccione una opción:
                1. Ver proyectos financiados
                2. Salir""");
    }

    public static void menuProyectos() {
        System.out.println("""
                \n--- PROYECTOS ---
                Seleccione una opción:
                1. Ver proyectos existentes
                2. Salir""");
    }

    public static void menuConfiguracion() {
        System.out.println("""
                Selecciona que quieres hacer:
                1.- Cambiar mi usuario
                2.- Cambiar mi contraseña
                3.- Salir""");
    }

    public static void menuVistaDetallada(int proyectosCreados, String nombre1, String nombre2, String nombre3) {
        System.out.println("\nVer vista detallada: ");
        for (int i = 1; i <= proyectosCreados; i++) {
            System.out.print(i + ". Proyecto ");
            if (i == 1) {
                if (nombre1 != null) System.out.println("1: " + nombre1);
                else if (nombre2 != null) System.out.println("2: " + nombre2);
                else if (nombre3 != null) System.out.println("3: " + nombre3);
            }
            else if (i == 2) {
                if (nombre2 != null) System.out.println("2: " + nombre2);
                else if (nombre3 != null) System.out.println("3: " + nombre3);
                else if (nombre1 != null) System.out.println("1: " + nombre1);
            }
            else if (i == 3) {
                if (nombre3 != null) System.out.println("3: " + nombre3);
                else if (nombre1 != null) System.out.println("1: " + nombre1);
                else if (nombre2 != null) System.out.println("2: " + nombre2);
            }
        }
        if (proyectosCreados == 1) System.out.print("2. ");
        else if (proyectosCreados == 2) System.out.print("3. ");
        else if (proyectosCreados == 3) System.out.print("4. ");
        System.out.println("Salir");
    }

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

    public static void menuGestionProyecto() {
        System.out.println("""
                \nOpciones de gestión:
                1. Modificar proyecto
                2. Eliminar proyecto
                3. Salir""");
    }

    public static void menuGestionProyectoInversor() {
        System.out.println("""
                \nSeleccione una opción:
                1. Salir""");
    }

    public static void menuInvertirProyecto() {
        System.out.println("""
                 \nSeleccione una opción:
                 1. Invertir en el proyecto
                 2. Salir""");
    }

    public static void menuInvertirRecompensa(String recompensa1, double precio1, String recompensa2, double precio2, String recompensa3, double precio3) {
        System.out.println("\nSelecciona la inversión: ");
        System.out.println("1. Recompensa 1: " + recompensa1 + " (" + precio1 + " €)");
        System.out.println("2. Recompensa 2: " + recompensa2 + " (" + precio2 + " €)");
        System.out.println("3. Recompensa 3: " + recompensa3 + " (" + precio3 + " €)");
        System.out.println("4. Salir");
    }

    public static void menuModificarProyecto() {
        System.out.println("""
                \nElige el apartado que vas a modificar:
                1. Nombre
                2. Descripción
                3. Categoría
                4. Cantidad necesaria
                5. Cantidad financiada
                6. Fecha inicio
                7. Fecha fin
                8. Recompensa 1
                9. Recompensa 2
                10. Recompensa 3
                11. Salir""");
    }

    public static void menuCartera() {
        System.out.println("""
                \n --- CARTERA DIGITAL ---
                Seleccione una opción:
                1. Ver saldo actual
                2. Añadir saldo
                3. Salir""");
    }

    public static void menuInvitaAmigo() {
        System.out.println("""
                \n--- INVITA A UN AMIGO ---
                Seleccione una opción:
                1. Lista de amigos
                2. Invitar amigo
                3. Salir""");
    }
}