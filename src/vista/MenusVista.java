package vista;

import modelo.*;
import java.util.ArrayList;

public class MenusVista {
    private String colorTexto;
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public void setColorTexto(String colorTexto) {
        this.colorTexto = colorTexto;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(colorTexto + mensaje + RESET);
    }

    public void menuInicioSesion() {
        System.out.println("""
                    \n--- INICIO DE SESIÓN ---
                    Seleccione una opción:
                    1. Como administrador
                    2. Como gestor
                    3. Como inversor
                    4. Salir""");
    }

    // MENÚS COMUNES
    public void menuConfiguracion() {
        System.out.println("""
                Selecciona que quieres hacer:
                1.- Cambiar mi usuario
                2.- Cambiar mi contraseña
                3.- Salir""");
    }

    public void menuProyectos() {
        System.out.println("""
                \n--- PROYECTOS ---
                Seleccione una opción:
                1. Ver proyectos existentes
                2. Salir""");
    }


    public void menuGestionProyecto() {
        System.out.println("""
                \n--- OPCIONES DE PROYECTO ---
                Seleccione una opción: 
                1. Vista detallada
                2. Modificar proyecto
                3. Modificar recompensa
                4. Eliminar proyecto
                5. Salir""");
    }


    public void menuModificarProyecto() {
        System.out.println("""
                \nElige el apartado que vas a modificar:
                1. Nombre
                2. Descripción
                3. Categoría
                4. Fecha inicio
                5. Fecha fin
                6. Cantidad necesaria
                7. Cantidad financiada
                8. Recompensas
                9. Salir""");
    }

    // MENÚS ADMINISTRADOR
    public void menuPrincipalAdmin() {
        System.out.println("""
                    \n--- MENÚ PRINCIPAL ADMINISTRADOR ---
                    Seleccione una opción:
                    1. Panel de control
                    2. Proyectos
                    3. Configuración
                    4. Cerrar sesión""");
    }

    public void menuPanelControl() {
        System.out.println("""
                \n--- PANEL DE CONTROL ---
                Seleccione una opción
                1. Ver usuarios registrados
                2. Bloquear usuario
                3. Desbloquear usuario
                4. Salir""");
    }

// MENÚS GESTOR
    public void menuPrincipalGestor() {
        System.out.println("""
                \n--- MENÚ PRINCIPAL GESTOR ---
                Seleccione una opción:
                1. Mis proyectos
                2. Configuración
                3. Cerrar sesión""");
    }

    public void menuMisProyectos() {
        System.out.println("""
                \n--- MIS PROYECTOS ---
                Seleccione una opción:
                1. Ver proyectos creados
                2. Crear un nuevo proyecto
                3. Salir""");
    }


// MENÚS INVERSOR
    public void menuPrincipalInversor() {
        System.out.println("""
                \n--- MENÚ PRINCIPAL INVERSOR ---
                Seleccione una opción:
                1. Mis inversiones
                2. Proyectos
                3. Cartera digital
                4. Invita a un amigo
                5. Configuración
                6. Cerrar sesión""");
    }

    public void menuMisInversiones() {
        System.out.println("""
                \n--- MIS INVERSIONES ---
                Seleccione una opción:
                1. Ver proyectos financiados
                2. Salir""");
    }

    public void menuInvertirProyecto() {
        System.out.println("""
                 \nSeleccione una opción:
                 1. Invertir en el proyecto
                 2. Salir""");
    }


    public void menuCartera() {
        System.out.println("""
                \n --- CARTERA DIGITAL ---
                Seleccione una opción:
                1. Ver saldo actual
                2. Añadir saldo
                3. Salir""");
    }

    public void menuInvitaAmigo() {
        System.out.println("""
                \n--- INVITA A UN AMIGO ---
                Seleccione una opción:
                1. Lista de amigos
                2. Invitar amigo
                3. Salir""");
    }
}
