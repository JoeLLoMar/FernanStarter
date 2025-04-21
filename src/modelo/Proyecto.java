package modelo;

import Utilidades.*;

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
    private static int contadorProyectos = 0;
    private int contadorRecompensas;
    private int idProyecto;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float cantidadNecesaria;
    private float cantidadFinanciada;
    private ArrayList<Recompensa> listaRecompensas;
    private ArrayList<Inversion> listaInversiones;
    private Gestor creador;

    /**
     * Constructor con parámetros para inicializar un proyecto.
     *
     * @param nombre Nombre del proyecto.
     * @param descripcion Descripción del proyecto.
     * @param categoria Categoría del proyecto.
     * @param fechaInicio Fecha de inicio.
     * @param fechaFin Fecha de finalización.
     * @param cantidadNecesaria Monto necesario para financiar el proyecto.
     * @param creador usario Gestor que ha creado el proyecto.
     */
    public Proyecto(
            String nombre,
            String descripcion,
            Categoria categoria,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            float cantidadNecesaria,
            Gestor creador) {
        this.idProyecto = ++contadorProyectos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadFinanciada = 0;
        this.listaRecompensas = new ArrayList<Recompensa>();
        this.contadorRecompensas = 0;
        this.listaInversiones = new ArrayList<Inversion>();
        this.creador = creador;
    }

    public static int getContadorProyectos() {
        return contadorProyectos;
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

    public float getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(float cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public float getCantidadFinanciada() {
        return cantidadFinanciada;
    }

    public void setCantidadFinanciada(float cantidadFinanciada) {
        this.cantidadFinanciada = cantidadFinanciada;
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
                "\nCantidad necesaria: " + cantidadNecesaria +
                "\nCantidad financiada: " + cantidadFinanciada +
                "\n";
    }
}
