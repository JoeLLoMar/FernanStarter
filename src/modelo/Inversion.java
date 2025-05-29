package modelo;

public class Inversion implements Invertible {
    private int idInversion;
    private Proyecto proyectoInvertido;
    private Inversor inversor;
    private float cantidadInvertida;
    private Recompensa recompensa;

    public Inversion(int idInversion, Proyecto proyectoInvertido, Inversor inversor, float cantidadInvertida) {
        this.idInversion = idInversion;
        this.proyectoInvertido = proyectoInvertido;
        this.inversor = inversor;
        this.cantidadInvertida = cantidadInvertida;
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
            if (proyectoInvertido.getCantidadObjetivo() > proyectoInvertido.getCantidadRecaudada()) {
                inversor.disminuyeSaldo(cantidad);
                return cantidadInvertida += cantidad;
            }
            return 0;
        } return -1;
    }

    @Override
    public float disminuyeInversion(float cantidad) {
        if (proyectoInvertido.getCantidadRecaudada() >= cantidad) {
            inversor.aumentaSaldo(cantidad);
            return cantidadInvertida -= cantidad;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\nINVERSIÓN" +
                "\n=============================================" +
                "\nID de la inversión: " + idInversion +
                "\nProyecto invertido: " + proyectoInvertido +
                "\nCantidad invertida: " + cantidadInvertida +
                "\nInversor: " + inversor +
                "\n=============================================";
    }
}
