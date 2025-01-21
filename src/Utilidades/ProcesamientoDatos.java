package Utilidades;

import java.util.Scanner;
import static Utilidades.Menus.*;

/**
 * La clase ProcesamientoDatos contiene métodos para mostrar información
 * sobre proyectos e inversores, incluyendo vistas detalladas y gráficos de progreso.
 *
 * @author José Luis López Martos, Alejandro Vergara Pozo
 * @version 1.0
 * @since 3.0
 */
public class ProcesamientoDatos {
//    /**
//     * Muestra una vista básica del proyecto.
//     *
//     * @param nombre           Nombre del proyecto.
//     * @param descripcion      Breve descripción del proyecto.
//     * @param categoria        Categoría del proyecto.
//     * @param cantidadNecesaria Cantidad necesaria para completar el proyecto.
//     * @param cantidadFinanciada Cantidad que ya ha sido financiada.
//     */
//    public static void vistaProyecto(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadFinanciada) {
//        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
//                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad financiada: " + cantidadFinanciada + " €");
//
//    }

    public static void verProyectos(int proyectosCreados, String[][] proyectos, double[][] cantidadesProyectos) {
        if (proyectosCreados == 0) {
            System.out.println("No hay proyectos creados.");
            return;
        }

        System.out.println("\n--- Lista de Proyectos ---");
        for (int i = 0; i < proyectosCreados; i++) {
            System.out.println("Proyecto " + (i + 1) + ":");
            System.out.println("Nombre: " + proyectos[i][0]);
            System.out.println("Descripción: " + proyectos[i][1]);
            System.out.println("Categoría: " + proyectos[i][2]);
            System.out.println("Fecha de inicio: " + proyectos[i][3]);
            System.out.println("Fecha de fin: " + proyectos[i][4]);
            System.out.println("Cantidad necesaria: " + cantidadesProyectos[i][0] + " €");
            System.out.println("Cantidad financiada: " + cantidadesProyectos[i][1] + " €");
            System.out.println("--------------------------");
        }
    }


    /**
     * Muestra una vista básica del proyecto desde la perspectiva de un inversor.
     *
     * @param nombre           Nombre del proyecto.
     * @param descripcion      Breve descripción del proyecto.
     * @param categoria        Categoría del proyecto.
     * @param cantidadNecesaria Cantidad necesaria para completar el proyecto.
     * @param cantidadInvertida Cantidad invertida por el usuario en el proyecto.
     */
    public static void vistaProyectoInversor(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadInvertida) {
        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad que has aportado: " + cantidadInvertida + " €");
    }

//    /**
//     * Muestra una vista detallada del proyecto, incluyendo recompensas y fechas clave.
//     *
//     * @param nombre           Nombre del proyecto.
//     * @param descripcion      Breve descripción del proyecto.
//     * @param categoria        Categoría del proyecto.
//     * @param cantidadNecesaria Cantidad necesaria para completar el proyecto.
//     * @param cantidadFinanciada Cantidad que ya ha sido financiada.
//     * @param fechaInicio      Fecha de inicio del proyecto.
//     * @param fechaFin         Fecha de finalización del proyecto.
//     * @param recompensa1      Descripción de la primera recompensa.
//     * @param precio1          Precio asociado a la primera recompensa.
//     * @param recompensa2      Descripción de la segunda recompensa.
//     * @param precio2          Precio asociado a la segunda recompensa.
//     * @param recompensa3      Descripción de la tercera recompensa.
//     * @param precio3          Precio asociado a la tercera recompensa.
//     */
//    public static void vistaProyectoDetalle(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadFinanciada, String fechaInicio, String fechaFin, String recompensa1, double precio1, String recompensa2, double precio2, String recompensa3, double precio3) {
//        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
//                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad financiada: " + cantidadFinanciada + " €" +
//                "\nFecha inicio: " + fechaInicio + "\nFecha fin: " + fechaFin);
//        System.out.println("Recompensas: 1) " + recompensa1 + " (" + precio1 + " €), 2) " + recompensa2 + " (" + precio2 + " €), 3) " + recompensa3 + " (" + precio3 + " €)");
//    }

