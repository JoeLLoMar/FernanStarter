package Utilidades;

import java.io.IOException;
import java.util.logging.*;

public class LoggerSistema {
    private static final Logger logger = Logger.getLogger("Actividad");

    static {
        try {
            FileHandler fh = new FileHandler("actividad.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registrar(String mensaje, String nombre) {
        logger.info(mensaje);
    }
}
