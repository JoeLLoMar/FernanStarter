package modelo;

import java.util.ArrayList;

public class Inversor extends Usuario implements Bloqueable {
    private ArrayList<Inversion> listaInversiones;
    private float saldo;
    private int iniciosSesionFallidos;
    private boolean bloqueado;

    public Inversor(
            String nombre,
            String clave,
            String email) {
        super(nombre, clave, email);
        this.listaInversiones = new ArrayList<Inversion>();
        this.saldo = 0;
        this.iniciosSesionFallidos = 0;
        this.bloqueado = false;
    }

    public Inversor(
            String nombre,
            String clave,
            String email,
            ArrayList<Inversion> listaInversiones,
            float saldo,
            int iniciosSesionFallidos) {
        super(nombre, clave, email);
        this.listaInversiones = listaInversiones;
        this.saldo = saldo;
        this.iniciosSesionFallidos = iniciosSesionFallidos;
    }

    public ArrayList<Inversion> getListaInversiones() {
        return listaInversiones;
    }

    public void setListaInversiones(ArrayList<Inversion> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public Inversion agregarInversion(Inversion inversion) {
        listaInversiones.add(inversion);
        return inversion;
    }

    public float getSaldo() {
        if (saldo >= 0)
        return saldo;
        return -1;
    }

    public void setSaldo(float saldo) {
        if (saldo < 0) return;
        this.saldo = saldo;
    }

    public void aumentaSaldo(float cantidad) {
        saldo += cantidad;
    }

    public boolean disminuyeSaldo(float cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public int getIniciosSesionFallidos() {
        return iniciosSesionFallidos;
    }

    public void setIniciosSesionFallidos(int iniciosSesionFallidos) {
        this.iniciosSesionFallidos = iniciosSesionFallidos;
    }

    public void incrementarIntentos(){ this.iniciosSesionFallidos += 1;}

    @Override
    public boolean bloquear() {
        if (bloqueado = false && iniciosSesionFallidos >= 3) {
            bloqueado = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean desbloquear() {
        if (bloqueado = true) {
            bloqueado = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean estaBloqueado() {
        return bloqueado;
    }

    @Override
    public String toString() {
        return "\n\nUSUARIO INVERSOR" +
                super.toString() +
                "\nInversiones realizadas: " + listaInversiones +
                "\nSaldo restante: " + saldo +
                "\n=============================================";
    }
}
