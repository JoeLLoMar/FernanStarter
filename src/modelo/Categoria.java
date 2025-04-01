package modelo;

public enum Categoria {
    ARTE, TECNOLOGIA, CINE, COMIDA, MODA, JUEGOS;

    public static boolean validarCategoria(String categoria) {
        if (
                categoria.equalsIgnoreCase(String.valueOf(ARTE)) ||
                categoria.equalsIgnoreCase(String.valueOf(TECNOLOGIA)) ||
                categoria.equalsIgnoreCase(String.valueOf(CINE)) ||
                categoria.equalsIgnoreCase(String.valueOf(COMIDA)) ||
                categoria.equalsIgnoreCase(String.valueOf(MODA)) ||
                categoria.equalsIgnoreCase(String.valueOf(JUEGOS))) {
            return true;
        }
        return false;
    }
}
