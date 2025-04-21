package modelo;

import java.util.HashMap;
import java.util.Map;

public class RegistroProyectos {
    private static Map<String, Proyecto> proyectos = new HashMap<>();

    public static void registrarProyecto(Proyecto proyecto) {
        proyectos.put(proyecto.getNombre(), proyecto);
    }

    public static Proyecto getProyecto(String nombre) {
        return proyectos.get(nombre);
    }

    public static Map<String, Proyecto> getProyectos() {
        return proyectos;
    }
}