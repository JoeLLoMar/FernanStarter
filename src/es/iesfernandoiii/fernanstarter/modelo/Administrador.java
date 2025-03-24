package es.iesfernandoiii.fernanstarter.modelo;

public class Administrador extends Usuario {
    private static int contadorAdministrador = 0;
    private int idAdmin;

    public Administrador(String nombre, String clave, String email) {
        super(nombre, clave, email);
        this.idAdmin = ++contadorAdministrador;
    }

    public static int getContadorAdministrador() {
        return contadorAdministrador;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdmin=" + idAdmin +
                '}';
    }
}
