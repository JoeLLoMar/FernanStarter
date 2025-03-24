package es.iesfernandoiii.fernanstarter.modelo;

public class Inversion implements Invertible {
    private static int contadorInversiones = 0;
    private int idInversion;
    private Proyecto proyectoInvertido;
    private float cantidadInvertida;
    private Inversor inversor;

    public Inversion(Proyecto proyectoInvertido, float cantidadInvertida, Inversor inversor) {
        this.idInversion = ++contadorInversiones;
        this.proyectoInvertido = proyectoInvertido;
        this.cantidadInvertida = cantidadInvertida;
        this.inversor = inversor;
    }

    public static int getContadorInversiones() {
        return contadorInversiones;
    }

    public int getIdInversion() {
        return idInversion;
    }

    public Proyecto getProyectoInvertido() {
        return proyectoInvertido;
    }

    public void setProyectoInvertido(Proyecto proyectoInvertido) {
        this.proyectoInvertido = proyectoInvertido;
    }

    public float getCantidadInvertida() {
        return cantidadInvertida;
    }

    public void setCantidadInvertida(float cantidadInvertida) {
        this.cantidadInvertida = cantidadInvertida;
    }

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }

    @Override
    public float aumentaInversion(float cantidad) {
        if (inversor.disminuyeSaldo(cantidad)) {
            if (proyectoInvertido.getCantidadNecesaria() > proyectoInvertido.getCantidadFinanciada()) {
                inversor.disminuyeSaldo(cantidad);
                return cantidadInvertida += cantidad;
            }
            return 0;
        } return -1;
    }

    @Override
    public float disminuyeInversion(float cantidad) {
        if (proyectoInvertido.getCantidadFinanciada() >= cantidad) {
            inversor.aumentaSaldo(cantidad);
            return cantidadInvertida -= cantidad;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Inversion{" +
                "idInversion=" + idInversion +
                ", proyectoInvertido=" + proyectoInvertido +
                ", cantidadInvertida=" + cantidadInvertida +
                ", inversor=" + inversor +
                '}';
    }
}
