package modelo;

import java.util.HashMap;

abstract public class Usuario {
    private static int contadorUsuarios = 0;
    private int id;
    private String nombre;
    private String contraseña;
    private String email;
    private HashMap<String, Usuario> listaAmigos;

    public Usuario(String nombre, String clave, String email) {
        this.id = ++contadorUsuarios;
        this.nombre = nombre;
        this.contraseña = clave;
        this.email = email;
        this.listaAmigos = new HashMap<String, Usuario>();
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

    public boolean validarContraseña(String contraseña) { return this.contraseña.equals(contraseña); }

    public Usuario invitarAmigo(String nombre, Usuario amigo) {
        listaAmigos.put(nombre, amigo);
        return amigo;
    }

    public HashMap<String, Usuario> getListaAmigos() {
        return listaAmigos;
    }

    @Override
    public String toString() {
        return "\n=============================================" +
                "\nID de usuario: " + id +
                "\nNombre de usuario: " + nombre +
                "\nContraseña: " + contraseña +
                "\nEmail: " + email;
    }
}
