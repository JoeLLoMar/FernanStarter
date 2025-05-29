package vista;

import modelo.Proyecto;
import utilidades.FuncionesFechas;

import java.util.ArrayList;

public class GestionProyectosVista {
    private String colorTexto;
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public void setColorTexto(String colorTexto) {
        this.colorTexto = colorTexto;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(colorTexto + mensaje + RESET);
    }

    public static void graficoProgreso(Proyecto proyecto) {
        // Calcular el porcentaje de progreso
        double porcentajeProgreso = (proyecto.getCantidadRecaudada() / proyecto.getCantidadObjetivo()) * 100;

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

    public void vistaDetalladaProyecto(Proyecto proyecto) {
        System.out.println(proyecto);
        System.out.println(
                "\nDescripcion: " + proyecto.getDescripcion() +
                "\nFecha de inicio: " + FuncionesFechas.formatearFecha(proyecto.getFechaInicio()) +
                "\nFecha de fin: " + FuncionesFechas.formatearFecha(proyecto.getFechaFin()) +
                "\nLista de recompensas: " + proyecto.getListaRecompensas() +
                "\nLista de inversiones: " + proyecto.getListaInversiones());
        graficoProgreso(proyecto);
    }

    public void mostrarProyectos(ArrayList<Proyecto> listaProyectos) {
        for (Proyecto proyecto : listaProyectos) {
            System.out.println(proyecto);
        }
    }
}
