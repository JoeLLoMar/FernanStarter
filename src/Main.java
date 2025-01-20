import java.util.Scanner;

import static Utilidades.AccesosRegistros.*;
import static Utilidades.Menus.*;
import static Utilidades.ProcesamientoDatos.*;

public class Main {
    //Parte donde nos morimos, es decir, pasamos 6k líneas a funciones

    public static void main(String[] args) {
        //Variables de usuarios
        int tipoUsuario;
        boolean cerrarPrograma=false;

        int intentos = 2;
        String usuarioLogin="", contraseniaLogin="";
        boolean registroAdmin = false,registroGestor = false;
        String usuarioAdmin = "pepito123", contraseniaAdmin = "12345";
        String usuarioGestor = "tornaceitor", contraseniaGestor = "54321";
        String usuarioNPC1 = "soyunnpc1", contraseniaNPC1 = "6969";
        String usuarioNPC2 = "npcsisoy", contraseniaNPC2 = "9696";
        boolean  usuarioNPC1Blocked=false, usuarioNPC2Blocked=false,usuarioGestorBlocked=false,npc1 = false, npc2 = false;
        boolean  registroInversor = false, cerrarSesion=false, admin=false,gestor=false;
        int opcionConfig = 0,contadorIntentos = 0;

        //Arrays usuarios por tipos
        final int MAX_GESTORES = 10;
        final int MAX_INVERSORES = 10;

        String[][] usuariosGestores = new String[MAX_GESTORES][2]; // 2 Campos: usuario, contraseña.
        String[][] usuariosInversores = new String[MAX_INVERSORES][2];

        usuariosInversores[0][0] = "Pepito";
        usuariosInversores[0][1] = "0000";
        usuariosInversores[1][0] = "Npc";
        usuariosInversores[1][1] = "1111";
        usuariosInversores[2][0] = "Cr7";
        usuariosInversores[2][1] = "2222";
        usuariosInversores[3][0] = "Messi";
        usuariosInversores[3][1] = "3333";
        usuariosInversores[4][0] = "Chicote";
        usuariosInversores[4][1] = "4444";

        //Variables específicas inversor
        double saldoInversor1 = 0, saldoInversor2 = 0;
        String amigosInversor1 = "", amigosInversor2 = "";
        double inversion1Proyecto1 = 0, inversion1Proyecto2 = 0, inversion1Proyecto3 = 0, inversion2Proyecto1 = 0, inversion2Proyecto2 = 0, inversion2Proyecto3 = 0;
        boolean participaInv1Proyecto1 = false, participaInv1Proyecto2 = false, participaInv1Proyecto3 = false, participaInv2Proyecto1 = false, participaInv2Proyecto2 = false, participaInv2Proyecto3 = false;
        int proyectosFinanciaInv1 = 0, proyectosFinanciaInv2 = 0;

        // Variables para almacenar información de hasta 3 proyectos
        String nombre1 = null, descripcion1 = null, categoria1 = null, fechaInicio1 = null, fechaFin1 = null;
        double cantidadNecesaria1 = -1, cantidadFinanciada1 = -1;
        String recompensa1_1 = null, recompensa1_2 = null, recompensa1_3 = null;
        double precio1_1 = -1, precio1_2 = -1, precio1_3 = -1;

        String nombre2 = null, descripcion2 = null, categoria2 = null, fechaInicio2 = null, fechaFin2 = null;
        double cantidadNecesaria2 = -1, cantidadFinanciada2 = -1;
        String recompensa2_1 = null, recompensa2_2 = null, recompensa2_3 = null;
        double precio2_1 = -1, precio2_2 = -1, precio2_3 = -1;

        String nombre3 = null, descripcion3 = null, categoria3 = null, fechaInicio3 = null, fechaFin3 = null;
        double cantidadNecesaria3 = -1, cantidadFinanciada3 = -1;
        String recompensa3_1 = null, recompensa3_2 = null, recompensa3_3 = null;
        double precio3_1 = -1, precio3_2 = -1, precio3_3 = -1;

        //Arrays proyectos
        final int MAX_PROYECTOS = 20;
        final int MAX_RECOMPENSAS = 3;

        String[][] proyectos = new String[MAX_PROYECTOS][5]; // 5 campos: nombre, descripción, categoría, fechaInicio, fechaFin
        double[][] proyectosCantidades = new double[MAX_PROYECTOS][2]; // Cantidad necesaria y financiada
        String[][] recompensasDescripcion = new String[MAX_PROYECTOS][MAX_RECOMPENSAS]; // Descripciones de recompensas
        double[][] recompensasPrecios = new double[MAX_PROYECTOS][MAX_RECOMPENSAS]; // Precios de recompensas

        // Inicializar arrays bidimensionales
        for (int i = 0; i < proyectos.length; i++) {
            for (int j = 0; j < proyectos[i].length; j++) {
                proyectos[i][j] = null;
            }
        }
        for (int i = 0; i < proyectosCantidades.length; i++) {
            for (int j = 0; j < proyectosCantidades[i].length; j++) {
                proyectosCantidades[i][j] = -1;
            }
        }
        for (int i = 0; i < recompensasDescripcion.length; i++) {
            for (int j = 0; j < recompensasDescripcion[i].length; j++) {
                recompensasDescripcion[i][j] = null;
                recompensasPrecios[i][j] = -1;
            }
        }

        //Arrays de inversiones
        double[][] inversiones = new double[MAX_INVERSORES][MAX_PROYECTOS]; // 5 usuarios x 20 proyectos
        boolean[][] proyectosInvertidos = new boolean[MAX_INVERSORES][MAX_PROYECTOS];

        for (int i = 0; i < inversiones.length; i++) {
            for (int j = 0; j < inversiones[i].length; j++) {
                inversiones[i][j] = 0;
            }
        }
        for (int i = 0; i < proyectosInvertidos.length; i++) {
            for (int j = 0; j < proyectosInvertidos[i].length; j++) {
                proyectosInvertidos[i][j] = false;
            }
        }

        int proyectosCreados = 0;

        do {
            Scanner lecturaDatos = new Scanner(System.in);
            primerMenu();
            tipoUsuario=menuInicial();
            //Switch que valida que tipo de usuario has seleccionado y te pide iniciar sesión como tal
            switch (tipoUsuario) {
    //0.1. LOGIN - ADMINISTRADOR
                case 1:
                    registroAdmin();
                    registroAdmin=true;
                    break;
    //0.2. LOGIN - GESTOR
                case 2: //Accedes al login como gestor
                    registroGestor(0,"default1","default2");
                    registroGestor=true;
                    break;
    //0.3. LOGIN - INVERSOR
                case 3: //igual que el case 2 de gestor
                    registroInversor(0,"default1","default2");
                    registroInversor=true;
                    break;
    //0.4. LOGIN - SALIR
                case 4:
                    System.out.println("Saliendo del programa...");
                    cerrarPrograma = true;
                    break;

                default:
                    System.out.println("Error");
                    break;
            }

            if(tipoUsuario==2){
                if(usuarioGestorBlocked)continue;
            }

            if(tipoUsuario==3){
                if(usuarioNPC1Blocked) continue;
                else if(usuarioNPC2Blocked) continue;
            }

            if (cerrarPrograma) {
                break;
            }
            //Bucle que ejecuta el programa hasta que se cierre sesión
            do{
                if (registroAdmin) {
//1. ADMINISTRADOR - MENÚ PRINCIPAL
                    boolean salirMenu = false;

                    while (!salirMenu) {

                        int seleccionAdmin=menuAdmin();
                        switch (seleccionAdmin) {
    //1.1. ADMINISTRADOR - PANEL DE CONTROL
                            case 1:
                                int eleccionBloqueo=menubloqueoDesbloqueo();

                                switch (eleccionBloqueo) {
                                    case 1:
                                        menuBloqueo(usuarioNPC1Blocked,usuarioGestorBlocked,usuarioNPC2Blocked);
                                        break;
                                    case 2:
                                        usuariosBloqueados(usuarioNPC1Blocked,usuarioGestorBlocked,usuarioNPC2Blocked);
                                        break;
                                }
                                break;
    //1.2. ADMINISTRADOR - PROYECTOS
                            case 2:
                                boolean salirSubMenu = false;

                                while (!salirSubMenu) { //El bucle finaliza cuando se le da 3. Salir, salirSubMenu = true y te sales del menú Mis proyectos para ir al menu gestor.
                                    menuProyectos();
                                    int seleccionProyectos = lecturaDatos.nextInt();
                                    lecturaDatos.nextLine();

                                    switch (seleccionProyectos) {
        //1.2.1. ADMINISTRADOR - VER PROYECTOS
                                        case 1:
                                            boolean salirVerProyectos = false;

                                            while (!salirVerProyectos) {
                                                verProyectos(proyectosCreados, proyectos, proyectosCantidades);

                                                if (proyectosCreados == 0) {
                                                    salirVerProyectos = true;
                                                }
            //1.2.1.1. ADMINISTRADOR - VISTA DETALLADA MENÚ
                                                if (proyectosCreados > 0) {
                                                    menuVistaDetallada(proyectosCreados, proyectos, proyectosCantidades);
                                                    System.out.println("Introduce el número del proyecto que deseas ver");
                                                    int selecProyectoDetalle = lecturaDatos.nextInt();
                                                    lecturaDatos.nextLine();
                                                    if (selecProyectoDetalle == proyectosCreados + 1) {
                                                        System.out.println("Volviendo a MIS PROYECTOS.");
                                                        salirVerProyectos = true;
                                                    }
                                                    else proyectosCreados = mostrarDetallesProyecto(selecProyectoDetalle, proyectosCreados, proyectos, proyectosCantidades, MAX_RECOMPENSAS, recompensasDescripcion, recompensasPrecios);

                                                }
                                            }
                                            break;
        //1.2.2. ADMINISTRADOR - SALIR (al menú principal)
                                        case 2:
                                            System.out.println("Volviendo a MENÚ PRINCIPAL...");
                                            salirSubMenu = true; // Salir del submenú
                                            cerrarSesion = true;
                                            break;
                                        default:
                                            System.out.println("Has introducido un valor incorrecto.");
                                            break;
                                    }
                                }
                                break;
    //1.3. ADMINISTRADOR - CONFIGURACIÓN
                            case 3:
                                do {
                                    menuConfiguracion();
                                    opcionConfig = lecturaDatos.nextInt();
                                    lecturaDatos.nextLine();
                                } while (opcionConfig < 1 || opcionConfig > 3);

                                switch (opcionConfig) {
                                    case 1:
                                        System.out.println("Introduce tu nuevo usuario: ");
                                        usuarioAdmin = lecturaDatos.nextLine();
                                        System.out.println();
                                        System.out.println("Usuario cambiado exitosamente.");
                                        break;
                                    case 2:
                                        System.out.println("Introduce tu nueva contraseña: ");
                                        contraseniaAdmin = lecturaDatos.nextLine();
                                        System.out.println("Contraseña cambiada exitosamente.");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                                        break;
                                }
                                break;
    //1.4. ADMINISTRADOR - CERRAR SESIÓN
                            case 4:
                                System.out.println("Volviendo al Menú Principal...");
                                //salirSubMenu = true; // Salir del submenú
                                cerrarSesion = true;
                                salirMenu = true;
                                registroAdmin=false;
                                break;
                            default:
                                System.out.println("Has introducido un valor incorrecto.");
                                break;
                        }
                    }

                }

                if (registroGestor) {
//2. GESTOR - MENÚ PRINCIPAL
                    boolean salirMenu = false;
                    contadorIntentos=0;
                    while (!salirMenu) { //El bucle finaliza cuando se le da 3. Cerrar sesión, salirMenu = true y te sales del menú de gestor.
                        menuPrincipalGestor();
                        int seleccionGestor = lecturaDatos.nextInt();

                        switch (seleccionGestor) {
    //2.1. GESTOR - MIS PROYECTOS
                            case 1:
                                boolean salirSubMenu = false;

                                while (!salirSubMenu) { //El bucle finaliza cuando se le da 3. Salir, salirSubMenu = true y te sales del menú Mis proyectos para ir al menu gestor.
                                    menuMisProyectoslGestor();
                                    int seleccionProyectos = lecturaDatos.nextInt();
                                    lecturaDatos.nextLine();

                                    switch (seleccionProyectos) {
        //2.1.1. GESTOR - CREAR PROYECTO
                                        case 1:
                                            crearProyecto(proyectosCreados, proyectos, proyectosCantidades, MAX_RECOMPENSAS, recompensasDescripcion, recompensasPrecios);
                                            proyectosCreados++;
                                            break;
        //2.1.2. GESTOR - VER PROYECTOS
                                        case 2:
                                            boolean salirVerProyectos = false;

                                            while (!salirVerProyectos) {
                                                verProyectos(proyectosCreados, proyectos, proyectosCantidades);

                                                if (proyectosCreados == 0) {
                                                    salirVerProyectos = true;
                                                }
            //2.1.2.1. GESTOR - VISTA DETALLADA MENÚ
                                                if (proyectosCreados > 0) {
                                                    menuVistaDetallada(proyectosCreados, proyectos, proyectosCantidades);
                                                    System.out.println("Introduce el número del proyecto que deseas ver");
                                                    int selecProyectoDetalle = lecturaDatos.nextInt();
                                                    lecturaDatos.nextLine();
                                                    if (selecProyectoDetalle == proyectosCreados + 1) {
                                                        System.out.println("Volviendo a MIS PROYECTOS.");
                                                        salirVerProyectos = true;
                                                    }
                                                    else proyectosCreados = mostrarDetallesProyecto(selecProyectoDetalle, proyectosCreados, proyectos, proyectosCantidades, MAX_RECOMPENSAS, recompensasDescripcion, recompensasPrecios);
                                                }
                                            }
                                            break;
        //2.1.3. GESTOR - SALIR (al menú principal)
                                        case 3:
                                            System.out.println("Volviendo a MENÚ PRINCIPAL...");
                                            salirSubMenu = true; // Salir del submenú
                                            cerrarSesion = true;
                                            break;
                                        default:
                                            System.out.println("Has introducido un valor incorrecto.");
                                            break;
                                    }
                                }
                                break;
    //2.2. GESTOR - CONFIGURACIÓN
                            case 2:
                                do {
                                    menuConfiguracion();
                                    opcionConfig = lecturaDatos.nextInt();
                                    lecturaDatos.nextLine();
                                } while (opcionConfig < 1 || opcionConfig > 3);

                                switch (opcionConfig) {
                                    case 1:
                                        System.out.println("Introduce tu nuevo usuario: ");
                                        usuarioGestor = lecturaDatos.nextLine();
                                        System.out.println();
                                        System.out.println("Usuario cambiado exitosamente.");
                                        break;
                                    case 2:
                                        System.out.println("Introduce tu nueva contraseña: ");
                                        contraseniaGestor = lecturaDatos.nextLine();
                                        System.out.println("Contraseña cambiada exitosamente.");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                                        break;
                                }
                                break;
    //2.3. GESTOR - CERRAR SESIÓN
                            case 3:
                                System.out.println("Saliendo del programa...");
                                registroGestor=false;
                                salirMenu = true; // Salir del menú
                                cerrarSesion=true;
                                break;
                            default:
                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                break;
                        }
                    }
                    if (cerrarSesion){
                        break;
                    }
                }

                //Menu inversor
                if(usuarioNPC1Blocked && (usuarioLogin.equalsIgnoreCase(usuarioNPC1) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC1))){
                    break;
                }else if(usuarioNPC2Blocked && (usuarioLogin.equalsIgnoreCase(usuarioNPC2) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC2))){
                    break;
                }else{
                    if (registroInversor) {
//3. INVERSOR - MENÚ PRINCIPAL
                        boolean salirMenu = false;
                        contadorIntentos=0;
                        while (!salirMenu) {
                            menuPrincipalInversor();
                            int seleccionInversor = lecturaDatos.nextInt();

                            switch (seleccionInversor) {
                                case 1:
    //3.1. INVERSOR - MIS INVERSIONES
                                    boolean salirSubMenuInversiones = false;
                                    while (!salirSubMenuInversiones) { //El bucle finaliza cuando se le da 3. Salir, salirSubMenu = true y te sales del menú Mis proyectos para ir al menu gestor.
                                        menuMisInversionesInversor();
                                        int seleccionProyectos = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();

                                        switch (seleccionProyectos) {
        //3.1.1. INVERSOR - VER PROYECTOS FINANCIADOS
                                            case 1:
                                                boolean salirVerProyectos = false;
                                                while (!salirVerProyectos) {
                                                    System.out.println("\n--- PROYECTOS FINANCIADOS ---");
                                                    // Si proyectosCreados tiene un valor determinado, se muestran todos los proyectos con valor inferior al actual (todos los creados previamente)
                    //Se evalua para usuario Inversor 1
                                                    if (npc1) {
                                                        if (nombre1 != null && participaInv1Proyecto1) {
                                                            System.out.println("\nProyecto 1:");
                                                            vistaProyectoInversor(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion1Proyecto1);
                                                        }
                                                        if (nombre2 != null && participaInv1Proyecto2) {
                                                            System.out.println("\nProyecto 2:");
                                                            vistaProyectoInversor(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion1Proyecto2);
                                                        }
                                                        if (nombre3 != null && participaInv1Proyecto3) {
                                                            System.out.println("\nProyecto 3:");
                                                            vistaProyectoInversor(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion1Proyecto3);
                                                        }

                                                        if (proyectosFinanciaInv1 == 0) {
                                                            System.out.println("No hay proyectos registrados.");
                                                            salirVerProyectos = true;
                                                        }
            //3.1.1.1. INVERSOR 1 - VISTA DETALLADA MENÚ
                                                        if (proyectosFinanciaInv1 > 0) {
                                                            menuVistaDetalladaInversor(proyectosFinanciaInv1, nombre1, nombre2, nombre3, participaInv1Proyecto1, participaInv1Proyecto2, participaInv1Proyecto3);
                                                            int selecProyectoDetalle = lecturaDatos.nextInt();
                                                            lecturaDatos.nextLine();

                                                            switch (selecProyectoDetalle) {
            //3.1.1.2. INVERSOR 1 - VISTA DETALLADA 1
                                                                case 1:
                                                                    if (proyectosFinanciaInv1 >= 1) {
                                                                        if (nombre1 != null && participaInv1Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            vistaProyectoInversorDetalle(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion1Proyecto1, fechaInicio1, fechaFin1, recompensa1_1, precio1_1, recompensa1_2, precio1_2, recompensa1_3, precio1_3);
                                                                            graficoProgreso(cantidadFinanciada1, cantidadNecesaria1);

                                                                    //SALIR proyecto 1
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre2 != null && participaInv1Proyecto2) {
                                                                            System.out.println("\nProyecto 2:");
                                                                            vistaProyectoInversorDetalle(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion1Proyecto2, fechaInicio2, fechaFin2, recompensa2_1, precio2_1, recompensa2_2, precio2_2, recompensa2_3, precio2_3);
                                                                            graficoProgreso(cantidadFinanciada2, cantidadNecesaria2);

                                                                    //SALIR proyecto 2
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre3 != null && participaInv1Proyecto3) {
                                                                            System.out.println("\nProyecto 3:");
                                                                            vistaProyectoInversorDetalle(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion1Proyecto3, fechaInicio3, fechaFin3, recompensa3_1, precio3_1, recompensa3_2, precio3_2, recompensa3_3, precio3_3);
                                                                            graficoProgreso(cantidadFinanciada3, cantidadNecesaria3);

                                                                    //SALIR proyecto 3
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else System.out.println("Error. Este proyecto no existe.");
                                                                    }
                                                                    else {
                                                                        System.out.println("Volviendo a MIS INVERSIONES");
                                                                        salirVerProyectos = true;
                                                                    }
                                                                    break;
            //3.1.1.3. INVERSOR 1 - VISTA DETALLADA 2
                                                                case 2:
                                                                    if (proyectosFinanciaInv1 >= 2) {
                                                                        if (nombre2 != null && participaInv1Proyecto2) {
                                                                            System.out.println("\nProyecto 2:");
                                                                            vistaProyectoInversorDetalle(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion1Proyecto2, fechaInicio2, fechaFin2, recompensa2_1, precio2_1, recompensa2_2, precio2_2, recompensa2_3, precio2_3);
                                                                            graficoProgreso(cantidadFinanciada2, cantidadNecesaria2);

                                                                            //SALIR proyecto 2
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre3 != null && participaInv1Proyecto3) {
                                                                            System.out.println("\nProyecto 3:");
                                                                            vistaProyectoInversorDetalle(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion1Proyecto3, fechaInicio3, fechaFin3, recompensa3_1, precio3_1, recompensa3_2, precio3_2, recompensa3_3, precio3_3);
                                                                            graficoProgreso(cantidadFinanciada3, cantidadNecesaria3);

                                                                            //SALIR proyecto 3
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre1 != null && participaInv1Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            vistaProyectoInversorDetalle(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion1Proyecto1, fechaInicio1, fechaFin1, recompensa1_1, precio1_1, recompensa1_2, precio1_2, recompensa1_3, precio1_3);
                                                                            graficoProgreso(cantidadFinanciada1, cantidadNecesaria1);

                                                                            //SALIR proyecto 1
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else System.out.println("Error. Este proyecto no existe.");
                                                                    }
                                                                    else {
                                                                        System.out.println("Volviendo a MIS INVERSIONES");
                                                                        salirVerProyectos = true;
                                                                    }
                                                                    break;
            //3.1.1.4. INVERSOR 1 - VISTA DETALLADA 3
                                                                case 3:
                                                                    if (proyectosFinanciaInv1 == 3) {
                                                                        if (nombre3 != null && participaInv1Proyecto3) {
                                                                            System.out.println("\nProyecto 3:");
                                                                            vistaProyectoInversorDetalle(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion1Proyecto3, fechaInicio3, fechaFin3, recompensa3_1, precio3_1, recompensa3_2, precio3_2, recompensa3_3, precio3_3);
                                                                            graficoProgreso(cantidadFinanciada3, cantidadNecesaria3);

                                                                            //SALIR proyecto 3
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre1 != null && participaInv1Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            vistaProyectoInversorDetalle(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion1Proyecto1, fechaInicio1, fechaFin1, recompensa1_1, precio1_1, recompensa1_2, precio1_2, recompensa1_3, precio1_3);
                                                                            graficoProgreso(cantidadFinanciada1, cantidadNecesaria1);

                                                                            //SALIR proyecto 1
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre2 != null && participaInv1Proyecto2) {
                                                                            System.out.println("\nProyecto 2:");
                                                                            vistaProyectoInversorDetalle(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion1Proyecto2, fechaInicio2, fechaFin2, recompensa2_1, precio2_1, recompensa2_2, precio2_2, recompensa2_3, precio2_3);
                                                                            graficoProgreso(cantidadFinanciada2, cantidadNecesaria2);

                                                                            //SALIR proyecto 2
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else System.out.println("Error. Este proyecto no existe.");
                                                                    }
                                                                    else {
                                                                        System.out.println("Volviendo a MIS INVERSIONES");
                                                                        salirVerProyectos = true;
                                                                    }
                                                                    break;
            //3.1.1.5. INVERSOR 1 - VISTA DETALLADA SALIR
                                                                case 4:
                                                                    if (proyectosFinanciaInv1 == 3) {
                                                                        System.out.println("Volviendo a MIS PROYECTOS...");
                                                                        salirVerProyectos = true;
                                                                    } else
                                                                        System.out.println("Has introducido un valor incorrecto.");
                                                                    break;
                                                                default:
                                                                    System.out.println("Has introducido un valor incorrecto.");
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                    //Se evalua para usuario Inversor 2
                                                    else if (npc2) {
                                                        if (nombre1 != null && participaInv2Proyecto1) {
                                                            System.out.println("\nProyecto 1:");
                                                            vistaProyectoInversor(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion2Proyecto1);
                                                        }
                                                        if (nombre2 != null && participaInv2Proyecto2) {
                                                            System.out.println("\nProyecto 2:");
                                                            vistaProyectoInversor(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion2Proyecto2);
                                                        }
                                                        if (nombre3 != null && participaInv2Proyecto3) {
                                                            System.out.println("\nProyecto 3:");
                                                            vistaProyectoInversor(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion2Proyecto3);
                                                        }

                                                        if (proyectosFinanciaInv2 == 0) {
                                                            System.out.println("No hay proyectos registrados.");
                                                            salirVerProyectos = true;
                                                        }
            //3.1.1.6. INVERSOR 2 - VISTA DETALLADA MENÚ
                                                        if (proyectosFinanciaInv2 > 0) {
                                                            menuVistaDetalladaInversor(proyectosFinanciaInv2, nombre1, nombre2, nombre3, participaInv2Proyecto1, participaInv2Proyecto2, participaInv2Proyecto3);
                                                            int selecProyectoDetalle = lecturaDatos.nextInt();
                                                            lecturaDatos.nextLine();

                                                            switch (selecProyectoDetalle) {
            //3.1.1.7. INVERSOR 2 - VISTA DETALLADA 1
                                                                case 1:
                                                                    if (proyectosFinanciaInv2 >= 1) {
                                                                        if (nombre1 != null && participaInv2Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            vistaProyectoInversorDetalle(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion2Proyecto1, fechaInicio1, fechaFin1, recompensa1_1, precio1_1, recompensa1_2, precio1_2, recompensa1_3, precio1_3);
                                                                            graficoProgreso(cantidadFinanciada1, cantidadNecesaria1);

                                                                            //SALIR proyecto 1
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre2 != null && participaInv2Proyecto2) {
                                                                            System.out.println("\nProyecto 2:");
                                                                            vistaProyectoInversorDetalle(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion2Proyecto2, fechaInicio2, fechaFin2, recompensa2_1, precio2_1, recompensa2_2, precio2_2, recompensa2_3, precio2_3);
                                                                            graficoProgreso(cantidadFinanciada2, cantidadNecesaria2);

                                                                            //SALIR proyecto 2
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre3 != null && participaInv2Proyecto3) {
                                                                            System.out.println("\nProyecto 3:");
                                                                            vistaProyectoInversorDetalle(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion2Proyecto3, fechaInicio3, fechaFin3, recompensa3_1, precio3_1, recompensa3_2, precio3_2, recompensa3_3, precio3_3);
                                                                            graficoProgreso(cantidadFinanciada3, cantidadNecesaria3);

                                                                            //SALIR proyecto 3
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else System.out.println("Error. Este proyecto no existe.");
                                                                    } else {
                                                                        System.out.println("Volviendo a MIS INVERSIONES");
                                                                        salirVerProyectos = true;
                                                                    }
                                                                    break;
            //3.1.1.8. INVERSOR 2 - VISTA DETALLADA 2
                                                                case 2:
                                                                    if (proyectosFinanciaInv2 >= 2) {
                                                                        if (nombre2 != null && participaInv2Proyecto2) {
                                                                            System.out.println("\nProyecto 2:");
                                                                            vistaProyectoInversorDetalle(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion2Proyecto2, fechaInicio2, fechaFin2, recompensa2_1, precio2_1, recompensa2_2, precio2_2, recompensa2_3, precio2_3);
                                                                            graficoProgreso(cantidadFinanciada2, cantidadNecesaria2);

                                                                            //SALIR proyecto 2
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre3 != null && participaInv2Proyecto3) {
                                                                            System.out.println("\nProyecto 3:");
                                                                            vistaProyectoInversorDetalle(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion2Proyecto3, fechaInicio3, fechaFin3, recompensa3_1, precio3_1, recompensa3_2, precio3_2, recompensa3_3, precio3_3);
                                                                            graficoProgreso(cantidadFinanciada3, cantidadNecesaria3);

                                                                            //SALIR proyecto 3
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre1 != null && participaInv2Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            vistaProyectoInversorDetalle(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion2Proyecto1, fechaInicio1, fechaFin1, recompensa1_1, precio1_1, recompensa1_2, precio1_2, recompensa1_3, precio1_3);
                                                                            graficoProgreso(cantidadFinanciada1, cantidadNecesaria1);

                                                                            //SALIR proyecto 1
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else System.out.println("Error. Este proyecto no existe.");
                                                                    } else {
                                                                        System.out.println("Volviendo a MIS INVERSIONES");
                                                                        salirVerProyectos = true;
                                                                    }
                                                                    break;
            //3.1.1.9. INVERSOR 2 - VISTA DETALLADA 3
                                                                case 3:
                                                                    if (proyectosFinanciaInv2 == 3) {
                                                                        if (nombre3 != null && participaInv2Proyecto3) {
                                                                            System.out.println("\nProyecto 3:");
                                                                            vistaProyectoInversorDetalle(nombre3, descripcion3, categoria3, cantidadNecesaria3, inversion2Proyecto3, fechaInicio3, fechaFin3, recompensa3_1, precio3_1, recompensa3_2, precio3_2, recompensa3_3, precio3_3);
                                                                            graficoProgreso(cantidadFinanciada3, cantidadNecesaria3);

                                                                            //SALIR proyecto 3
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre1 != null && participaInv2Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            vistaProyectoInversorDetalle(nombre1, descripcion1, categoria1, cantidadNecesaria1, inversion2Proyecto1, fechaInicio1, fechaFin1, recompensa1_1, precio1_1, recompensa1_2, precio1_2, recompensa1_3, precio1_3);
                                                                            graficoProgreso(cantidadFinanciada1, cantidadNecesaria1);

                                                                            //SALIR proyecto 1
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (nombre2 != null && participaInv2Proyecto2) {
                                                                            System.out.println("\nProyecto 2:");
                                                                            vistaProyectoInversorDetalle(nombre2, descripcion2, categoria2, cantidadNecesaria2, inversion2Proyecto2, fechaInicio2, fechaFin2, recompensa2_1, precio2_1, recompensa2_2, precio2_2, recompensa2_3, precio2_3);
                                                                            graficoProgreso(cantidadFinanciada2, cantidadNecesaria2);

                                                                            //SALIR proyecto 2
                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                menuGestionProyectoInversor();
                                                                                int gestionProyecto = lecturaDatos.nextInt();
                                                                                lecturaDatos.nextLine();

                                                                                if (gestionProyecto == 1) {
                                                                                    System.out.println("Volviendo a PROYECTOS FINANCIADOS");
                                                                                    salirGestionProyecto = true;
                                                                                } else {
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                }
                                                                            }
                                                                        }
                                                                        else System.out.println("Error. Este proyecto no existe.");
                                                                    } else {
                                                                        System.out.println("Volviendo a MIS INVERSIONES");
                                                                        salirVerProyectos = true;
                                                                    }
                                                                    break;
            //3.1.1.10. INVERSOR 2 - VISTA DETALLADA Salir
                                                                case 4:
                                                                    if (proyectosFinanciaInv2 == 3) {
                                                                        System.out.println("Volviendo a MIS INVERSIONES");
                                                                        salirVerProyectos = true;
                                                                    } else System.out.println("Has introducido un valor incorrecto.");
                                                                    break;
                                                                default:
                                                                    System.out.println("Has introducido un valor incorrecto.");
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                }
                                                break;
        //3.1.2. INVERSOR - SALIR (a menú principal)
                                            case 2:
                                                System.out.println("Volviendo a MENÚ PRINCIPAL");
                                                salirSubMenuInversiones = true; // Salir del submenú
                                                break;
                                            default:
                                                System.out.println("Has introducido un valor incorrecto.");
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
    //3.2. INVERSOR - PROYECTOS
                                    boolean salirSubMenuProyectos = false;
                                    while (!salirSubMenuProyectos) { //El bucle finaliza cuando se le da 3. Salir, salirSubMenu = true y te sales del menú Mis proyectos para ir al menu gestor.
                                        menuProyectos();
                                        int seleccionProyectos = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();

                                        switch (seleccionProyectos) {
        //3.2.1. INVERSOR - VER PROYECTOS EXISTENTES
                                            case 1:
                                                boolean salirVerProyectos = false;

                                                while (!salirVerProyectos) {
                                                    verProyectos(proyectosCreados, proyectos, proyectosCantidades);

                                                    if (proyectosCreados == 0) {
                                                        salirVerProyectos = true;
                                                    }

                                                    if (proyectosCreados > 0) {
                                                        menuVistaDetallada(proyectosCreados, proyectos, proyectosCantidades);
                                                        System.out.println("Introduce el número del proyecto que deseas ver");
                                                        int selecProyectoDetalle = lecturaDatos.nextInt();
                                                        lecturaDatos.nextLine();

                                                        if (selecProyectoDetalle == proyectosCreados + 1) {
                                                            System.out.println("Volviendo a MIS PROYECTOS.");
                                                            salirVerProyectos = true;
                                                        }
                                                        else mostrarDetallesProyectoInversor(selecProyectoDetalle, proyectosCreados, proyectos, proyectosCantidades, MAX_RECOMPENSAS, recompensasDescripcion, recompensasPrecios);

                                                    }
                                                }
                                                break;
        //3.2.2. INVERSOR - SALIR (a menú principal)
                                            case 2:
                                                System.out.println("Volviendo a MENÚ PRINCIPAL");
                                                salirSubMenuProyectos = true; // Salir del submenú
                                                break;
                                            default:
                                                System.out.println("Has introducido un valor incorrecto.");
                                                break;
                                        }
                                    }
                                    break;
                                case 3:
    //3.3. INVERSOR - CARTERA DIGITAL
                                    boolean salirSubMenuCartera = false;
                                    while (!salirSubMenuCartera) {
                                        menuCartera();
                                        int seleccionCartera = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();

                                        switch (seleccionCartera) {
                                            case 1:
                                                System.out.print("Tu saldo actual es de: ");
                                                if (npc1) System.out.println(saldoInversor1 + " €");
                                                else if (npc2) System.out.println(saldoInversor2 + " €");
                                                break;
                                            case 2:
                                                System.out.print("Introduce la cantidad que vas a añadir (en €): ");
                                                double sumaSaldo = lecturaDatos.nextDouble();
                                                lecturaDatos.nextLine();
                                                if (npc1) saldoInversor1 += sumaSaldo;
                                                else if (npc2) saldoInversor2 += sumaSaldo;
                                                System.out.println("Se han añadido " + sumaSaldo + " € a tu saldo actual.");
                                                break;
                                            case 3:
                                                System.out.println("Volviendo a MENÚ PRINCIPAL...");
                                                salirSubMenuCartera = true; // Salir del submenú
                                                break;
                                            default:
                                                System.out.println("Has introducido un valor incorrecto.");
                                                break;
                                        }
                                    }
                                    break;
                                case 4:
    //3.4. INVERSOR - INVITAR AMIGO
                                    boolean salirSubMenuAmigos = false;
                                    while (!salirSubMenuAmigos) {
                                        menuInvitaAmigo();
                                        int seleccionAmigos = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();

                                        switch (seleccionAmigos) {
                                            case 1:
                                                System.out.print("Tu lista de amigos es: ");
                                                if (npc1) {
                                                    if (amigosInversor1.isEmpty()) System.out.println("No tienes ningún amigo actualmente");
                                                    else System.out.println(amigosInversor1);
                                                }
                                                else if (npc2) {
                                                    if (amigosInversor2.isEmpty()) System.out.println("No tienes ningún amigo actualmente");
                                                    else System.out.println(amigosInversor2);
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Introduce la cuenta de usuario de un amigo: ");
                                                String cuentaAmigo = lecturaDatos.nextLine();
                                                if (npc1) amigosInversor1 = amigosInversor1.concat("\n" + cuentaAmigo);
                                                else if (npc2) amigosInversor2 = amigosInversor2.concat("\n" + cuentaAmigo);
                                                System.out.println("Se ha añadido " + cuentaAmigo + " a tu lista de amigos.");
                                                break;
                                            case 3:
                                                System.out.println("Volviendo a MENÚ PRINCIPAL...");
                                                salirSubMenuAmigos = true; // Salir del submenú
                                                break;
                                            default:
                                                System.out.println("Has introducido un valor incorrecto.");
                                                break;
                                        }
                                    }
                                    break;
                                case 5:
    //3.5. INVERSOR - CONFIGURACION
                                    do {
                                        menuConfiguracion();
                                        opcionConfig = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();
                                    } while (opcionConfig < 1 || opcionConfig > 3);

                                    switch (opcionConfig) {
                                        case 1:
                                            System.out.println("Introduce tu nuevo usuario: ");
                                            if (npc1) {
                                                usuarioNPC1 = lecturaDatos.nextLine();
                                                System.out.println();
                                                System.out.println("Usuario cambiado exitosamente.");
                                                break;
                                            }
                                            else {
                                                usuarioNPC2 = lecturaDatos.nextLine();
                                                System.out.println();
                                                System.out.println("Usuario cambiado exitosamente.");
                                                break;
                                            }

                                        case 2:
                                            if (npc1) {
                                                System.out.println("Introduce tu nueva contraseña: ");
                                                contraseniaNPC1 = lecturaDatos.nextLine();
                                                System.out.println("Contraseña cambiada exitosamente.");
                                                break;
                                            }
                                            else {
                                                System.out.println("Introduce tu nueva contraseña: ");
                                                contraseniaNPC2 = lecturaDatos.nextLine();
                                                System.out.println("Contraseña cambiada exitosamente.");
                                                break;
                                            }
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Has introducido un valor incorrecto.");
                                            break;
                                    }
                                    break;
                                case 6:
    //3.6. INVERSOR - CERRAR SESIÓN
                                    System.out.println("Saliendo del programa...");
                                    salirMenu = true; // Salir del menú
                                    registroInversor = false;
                                    cerrarSesion = true;
                                    break;
                                default:
                                    System.out.println("Has introducido un valor incorrecto.");
                            }
                        }
                        if (cerrarSesion){
                            break;
                        }
                    }
                }
            }while(!cerrarSesion);
        }while(!cerrarPrograma);
    }
}
