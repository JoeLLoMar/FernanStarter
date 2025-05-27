package modelo;

import controlador.GestorConfiguracion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCSV {
    private static final String ARCHIVO = "proyectos.csv";
    String ruta = GestorConfiguracion.getRutaProyectos();


    public static void guardarProyectos(List<Proyecto> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Proyecto p : lista) {
                bw.write(p.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Proyecto> cargarProyectos() {
        List<Proyecto> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Proyecto.fromCSV(linea));
            }
        } catch (IOException e) {
            // Si no existe el archivo, simplemente devuelve la lista vacía
        }
        return lista;
    }
}

