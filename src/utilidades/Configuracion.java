package Utilidades;

import java.io.*;
import java.util.Properties;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Configuracion {
    private static final String ARCHIVO_PROPERTIES = "config.properties";
    private static Properties props = new Properties();

    static {
        try {
            File archivo = new File(ARCHIVO_PROPERTIES);
            if (archivo.exists()) {
                FileInputStream in = new FileInputStream(archivo);
                props.load(in);
                in.close();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar archivo de configuración.");
        }
    }

    public static String getUltimoInicio(String usuario) {
        return props.getProperty("ultimoInicio." + usuario);
    }

    public static void setUltimoInicio(String usuario) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
        props.setProperty("ultimoInicio." + usuario, fecha);
        guardar();
    }

    private static void guardar() {
        try (FileOutputStream out = new FileOutputStream(ARCHIVO_PROPERTIES)) {
            props.store(out, "Configuración del sistema");
        } catch (IOException e) {
            System.out.println("Error al guardar configuración.");
        }
    }
}

