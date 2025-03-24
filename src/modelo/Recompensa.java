package modelo;

public class Recompensa {
    private String descripcion;
    private float precio;

    public Recompensa(String descripcion, float precio) {
        this.descripcion = descripcion;
        this.precio = precio;
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
        return "Recompensa{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
