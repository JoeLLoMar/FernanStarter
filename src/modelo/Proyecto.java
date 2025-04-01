package modelo;

import utilidades.FuncionesFechas;

import java.time.LocalDate;
import java.util.ArrayList;

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
