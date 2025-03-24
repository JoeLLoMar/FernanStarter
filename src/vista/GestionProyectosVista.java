package vista;

public class GestionProyectosVista {


    public static void graficoProgreso(float cantidadActual, float cantidadTotal) {
        // Calcular el porcentaje de progreso
        double porcentajeProgreso = (cantidadActual / cantidadTotal) * 100;

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
}
