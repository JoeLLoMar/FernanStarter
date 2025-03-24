package utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class FuncionesFechas {
    // Formato de fecha: dd/MM/yyyy
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Convierte un String con formato "dd/MM/yyyy" a LocalDate.
     * @param fechaStr la fecha en formato String.
     * @return LocalDate o null si falla el parseo.
     * @throws DateTimeParseException ll String no cumple con el formato "dd/MM/yyyy".
     */
    public static LocalDate parsearFecha(String fechaStr) {
        try {
            return LocalDate.parse(fechaStr, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            System.out.println("Error: La fecha '" + fechaStr + "' no cumple el formato dd/MM/yyyy");
            return null;
        }
    }

    /**
     * Convierte un LocalDate a un String con formato "dd/MM/yyyy".
     * @param fecha el LocalDate a formatear.
     * @return la fecha en formato String.
     */
    public static String formatearFecha(LocalDate fecha) {
        if(fecha == null) return null;
        return fecha.format(FORMATO_FECHA);
    }

    /**
     * Comprueba si una fecha/hora es anterior a otra.
     * @param fecha1 la primera fecha/hora.
     * @param fecha2 la segunda fecha/hora.
     * @return true si fecha1 es anterior a fecha2.
     */
    public static boolean esAnterior(LocalDateTime fecha1, LocalDateTime fecha2) {
        return fecha1.isBefore(fecha2);
    }

    /**
     * Calcula los segundos transcurridos entre la fecha pasada y ahora.
     * @param fecha la fecha/hora de referencia.
     * @return segundos transcurridos.
     */
    public static long segundosEntre(LocalDateTime fecha) {
        return ChronoUnit.SECONDS.between(fecha, LocalDateTime.now());
    }

    /**
     * Calcula los minutos transcurridos entre la fecha pasada y ahora.
     * @param fecha la fecha/hora de referencia.
     * @return minutos transcurridos.
     */
    public static long minutosEntre(LocalDateTime fecha) {
        return ChronoUnit.MINUTES.between(fecha, LocalDateTime.now());
    }

    /**
     * Calcula las horas transcurridas entre la fecha pasada y ahora.
     * @param fecha la fecha/hora de referencia.
     * @return horas transcurridas.
     */
    public static long horasEntre(LocalDateTime fecha) {
        return ChronoUnit.HOURS.between(fecha, LocalDateTime.now());
    }

    /**
     * Calcula los días transcurridos entre la fecha pasada y ahora.
     * @param fecha la fecha/hora de referencia.
     * @return días transcurridos.
     */
    public static long diasEntre(LocalDateTime fecha) {
        return ChronoUnit.DAYS.between(fecha, LocalDateTime.now());
    }

    // Funciones adicionales (por si te apetece)

    /**
     * Devuelve la fecha y hora actual en formato ISO.
     * @return String con la fecha y hora actual.
     */
    public static String fechaHoraActual() {
        return LocalDateTime.now().toString();
    }

    /**
     * Suma un número determinado de días a una fecha.
     * @param fecha la fecha de partida.
     * @param dias el número de días a sumar.
     * @return la fecha resultante.
     */
    public static LocalDate sumarDias(LocalDate fecha, int dias) {
        return fecha.plusDays(dias);
    }

    /**
     * Calcula la diferencia en días entre dos LocalDate.
     * @param inicio la fecha de inicio.
     * @param fin la fecha de fin.
     * @return número de días entre las dos fechas.
     */
    public static long diferenciaDias(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.DAYS.between(inicio, fin);
    }
}