    //Nueva función de vista detallada de proyecto
    public static int mostrarDetallesProyecto(
            int seleccion,
            int proyectosCreados,
            String[][] proyectos,
            double[][] proyectosCantidades,
            final int MAX_RECOMPENSAS,
            String[][] recompensasDescripcion,
            double[][] recompensasPrecios) {

        // Validar la selección
        if (seleccion > 0 && seleccion <= proyectosCreados) {
            int indice = seleccion - 1; // Ajustar índice para el array

            // Mostrar detalles del proyecto seleccionado
            System.out.println("\n--- DETALLES DEL PROYECTO ---");
            System.out.println("Nombre: " + proyectos[indice][0]);
            System.out.println("Descripción: " + proyectos[indice][1]);
            System.out.println("Categoría: " + proyectos[indice][2]);
            System.out.println("Fecha de inicio: " + proyectos[indice][3]);
            System.out.println("Fecha de fin: " + proyectos[indice][4]);
            System.out.println("Cantidad necesaria: " + proyectosCantidades[indice][0] + " €");
            System.out.println("Cantidad financiada: " + proyectosCantidades[indice][1] + " €");

            // Mostrar recompensas
            for (int i = 0; i < MAX_RECOMPENSAS; i++) {
                System.out.println("Recompensa " + (i + 1) + ": " + recompensasDescripcion[indice][i] + " (" + recompensasPrecios[indice][i] + " €)");
            }
            graficoProgreso(indice, proyectosCantidades);
            System.out.println("-----------------------------------");

            // Mostrar opciones adicionales
            Scanner sc = new Scanner(System.in);
            while(true) {
                menuGestionProyecto();

                int opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        modificarProyecto(indice, proyectosCreados, proyectos, proyectosCantidades, recompensasDescripcion, recompensasPrecios, MAX_RECOMPENSAS);
                        break;

                    case 2:
                        proyectosCreados = eliminarProyecto(indice, proyectosCreados, proyectos, proyectosCantidades, recompensasDescripcion, recompensasPrecios, MAX_RECOMPENSAS);
                        return proyectosCreados; // Sale directamente después de eliminar y devuelve el número actualizado de proyectos

                    case 3:
                        System.out.println("Volviendo al menú anterior...");
                        return proyectosCreados;

                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            }
        }
        else System.out.println("Selección no válida. Inténtalo de nuevo.");
        return proyectosCreados;
    }

    //Función de vista detallada de proyecto, sin opción de modificar o eliminar proyectos.
    public static void mostrarDetallesProyectoInversor(
            int seleccion,
            int proyectosCreados,
            String[][] proyectos,
            double[][] proyectosCantidades,
            final int MAX_RECOMPENSAS,
            String[][] recompensasDescripcion,
            double[][] recompensasPrecios) {

        // Validar la selección
        if (seleccion > 0 && seleccion <= proyectosCreados) {
            int indice = seleccion - 1; // Ajustar índice para el array

            while (true) {
                // Mostrar detalles del proyecto seleccionado
                System.out.println("\n--- DETALLES DEL PROYECTO ---");
                System.out.println("Nombre: " + proyectos[indice][0]);
                System.out.println("Descripción: " + proyectos[indice][1]);
                System.out.println("Categoría: " + proyectos[indice][2]);
                System.out.println("Fecha de inicio: " + proyectos[indice][3]);
                System.out.println("Fecha de fin: " + proyectos[indice][4]);
                System.out.println("Cantidad necesaria: " + proyectosCantidades[indice][0] + " €");
                System.out.println("Cantidad financiada: " + proyectosCantidades[indice][1] + " €");

                // Mostrar recompensas
                for (int i = 0; i < MAX_RECOMPENSAS; i++) {
                    System.out.println("Recompensa " + (i + 1) + ": " + recompensasDescripcion[indice][i] + " (" + recompensasPrecios[indice][i] + " €)");
                }
                graficoProgreso(indice, proyectosCantidades);
                System.out.println("-----------------------------------");

                // Opción para salir de la vista detallada
                Scanner sc = new Scanner(System.in);
                System.out.println("Presiona 1 para volver al menú anterior.");
                int opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 1) {
                    System.out.println("Volviendo al menú anterior...");
                    break;
                } else {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            }
        } else {
            System.out.println("Selección no válida. Inténtalo de nuevo.");
        }
    }


