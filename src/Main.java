import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables de usuarios
        String usuarioLogin,contraseniaLogin;
        int contadorIntentos=0, intentos=2;
        String usuarioAdmin = "pepito123", contraseniaAdmin = "12345";
        String usuarioGestor = "tornaceitor", contraseniaGestor = "54321";
        String usuarioNPC1 = "soyunnpc1", contraseniaNPC1 = "6969";
        String usuarioNPC2 = "npcsisoy", contraseniaNPC2 = "9696";
        boolean admin=false, gestor=false, inversor=false, npc1=false, npc2=false;
        boolean registroAdmin=false, registroGestor=false, registroInversor=false;
        int opcionConfig=0;

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
                3. Como inversor""");

        int tipoUsuario = Integer.parseInt(lecturaDatos.nextLine());

        switch (tipoUsuario) {
            case 1:
                admin = true;
                System.out.println();
                System.out.println("Usted ha elegido ingresar como administrador.");
                System.out.println();
                do{
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
               }while(!registroAdmin);
                break;

            case 2: //Accedes al login como gestor
                gestor = true;
                System.out.println();
                System.out.println("Usted ha elegido ingresar como gestor.");
                do{
                    if (contadorIntentos<3){
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
                        }else if(contadorIntentos<3) {
                            System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo, le quedan " + intentos-- + " intentos.");
                            contadorIntentos++;
                        }
                    }else{
                        break; //Agotas intentos y te manda al inicio del login gestor
                    }
                }while(!registroGestor);
                break; // Te lleva a la creación de Proyectos

            case 3: //igual que el case 2 de gestor
                inversor = true;
                System.out.println();
                System.out.println("Usted ha elegido ingresar como inversor.");
                do{
                    if (contadorIntentos<3){
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
                            npc1=true;
                            System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                        } else if(usuarioLogin.equalsIgnoreCase(usuarioNPC2) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC2)){
                            registroInversor = true;
                            npc2=true;
                            System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                        }else if(contadorIntentos<3) {
                            System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo, le quedan " + intentos-- + " intentos.");
                            contadorIntentos++;
                        }
                    }else{
                        break;
                    }
                }while(!registroInversor);
                break;

            default:
                System.out.println("Error");
                break;
        }



        // Creación de proyecto - Gestor

        if (registroGestor) {

            // Variables para almacenar información de hasta 3 proyectos
            String nombre1 = "", descripcion1 = "", categoria1 = "", fechaInicio1 = "", fechaFin1 = "";
            double cantidadNecesaria1 = 0, cantidadFinanciada1 = 0;
            String recompensa1_1 = "", recompensa1_2 = "", recompensa1_3 = "";
            double precio1_1 = 0, precio1_2 = 0, precio1_3 = 0;

            String nombre2 = "", descripcion2 = "", categoria2 = "", fechaInicio2 = "", fechaFin2 = "";
            double cantidadNecesaria2 = 0, cantidadFinanciada2 = 0;
            String recompensa2_1 = "", recompensa2_2 = "", recompensa2_3 = "";
            double precio2_1 = 0, precio2_2 = 0, precio2_3 = 0;

            String nombre3 = "", descripcion3 = "", categoria3 = "", fechaInicio3 = "", fechaFin3 = "";
            double cantidadNecesaria3 = 0, cantidadFinanciada3 = 0;
            String recompensa3_1 = "", recompensa3_2 = "", recompensa3_3 = "";
            double precio3_1 = 0, precio3_2 = 0, precio3_3 = 0;

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
                            case 1:
                                if (proyectosCreados >= 3) {
                                    System.out.println("Ya no se pueden crear más proyectos (máximo 3).");
                                }
                                else {
                                    proyectosCreados++;

                                    System.out.println("\n--- Crear Proyecto " + proyectosCreados + " ---");
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
                                    System.out.print("Recompensa 1 descripción: ");
                                    String recompensa1 = lecturaDatos.nextLine();
                                    System.out.print("Recompensa 1 precio (€): ");
                                    double precio1 = lecturaDatos.nextDouble();
                                    lecturaDatos.nextLine();
                                    System.out.print("Recompensa 2 descripción: ");
                                    String recompensa2 = lecturaDatos.nextLine();
                                    System.out.print("Recompensa 2 precio (€): ");
                                    double precio2 = lecturaDatos.nextDouble();
                                    lecturaDatos.nextLine();
                                    System.out.print("Recompensa 3 descripción: ");
                                    String recompensa3 = lecturaDatos.nextLine();
                                    System.out.print("Recompensa 3 precio (€): ");
                                    double precio3 = lecturaDatos.nextDouble();
                                    lecturaDatos.nextLine();

                                    if (proyectosCreados == 1) {
                                        nombre1 = nombre; descripcion1 = descripcion; categoria1 = categoria;
                                        cantidadNecesaria1 = cantidadNecesaria; cantidadFinanciada1 = cantidadFinanciada;
                                        fechaInicio1 = fechaInicio; fechaFin1 = fechaFin;
                                        recompensa1_1 = recompensa1; recompensa1_2 = recompensa2; recompensa1_3 = recompensa3;
                                        precio1_1 = precio1; precio1_2 = precio2; precio1_3 = precio3;
                                    } else if (proyectosCreados == 2) {
                                        nombre2 = nombre; descripcion2 = descripcion; categoria2 = categoria;
                                        cantidadNecesaria2 = cantidadNecesaria; cantidadFinanciada2 = cantidadFinanciada;
                                        fechaInicio2 = fechaInicio; fechaFin2 = fechaFin;
                                        recompensa2_1 = recompensa1; recompensa2_2 = recompensa2; recompensa2_3 = recompensa3;
                                        precio2_1 = precio1; precio2_2 = precio2; precio2_3 = precio3;
                                    } else if (proyectosCreados == 3) {
                                        nombre3 = nombre; descripcion3 = descripcion; categoria3 = categoria;
                                        cantidadNecesaria3 = cantidadNecesaria; cantidadFinanciada3 = cantidadFinanciada;
                                        fechaInicio3 = fechaInicio; fechaFin3 = fechaFin;
                                        recompensa3_1 = recompensa1; recompensa3_2 = recompensa2; recompensa3_3 = recompensa3;
                                        precio3_1 = precio1; precio3_2 = precio2; precio3_3 = precio3;
                                    }

                                    System.out.println("Proyecto creado con éxito.");
                                }
                            case 2:
                                System.out.println("\n--- Proyectos Existentes ---");
                                // Si proyectosCreados tiene un valor determinado, se muestran todos los proyectos con valor inferior al actual (todos los creados previamente)
                                if (proyectosCreados >= 1) {
                                    System.out.println("\nProyecto 1:");
                                    System.out.println("Nombre: " + nombre1 + "\nDescripción: " + descripcion1 + "\nCategoría: " + categoria1 +
                                            "\nCantidad necesaria: " + cantidadNecesaria1 + " €\nCantidad financiada: " + cantidadFinanciada1 + " €" +
                                            "\nFecha inicio: " + fechaInicio1 + "\nFecha fin: " + fechaFin1);
                                    System.out.println("Recompensas: 1) " + recompensa1_1 + " (" + precio1_1 + " €), 2) " + recompensa1_2 + " (" + precio1_2 + " €), 3) " + recompensa1_3 + " (" + precio1_3 + " €)");
                                }

                                if (proyectosCreados >= 2) {
                                    System.out.println("\nProyecto 2:");
                                    System.out.println("Nombre: " + nombre2 + "\nDescripción: " + descripcion2 + "\nCategoría: " + categoria2 +
                                            "\nCantidad necesaria: " + cantidadNecesaria2 + " €\nCantidad financiada: " + cantidadFinanciada2 + " €" +
                                            "\nFecha inicio: " + fechaInicio2 + "\nFecha fin: " + fechaFin2);
                                    System.out.println("Recompensas: 1) " + recompensa2_1 + " (" + precio2_1 + " €), 2) " + recompensa2_2 + " (" + precio2_2 + " €), 3) " + recompensa2_3 + " (" + precio2_3 + " €)");
                                }

                                if (proyectosCreados == 3) {
                                    System.out.println("\nProyecto 3:");
                                    System.out.println("Nombre: " + nombre3 + "\nDescripción: " + descripcion3 + "\nCategoría: " + categoria3 +
                                            "\nCantidad necesaria: " + cantidadNecesaria3 + " €\nCantidad financiada: " + cantidadFinanciada3 + " €" +
                                            "\nFecha inicio: " + fechaInicio3 + "\nFecha fin: " + fechaFin3);
                                    System.out.println("Recompensas: 1) " + recompensa3_1 + " (" + precio3_1 + " €), 2) " + recompensa3_2 + " (" + precio3_2 + " €), 3) " + recompensa3_3 + " (" + precio3_3 + " €)");
                                }

                                if (proyectosCreados == 0) {
                                    System.out.println("No hay proyectos registrados.");
                                }
                            case 3:
                                System.out.println("Volviendo al Menú Principal...");
                                salirSubMenu = true; // Salir del submenú
                                break;
                            default:
                                System.out.println("Has introducido un valor incorrecto.");
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
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                }
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
                    default:
                        System.out.println("Has introducido un valor incorrecto.");
                }
            }
        // Meterlo en apartados de proyectos detallados
            /*System.out.println("Fecha de apertura para recibir inversiones: " + fechaInicio);
            System.out.println("Fecha de apertura para recibir inversiones: " + fechaInicio);
            System.out.println("Fecha de cierre de inversiones: " + fechaFin);
            System.out.println(": " + fechaInicio);*/



    }
}
