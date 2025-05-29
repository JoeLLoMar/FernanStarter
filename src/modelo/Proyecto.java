package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa un proyecto con toda la información necesaria para su gestión.
 * Contiene atributos como identificador, nombre, descripción, categoría, fechas,
 * datos financieros y las listas de recompensas e inversiones asociadas.
 *
 * <p>Esta clase forma parte del modelo en la arquitectura MVC.</p>
 *
 * @author
 * @version 1.0
 */
public class Proyecto {
    private int idProyecto;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float cantidadObjetivo;
    private float cantidadRecaudada;
    private Gestor creador;
    private ArrayList<Recompensa> listaRecompensas;
    private ArrayList<Inversion> listaInversiones;

    /**
     * Constructor con parámetros para inicializar un proyecto.
     *
     * @param nombre Nombre del proyecto.
     * @param descripcion Descripción del proyecto.
     * @param categoria Categoría del proyecto.
     * @param fechaInicio Fecha de inicio.
     * @param fechaFin Fecha de finalización.
     * @param cantidadObjetivo Monto necesario para financiar el proyecto.
     */
    public Proyecto(
            int idProyecto,
            String nombre,
            String descripcion,
            Categoria categoria,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            float cantidadObjetivo,
            float cantidadRecaudada) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadObjetivo = cantidadObjetivo;
        this.cantidadRecaudada = cantidadRecaudada;
        this.creador = null;
        this.listaRecompensas = new ArrayList<>();
        this.listaInversiones = new ArrayList<>();

    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getCantidadObjetivo() {
        return cantidadObjetivo;
    }

    public void setCantidadObjetivo(float cantidadObjetivo) {
        this.cantidadObjetivo = cantidadObjetivo;
    }

    public float getCantidadRecaudada() {
        return cantidadRecaudada;
    }

    public void setCantidadRecaudada(float cantidadRecaudada) {
        this.cantidadRecaudada = cantidadRecaudada;
    }

    public ArrayList<Recompensa> getListaRecompensas() {
        return listaRecompensas;
    }

    public Recompensa modificarRecompensa(Recompensa recompensa, int posicion) {
        listaRecompensas.set(posicion, recompensa);
        return recompensa;
    }

    public Recompensa agregarRecompensa(Recompensa recompensa) {
        listaRecompensas.add(recompensa);
        return recompensa;
    }

    public ArrayList<Inversion> getListaInversiones() {
        return listaInversiones;
    }

    public Inversion agregarInversion(Inversion inversion) {
        listaInversiones.add(inversion);
        return inversion;
    }

    public Gestor getCreador() {
        return creador;
    }

    @Override
    public String toString() {
        return "\nPROYECTO" +
                "\n=============================================" +
                "\nID Proyecto: " + idProyecto +
                "\nNombre: " + nombre +
                "\nCategoría: " + categoria +
                "\nCantidad necesaria: " + cantidadObjetivo +
                "\nCantidad financiada: " + cantidadRecaudada +
                "\n";
    }
}
