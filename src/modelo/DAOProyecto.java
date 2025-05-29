package modelo;

import java.util.ArrayList;

public interface DAOProyecto {
    int insert(Proyecto proyecto);
    int update(Proyecto proyecto);
    int delete(int idProyecto);
    Proyecto read(int idProyecto);
    ArrayList<Usuario> readAll();
}
