package modelo;

import java.sql.*;
import java.util.ArrayList;

public class DAOUsuarioSQL implements DAOUsuario {
    private final DAOManager daoManager = DAOManager.getInstance();

    @Override
    public int insert(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre_usuario, contraseña, email, tipo, saldo, proyectos_gestionados) VALUES (?, ?, ?, ?, ?, ?)";
        return prepararSentencia(usuario, sql);
    }

    @Override
    public int update(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre_usuario = ?, contraseña = ?, email = ?, tipo = ?, saldo = ?, proyectos_gestionados = ? WHERE id = ?";
        return prepararSentencia(usuario, sql);
    }

    private int prepararSentencia(Usuario usuario, String sql) {
        int filasAfectadas = 0;
        try (PreparedStatement myStatement = daoManager.getConnection().prepareStatement(sql)) {
            parametrizarSentencia(usuario, myStatement);
            filasAfectadas = myStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    private void parametrizarSentencia(Usuario usuario, PreparedStatement myStatement) throws SQLException {
        myStatement.setString(1, usuario.getNombre());
        myStatement.setString(2, usuario.getContraseña());
        myStatement.setString(3, usuario.getEmail());
        myStatement.setString(4, String.valueOf(usuario.getClass()));
        if (usuario instanceof Inversor inversor) myStatement.setFloat(5, inversor.getSaldo());
        if (usuario instanceof Gestor gestor) myStatement.setInt(6, gestor.getProyectosCreados());
    }

    @Override
    public int delete(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        return filtrarPorID(idUsuario, sql);
    }

    private int filtrarPorID(int idUsuario, String sql) {
        int filasAfectadas = 0;
        try (PreparedStatement myStatement = daoManager.getConnection().prepareStatement(sql)) {
            myStatement.setInt(1, idUsuario);
            filasAfectadas = myStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    @Override
    public Usuario read(int idUsuario) {
        String sql = "SELECT * FROM entradas WHERE id = "+ idUsuario + ";";
        try{
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                // Si existe una entrada con ese id creo el objeto Entrada a partir de los datos de la tabla entradas
                Usuario usuario = new Inversor(rs.getInt("id"), rs.getString("nombre"));
                return usuario;
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario read(int idUsuario) {
        String sql = "SELECT id, nombre_usuario ,contraseña, email, tipo, saldo, proyectos_gestionados FROM usuario WHERE id = ?";
        try (PreparedStatement myStatement = daoManager.getConnection().prepareStatement(sql)) {
            myStatement.setInt(1, idUsuario);
            try (ResultSet rs = myStatement.executeQuery()) {
                if (rs.next()) {
                    // extraemos campos
                    String nombreUsuario = rs.getString("nombre_usuario");
                    String contraseña = rs.getString("contraseña");
                    String email = rs.getString("email");
                    String tipo = rs.getString("tipo");
                    float saldo = rs.getFloat("saldo");
                    int proyectosGestionados = rs.getInt("proyectos_gestionados");
                    // devolvemos el POJO adecuado según el tipo:
                    return switch (tipo) {
                        case "administrador"    -> new Administrador(nombreUsuario, contraseña, email);
                        case "gestor"           -> new Gestor(nombreUsuario, contraseña, email);
                        case "inversor"         -> new Inversor(nombreUsuario, contraseña, email);
                        default                 -> null;
                    };
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> readAll() {
        String sql = "SELECT * FROM entradas;";
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                // Mientras existan listaUsuarios se añaden al arraylist
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }


}