    public static void modificarProyecto(
            int indice,
            int proyectosCreados,
            String[][] proyectos,
            double[][] proyectosCantidades,
            String[][] recompensasDescripcion,
            double[][] recompensasPrecios,
            final int MAX_RECOMPENSAS) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            menuModificarProyecto();
            int seleccion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (seleccion) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    proyectos[indice][0] = sc.nextLine();
                    break;

                case 2:
                    System.out.print("Nueva descripción: ");
                    proyectos[indice][1] = sc.nextLine();
                    break;

                case 3:
                    System.out.print("Nueva categoría: ");
                    proyectos[indice][2] = sc.nextLine();
                    break;

                case 4:
                    System.out.print("Nueva fecha de inicio: ");
                    proyectos[indice][3] = sc.nextLine();
                    break;

                case 5:
                    System.out.print("Nueva fecha de fin: ");
                    proyectos[indice][4] = sc.nextLine();
                    break;

                case 6:
                    System.out.print("Nueva cantidad necesaria: ");
                    proyectosCantidades[indice][0] = sc.nextDouble();
                    sc.nextLine();
                    break;

                case 7:
                    System.out.print("Nueva cantidad financiada: ");
                    proyectosCantidades[indice][1] = sc.nextDouble();
                    sc.nextLine();
                    break;

                case 8:
                    for (int i = 0; i < MAX_RECOMPENSAS; i++) {
                        System.out.print("Nueva descripción para la recompensa " + (i + 1) + ": ");
                        recompensasDescripcion[indice][i] = sc.nextLine();
                        System.out.print("Nuevo precio para la recompensa " + (i + 1) + ": ");
                        recompensasPrecios[indice][i] = sc.nextDouble();
                        sc.nextLine(); // Limpiar buffer
                    }
                    break;

                case 9:
                    System.out.println("Volviendo al menú...");
                    return;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    public static int eliminarProyecto(
            int indice,
            int proyectosCreados,
            String[][] proyectos,
            double[][] proyectosCantidades,
            String[][] recompensasDescripcion,
            double[][] recompensasPrecios,
            final int MAX_RECOMPENSAS) {

        // Desplazar todos los proyectos hacia arriba
        for (int i = indice; i < proyectosCreados - 1; i++) {
            proyectos[i] = proyectos[i + 1];
            proyectosCantidades[i] = proyectosCantidades[i + 1];
            recompensasDescripcion[i] = recompensasDescripcion[i + 1];
            recompensasPrecios[i] = recompensasPrecios[i + 1];
        }

        // Limpiar la última posición
        proyectos[proyectosCreados - 1] = new String[proyectos[0].length];
        proyectosCantidades[proyectosCreados - 1] = new double[proyectosCantidades[0].length];
        recompensasDescripcion[proyectosCreados - 1] = new String[MAX_RECOMPENSAS];
        recompensasPrecios[proyectosCreados - 1] = new double[MAX_RECOMPENSAS];

        System.out.println("Proyecto eliminado con éxito.");

        // Decrementar el número de proyectos creados
        return proyectosCreados - 1;
    }

    /**
     * Muestra una vista detallada del proyecto desde la perspectiva de un inversor, incluyendo recompensas y fechas clave.
     *
     * @param nombre           Nombre del proyecto.
     * @param descripcion      Breve descripción del proyecto.
     * @param categoria        Categoría del proyecto.
     * @param cantidadNecesaria Cantidad necesaria para completar el proyecto.
     * @param cantidadInvertida Cantidad invertida por el usuario en el proyecto.
     * @param fechaInicio      Fecha de inicio del proyecto.
     * @param fechaFin         Fecha de finalización del proyecto.
     * @param recompensa1      Descripción de la primera recompensa.
     * @param precio1          Precio asociado a la primera recompensa.
     * @param recompensa2      Descripción de la segunda recompensa.
     * @param precio2          Precio asociado a la segunda recompensa.
     * @param recompensa3      Descripción de la tercera recompensa.
     * @param precio3          Precio asociado a la tercera recompensa.
     */
    public static void vistaProyectoInversorDetalle(String nombre, String descripcion, String categoria, double cantidadNecesaria, double cantidadInvertida, String fechaInicio, String fechaFin, String recompensa1, double precio1, String recompensa2, double precio2, String recompensa3, double precio3) {
        System.out.println("Nombre: " + nombre + "\nDescripción: " + descripcion + "\nCategoría: " + categoria +
                "\nCantidad necesaria: " + cantidadNecesaria + " €\nCantidad que has aportado: " + cantidadInvertida + " €" +
                "\nFecha inicio: " + fechaInicio + "\nFecha fin: " + fechaFin);
        System.out.println("Recompensas: 1) " + recompensa1 + " (" + precio1 + " €), 2) " + recompensa2 + " (" + precio2 + " €), 3) " + recompensa3 + " (" + precio3 + " €)");

    }

