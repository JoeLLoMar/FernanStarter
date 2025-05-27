package modelo;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class RegistroProyectos {
    private static Map<String, Proyecto> proyectos = new HashMap<>();
    private static List<Proyecto> listaProyectos = new ArrayList<>();


    public static void registrarProyecto(Proyecto proyecto) {
        proyectos.put(proyecto.getNombre(), proyecto);
    }

    public static Proyecto getProyecto(String nombre) {
        return proyectos.get(nombre);
    }

    public static Map<String, Proyecto> getProyectos() {
        return proyectos;
    }

    public static List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }




}