package modelo;

public class RegistroInversiones {
    private static java.util.List<Inversion> inversiones = new java.util.ArrayList<>();

    public static void registrarInversion(Inversion inversion) {
        inversiones.add(inversion);
    }

    public static java.util.List<Inversion> getInversiones() {
        return inversiones;
    }
}
