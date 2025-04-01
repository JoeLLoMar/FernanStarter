package modelo;

public interface Bloqueable {
    boolean bloquear();
    boolean estaBloqueado();
    boolean desbloquear();

    void incrementarIntentos();
}
