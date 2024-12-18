import java.util.Scanner;

public class Backup {
    public static void main(String[] args) {
        //Variables de usuarios
        int tipoUsuario;
        boolean cerrarPrograma=false;
        String usuarioLogin, contraseniaLogin;
        int contadorIntentos = 0, intentos = 2;
        String usuarioAdmin = "pepito123", contraseniaAdmin = "12345";
        String usuarioGestor = "tornaceitor", contraseniaGestor = "54321";
        String usuarioNPC1 = "soyunnpc1", contraseniaNPC1 = "6969";
        String usuarioNPC2 = "npcsisoy", contraseniaNPC2 = "9696";
        boolean admin = false, gestor = false, inversor = false, npc1 = false, npc2 = false;
        boolean registroAdmin = false, registroGestor = false, registroInversor = false, cerrarSesion=false;
        int opcionConfig = 0;
        do {
            Scanner lecturaDatos = new Scanner(System.in);

            System.out.println("----------------------------");
            System.out.println("¡Bienvenido a FernanStarter!");
            System.out.println("----------------------------");
            System.out.println();

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
                        break;
                    } while (!registroAdmin);
                    break;

                case 2: //Accedes al login como gestor
                    gestor = true;
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
                            break; //Agotas intentos y te manda al inicio del login gestor
                        }
                    } while (!registroGestor);
                    break; // Te lleva a la creación de Proyectos

                case 3: //igual que el case 2 de gestor
                    inversor = true;
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
                            break;
                        }
                    } while (!registroInversor);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    cerrarPrograma=true;
                    break;

                default:
                    System.out.println("Error");
                    break;
            }
            if(cerrarPrograma){
                break;
            }
            //Bucle que ejecuta el programa hasta que se cierre sesión
            do{
                if (registroGestor) {

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

                    // Menú gestor

                    boolean salirMenu = false;

                    while (!salirMenu) { //El bucle finaliza cuando se le da 3. Cerrar sesión, salirMenu = true y te sales del menú de gestor.
                        System.out.println("""
                            \n--- MENÚ PRINCIPAL ---
                            Seleccione una opción:
                            1. Mis proyectos
                            2. Configuración
                            3. Cerrar sesión""");
                        int seleccionGestor = lecturaDatos.nextInt();

                        switch (seleccionGestor) {
                            case 1: // Menú - Mis proyectos
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
                                        // CREAR PROYECTO
                                        case 1:
                                            if (proyectosCreados >= 3) {
                                                System.out.println("Ya no se pueden crear más proyectos (máximo 3).");
                                            } else {
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
                                        //VER PROYECTOS
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
                                                //VISTA DETALLADA - Menú
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
                                                        //VISTA DETALLADA - Proyecto 1
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
                                                        //VISTA DETALLADA - Proyecto 2
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
                                                        //VISTA DETALLADA - Proyecto 3
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
                                                        //VISTA DETALLADA - Salir
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
                                        //SALIR
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
                            case 2: // Menú - Configuración
                                do {
                                    System.out.println("Selecciona que quieres hacer: " +
                                            "1.- Cambiar mi usuario" +
                                            "2.- Cambiar mi contraseña" +
                                            "3.- Salir");
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
                            case 3:
                                System.out.println("Saliendo del programa...");
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

                if (registroInversor) {
                    int seleccionInversor = 0;
                    do {
                        System.out.println();
                        System.out.println("""
                            1. Mis inversiones
                            2. Proyectos
                            3. Cartera digital
                            4. Invita a un amigo
                            5. Configuración
                            6. Cerrar sesión""");

                        seleccionInversor = lecturaDatos.nextInt();
                    }
                    while (seleccionInversor < 1 || seleccionInversor > 6);

                    switch (seleccionInversor) {
                        case 1:
                        case 2:
                            System.out.println("Nombre: ");
                            System.out.println("Descripción: ");
                            System.out.println("Categoría: ");
                            System.out.println("Cantidad necesaria: ");
                            System.out.println("Cantidad aportada: ");
                        case 3:
                        case 4:
                        case 5:
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
                            System.out.println("Saliendo del programa...");
                            //salirMenu = true; // Salir del menú
                            cerrarSesion=true;
                            break;
                        default:
                            System.out.println("Has introducido un valor incorrecto.");
                    }
                    if (cerrarSesion){
                        break;
                    }
                }

            }while(!cerrarSesion);

        } while (!cerrarPrograma);
    }
}
