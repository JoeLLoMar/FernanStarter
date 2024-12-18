package Utilidades;

import java.util.Scanner;

public class ProcesamientoDatos {
    public static void vistaProyecto(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadFinanciada) {
        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad financiada: " + cantidadFinanciada + " €");

    }
    public static void vistaProyectoInversor(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadInvertida) {
        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad que has aportado: " + cantidadInvertida + " €");
    }

    public static void vistaProyectoDetalle(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadFinanciada, String fechaInicio, String fechaFin, String recompensa1, double precio1, String recompensa2, double precio2, String recompensa3, double precio3) {
        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad financiada: " + cantidadFinanciada + " €" +
                "\nFecha inicio: " + fechaInicio + "\nFecha fin: " + fechaFin);
        System.out.println("Recompensas: 1) " + recompensa1 + " (" + precio1 + " €), 2) " + recompensa2 + " (" + precio2 + " €), 3) " + recompensa3 + " (" + precio3 + " €)");
    }

    public static void vistaProyectoInversorDetalle(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadInvertida, String fechaInicio, String fechaFin, String recompensa1, double precio1, String recompensa2, double precio2, String recompensa3, double precio3) {
        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad que has aportado: " + cantidadInvertida + " €" +
                "\nFecha inicio: " + fechaInicio + "\nFecha fin: " + fechaFin);
        System.out.println("Recompensas: 1) " + recompensa1 + " (" + precio1 + " €), 2) " + recompensa2 + " (" + precio2 + " €), 3) " + recompensa3 + " (" + precio3 + " €)");

    }

    public static void graficoProgreso(double cantidadFinanciada, double cantidadNecesaria) {
        // Calcular el porcentaje de progreso
        double porcentajeProgreso = (cantidadFinanciada / cantidadNecesaria) * 100;

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
    }

    public static String modificarApartado() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
//    public static void opcionesModificacion(int opcion, String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadFinanciada, String fechaInicio, String fechaFin, String recompensa1, double precio1, String recompensa2, double precio2, String recompensa3, double precio3, boolean salir) {
//        Scanner lecturaDatos = new Scanner(System.in);
//        switch (opcion) {
//            case 1:
//                System.out.print("Nombre del proyecto: ");
//                nombre = modificarApartado();
//                break;
//            case 2:
//                System.out.print("Descripción del proyecto: ");
//                descripcion = lecturaDatos.nextLine();
//                break;
//            case 3:
//                System.out.print("Categoría (arte, tecnología, cine, etc.): ");
//                categoria = lecturaDatos.nextLine();
//                break;
//            case 4:
//                System.out.print("Cantidad necesaria (€): ");
//                cantidadNecesaria = lecturaDatos.nextDouble();
//                break;
//            case 5:
//                System.out.print("Cantidad financiada hasta el momento (€): ");
//                cantidadFinanciada = lecturaDatos.nextDouble();
//                lecturaDatos.nextLine(); // Limpiar buffer
//                break;
//            case 6:
//                System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
//                fechaInicio = lecturaDatos.nextLine();
//                break;
//            case 7:
//                System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
//                fechaFin = lecturaDatos.nextLine();
//                break;
//            case 8:
//                System.out.print("Recompensa 1 - Descripción: ");
//                recompensa1 = lecturaDatos.nextLine();
//                System.out.print("Recompensa 1 -Precio (€): ");
//                precio1 = lecturaDatos.nextDouble();
//                lecturaDatos.nextLine();
//                break;
//            case 9:
//                System.out.print("Recompensa 2 - Descripción: ");
//                recompensa2 = lecturaDatos.nextLine();
//                System.out.print("Recompensa 2 - Precio (€): ");
//                precio2 = lecturaDatos.nextDouble();
//                lecturaDatos.nextLine();
//                break;
//            case 10:
//                System.out.print("Recompensa 3 - Descripción: ");
//                recompensa3 = lecturaDatos.nextLine();
//                System.out.print("Recompensa 3 - Precio (€): ");
//                precio3 = lecturaDatos.nextDouble();
//                lecturaDatos.nextLine();
//                break;
//            case 11:
//                System.out.println("Volviendo al menú de modificación.");
//                salir = true;
//                break;
//            default:
//                System.out.println("Opción inválida. Inténtelo de nuevo.");
//                break;
//        }
//    }

    public static void opcionesConfiguracion(int opcion, String usuario, String contrasenia) {
        Scanner lecturaDatos = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Introduce tu nuevo usuario: ");
                usuario = lecturaDatos.nextLine();
                System.out.println();
                System.out.println("Usuario cambiado exitosamente.");
                break;
            case 2:
                System.out.println("Introduce tu nueva contraseña: ");
                contrasenia = lecturaDatos.nextLine();
                System.out.println("Contraseña cambiada exitosamente.");
                break;
            case 3:
                break;
            default:
                System.out.println("Opción inválida. Inténtelo de nuevo.");
                break;
        }
    }

    public static void opcionesConfiguracionInversor(int opcion, boolean usuarioLogeado1, String usuario1, String usuario2, String contrasenia1, String contrasenia2) {
        Scanner lecturaDatos = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Introduce tu nuevo usuario: ");
                if (usuarioLogeado1) {
                    usuario1 = lecturaDatos.nextLine();
                    System.out.println();
                    System.out.println("Usuario cambiado exitosamente.");
                    break;
                }
                else {
                    usuario2 = lecturaDatos.nextLine();
                    System.out.println();
                    System.out.println("Usuario cambiado exitosamente.");
                    break;
                }

            case 2:
                if (usuarioLogeado1) {
                    System.out.println("Introduce tu nueva contraseña: ");
                    contrasenia1 = lecturaDatos.nextLine();
                    System.out.println("Contraseña cambiada exitosamente.");
                    break;
                }
                else {
                    System.out.println("Introduce tu nueva contraseña: ");
                    contrasenia2 = lecturaDatos.nextLine();
                    System.out.println("Contraseña cambiada exitosamente.");
                    break;
                }
            case 3:
                break;
            default:
                System.out.println("Has introducido un valor incorrecto.");
                break;
        }
    }
}
