package modelo;

public class Recompensa {
    private int idRecompensa;
    private Proyecto proyecto;
    private String descripcion;
    private float precio;

    public Recompensa(int idRecompensa, String descripcion, float precio, Proyecto proyecto) {
        this.idRecompensa = idRecompensa;
        this.descripcion = descripcion;
        this.precio = precio;
        this.proyecto = proyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\nRECOMPENSA" +
                "\n------------------------------------" +
                "\nID de recompensa: " + idRecompensa +
                "\nDescripción: " + descripcion +
                "\nPrecio: " + precio +
                "\n";
    }
}
