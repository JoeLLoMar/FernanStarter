package vista;

import controlador.GestionInversionesControlador;
import modelo.GestionUsuarios;
import modelo.Usuario;
import controlador.GestionUsuariosControlador;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionUsuariosVista {
    private String colorTexto;
    private GestionUsuariosControlador controlador;
    private Scanner scanner;
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public void setColorTexto(String colorTexto) {
        this.colorTexto = colorTexto;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(colorTexto + mensaje + RESET);
    }

    public void mostrarListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
        for (Map.Entry pareja : listaUsuarios.entrySet()) {
            System.out.println(pareja.getValue());
        }
    }

    public void mostrarListaAmigos(Usuario usuario) {
        for (Map.Entry pareja : usuario.getListaAmigos().entrySet()) {
            System.out.println(pareja.getValue());
        }
    }



    public GestionUsuariosVista() {
        scanner = new Scanner(System.in);
        controlador = new GestionUsuariosControlador(this);
    }

    public void mostrarFormularioRegistro() {
        System.out.println("\n--- Registro de nuevo usuario ---");
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("Tipo de usuario (gestor, inversor, administrador): ");
        String tipo = scanner.nextLine();

        boolean exito = controlador.registrarNuevoUsuario(nombre, contrasena, email, tipo);
        if (exito) {
            System.out.println("Usuario " + tipo + " registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el usuario. Verifica los datos.");
        }
    }

    public void mostrarMenuInversion() {
        System.out.println("\n--- Inversión en Proyecto ---");
        System.out.print("Nombre del inversor: ");
        String nombre = scanner.nextLine();
        System.out.print("Nombre del proyecto: ");
        String nombreProyecto = scanner.nextLine();
        System.out.print("Cantidad a invertir: ");
        float cantidad = Float.parseFloat(scanner.nextLine());

        GestionInversionesControlador controladorInversiones = new GestionInversionesControlador();
        boolean exito = controladorInversiones.invertir(nombre, nombreProyecto, cantidad);
        if (exito) {
            System.out.println("Inversión registrada correctamente.");
        } else {
            System.out.println("Error al registrar la inversión.");
        }
    }

}
