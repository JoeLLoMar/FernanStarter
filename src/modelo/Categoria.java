package modelo;

public enum Categoria {
    ARTE, TECNOLOGIA, CINE, COMIDA, MODA, JUEGOS;

    public static boolean validarCategoria(String categoria) {
        return esArte(categoria)
                || esTecnologia(categoria)
                || esCine(categoria)
                || esComida(categoria)
                || esModa(categoria)
                || esJuegos(categoria);
    }

    private static boolean esArte(String categoria) {
        return categoria.equalsIgnoreCase(String.valueOf(ARTE));
    }

    private static boolean esTecnologia(String categoria) {
        return categoria.equalsIgnoreCase(String.valueOf(TECNOLOGIA));
    }

    private static boolean esCine(String categoria) {
        return categoria.equalsIgnoreCase(String.valueOf(CINE));
    }

    private static boolean esComida(String categoria) {
        return categoria.equalsIgnoreCase(String.valueOf(COMIDA));
    }

    private static boolean esModa(String categoria) {
        return categoria.equalsIgnoreCase(String.valueOf(MODA));
    }

    private static boolean esJuegos(String categoria) {
        return categoria.equalsIgnoreCase(String.valueOf(JUEGOS));
    }
}
