package es.iesfernandoiii.fernanstarter.utilidades;

public class FuncionesCadenas {
    /**
     * Comprueba si dos contraseñas son iguales.
     * Útil para confirmar la contraseña en el registro de usuarios.
     *
     * @param contraseña1 La primera contraseña.
     * @param contraseña2 La segunda contraseña.
     * @return true si son idénticas, false en caso contrario.
     */
    public static boolean sonContraseñasIguales(String contraseña1, String contraseña2) {
        return contraseña1 != null && contraseña1.equals(contraseña2);
    }

    /**
     * Verifica si una contraseña es "fuerte".
     * Se considera fuerte si:
     * - Tiene al menos 8 caracteres.
     * - Contiene al menos una minúscula.
     * - Contiene al menos una mayúscula.
     * - Contiene al menos un número.
     * - Contiene al menos uno de estos símbolos: - _ . , * + @
     *
     * @param contraseña La contraseña a evaluar.
     * @return true si cumple todos los criterios, false si falla alguno.
     */
    public static boolean esContraseñaFuerte(String contraseña) {
        if (contraseña == null || contraseña.length() < 8) {
            return false;
        }
        boolean tieneMinuscula = false;
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;
        String simbolos = "-_.,*+@";

        for (char c : contraseña.toCharArray()) {
            if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (simbolos.indexOf(c) != -1) {
                tieneSimbolo = true;
            }
        }
        return tieneMinuscula && tieneMayuscula && tieneNumero && tieneSimbolo;
    }

    /**
     * Comprueba si un texto cumple con una longitud mínima y máxima.
     * Por ejemplo, para validar títulos y descripciones de proyectos.
     *
     * @param texto El texto a comprobar.
     * @param min   La longitud mínima permitida.
     * @param max   La longitud máxima permitida.
     * @return true si el texto tiene una longitud entre min y max (inclusive).
     */
    public static boolean comprobarLongitud(String texto, int min, int max) {
        if (texto == "") {
            return false;
        }
        int longitud = texto.length();
        return longitud >= min && longitud <= max;
    }

    /**
     * Comprueba si un texto contiene el carácter '%'
     * (por ejemplo, para campos de interés o formatos específicos).
     *
     * @param texto El texto a evaluar.
     * @return true si contiene '%', false si no.
     */
    public static boolean tieneFormatoPorcentaje(String texto) {
        return texto != null && texto.contains("%");
    }

    /**
     * Comprueba si un texto contiene el carácter '€'
     * (útil para validar campos de moneda).
     *
     * @param texto El texto a evaluar.
     * @return true si contiene '€', false si no.
     */
    public static boolean tieneFormatoEuro(String texto) {
        return texto != null && texto.contains("€");
    }

}
