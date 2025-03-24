package es.iesfernandoiii.fernanstarter.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Proyecto {
    private static int contadorProyectos = 0;
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

    public Proyecto(String nombre, String descripcion, Categoria categoria, LocalDate fechaInicio, LocalDate fechaFin, float cantidadNecesaria, ArrayList<Recompensa> listaRecompensas) {
        this.idProyecto = ++contadorProyectos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadFinanciada = 0;
        this.listaRecompensas = listaRecompensas;
        this.listaInversiones = new ArrayList<Inversion>();
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

    public void setListaRecompensas(ArrayList<Recompensa> listaRecompensas) {
        this.listaRecompensas = listaRecompensas;
    }

    public ArrayList<Inversion> getListaInversiones() {
        return listaInversiones;
    }

    public void setListaInversiones(ArrayList<Inversion> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + categoria +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cantidadNecesaria=" + cantidadNecesaria +
                ", cantidadFinanciada=" + cantidadFinanciada +
                ", listaRecompensas=" + listaRecompensas +
                ", listaInversiones=" + listaInversiones +
                '}';
    }
}
