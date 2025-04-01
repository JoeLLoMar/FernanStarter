package modelo;

public class Recompensa {
    private int idRecompensa;
    private String descripcion;
    private float precio;

    public Recompensa(String descripcion, float precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(Proyecto proyecto) {
        this.idRecompensa = proyecto.getListaRecompensas().size();
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