    /**
     * Genera y muestra un gráfico de progreso basado en la cantidad financiada y necesaria.
     *
     * @param cantidadFinanciada Cantidad que ya ha sido financiada.
     * @param cantidadNecesaria  Cantidad necesaria para completar el proyecto.
     */
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

    public static void graficoProgreso(int indice, double[][] proyectosCantidades) {
        // Calcular el porcentaje de progreso
        double porcentajeProgreso = (proyectosCantidades[indice][1] / proyectosCantidades[indice][0]) * 100;

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

    // Función para crear un proyecto
    public static void crearProyecto(int proyectosCreados, String[][] proyectos, double[][] proyectosCantidades, final int MAX_RECOMPENSAS, String[][] recompensasDescripcion, double[][] recompensasPrecios) {
        if (proyectosCreados >= proyectos.length) {
            System.out.println("No se pueden crear más proyectos. Capacidad máxima alcanzada.");
            return;
        }

        System.out.println("\n--- Crear Proyecto " + (proyectosCreados + 1) + " ---");
        // Leer datos del proyecto
        leerDatosProyecto(proyectosCreados, proyectos, proyectosCantidades);
        // Leer recompensas
        leerRecompensas(proyectosCreados, MAX_RECOMPENSAS, recompensasDescripcion, recompensasPrecios);

        System.out.println("Proyecto creado con éxito.");
    }

    // Función para leer datos básicos del proyecto
    public static void leerDatosProyecto(int proyectosCreados, String[][] proyectos, double[][] proyectosCantidades) {
        Scanner lecturaDatos = new Scanner(System.in);
        System.out.print("Nombre del proyecto: ");
        proyectos[proyectosCreados][0] = lecturaDatos.nextLine();
        System.out.print("Descripción del proyecto: ");
        proyectos[proyectosCreados][1] = lecturaDatos.nextLine();
        System.out.print("Categoría (arte, tecnología, cine, etc.): ");
        proyectos[proyectosCreados][2] = lecturaDatos.nextLine();
        System.out.print("Fecha inicio de apertura (dd/mm/yyyy): ");
        proyectos[proyectosCreados][3] = lecturaDatos.nextLine();
        System.out.print("Fecha fin de cierre (dd/mm/yyyy): ");
        proyectos[proyectosCreados][4] = lecturaDatos.nextLine();

        System.out.print("Cantidad necesaria (€): ");
        proyectosCantidades[proyectosCreados][0] = lecturaDatos.nextDouble();
        System.out.print("Cantidad financiada hasta el momento (€): ");
        proyectosCantidades[proyectosCreados][1] = lecturaDatos.nextDouble();
        lecturaDatos.nextLine(); // Limpiar buffer
    }

    // Función para leer recompensas de un proyecto
    public static void leerRecompensas(int proyectosCreados, final int MAX_RECOMPENSAS, String[][] recompensasDescripcion, double[][] recompensasPrecios) {
        Scanner lecturaDatos = new Scanner(System.in);
        System.out.println("\nAñadiendo recompensas (máximo " + MAX_RECOMPENSAS + "):");
        for (int i = 0; i < MAX_RECOMPENSAS; i++) {
            System.out.print("Recompensa " + (i + 1) + " - Descripción: ");
            recompensasDescripcion[proyectosCreados][i] = lecturaDatos.nextLine();
            System.out.print("Recompensa " + (i + 1) + " - Precio (€): ");
            recompensasPrecios[proyectosCreados][i] = lecturaDatos.nextDouble();
            lecturaDatos.nextLine(); // Limpiar buffer
        }
    }
}
