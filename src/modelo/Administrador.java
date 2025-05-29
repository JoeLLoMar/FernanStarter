package modelo;

public class Administrador extends Usuario {

    public Administrador(String nombre, String clave, String email) {
        super(nombre, clave, email);
    }

    @Override
    public String toString() {
        return "\n\nUSUARIO ADMINISTRADOR" +
                super.toString() +
                "\n=============================================";
    }
}
