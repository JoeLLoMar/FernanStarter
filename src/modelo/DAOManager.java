package modelo;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DAOManager {
    private Connection myConnection = null;
    private static DAOManager instancia;
    private String url, user, password;

    private DAOManager() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties p = new Properties();
            p.load(in);
            url = p.getProperty("db.url");
            user = p.getProperty("db.user");
            password = p.getProperty("db.password");
        } catch (Exception e) {
            throw new RuntimeException("No se ha podido cargar config.properties", e);
        }
    }

    public static DAOManager getInstance() {
        if (instancia == null) instancia = new DAOManager();
        return instancia;
    }

    // Abrir la conexión con la BD
    public void open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Cargo el driver de conexión JDBC
            myConnection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Cerrar la conexión con la BD
    public void close(){
        if(myConnection != null) {
            try {
                myConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Getter de la conexión
    public Connection getConnection() {
        return myConnection;
    }

    // Ejecuta sentencia: INSERT, UPDATE y DELETE
    public int ejecutaSentencia(String sql) {
        int affectedRows = 0;
        try {
            Statement myStatement = myConnection.createStatement();
            affectedRows = myStatement.executeUpdate(sql);
            myStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }


}

