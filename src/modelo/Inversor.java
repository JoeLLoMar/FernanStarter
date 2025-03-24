package modelo;

import java.util.ArrayList;

public class Inversor extends Usuario implements Bloqueable {
    private static int contadorInversor = 0;
    private int idInversor;
    private ArrayList<Inversion> listaInversiones;
    private float saldo;
    private int contadorLogin;
    private boolean bloqueado;

    public Inversor(String nombre, String clave, String email) {
        super(nombre, clave, email);
        this.idInversor = ++contadorInversor;
        this.listaInversiones = new ArrayList<Inversion>();
        this.saldo = 0;
        this.contadorLogin = 0;
        this.bloqueado = false;
    }

    public Inversor(String nombre, String clave, String email, ArrayList<Inversion> listaInversiones, float saldo, int contadorLogin) {
        super(nombre, clave, email);
        this.idInversor = ++contadorInversor;
        this.listaInversiones = listaInversiones;
        this.saldo = saldo;
        this.contadorLogin = contadorLogin;
    }

    public static int getContadorInversor() {
        return contadorInversor;
    }

    public int getIdInversor() {
        return idInversor;
    }

    public ArrayList<Inversion> getListaInversiones() {
        return listaInversiones;
    }

    public void setListaInversiones(ArrayList<Inversion> listaInversiones) {
        this.listaInversiones = listaInversiones;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
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

    public int getContadorLogin() {
        return contadorLogin;
    }

    public void setContadorLogin(int contadorLogin) {
        this.contadorLogin = contadorLogin;
    }

    @Override
    public void bloquear() {
        if (bloqueado = false)
            if (contadorLogin >= 3)
                bloqueado = true;
    }

    @Override
    public void desbloquear() {
        if (bloqueado = true) bloqueado = false;
    }

    @Override
    public String toString() {
        return "Inversor{" +
                "idInversor=" + idInversor +
                ", listaInversiones=" + listaInversiones +
                ", saldo=" + saldo +
                ", contadorLogin=" + contadorLogin +
                '}';
    }
}
