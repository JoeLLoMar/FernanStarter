package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProyectoSQL implements DAOProyecto {


    @Override
    public int insert(Proyecto proyecto) {
        return 0;
    }

    @Override
    public int update(Proyecto proyecto) {
        return 0;
    }

    @Override
    public int delete(int idProyecto) {
        return 0;
    }

    @Override
    public Proyecto read(int idProyecto) {
        return null;
    }

    @Override
    public ArrayList<Usuario> readAll() {
        return null;
    }

    private Proyecto mapearProyecto(ResultSet rs) throws SQLException {
        return new Proyecto(rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("descripcion"),
                Categoria.valueOf(rs.getString("categoria").toUpperCase()),
                rs.getDate("fecha_inicio").toLocalDate(),
                rs.getDate("fecha_fin") == null ? null : rs.getDate("fecha_fin").toLocalDate(),
                rs.getFloat("cantidad_objetivo"),
                rs.getFloat("cantidad_recaudada"));
    }
}
