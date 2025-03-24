package modelo;

abstract public class Usuario {
    private static int contadorUsuarios = 0;
    private int id;
    private String nombre;
    private String contraseña;
    private String email;

    public Usuario(String nombre, String clave, String email) {
        this.id = ++contadorUsuarios;
        this.nombre = nombre;
        this.contraseña = clave;
        this.email = email;
    }

    public static int getContadorUsuarios() {
        return contadorUsuarios;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
