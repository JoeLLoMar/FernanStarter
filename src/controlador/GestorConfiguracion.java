package controlador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class GestorConfiguracion {

    private static final String CONFIG_PATH = "config.properties";
    private static final Properties config = new Properties();

    static {
        try {
            File file = new File(CONFIG_PATH);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                config.load(fis);
                fis.close();
            } else {
                config.setProperty("rutaProyectos", "proyectos.csv");
                config.setProperty("permiteAccesoInvitado", "false");
                guardar();
            }
        } catch (IOException e) {
            System.err.println("Error al cargar configuración: " + e.getMessage());
        }
    }

    public static void guardar() {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_PATH)) {
            config.store(fos, "Configuración del sistema Petroprix");
        } catch (IOException e) {
            System.err.println("Error al guardar configuración: " + e.getMessage());
        }
    }

    public static String getRutaProyectos() {
        return config.getProperty("rutaProyectos", "proyectos.csv");
    }

    public static boolean permiteAccesoInvitado() {
        return config.getProperty("permiteAccesoInvitado", "false").equalsIgnoreCase("true");
    }

    public static String getUltimoInicio(String usuario) {
        return config.getProperty("ultimoInicio." + usuario);
    }

    public static void setUltimoInicio(String usuario) {
        String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        config.setProperty("ultimoInicio." + usuario, fechaHora);
        guardar();
    }

    public static void mostrarConfiguracion() {
        System.out.println("=== CONFIGURACIÓN DEL SISTEMA ===");
        config.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
