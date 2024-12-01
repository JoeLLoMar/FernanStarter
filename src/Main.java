import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables de usuarios
        int tipoUsuario;
        boolean cerrarPrograma=false;
        String usuarioLogin="", contraseniaLogin="";
        int contadorIntentos = 0, intentos = 2;
        String usuarioAdmin = "pepito123", contraseniaAdmin = "12345";
        String usuarioGestor = "tornaceitor", contraseniaGestor = "54321";
        String usuarioNPC1 = "soyunnpc1", contraseniaNPC1 = "6969";
        String usuarioNPC2 = "npcsisoy", contraseniaNPC2 = "9696";
        boolean admin = false, gestor = false, inversor = false, usuarioNPC1Blocked=false, usuarioGestorBlocked=false, usuarioNPC2Blocked=false;
        boolean registroAdmin = false, registroGestor = false, registroInversor = false, cerrarSesion=false;
        int opcionConfig = 0;

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

        int proyectosCreados = 0;

        do {
            boolean npc1 = false, npc2 = false;

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
            //Switch que valida que tipo de usuario has seleccionado y te pide iniciar sesión como tal
            switch (tipoUsuario) {
    //0.1. LOGIN - ADMINISTRADOR
                case 1:
                    admin = true;
                    System.out.println();
                    System.out.println("Usted ha elegido ingresar como administrador.");
                    System.out.println();
                    do {
                        System.out.println("Para salir del programa, escribe SALIR");
                        System.out.println("--------------------------------------");
                        System.out.println("1.-Introduce usuario ");
                        usuarioLogin = lecturaDatos.nextLine().toLowerCase();
                        if (usuarioLogin.equalsIgnoreCase("salir")) break;
                        System.out.println("2.-Introduce la contraseña");
                        contraseniaLogin = lecturaDatos.nextLine().toLowerCase();
                        if (contraseniaLogin.equalsIgnoreCase("salir")) break;

                        if ((usuarioLogin.equalsIgnoreCase(usuarioAdmin) && contraseniaLogin.equalsIgnoreCase(contraseniaAdmin))) {
                            registroAdmin = true;
                            System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                        }
                        else{
                            System.out.println("Credenciales incorrectos, pruebe de nuevo.");
                            System.out.println();
                            continue;
                        }
                        break;
                    } while (!registroAdmin);
                    break;
    //0.2. LOGIN - GESTOR
                case 2: //Accedes al login como gestor
                    gestor = true;
                    if (usuarioGestorBlocked) {
                        System.out.println("Este usuario ha sido bloqueado por el administrador.");
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Usted ha elegido ingresar como gestor.");
                        do {
                            if (contadorIntentos < 3) {
                                System.out.println();
                                System.out.println("Para salir del programa, escribe SALIR");
                                System.out.println("--------------------------------------");
                                System.out.println("1.-Introduce usuario ");
                                usuarioLogin = lecturaDatos.nextLine().toLowerCase();
                                if (usuarioLogin.equalsIgnoreCase("salir")) break;
                                System.out.println("2.-Introduce la contraseña");
                                contraseniaLogin = lecturaDatos.nextLine().toLowerCase();
                                if (contraseniaLogin.equalsIgnoreCase("salir")) break;

                                if ((usuarioLogin.equalsIgnoreCase(usuarioGestor) && contraseniaLogin.equalsIgnoreCase(contraseniaGestor))) {
                                    registroGestor = true;
                                    System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                                } else if (contadorIntentos < 3) {
                                    System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo, le quedan " + intentos-- + " intentos.");
                                    contadorIntentos++;
                                }
                            } else {
                                System.out.println();
                                System.out.println("Intentos agotados, usuario bloqueado.");
                                usuarioGestorBlocked=true;
                                break; //Agotas intentos y te manda al inicio del login gestor
                            }
                        } while (!registroGestor);
                        contadorIntentos=0;
                        break; // Te lleva a la creación de Proyectos
                    }
    //0.3. LOGIN - INVERSOR
                case 3: //igual que el case 2 de gestor
                    inversor = true;
                    if (usuarioNPC1Blocked && (usuarioLogin.equalsIgnoreCase(usuarioNPC1) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC1))) {
                        System.out.println("Este usuario ha sido bloqueado por el administrador.");
                        break;
                    } else if (usuarioNPC2Blocked && (usuarioLogin.equalsIgnoreCase(usuarioNPC2) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC2))) {
                        System.out.println("Este usuario ha sido bloqueado por el administrador.");
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Usted ha elegido ingresar como inversor.");
                        do {
                            if (contadorIntentos < 3) {
                                System.out.println();
                                System.out.println("Para salir del programa, escribe SALIR");
                                System.out.println("--------------------------------------");
                                System.out.println("1.-Introduce usuario ");
                                usuarioLogin = lecturaDatos.nextLine().toLowerCase();
                                if (usuarioLogin.equalsIgnoreCase("salir")) break;
                                System.out.println("2.-Introduce la contraseña");
                                contraseniaLogin = lecturaDatos.nextLine().toLowerCase();
                                if (contraseniaLogin.equalsIgnoreCase("salir")) break;

                                if ((usuarioLogin.equalsIgnoreCase(usuarioNPC1) && usuarioNPC1Blocked) ||
                                        (usuarioLogin.equalsIgnoreCase(usuarioNPC2) && usuarioNPC2Blocked)) {
                                    System.out.println("Este usuario ha sido bloqueado por el administrador.");
                                    break;
                                }
                                if ((usuarioLogin.equalsIgnoreCase(usuarioNPC1) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC1))) {
                                    registroInversor = true;
                                    npc1 = true;
                                    System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                                } else if (usuarioLogin.equalsIgnoreCase(usuarioNPC2) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC2)) {
                                    registroInversor = true;
                                    npc2 = true;
                                    System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                                } else if (contadorIntentos < 3) {
                                    System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo, le quedan " + intentos-- + " intentos.");
                                    contadorIntentos++;
                                }
                            } else {
                                System.out.println();
                                System.out.println("Intentos agotados, usuario bloqueado.");
                                usuarioNPC1Blocked=true;
                                usuarioNPC2Blocked=true;
                                break; //Agotas intentos y te manda al inicio del login gestor
                            }
                        } while (!registroInversor);
                        contadorIntentos=0;
                        break;
                    }
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
                        System.out.println("""
                            \n--- MENÚ PRINCIPAL ---
                            Seleccione una opción:
                            1. Panel de control
                            2. Proyectos
                            3. Configuración
                            4. Cerrar sesión""");
                        int seleccionAdmin = Integer.parseInt(lecturaDatos.nextLine());

                        switch (seleccionAdmin) {
    //1.1. ADMINISTRADOR - PANEL DE CONTROL
                            case 1:
                                System.out.println("Bienvenido al panel de control, ¿qué deseas hacer?:");
                                System.out.println("""
                                    \n--- PANEL DE CONTROL ---
                                    1. Bloquear usuario
                                    2. Desbloquear usuario""");

                                int eleccionBloqueo = Integer.parseInt(lecturaDatos.nextLine());
                                switch (eleccionBloqueo) {
                                    case 1:
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
                                    case 2:
                                        System.out.println("Lista de usuarios bloqueados");
                                        if(usuarioGestorBlocked) System.out.println("1. Usuario gestor: " + usuarioGestor + " está bloqueado");
                                        else System.out.println("1. Usuario gestor: " + usuarioGestor + " NO está bloqueado");
                                        if(usuarioNPC1Blocked) System.out.println("2. Usuario inversor 1: " + usuarioNPC1 + " está bloqueado");
                                        else System.out.println("2. Usuario inversor 1: " + usuarioNPC1 + " NO está bloqueado");
                                        if(usuarioNPC2Blocked) System.out.println("3. Usuario inversor 2: " + usuarioNPC2 + " está bloqueado");
                                        else System.out.println("3. Usuario inversor 2: " + usuarioNPC2 + " NO está bloqueado");
                                        int eleccionDesbloqueo = Integer.parseInt(lecturaDatos.nextLine());

                                        switch(eleccionDesbloqueo){
                                            case 1:
                                                if(usuarioGestorBlocked){
                                                    usuarioGestorBlocked=false;
                                                    System.out.println("Usuario desbloqueado con éxito.");
                                                }
                                                else System.out.println("Error, no se puede desbloquear un usuario ya desbloqueado");
                                                break;
                                            case 2:
                                                if(usuarioNPC1Blocked){
                                                    usuarioNPC1Blocked=false;
                                                    System.out.println("Usuario desbloqueado con éxito.");
                                                }
                                                else System.out.println("Error, no se puede desbloquear un usuario ya desbloqueado");
                                                break;
                                            case 3:
                                                if(usuarioNPC2Blocked){
                                                    usuarioNPC2Blocked=false;
                                                    System.out.println("Usuario desbloqueado con éxito.");
                                                }
                                                else System.out.println("Error, no se puede desbloquear un usuario ya desbloqueado");
                                                break;
                                        }
                                        break;
                                }
                                break;
    //1.2. ADMINISTRADOR - PROYECTOS
                            case 2:
                                boolean salirSubMenu = false;

                                while (!salirSubMenu) { //El bucle finaliza cuando se le da 3. Salir, salirSubMenu = true y te sales del menú Mis proyectos para ir al menu gestor.
                                    System.out.println("""
                                        \n--- PROYECTOS ---
                                        Seleccione una opción:
                                        1. Ver proyectos existentes
                                        2. Salir""");
                                    int seleccionProyectos = lecturaDatos.nextInt();
                                    lecturaDatos.nextLine();

                                    switch (seleccionProyectos) {
        //1.2.1. ADMINISTRADOR - VER PROYECTOS
                                        case 1:
                                            boolean salirVerProyectos = false;

                                            while (!salirVerProyectos) {
                                                System.out.println("\n--- PROYECTOS EXISTENTES ---");
                                                // Si proyectosCreados tiene un valor determinado, se muestran todos los proyectos con valor inferior al actual (todos los creados previamente)
                                                if (nombre1 != null) {
                                                    System.out.println("\nProyecto 1:");
                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €");
                                                }

                                                if (nombre2 != null) {
                                                    System.out.println("\nProyecto 2:");
                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €");
                                                }

                                                if (nombre3 != null) {
                                                    System.out.println("\nProyecto 3:");
                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €");
                                                }

                                                if (proyectosCreados == 0) {
                                                    System.out.println("No hay proyectos registrados.");
                                                    salirVerProyectos = true;
                                                }
            //1.2.1.1. ADMINISTRADOR - VISTA DETALLADA MENÚ
                                                if (proyectosCreados > 0) {
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
                                                    int selecProyectoDetalle = lecturaDatos.nextInt();
                                                    lecturaDatos.nextLine();

                                                    switch (selecProyectoDetalle) {
            //1.2.1.2. ADIMINISTRADOR - VISTA DETALLADA 1
                                                        case 1:
                                                            if (proyectosCreados >= 1) {
                                                                if (nombre1 != null) {
                                                                    System.out.println("\nProyecto 1:");
                                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                    System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 1
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria1 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa1_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 -Precio (€): ");
                                                                                            precio1_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa1_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio1_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa1_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio1_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2: // Todas las variables a "nulo" o a -1 para indicar que no hay un valor definido
                                                                                nombre1 = null;
                                                                                descripcion1 = null;
                                                                                categoria1 = null;
                                                                                cantidadNecesaria1 = -1;
                                                                                cantidadFinanciada1 = -1;
                                                                                fechaInicio1 = null;
                                                                                fechaFin1 = null;
                                                                                recompensa1_1 = null;
                                                                                recompensa1_2 = null;
                                                                                recompensa1_3 = null;
                                                                                precio1_1 = -1;
                                                                                precio1_2 = -1;
                                                                                precio1_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre2 != null) {
                                                                    System.out.println("\nProyecto 2:");
                                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                    System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 2
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria2 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa2_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio2_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa2_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio2_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa2_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio2_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre2 = null;
                                                                                descripcion2 = null;
                                                                                categoria2 = null;
                                                                                cantidadNecesaria2 = -1;
                                                                                cantidadFinanciada2 = -1;
                                                                                fechaInicio2 = null;
                                                                                fechaFin2 = null;
                                                                                recompensa2_1 = null;
                                                                                recompensa2_2 = null;
                                                                                recompensa2_3 = null;
                                                                                precio2_1 = -1;
                                                                                precio2_2 = -1;
                                                                                precio2_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre3 != null) {
                                                                    System.out.println("\nProyecto 3:");
                                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                    System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria3 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa3_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio3_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa3_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio3_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa3_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio3_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre3 = null;
                                                                                descripcion3 = null;
                                                                                categoria3 = null;
                                                                                cantidadNecesaria3 = -1;
                                                                                cantidadFinanciada3 = -1;
                                                                                fechaInicio3 = null;
                                                                                fechaFin3 = null;
                                                                                recompensa3_1 = null;
                                                                                recompensa3_2 = null;
                                                                                recompensa3_3 = null;
                                                                                precio3_1 = -1;
                                                                                precio3_2 = -1;
                                                                                precio3_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else System.out.println("Error. Este proyecto no existe.");
                                                            }
                                                            else {
                                                                System.out.println("Volviendo a PROYECTOS.");
                                                                salirVerProyectos = true;
                                                            }
                                                            break;
            //1.2.1.3. ADIMINISTRADOR - VISTA DETALLADA 2
                                                        case 2:
                                                            if (proyectosCreados >= 2) {
                                                                if (nombre2 != null) {
                                                                    System.out.println("\nProyecto 2:");
                                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                    System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);


                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 2
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria2 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa2_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio2_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa2_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio2_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa2_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio2_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre2 = null;
                                                                                descripcion2 = null;
                                                                                categoria2 = null;
                                                                                cantidadNecesaria2 = -1;
                                                                                cantidadFinanciada2 = -1;
                                                                                fechaInicio2 = null;
                                                                                fechaFin2 = null;
                                                                                recompensa2_1 = null;
                                                                                recompensa2_2 = null;
                                                                                recompensa2_3 = null;
                                                                                precio2_1 = -1;
                                                                                precio2_2 = -1;
                                                                                precio2_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre3 != null) {
                                                                    System.out.println("\nProyecto 3:");
                                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                    System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria3 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa3_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio3_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa3_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio3_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa3_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio3_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre3 = null;
                                                                                descripcion3 = null;
                                                                                categoria3 = null;
                                                                                cantidadNecesaria3 = -1;
                                                                                cantidadFinanciada3 = -1;
                                                                                fechaInicio3 = null;
                                                                                fechaFin3 = null;
                                                                                recompensa3_1 = null;
                                                                                recompensa3_2 = null;
                                                                                recompensa3_3 = null;
                                                                                precio3_1 = -1;
                                                                                precio3_2 = -1;
                                                                                precio3_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre1 != null) {
                                                                    System.out.println("\nProyecto 1:");
                                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                    System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 1
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria1 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa1_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 -Precio (€): ");
                                                                                            precio1_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa1_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio1_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa1_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio1_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2: // Todas las variables a "nulo" o a -1 para indicar que no hay un valor definido
                                                                                nombre1 = null;
                                                                                descripcion1 = null;
                                                                                categoria1 = null;
                                                                                cantidadNecesaria1 = -1;
                                                                                cantidadFinanciada1 = -1;
                                                                                fechaInicio1 = null;
                                                                                fechaFin1 = null;
                                                                                recompensa1_1 = null;
                                                                                recompensa1_2 = null;
                                                                                recompensa1_3 = null;
                                                                                precio1_1 = -1;
                                                                                precio1_2 = -1;
                                                                                precio1_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else System.out.println("Error. Este proyecto no existe.");
                                                            }
                                                            else {
                                                                System.out.println("Volviendo a PROYECTOS.");
                                                                salirVerProyectos = true;
                                                            }
                                                            break;
            //1.2.1.4. ADIMINISTRADOR - VISTA DETALLADA 3
                                                        case 3:
                                                            if (proyectosCreados == 3) {
                                                                if (nombre3 != null) {
                                                                    System.out.println("\nProyecto 3:");
                                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                    System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria3 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa3_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio3_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa3_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio3_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa3_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio3_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre3 = null;
                                                                                descripcion3 = null;
                                                                                categoria3 = null;
                                                                                cantidadNecesaria3 = -1;
                                                                                cantidadFinanciada3 = -1;
                                                                                fechaInicio3 = null;
                                                                                fechaFin3 = null;
                                                                                recompensa3_1 = null;
                                                                                recompensa3_2 = null;
                                                                                recompensa3_3 = null;
                                                                                precio3_1 = -1;
                                                                                precio3_2 = -1;
                                                                                precio3_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre1 != null) {
                                                                    System.out.println("\nProyecto 1:");
                                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                    System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 1
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria1 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa1_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 -Precio (€): ");
                                                                                            precio1_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa1_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio1_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa1_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio1_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2: // Todas las variables a "nulo" o a -1 para indicar que no hay un valor definido
                                                                                nombre1 = null;
                                                                                descripcion1 = null;
                                                                                categoria1 = null;
                                                                                cantidadNecesaria1 = -1;
                                                                                cantidadFinanciada1 = -1;
                                                                                fechaInicio1 = null;
                                                                                fechaFin1 = null;
                                                                                recompensa1_1 = null;
                                                                                recompensa1_2 = null;
                                                                                recompensa1_3 = null;
                                                                                precio1_1 = -1;
                                                                                precio1_2 = -1;
                                                                                precio1_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre2 != null) {
                                                                    System.out.println("\nProyecto 2:");
                                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                    System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 2
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria2 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa2_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio2_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa2_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio2_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa2_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio2_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre2 = null;
                                                                                descripcion2 = null;
                                                                                categoria2 = null;
                                                                                cantidadNecesaria2 = -1;
                                                                                cantidadFinanciada2 = -1;
                                                                                fechaInicio2 = null;
                                                                                fechaFin2 = null;
                                                                                recompensa2_1 = null;
                                                                                recompensa2_2 = null;
                                                                                recompensa2_3 = null;
                                                                                precio2_1 = -1;
                                                                                precio2_2 = -1;
                                                                                precio2_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else System.out.println("Error. Este proyecto no existe.");
                                                            }
                                                            else {
                                                                System.out.println("Volviendo a PROYECTOS.");
                                                                salirVerProyectos = true;
                                                            }
                                                            break;
            //1.2.1.5. ADIMINISTRADOR - VISTA DETALLADA SALIR
                                                        case 4:
                                                            if (proyectosCreados == 3) {
                                                                System.out.println("Volviendo a PROYECTOS...");
                                                                salirVerProyectos = true;
                                                            }
                                                            else System.out.println("Has introducido un valor incorrecto.");
                                                            break;
                                                        default:
                                                            System.out.println("Has introducido un valor incorrecto.");
                                                            break;
                                                    }
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
                                    System.out.println("""
                                        Selecciona que quieres hacer: 
                                        1.- Cambiar mi usuario
                                        2.- Cambiar mi contraseña
                                        3.- Salir""");
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
                        System.out.println("""
                            \n--- MENÚ PRINCIPAL ---
                            Seleccione una opción:
                            1. Mis proyectos
                            2. Configuración
                            3. Cerrar sesión""");
                        int seleccionGestor = lecturaDatos.nextInt();

                        switch (seleccionGestor) {
    //2.1. GESTOR - MIS PROYECTOS
                            case 1:
                                boolean salirSubMenu = false;

                                while (!salirSubMenu) { //El bucle finaliza cuando se le da 3. Salir, salirSubMenu = true y te sales del menú Mis proyectos para ir al menu gestor.
                                    System.out.println("""
                                        \n--- MIS PROYECTOS ---
                                        Seleccione una opción:
                                        1. Crear un nuevo proyecto
                                        2. Ver proyectos existentes
                                        3. Salir""");
                                    int seleccionProyectos = lecturaDatos.nextInt();
                                    lecturaDatos.nextLine();

                                    switch (seleccionProyectos) {
        //2.1.1. GESTOR - CREAR PROYECTO
                                        case 1:
                                            if (proyectosCreados >= 3) {
                                                System.out.println("Ya no se pueden crear más proyectos (máximo 3).");
                                            }
                                            else {
                                                proyectosCreados++;

                                                if (nombre1 == null) System.out.println("\n--- Crear Proyecto 1 ---");
                                                else if (nombre2 == null) System.out.println("\n--- Crear Proyecto 2 ---");
                                                else if (nombre3 == null) System.out.println("\n--- Crear Proyecto 3 ---");

                                                System.out.print("Nombre del proyecto: ");
                                                String nombre = lecturaDatos.nextLine();
                                                System.out.print("Descripción del proyecto: ");
                                                String descripcion = lecturaDatos.nextLine();
                                                System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                String categoria = lecturaDatos.nextLine();
                                                System.out.print("Cantidad necesaria (€): ");
                                                double cantidadNecesaria = lecturaDatos.nextDouble();
                                                System.out.print("Cantidad financiada hasta el momento (€): ");
                                                double cantidadFinanciada = lecturaDatos.nextDouble();
                                                lecturaDatos.nextLine(); // Limpiar buffer
                                                System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                String fechaInicio = lecturaDatos.nextLine();
                                                System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                String fechaFin = lecturaDatos.nextLine();

                                                System.out.println("\nAñadiendo recompensas (máximo 3):");
                                                System.out.print("Recompensa 1 - Descripción: ");
                                                String recompensa1 = lecturaDatos.nextLine();
                                                System.out.print("Recompensa 1 - Precio (€): ");
                                                double precio1 = lecturaDatos.nextDouble();
                                                lecturaDatos.nextLine();
                                                System.out.print("Recompensa 2 - Descripción: ");
                                                String recompensa2 = lecturaDatos.nextLine();
                                                System.out.print("Recompensa 2 - Precio (€): ");
                                                double precio2 = lecturaDatos.nextDouble();
                                                lecturaDatos.nextLine();
                                                System.out.print("Recompensa 3 - Descripción: ");
                                                String recompensa3 = lecturaDatos.nextLine();
                                                System.out.print("Recompensa 3 - Precio (€): ");
                                                double precio3 = lecturaDatos.nextDouble();
                                                lecturaDatos.nextLine();

                                                if (nombre1 == null) {
                                                    nombre1 = nombre;
                                                    descripcion1 = descripcion;
                                                    categoria1 = categoria;
                                                    cantidadNecesaria1 = cantidadNecesaria;
                                                    cantidadFinanciada1 = cantidadFinanciada;
                                                    fechaInicio1 = fechaInicio;
                                                    fechaFin1 = fechaFin;
                                                    recompensa1_1 = recompensa1;
                                                    recompensa1_2 = recompensa2;
                                                    recompensa1_3 = recompensa3;
                                                    precio1_1 = precio1;
                                                    precio1_2 = precio2;
                                                    precio1_3 = precio3;
                                                } else if (nombre2 == null) {
                                                    nombre2 = nombre;
                                                    descripcion2 = descripcion;
                                                    categoria2 = categoria;
                                                    cantidadNecesaria2 = cantidadNecesaria;
                                                    cantidadFinanciada2 = cantidadFinanciada;
                                                    fechaInicio2 = fechaInicio;
                                                    fechaFin2 = fechaFin;
                                                    recompensa2_1 = recompensa1;
                                                    recompensa2_2 = recompensa2;
                                                    recompensa2_3 = recompensa3;
                                                    precio2_1 = precio1;
                                                    precio2_2 = precio2;
                                                    precio2_3 = precio3;
                                                } else if (nombre3 == null) {
                                                    nombre3 = nombre;
                                                    descripcion3 = descripcion;
                                                    categoria3 = categoria;
                                                    cantidadNecesaria3 = cantidadNecesaria;
                                                    cantidadFinanciada3 = cantidadFinanciada;
                                                    fechaInicio3 = fechaInicio;
                                                    fechaFin3 = fechaFin;
                                                    recompensa3_1 = recompensa1;
                                                    recompensa3_2 = recompensa2;
                                                    recompensa3_3 = recompensa3;
                                                    precio3_1 = precio1;
                                                    precio3_2 = precio2;
                                                    precio3_3 = precio3;
                                                }

                                                System.out.println("Proyecto creado con éxito.");
                                            }
                                            break;
        //2.1.2. GESTOR - VER PROYECTOS
                                        case 2:
                                            boolean salirVerProyectos = false;

                                            while (!salirVerProyectos) {
                                                System.out.println("\n--- PROYECTOS EXISTENTES ---");
                                                // Si proyectosCreados tiene un valor determinado, se muestran todos los proyectos con valor inferior al actual (todos los creados previamente)
                                                if (nombre1 != null) {
                                                    System.out.println("\nProyecto 1:");
                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €");
                                                }

                                                if (nombre2 != null) {
                                                    System.out.println("\nProyecto 2:");
                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €");
                                                }

                                                if (nombre3 != null) {
                                                    System.out.println("\nProyecto 3:");
                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €");
                                                }

                                                if (proyectosCreados == 0) {
                                                    System.out.println("No hay proyectos registrados.");
                                                    salirVerProyectos = true;
                                                }
            //2.1.2.1. GESTOR - VISTA DETALLADA MENÚ
                                                if (proyectosCreados > 0) {
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
                                                    int selecProyectoDetalle = lecturaDatos.nextInt();
                                                    lecturaDatos.nextLine();

                                                    switch (selecProyectoDetalle) {
            //2.1.2.2. GESTOR - VISTA DETALLADA 1
                                                        case 1:
                                                            if (proyectosCreados >= 1) {
                                                                if (nombre1 != null) {
                                                                    System.out.println("\nProyecto 1:");
                                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                    System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 1
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria1 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa1_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 -Precio (€): ");
                                                                                            precio1_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa1_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio1_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa1_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio1_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2: // Todas las variables a "nulo" o a -1 para indicar que no hay un valor definido
                                                                                nombre1 = null;
                                                                                descripcion1 = null;
                                                                                categoria1 = null;
                                                                                cantidadNecesaria1 = -1;
                                                                                cantidadFinanciada1 = -1;
                                                                                fechaInicio1 = null;
                                                                                fechaFin1 = null;
                                                                                recompensa1_1 = null;
                                                                                recompensa1_2 = null;
                                                                                recompensa1_3 = null;
                                                                                precio1_1 = -1;
                                                                                precio1_2 = -1;
                                                                                precio1_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre2 != null) {
                                                                    System.out.println("\nProyecto 2:");
                                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                    System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 2
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria2 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa2_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio2_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa2_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio2_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa2_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio2_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre2 = null;
                                                                                descripcion2 = null;
                                                                                categoria2 = null;
                                                                                cantidadNecesaria2 = -1;
                                                                                cantidadFinanciada2 = -1;
                                                                                fechaInicio2 = null;
                                                                                fechaFin2 = null;
                                                                                recompensa2_1 = null;
                                                                                recompensa2_2 = null;
                                                                                recompensa2_3 = null;
                                                                                precio2_1 = -1;
                                                                                precio2_2 = -1;
                                                                                precio2_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre3 != null) {
                                                                    System.out.println("\nProyecto 3:");
                                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                    System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria3 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa3_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio3_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa3_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio3_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa3_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio3_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre3 = null;
                                                                                descripcion3 = null;
                                                                                categoria3 = null;
                                                                                cantidadNecesaria3 = -1;
                                                                                cantidadFinanciada3 = -1;
                                                                                fechaInicio3 = null;
                                                                                fechaFin3 = null;
                                                                                recompensa3_1 = null;
                                                                                recompensa3_2 = null;
                                                                                recompensa3_3 = null;
                                                                                precio3_1 = -1;
                                                                                precio3_2 = -1;
                                                                                precio3_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else System.out.println("Error. Este proyecto no existe.");
                                                            }
                                                            else {
                                                                System.out.println("Volviendo a MIS PROYECTOS.");
                                                                salirVerProyectos = true;
                                                            }
                                                            break;
            //2.1.2.3. GESTOR - VISTA DETALLADA 2
                                                        case 2:
                                                            if (proyectosCreados >= 2) {
                                                                if (nombre2 != null) {
                                                                    System.out.println("\nProyecto 2:");
                                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                    System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);


                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 2
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria2 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa2_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio2_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa2_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio2_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa2_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio2_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre2 = null;
                                                                                descripcion2 = null;
                                                                                categoria2 = null;
                                                                                cantidadNecesaria2 = -1;
                                                                                cantidadFinanciada2 = -1;
                                                                                fechaInicio2 = null;
                                                                                fechaFin2 = null;
                                                                                recompensa2_1 = null;
                                                                                recompensa2_2 = null;
                                                                                recompensa2_3 = null;
                                                                                precio2_1 = -1;
                                                                                precio2_2 = -1;
                                                                                precio2_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre3 != null) {
                                                                    System.out.println("\nProyecto 3:");
                                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                    System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria3 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa3_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio3_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa3_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio3_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa3_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio3_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre3 = null;
                                                                                descripcion3 = null;
                                                                                categoria3 = null;
                                                                                cantidadNecesaria3 = -1;
                                                                                cantidadFinanciada3 = -1;
                                                                                fechaInicio3 = null;
                                                                                fechaFin3 = null;
                                                                                recompensa3_1 = null;
                                                                                recompensa3_2 = null;
                                                                                recompensa3_3 = null;
                                                                                precio3_1 = -1;
                                                                                precio3_2 = -1;
                                                                                precio3_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre1 != null) {
                                                                    System.out.println("\nProyecto 1:");
                                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                    System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 1
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria1 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa1_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 -Precio (€): ");
                                                                                            precio1_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa1_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio1_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa1_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio1_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2: // Todas las variables a "nulo" o a -1 para indicar que no hay un valor definido
                                                                                nombre1 = null;
                                                                                descripcion1 = null;
                                                                                categoria1 = null;
                                                                                cantidadNecesaria1 = -1;
                                                                                cantidadFinanciada1 = -1;
                                                                                fechaInicio1 = null;
                                                                                fechaFin1 = null;
                                                                                recompensa1_1 = null;
                                                                                recompensa1_2 = null;
                                                                                recompensa1_3 = null;
                                                                                precio1_1 = -1;
                                                                                precio1_2 = -1;
                                                                                precio1_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else System.out.println("Error. Este proyecto no existe.");
                                                            }
                                                            else {
                                                                System.out.println("Volviendo a MIS PROYECTOS.");
                                                                salirVerProyectos = true;
                                                            }
                                                            break;
            //2.1.2.4. GESTOR - VISTA DETALLADA 3
                                                        case 3:
                                                            if (proyectosCreados == 3) {
                                                                if (nombre3 != null) {
                                                                    System.out.println("\nProyecto 3:");
                                                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                    System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria3 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin3 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa3_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio3_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa3_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio3_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa3_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio3_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre3 = null;
                                                                                descripcion3 = null;
                                                                                categoria3 = null;
                                                                                cantidadNecesaria3 = -1;
                                                                                cantidadFinanciada3 = -1;
                                                                                fechaInicio3 = null;
                                                                                fechaFin3 = null;
                                                                                recompensa3_1 = null;
                                                                                recompensa3_2 = null;
                                                                                recompensa3_3 = null;
                                                                                precio3_1 = -1;
                                                                                precio3_2 = -1;
                                                                                precio3_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre1 != null) {
                                                                    System.out.println("\nProyecto 1:");
                                                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                    System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 1
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria1 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin1 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa1_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 -Precio (€): ");
                                                                                            precio1_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa1_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio1_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa1_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio1_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2: // Todas las variables a "nulo" o a -1 para indicar que no hay un valor definido
                                                                                nombre1 = null;
                                                                                descripcion1 = null;
                                                                                categoria1 = null;
                                                                                cantidadNecesaria1 = -1;
                                                                                cantidadFinanciada1 = -1;
                                                                                fechaInicio1 = null;
                                                                                fechaFin1 = null;
                                                                                recompensa1_1 = null;
                                                                                recompensa1_2 = null;
                                                                                recompensa1_3 = null;
                                                                                precio1_1 = -1;
                                                                                precio1_2 = -1;
                                                                                precio1_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else if (nombre2 != null) {
                                                                    System.out.println("\nProyecto 2:");
                                                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                            "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                    System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                    // Calcular el porcentaje de progreso
                                                                    double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria3) * 100;

                                                                    // Pintar la barra de progreso
                                                                    System.out.println("\nBarra de Progreso:");
                                                                    System.out.print("[");

                                                                    int totalCaracteres = 50; // Longitud total de la barra
                                                                    int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                    for (int i = 0; i < totalCaracteres; i++) {
                                                                        if (i < caracteresLlenos) {
                                                                            System.out.print("#"); // Parte llena de la barra
                                                                        } else {
                                                                            System.out.print("-"); // Parte vacía de la barra
                                                                        }
                                                                    }
                                                                    System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                    boolean salirGestionProyecto = false;
                                                                    //MODIFICAR - ELIMINAR proyecto 2
                                                                    while (!salirGestionProyecto) {
                                                                        System.out.println("""
                                                                    \nOpciones de gestión:
                                                                    1. Modificar proyecto
                                                                    2. Eliminar proyecto
                                                                    3. Salir""");
                                                                        int gestionProyecto = lecturaDatos.nextInt();
                                                                        lecturaDatos.nextLine();

                                                                        switch (gestionProyecto) {
                                                                            case 1:
                                                                                boolean salirModificar = false;

                                                                                while (!salirModificar){
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
                                                                                    int modificaApartado = lecturaDatos.nextInt();
                                                                                    lecturaDatos.nextLine();

                                                                                    switch (modificaApartado) {
                                                                                        case 1:
                                                                                            System.out.print("Nombre del proyecto: ");
                                                                                            nombre2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.print("Descripción del proyecto: ");
                                                                                            descripcion2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.print("Categoría (arte, tecnología, cine, etc.): ");
                                                                                            categoria2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.print("Cantidad necesaria (€): ");
                                                                                            cantidadNecesaria2 = lecturaDatos.nextDouble();
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.print("Cantidad financiada hasta el momento (€): ");
                                                                                            cantidadFinanciada2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine(); // Limpiar buffer
                                                                                            break;
                                                                                        case 6:
                                                                                            System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
                                                                                            fechaInicio2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 7:
                                                                                            System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
                                                                                            fechaFin2 = lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 8:
                                                                                            System.out.print("Recompensa 1 - Descripción: ");
                                                                                            recompensa2_1 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 1 - Precio (€): ");
                                                                                            precio2_1 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 9:
                                                                                            System.out.print("Recompensa 2 - Descripción: ");
                                                                                            recompensa2_2 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 2 - Precio (€): ");
                                                                                            precio2_2 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 10:
                                                                                            System.out.print("Recompensa 3 - Descripción: ");
                                                                                            recompensa2_3 = lecturaDatos.nextLine();
                                                                                            System.out.print("Recompensa 3 - Precio (€): ");
                                                                                            precio2_3 = lecturaDatos.nextDouble();
                                                                                            lecturaDatos.nextLine();
                                                                                            break;
                                                                                        case 11:
                                                                                            System.out.println("Volviendo al menú de modificación.");
                                                                                            salirModificar = true;
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                nombre2 = null;
                                                                                descripcion2 = null;
                                                                                categoria2 = null;
                                                                                cantidadNecesaria2 = -1;
                                                                                cantidadFinanciada2 = -1;
                                                                                fechaInicio2 = null;
                                                                                fechaFin2 = null;
                                                                                recompensa2_1 = null;
                                                                                recompensa2_2 = null;
                                                                                recompensa2_3 = null;
                                                                                precio2_1 = -1;
                                                                                precio2_2 = -1;
                                                                                precio2_3 = -1;
                                                                                proyectosCreados--;
                                                                                System.out.println("El proyecto ha sido eliminado.");
                                                                                salirGestionProyecto = true;
                                                                                if (proyectosCreados == 0) salirSubMenu = true;
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Volviendo al menú de gestión de proyecto.");
                                                                                salirGestionProyecto = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                else System.out.println("Error. Este proyecto no existe.");
                                                            }
                                                            else {
                                                                System.out.println("Volviendo a MIS PROYECTOS.");
                                                                salirVerProyectos = true;
                                                            }
                                                            break;
            //2.1.2.5. GESTOR - VISTA DETALLADA SALIR
                                                        case 4:
                                                            if (proyectosCreados == 3) {
                                                                System.out.println("Volviendo a MIS PROYECTOS...");
                                                                salirVerProyectos = true;
                                                            }
                                                            else System.out.println("Has introducido un valor incorrecto.");
                                                            break;
                                                        default:
                                                            System.out.println("Has introducido un valor incorrecto.");
                                                            break;
                                                    }
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
                                    System.out.println("""
                                        Selecciona que quieres hacer: 
                                        1.- Cambiar mi usuario
                                        2.- Cambiar mi contraseña
                                        3.- Salir""");
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
                            System.out.println("""
                                    \n--- MENÚ PRINCIPAL ---
                                    Seleccione una opción:
                                    1. Mis inversiones
                                    2. Proyectos
                                    3. Cartera digital
                                    4. Invita a un amigo
                                    5. Configuración
                                    6. Cerrar sesión""");

                            int seleccionInversor = lecturaDatos.nextInt();


                            switch (seleccionInversor) {
                                case 1:
    //3.1. INVERSOR - MIS INVERSIONES
                                    boolean salirSubMenuInversiones = false;

                                    while (!salirSubMenuInversiones) { //El bucle finaliza cuando se le da 3. Salir, salirSubMenu = true y te sales del menú Mis proyectos para ir al menu gestor.
                                        System.out.println("""
                                                \n--- PROYECTOS ---
                                                Seleccione una opción:
                                                1. Ver proyectos financiados
                                                2. Salir""");
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
                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion1Proyecto1 + " €");
                                                        }

                                                        if (nombre2 != null && participaInv1Proyecto2) {
                                                            System.out.println("\nProyecto 2:");
                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion1Proyecto2 + " €");
                                                        }

                                                        if (nombre3 != null && participaInv1Proyecto3) {
                                                            System.out.println("\nProyecto 3:");
                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion1Proyecto3 + " €");
                                                        }

                                                        if (proyectosFinanciaInv1 == 0) {
                                                            System.out.println("No hay proyectos registrados.");
                                                            salirVerProyectos = true;
                                                        }
            //3.1.1.1. INVERSOR 1 - VISTA DETALLADA MENÚ
                                                        if (proyectosFinanciaInv1 > 0) {
                                                            System.out.println("\nVer vista detallada: ");

                                                            for (int i = 1; i <= proyectosFinanciaInv1; i++) {
                                                                System.out.print(i + ". Proyecto ");
                                                                if (i == 1) {
                                                                    if (nombre1 != null && participaInv1Proyecto1) System.out.println("1: " + nombre1);
                                                                    else if (nombre2 != null && participaInv1Proyecto2) System.out.println("2: " + nombre2);
                                                                    else if (nombre3 != null && participaInv1Proyecto3) System.out.println("3: " + nombre3);

                                                                } else if (i == 2) {
                                                                    if (nombre2 != null && participaInv1Proyecto2) System.out.println("2: " + nombre2);
                                                                    else if (nombre3 != null && participaInv1Proyecto3) System.out.println("3: " + nombre3);
                                                                    else if (nombre1 != null && participaInv1Proyecto1) System.out.println("1: " + nombre1);

                                                                } else if (i == 3) {
                                                                    if (nombre3 != null && participaInv1Proyecto3) System.out.println("3: " + nombre3);
                                                                    else if (nombre1 != null && participaInv1Proyecto1) System.out.println("1: " + nombre1);
                                                                    else if (nombre2 != null && participaInv1Proyecto2) System.out.println("2: " + nombre2);
                                                                }
                                                            }

                                                            if (proyectosFinanciaInv1 == 1) System.out.print("2. ");
                                                            else if (proyectosFinanciaInv1 == 2) System.out.print("3. ");
                                                            else if (proyectosFinanciaInv1 == 3) System.out.print("4. ");
                                                            System.out.println("Salir");
                                                            int selecProyectoDetalle = lecturaDatos.nextInt();
                                                            lecturaDatos.nextLine();

                                                            switch (selecProyectoDetalle) {
            //3.1.1.2. INVERSOR 1 - VISTA DETALLADA 1
                                                                case 1:
                                                                    if (proyectosFinanciaInv1 >= 1) {
                                                                        if (nombre1 != null && participaInv1Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion1Proyecto1 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                            System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 1
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion1Proyecto2 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                            System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 2
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion1Proyecto3 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                            System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion1Proyecto2 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                            System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 2
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion1Proyecto3 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                            System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion1Proyecto1 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                            System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 1
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion1Proyecto3 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                            System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion1Proyecto1 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                            System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 1
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion1Proyecto2 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                            System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 2
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                    if (npc2) {
                                                        if (nombre1 != null && participaInv2Proyecto1) {
                                                            System.out.println("\nProyecto 1:");
                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion2Proyecto1 + " €");
                                                        }

                                                        if (nombre2 != null && participaInv2Proyecto2) {
                                                            System.out.println("\nProyecto 2:");
                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion2Proyecto2 + " €");
                                                        }

                                                        if (nombre3 != null && participaInv2Proyecto3) {
                                                            System.out.println("\nProyecto 3:");
                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion2Proyecto3 + " €");
                                                        }

                                                        if (proyectosFinanciaInv2 == 0) {
                                                            System.out.println("No hay proyectos registrados.");
                                                            salirVerProyectos = true;
                                                        }
            //3.1.1.6. INVERSOR 2 - VISTA DETALLADA MENÚ
                                                        if (proyectosFinanciaInv2 > 0) {
                                                            System.out.println("\nVer vista detallada: ");

                                                            for (int i = 1; i <= proyectosFinanciaInv2; i++) {
                                                                System.out.print(i + ". Proyecto ");
                                                                if (i == 1) {
                                                                    if (nombre1 != null && participaInv2Proyecto1) System.out.println("1: " + nombre1);
                                                                    else if (nombre2 != null && participaInv2Proyecto2) System.out.println("2: " + nombre2);
                                                                    else if (nombre3 != null && participaInv2Proyecto3) System.out.println("3: " + nombre3);
                                                                } else if (i == 2) {
                                                                    if (nombre2 != null && participaInv2Proyecto2) System.out.println("2: " + nombre2);
                                                                    else if (nombre3 != null && participaInv2Proyecto3) System.out.println("3: " + nombre3);
                                                                    else if (nombre1 != null && participaInv2Proyecto1) System.out.println("1: " + nombre1);
                                                                } else if (i == 3) {
                                                                    if (nombre3 != null && participaInv2Proyecto3) System.out.println("3: " + nombre3);
                                                                    else if (nombre1 != null && participaInv2Proyecto1) System.out.println("1: " + nombre1);
                                                                    else if (nombre2 != null && participaInv2Proyecto2) System.out.println("2: " + nombre2);
                                                                }
                                                            }

                                                            if (proyectosFinanciaInv2 == 1) System.out.print("2. ");
                                                            else if (proyectosFinanciaInv2 == 2) System.out.print("3. ");
                                                            else if (proyectosFinanciaInv2 == 3) System.out.print("4. ");
                                                            System.out.println("Salir");
                                                            int selecProyectoDetalle = lecturaDatos.nextInt();
                                                            lecturaDatos.nextLine();

                                                            switch (selecProyectoDetalle) {
            //3.1.1.7. INVERSOR 2 - VISTA DETALLADA 1
                                                                case 1:
                                                                    if (proyectosFinanciaInv2 >= 1) {
                                                                        if (nombre1 != null && participaInv2Proyecto1) {
                                                                            System.out.println("\nProyecto 1:");
                                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion2Proyecto1 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                            System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 1
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion2Proyecto2 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                            System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 2
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion2Proyecto3 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                            System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion2Proyecto2 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                            System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 2
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion2Proyecto3 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                            System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion2Proyecto1 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                            System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 1
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad que has aportado: " + inversion2Proyecto3 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                            System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad que has aportado: " + inversion2Proyecto1 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                            System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 1
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                                                            System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                    "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad que has aportado: " + inversion2Proyecto2 + " €" +
                                                                                    "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                            System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                            // Calcular el porcentaje de progreso
                                                                            double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                            // Pintar la barra de progreso
                                                                            System.out.println("\nBarra de Progreso:");
                                                                            System.out.print("[");

                                                                            int totalCaracteres = 50; // Longitud total de la barra
                                                                            int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                            for (int i = 0; i < totalCaracteres; i++) {
                                                                                if (i < caracteresLlenos) {
                                                                                    System.out.print("#"); // Parte llena de la barra
                                                                                } else {
                                                                                    System.out.print("-"); // Parte vacía de la barra
                                                                                }
                                                                            }
                                                                            System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                            boolean salirGestionProyecto = false;
                                                                            //MODIFICAR - ELIMINAR proyecto 2
                                                                            while (!salirGestionProyecto) {
                                                                                System.out.println("""
                                                                                        \nSeleccione una opción:
                                                                                        1. Salir""");
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
                                        System.out.println("""
                                        \n--- PROYECTOS ---
                                        Seleccione una opción:
                                        1. Ver proyectos existentes
                                        2. Salir""");
                                        int seleccionProyectos = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();

                                        switch (seleccionProyectos) {
        //3.2.1. INVERSOR - VER PROYECTOS EXISTENTES
                                            case 1:
                                                boolean salirVerProyectos = false;

                                                while (!salirVerProyectos) {
                                                    System.out.println("\n--- PROYECTOS EXISTENTES ---");

                                                    // Si proyectosCreados tiene un valor determinado, se muestran todos los proyectos con valor inferior al actual (todos los creados previamente)
                                                    if (nombre1 != null) {
                                                        System.out.println("\nProyecto 1:");
                                                        System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €");
                                                    }

                                                    if (nombre2 != null) {
                                                        System.out.println("\nProyecto 2:");
                                                        System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €");
                                                    }

                                                    if (nombre3 != null) {
                                                        System.out.println("\nProyecto 3:");
                                                        System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €");
                                                    }

                                                    if (proyectosCreados == 0) {
                                                        System.out.println("No hay proyectos registrados.");
                                                        salirVerProyectos = true;
                                                    }

                                                    if (proyectosCreados > 0) {
                                                        System.out.println("\nVer vista detallada: ");
            //3.2.1.1. INVERSOR - VISTA DETALLADA MENÚ
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
                                                        int selecProyectoDetalle = lecturaDatos.nextInt();
                                                        lecturaDatos.nextLine();

                                                        switch (selecProyectoDetalle) {
            //3.2.1.2. INVERSOR - VISTA DETALLADA 1
                                                            case 1:
                                                                if (proyectosCreados >= 1) {
                                                                    if (nombre1 != null) {
                                                                        System.out.println("\nProyecto 1:");
                                                                        System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                        System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        //INVERTIR - proyecto 1
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                             \nSeleccione una opción:
                                                                             1. Invertir en el proyecto
                                                                             2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa1_1 + " (" + precio1_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa1_2 + " (" + precio1_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa1_3 + " (" + precio1_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 1 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_1) {
                                                                                                        System.out.println("Has invertido " + precio1_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa1_1);
                                                                                                        cantidadFinanciada1 += precio1_1;
                                                                                                        saldoInversor1 -= precio1_1;
                                                                                                        inversion1Proyecto1 += precio1_1;
                                                                                                        participaInv1Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_1) {
                                                                                                        System.out.println("Has invertido " + precio1_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa1_1);
                                                                                                        cantidadFinanciada1 += precio1_1;
                                                                                                        saldoInversor2 -= precio1_1;
                                                                                                        inversion2Proyecto1 += precio1_1;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 1 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_2) {
                                                                                                        System.out.println("Has invertido " + precio1_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa1_2);
                                                                                                        cantidadFinanciada1 += precio1_2;
                                                                                                        saldoInversor1 -= precio1_2;
                                                                                                        inversion1Proyecto1 += precio1_2;
                                                                                                        participaInv1Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_2) {
                                                                                                        System.out.println("Has invertido " + precio1_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa1_2);
                                                                                                        cantidadFinanciada1 += precio1_2;
                                                                                                        saldoInversor2 -= precio1_2;
                                                                                                        inversion2Proyecto1 += precio1_2;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 1 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_3) {
                                                                                                        System.out.println("Has invertido " + precio1_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa1_3);
                                                                                                        cantidadFinanciada1 += precio1_3;
                                                                                                        saldoInversor1 -= precio1_3;
                                                                                                        inversion1Proyecto1 += precio1_3;
                                                                                                        participaInv1Proyecto1 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_3) {
                                                                                                        System.out.println("Has invertido " + precio1_3 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa1_3);
                                                                                                        cantidadFinanciada1 += precio1_3;
                                                                                                        saldoInversor2 -= precio1_3;
                                                                                                        inversion2Proyecto1 += precio1_3;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo a gestiones de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto1) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto1) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (nombre2 != null) {
                                                                        System.out.println("\nProyecto 2:");
                                                                        System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                        System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        //INVERTIR - proyecto 2
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                            \nSeleccione una opción:
                                                                             1. Invertir en el proyecto
                                                                             2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa2_1 + " (" + precio2_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa2_2 + " (" + precio2_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa2_3 + " (" + precio2_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 2 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_1) {
                                                                                                        System.out.println("Has invertido " + precio2_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa2_1);
                                                                                                        cantidadFinanciada2 += precio2_1;
                                                                                                        saldoInversor1 -= precio2_1;
                                                                                                        inversion1Proyecto2 += precio2_1;
                                                                                                        participaInv1Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_1) {
                                                                                                        System.out.println("Has invertido " + precio2_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa2_1);
                                                                                                        cantidadFinanciada2 += precio2_1;
                                                                                                        saldoInversor2 -= precio2_1;
                                                                                                        inversion2Proyecto2 += precio2_1;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 2 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_2) {
                                                                                                        System.out.println("Has invertido " + precio2_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_2);
                                                                                                        cantidadFinanciada2 += precio2_2;
                                                                                                        saldoInversor1 -= precio2_2;
                                                                                                        inversion1Proyecto2 += precio2_2;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_2) {
                                                                                                        System.out.println("Has invertido " + precio2_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa2_2);
                                                                                                        cantidadFinanciada2 += precio2_2;
                                                                                                        saldoInversor2 -= precio2_2;
                                                                                                        inversion2Proyecto2 += precio2_2;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 2 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_3) {
                                                                                                        System.out.println("Has invertido " + precio2_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_3);
                                                                                                        cantidadFinanciada2 += precio2_3;
                                                                                                        saldoInversor1 -= precio2_3;
                                                                                                        inversion1Proyecto2 += precio2_3;
                                                                                                        participaInv1Proyecto2 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_3) {
                                                                                                        System.out.println("Has invertido " + precio2_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_3);
                                                                                                        cantidadFinanciada2 += precio2_3;
                                                                                                        saldoInversor2 -= precio2_3;
                                                                                                        inversion2Proyecto2 += precio2_3;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo al menú de gestión de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto2) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto2) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (nombre3 != null) {
                                                                        System.out.println("\nProyecto 3:");
                                                                        System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                        System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                            \nSeleccione una opción:
                                                                            1. Invertir en el proyecto
                                                                            2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa2_1 + " (" + precio2_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa2_2 + " (" + precio2_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa2_3 + " (" + precio2_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                            //Proyecto 3 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_1) {
                                                                                                        System.out.println("Has invertido " + precio3_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa3_1);
                                                                                                        cantidadFinanciada3 += precio3_1;
                                                                                                        saldoInversor1 -= precio3_1;
                                                                                                        inversion1Proyecto3 += precio3_1;
                                                                                                        participaInv1Proyecto3 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_1) {
                                                                                                        System.out.println("Has invertido " + precio3_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa3_1);
                                                                                                        cantidadFinanciada3 += precio3_1;
                                                                                                        saldoInversor2 -= precio3_1;
                                                                                                        inversion2Proyecto3 += precio3_1;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                            //Proyecto 3 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_2) {
                                                                                                        System.out.println("Has invertido " + precio3_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_2);
                                                                                                        cantidadFinanciada3 += precio3_2;
                                                                                                        saldoInversor1 -= precio3_2;
                                                                                                        inversion1Proyecto3 += precio3_2;
                                                                                                        participaInv1Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_2) {
                                                                                                        System.out.println("Has invertido " + precio3_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa3_2);
                                                                                                        cantidadFinanciada3 += precio3_2;
                                                                                                        saldoInversor2 -= precio3_2;
                                                                                                        inversion2Proyecto3 += precio3_2;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                            //Proyecto 3 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_3) {
                                                                                                        System.out.println("Has invertido " + precio3_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_3);
                                                                                                        cantidadFinanciada3 += precio3_3;
                                                                                                        saldoInversor1 -= precio3_3;
                                                                                                        inversion1Proyecto3 += precio3_3;
                                                                                                        participaInv1Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_3) {
                                                                                                        System.out.println("Has invertido " + precio3_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_3);
                                                                                                        cantidadFinanciada3 += precio3_3;
                                                                                                        saldoInversor2 -= precio3_3;
                                                                                                        inversion2Proyecto3 += precio3_3;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo al menú de gestión de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto3) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto3) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else System.out.println("Error. Este proyecto no existe.");
                                                                }
                                                                else {
                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                    salirVerProyectos = true;
                                                                }
                                                                break;
            //3.2.1.3. INVERSOR - VISTA DETALLADA 2
                                                            case 2:
                                                                if (proyectosCreados >= 2) {
                                                                    if (nombre2 != null) {
                                                                        System.out.println("\nProyecto 2:");
                                                                        System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                        System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        //INVERTIR - proyecto 2
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                            \nSeleccione una opción:
                                                                             1. Invertir en el proyecto
                                                                             2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa2_1 + " (" + precio2_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa2_2 + " (" + precio2_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa2_3 + " (" + precio2_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 2 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_1) {
                                                                                                        System.out.println("Has invertido " + precio2_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa2_1);
                                                                                                        cantidadFinanciada2 += precio2_1;
                                                                                                        saldoInversor1 -= precio2_1;
                                                                                                        inversion1Proyecto2 += precio2_1;
                                                                                                        participaInv1Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_1) {
                                                                                                        System.out.println("Has invertido " + precio2_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa2_1);
                                                                                                        cantidadFinanciada2 += precio2_1;
                                                                                                        saldoInversor2 -= precio2_1;
                                                                                                        inversion2Proyecto2 += precio2_1;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 2 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_2) {
                                                                                                        System.out.println("Has invertido " + precio2_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_2);
                                                                                                        cantidadFinanciada2 += precio2_2;
                                                                                                        saldoInversor1 -= precio2_2;
                                                                                                        inversion1Proyecto2 += precio2_2;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_2) {
                                                                                                        System.out.println("Has invertido " + precio2_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa2_2);
                                                                                                        cantidadFinanciada2 += precio2_2;
                                                                                                        saldoInversor2 -= precio2_2;
                                                                                                        inversion2Proyecto2 += precio2_2;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 2 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_3) {
                                                                                                        System.out.println("Has invertido " + precio2_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_3);
                                                                                                        cantidadFinanciada2 += precio2_3;
                                                                                                        saldoInversor1 -= precio2_3;
                                                                                                        inversion1Proyecto2 += precio2_3;
                                                                                                        participaInv1Proyecto2 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_3) {
                                                                                                        System.out.println("Has invertido " + precio2_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_3);
                                                                                                        cantidadFinanciada2 += precio2_3;
                                                                                                        saldoInversor2 -= precio2_3;
                                                                                                        inversion2Proyecto2 += precio2_3;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo al menú de gestión de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto2) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto2) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (nombre3 != null) {
                                                                        System.out.println("\nProyecto 3:");
                                                                        System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                        System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                            \nSeleccione una opción:
                                                                            1. Invertir en el proyecto
                                                                            2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa2_1 + " (" + precio2_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa2_2 + " (" + precio2_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa2_3 + " (" + precio2_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 3 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_1) {
                                                                                                        System.out.println("Has invertido " + precio3_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa3_1);
                                                                                                        cantidadFinanciada3 += precio3_1;
                                                                                                        saldoInversor1 -= precio3_1;
                                                                                                        inversion1Proyecto3 += precio3_1;
                                                                                                        participaInv1Proyecto3 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_1) {
                                                                                                        System.out.println("Has invertido " + precio3_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa3_1);
                                                                                                        cantidadFinanciada3 += precio3_1;
                                                                                                        saldoInversor2 -= precio3_1;
                                                                                                        inversion2Proyecto3 += precio3_1;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 3 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_2) {
                                                                                                        System.out.println("Has invertido " + precio3_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_2);
                                                                                                        cantidadFinanciada3 += precio3_2;
                                                                                                        saldoInversor1 -= precio3_2;
                                                                                                        inversion1Proyecto3 += precio3_2;
                                                                                                        participaInv1Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_2) {
                                                                                                        System.out.println("Has invertido " + precio3_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa3_2);
                                                                                                        cantidadFinanciada3 += precio3_2;
                                                                                                        saldoInversor2 -= precio3_2;
                                                                                                        inversion2Proyecto3 += precio3_2;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 3 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_3) {
                                                                                                        System.out.println("Has invertido " + precio3_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_3);
                                                                                                        cantidadFinanciada3 += precio3_3;
                                                                                                        saldoInversor1 -= precio3_3;
                                                                                                        inversion1Proyecto3 += precio3_3;
                                                                                                        participaInv1Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_3) {
                                                                                                        System.out.println("Has invertido " + precio3_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_3);
                                                                                                        cantidadFinanciada3 += precio3_3;
                                                                                                        saldoInversor2 -= precio3_3;
                                                                                                        inversion2Proyecto3 += precio3_3;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo al menú de gestión de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto3) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto3) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (nombre1 != null) {
                                                                        System.out.println("\nProyecto 1:");
                                                                        System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                        System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        //INVERTIR - proyecto 1
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                             \nSeleccione una opción:
                                                                             1. Invertir en el proyecto
                                                                             2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa1_1 + " (" + precio1_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa1_2 + " (" + precio1_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa1_3 + " (" + precio1_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 1 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_1) {
                                                                                                        System.out.println("Has invertido " + precio1_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa1_1);
                                                                                                        cantidadFinanciada1 += precio1_1;
                                                                                                        saldoInversor1 -= precio1_1;
                                                                                                        inversion1Proyecto1 += precio1_1;
                                                                                                        participaInv1Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_1) {
                                                                                                        System.out.println("Has invertido " + precio1_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa1_1);
                                                                                                        cantidadFinanciada1 += precio1_1;
                                                                                                        saldoInversor2 -= precio1_1;
                                                                                                        inversion2Proyecto1 += precio1_1;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 1 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_2) {
                                                                                                        System.out.println("Has invertido " + precio1_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa1_2);
                                                                                                        cantidadFinanciada1 += precio1_2;
                                                                                                        saldoInversor1 -= precio1_2;
                                                                                                        inversion1Proyecto1 += precio1_2;
                                                                                                        participaInv1Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_2) {
                                                                                                        System.out.println("Has invertido " + precio1_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa1_2);
                                                                                                        cantidadFinanciada1 += precio1_2;
                                                                                                        saldoInversor2 -= precio1_2;
                                                                                                        inversion2Proyecto1 += precio1_2;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 1 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_3) {
                                                                                                        System.out.println("Has invertido " + precio1_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa1_3);
                                                                                                        cantidadFinanciada1 += precio1_3;
                                                                                                        saldoInversor1 -= precio1_3;
                                                                                                        inversion1Proyecto1 += precio1_3;
                                                                                                        participaInv1Proyecto1 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_3) {
                                                                                                        System.out.println("Has invertido " + precio1_3 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa1_3);
                                                                                                        cantidadFinanciada1 += precio1_3;
                                                                                                        saldoInversor2 -= precio1_3;
                                                                                                        inversion2Proyecto1 += precio1_3;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo a gestiones de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto1) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto1) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else System.out.println("Error. Este proyecto no existe.");
                                                                }
                                                                else {
                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                    salirVerProyectos = true;
                                                                }
                                                                break;
            //3.2.1.4. INVERSOR - VISTA DETALLADA 3
                                                            case 3:
                                                                if (proyectosCreados == 3) {
                                                                    if (nombre3 != null) {
                                                                        System.out.println("\nProyecto 3:");
                                                                        System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                                                        System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada3 / cantidadNecesaria3) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                            \nSeleccione una opción:
                                                                            1. Invertir en el proyecto
                                                                            2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa2_1 + " (" + precio2_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa2_2 + " (" + precio2_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa2_3 + " (" + precio2_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 3 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_1) {
                                                                                                        System.out.println("Has invertido " + precio3_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa3_1);
                                                                                                        cantidadFinanciada3 += precio3_1;
                                                                                                        saldoInversor1 -= precio3_1;
                                                                                                        inversion1Proyecto3 += precio3_1;
                                                                                                        participaInv1Proyecto3 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_1) {
                                                                                                        System.out.println("Has invertido " + precio3_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa3_1);
                                                                                                        cantidadFinanciada3 += precio3_1;
                                                                                                        saldoInversor2 -= precio3_1;
                                                                                                        inversion2Proyecto3 += precio3_1;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 3 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_2) {
                                                                                                        System.out.println("Has invertido " + precio3_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_2);
                                                                                                        cantidadFinanciada3 += precio3_2;
                                                                                                        saldoInversor1 -= precio3_2;
                                                                                                        inversion1Proyecto3 += precio3_2;
                                                                                                        participaInv1Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_2) {
                                                                                                        System.out.println("Has invertido " + precio3_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa3_2);
                                                                                                        cantidadFinanciada3 += precio3_2;
                                                                                                        saldoInversor2 -= precio3_2;
                                                                                                        inversion2Proyecto3 += precio3_2;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 3 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio3_3) {
                                                                                                        System.out.println("Has invertido " + precio3_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_3);
                                                                                                        cantidadFinanciada3 += precio3_3;
                                                                                                        saldoInversor1 -= precio3_3;
                                                                                                        inversion1Proyecto3 += precio3_3;
                                                                                                        participaInv1Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio3_3) {
                                                                                                        System.out.println("Has invertido " + precio3_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa3_3);
                                                                                                        cantidadFinanciada3 += precio3_3;
                                                                                                        saldoInversor2 -= precio3_3;
                                                                                                        inversion2Proyecto3 += precio3_3;
                                                                                                        participaInv2Proyecto3 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo al menú de gestión de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto3) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto3) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (nombre1 != null) {
                                                                        System.out.println("\nProyecto 1:");
                                                                        System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                                                        System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada1 / cantidadNecesaria1) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        //INVERTIR - proyecto 1
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                             \nSeleccione una opción:
                                                                             1. Invertir en el proyecto
                                                                             2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa1_1 + " (" + precio1_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa1_2 + " (" + precio1_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa1_3 + " (" + precio1_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 1 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_1) {
                                                                                                        System.out.println("Has invertido " + precio1_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa1_1);
                                                                                                        cantidadFinanciada1 += precio1_1;
                                                                                                        saldoInversor1 -= precio1_1;
                                                                                                        inversion1Proyecto1 += precio1_1;
                                                                                                        participaInv1Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_1) {
                                                                                                        System.out.println("Has invertido " + precio1_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa1_1);
                                                                                                        cantidadFinanciada1 += precio1_1;
                                                                                                        saldoInversor2 -= precio1_1;
                                                                                                        inversion2Proyecto1 += precio1_1;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 1 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_2) {
                                                                                                        System.out.println("Has invertido " + precio1_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa1_2);
                                                                                                        cantidadFinanciada1 += precio1_2;
                                                                                                        saldoInversor1 -= precio1_2;
                                                                                                        inversion1Proyecto1 += precio1_2;
                                                                                                        participaInv1Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_2) {
                                                                                                        System.out.println("Has invertido " + precio1_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa1_2);
                                                                                                        cantidadFinanciada1 += precio1_2;
                                                                                                        saldoInversor2 -= precio1_2;
                                                                                                        inversion2Proyecto1 += precio1_2;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 1 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio1_3) {
                                                                                                        System.out.println("Has invertido " + precio1_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa1_3);
                                                                                                        cantidadFinanciada1 += precio1_3;
                                                                                                        saldoInversor1 -= precio1_3;
                                                                                                        inversion1Proyecto1 += precio1_3;
                                                                                                        participaInv1Proyecto1 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio1_3) {
                                                                                                        System.out.println("Has invertido " + precio1_3 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa1_3);
                                                                                                        cantidadFinanciada1 += precio1_3;
                                                                                                        saldoInversor2 -= precio1_3;
                                                                                                        inversion2Proyecto1 += precio1_3;
                                                                                                        participaInv2Proyecto1 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo a gestiones de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto1) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto1) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (nombre2 != null) {
                                                                        System.out.println("\nProyecto 2:");
                                                                        System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                                                                "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                                                                "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                                                        System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");

                                                                        // Calcular el porcentaje de progreso
                                                                        double porcentajeProgreso = (cantidadFinanciada2 / cantidadNecesaria2) * 100;

                                                                        // Pintar la barra de progreso
                                                                        System.out.println("\nBarra de Progreso:");
                                                                        System.out.print("[");

                                                                        int totalCaracteres = 50; // Longitud total de la barra
                                                                        int caracteresLlenos = (int) (porcentajeProgreso / (100.0 / totalCaracteres)); // Caracteres llenos, se hace una regla de 3
                                                                        for (int i = 0; i < totalCaracteres; i++) {
                                                                            if (i < caracteresLlenos) {
                                                                                System.out.print("#"); // Parte llena de la barra
                                                                            } else {
                                                                                System.out.print("-"); // Parte vacía de la barra
                                                                            }
                                                                        }
                                                                        System.out.printf("] %.2f %%\n", porcentajeProgreso);

                                                                        boolean salirGestionProyecto = false;
                                                                        //INVERTIR - proyecto 2
                                                                        while (!salirGestionProyecto) {
                                                                            System.out.println("""
                                                                            \nSeleccione una opción:
                                                                             1. Invertir en el proyecto
                                                                             2. Salir""");
                                                                            int gestionProyecto = lecturaDatos.nextInt();
                                                                            lecturaDatos.nextLine();

                                                                            switch (gestionProyecto) {
                                                                                case 1:
                                                                                    boolean salirSubMenuRecompensa = false;

                                                                                    while (!salirSubMenuRecompensa) {
                                                                                        System.out.println("\nSelecciona la inversión: ");
                                                                                        System.out.println("1. Recompensa 1: " + recompensa2_1 + " (" + precio2_1 + " €)");
                                                                                        System.out.println("2. Recompensa 2: " + recompensa2_2 + " (" + precio2_2 + " €)");
                                                                                        System.out.println("3. Recompensa 3: " + recompensa2_3 + " (" + precio2_3 + " €)");
                                                                                        System.out.println("4. Salir");
                                                                                        int seleccionInversion = lecturaDatos.nextInt();
                                                                                        lecturaDatos.nextLine();

                                                                                        switch  (seleccionInversion) {
                                                                                            //Proyecto 2 - Recompensa 1
                                                                                            case 1:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_1) {
                                                                                                        System.out.println("Has invertido " + precio2_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa2_1);
                                                                                                        cantidadFinanciada2 += precio2_1;
                                                                                                        saldoInversor1 -= precio2_1;
                                                                                                        inversion1Proyecto2 += precio2_1;
                                                                                                        participaInv1Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_1) {
                                                                                                        System.out.println("Has invertido " + precio2_1 + " € en el proyecto. Has obtenido la recompensa 1: " + recompensa2_1);
                                                                                                        cantidadFinanciada2 += precio2_1;
                                                                                                        saldoInversor2 -= precio2_1;
                                                                                                        inversion2Proyecto2 += precio2_1;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 2 - Recompensa 2
                                                                                            case 2:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_2) {
                                                                                                        System.out.println("Has invertido " + precio2_2 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_2);
                                                                                                        cantidadFinanciada2 += precio2_2;
                                                                                                        saldoInversor1 -= precio2_2;
                                                                                                        inversion1Proyecto2 += precio2_2;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_2) {
                                                                                                        System.out.println("Has invertido " + precio2_2 + " € en el proyecto.Has obtenido la recompensa 2: " + recompensa2_2);
                                                                                                        cantidadFinanciada2 += precio2_2;
                                                                                                        saldoInversor2 -= precio2_2;
                                                                                                        inversion2Proyecto2 += precio2_2;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //Proyecto 2 - Recompensa 3
                                                                                            case 3:
                                                                                                if (npc1) {
                                                                                                    if (saldoInversor1 > precio2_3) {
                                                                                                        System.out.println("Has invertido " + precio2_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_3);
                                                                                                        cantidadFinanciada2 += precio2_3;
                                                                                                        saldoInversor1 -= precio2_3;
                                                                                                        inversion1Proyecto2 += precio2_3;
                                                                                                        participaInv1Proyecto2 = true;

                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                if (npc2) {
                                                                                                    if (saldoInversor2 > precio2_3) {
                                                                                                        System.out.println("Has invertido " + precio2_3 + " € en el proyecto. Has obtenido la recompensa 2: " + recompensa2_3);
                                                                                                        cantidadFinanciada2 += precio2_3;
                                                                                                        saldoInversor2 -= precio2_3;
                                                                                                        inversion2Proyecto2 += precio2_3;
                                                                                                        participaInv2Proyecto2 = true;
                                                                                                    }
                                                                                                    else System.out.println("No tienes suficiente saldo. Añade más para invertir.");
                                                                                                }
                                                                                                break;
                                                                                            //SALIR
                                                                                            case 4:
                                                                                                System.out.println("Volviendo al menú de gestión de proyecto");
                                                                                                salirSubMenuRecompensa = true;
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                    if (participaInv1Proyecto2) proyectosFinanciaInv1++;
                                                                                    if (participaInv2Proyecto2) proyectosFinanciaInv2++;
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                                    salirGestionProyecto = true;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                    else System.out.println("Error. Este proyecto no existe.");
                                                                }
                                                                else {
                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                    salirVerProyectos = true;
                                                                }
                                                                break;
            //3.2.1.5. INVERSOR - SALIR (a proyectos)
                                                            case 4:
                                                                if (proyectosCreados == 3) {
                                                                    System.out.println("Volviendo a PROYECTOS");
                                                                    salirVerProyectos = true;
                                                                }
                                                                else System.out.println("Has introducido un valor incorrecto.");
                                                                break;
                                                            default:
                                                                System.out.println("Has introducido un valor incorrecto.");
                                                                break;
                                                        }
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
                                        System.out.println("""
                                            \n --- CARTERA DIGITAL ---
                                            Seleccione una opción:
                                            1. Ver saldo actual
                                            2. Añadir saldo
                                            3. Salir""");
                                        int seleccionCartera = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();

                                        switch (seleccionCartera) {
                                            case 1:
                                                System.out.print("Tu saldo actual es de: ");
                                                if (npc1) System.out.println(saldoInversor1 + " €");
                                                if (npc2) System.out.println(saldoInversor2 + " €");
                                                break;
                                            case 2:
                                                System.out.print("Introduce la cantidad que vas a añadir (en €): ");
                                                double sumaSaldo = lecturaDatos.nextDouble();
                                                lecturaDatos.nextLine();
                                                if (npc1) saldoInversor1 += sumaSaldo;
                                                if (npc2) saldoInversor2 += sumaSaldo;
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
                                        System.out.println("""
                                            \n--- INVITA A UN AMIGO ---
                                            Seleccione una opción:
                                            1. Lista de amigos
                                            2. Invitar amigo
                                            3. Salir""");
                                        int seleccionAmigos = lecturaDatos.nextInt();
                                        lecturaDatos.nextLine();

                                        switch (seleccionAmigos) {
                                            case 1:
                                                System.out.print("Tu lista de amigos es: ");
                                                if (npc1) {
                                                    if (amigosInversor1.isEmpty()) System.out.println("No tienes ningún amigo actualmente");
                                                    else System.out.println(amigosInversor1);
                                                }
                                                if (npc2) {
                                                    if (amigosInversor2.isEmpty()) System.out.println("No tienes ningún amigo actualmente");
                                                    else System.out.println(amigosInversor2);
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Introduce la cuenta de usuario de un amigo: ");
                                                String cuentaAmigo = lecturaDatos.nextLine();
                                                if (npc1) amigosInversor1 = amigosInversor1.concat("\n" + cuentaAmigo);
                                                if (npc2) amigosInversor2 = amigosInversor2.concat("\n" + cuentaAmigo);
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
                                        System.out.println("""
                                                Selecciona que quieres hacer:
                                                1.-Cambiar el usuario
                                                2.-Cambiar la contraseña
                                                3.-Salir""");
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
                                            } else {
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
                                            } else {
                                                System.out.println("Introduce tu nueva contraseña: ");
                                                contraseniaNPC2 = lecturaDatos.nextLine();
                                                System.out.println("Contraseña cambiada exitosamente.");
                                                break;
                                            }
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Has introducido un valor incorrecto.");
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
