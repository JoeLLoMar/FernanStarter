package modelo;

import java.util.ArrayList;

public interface DAOUsuario {
    int insert(Usuario usuario);
    int update(Usuario usuario);
    int delete(int idUsuario);
    Usuario read(int idUsuario);
    ArrayList<Usuario> readAll();
}
