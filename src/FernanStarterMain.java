import controlador.GestionProyectosControlador;
import controlador.GestionUsuariosControlador;
import controlador.MenusControlador;
import modelo.*;
import utilidades.FuncionesFechas;
import vista.GestionProyectosVista;
import vista.GestionUsuariosVista;
import vista.MenusVista;

import java.time.LocalDate;
import java.util.Scanner;

public class FernanStarterMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionUsuarios usuariosModelo = new GestionUsuarios();
        GestionProyectos proyectosModelo = new GestionProyectos();
        GestionUsuariosVista usuariosVista = new GestionUsuariosVista();
        GestionProyectosVista proyectosVista = new GestionProyectosVista();
        MenusVista menusVista = new MenusVista();
        GestionUsuariosControlador usuariosControlador = new GestionUsuariosControlador(usuariosModelo, usuariosVista);
        GestionProyectosControlador proyectosControlador = new GestionProyectosControlador(proyectosModelo, proyectosVista);
        MenusControlador menusControlador = new MenusControlador(menusVista);

        Usuario admin1 = new Administrador("admin1", "admin123", "admin1@mail.com");
        Usuario admin2 = new Administrador("admin2", "admin123", "admin2@mail.com");
        Usuario gestor1 = new Gestor("gestor1", "gestor123", "gestor1@mail.com");
        Usuario gestor2 = new Gestor("gestor2", "gestor123", "gestor2@mail.com");
        Usuario inversor1 = new Inversor("inversor1", "inversor123", "inversor1@mail.com");
        Usuario inversor2 = new Inversor("inversor2", "inversor123", "inversor2@mail.com");
        usuariosModelo.agregarUsuario(admin1.getNombre(), admin1);
        usuariosModelo.agregarUsuario(admin2.getNombre(), admin2);
        usuariosModelo.agregarUsuario(gestor1.getNombre(), gestor1);
        usuariosModelo.agregarUsuario(gestor2.getNombre(), gestor2);
        usuariosModelo.agregarUsuario(inversor1.getNombre(), inversor1);
        usuariosModelo.agregarUsuario(inversor2.getNombre(), inversor2);

//============================================================
// INICIO DE SESIÓN
/*Contiene dentro de su bucle los tres menús según el usuario,
faltaría hacer que mediante la función de login y, por ejemplo, un "if",
te llevara al menú correspondiente.
 */
//============================================================
        boolean salirMenuInicio = false;
        boolean loginExitoso = false;
        Usuario usuario = null;
        int opcion=0;

        while (!loginExitoso) {
            do {
                menusControlador.menuInicioSesion();

                while (!sc.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.");
                    sc.next();
                }
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción no válida. Por favor, seleccione un número entre 1 y 4.");
                }
            } while (opcion < 1 || opcion > 4);

            if (opcion == 4) {
                System.out.println("Saliendo del sistema...");
                return;
            }

            System.out.print("Ingrese su nombre de usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String clave = sc.nextLine();

            usuario = usuariosModelo.buscarUsuarioPorNombre(nombre);
            if (usuario != null && usuario.getContraseña().equals(clave) && !(usuario instanceof Bloqueable && ((Bloqueable) usuario).estaBloqueado())) {
                loginExitoso = true;
            } else {
                System.out.println("Credenciales incorrectas o usuario bloqueado. Intente de nuevo.");
                if (usuario instanceof Bloqueable) {
                    ((Bloqueable) usuario).incrementarIntentos();
                }
            }
    //============================================================
    // MENÚS SEGÚN EL TIPO DE USUARIO
    //============================================================
            boolean salirMenu = false;
            while (!salirMenu) {
        //============================================================
        // ADMINISTRADOR
        //============================================================
                if (usuario instanceof Administrador) {
                    menusControlador.menuPrincipalAdmin();
                    int opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion2) {
            // PANEL DE CONTROL
            //====================================================
                        case 1 -> {
                            boolean salirSubmenu = false;
                            while (!salirSubmenu) {
                                menusControlador.menuPanelControl();
                                int opcion3 = sc.nextInt();
                                sc.nextLine();
                                switch (opcion3) {
                    // VER USUARIOS REGISTRADOS
                    //====================================================
                                    case 1 -> {
                                        usuariosControlador.mostrarListaUsuarios();
                                    }
                    // BLOQUEAR USUARIO
                    //====================================================
                                    case 2 -> {
                                        usuariosControlador.mostrarMensaje("", "Introduce el nombre del usuario: ");
                                        Usuario usuarioSeleccionado = usuariosControlador.buscarUsuarioPorNombre(nombre);
                                        usuariosControlador.bloquearUsuario(usuarioSeleccionado);
                                    }
                    // DESBLOQUEAR USUARIO
                    //====================================================
                                    case 3 -> {
                                        usuariosControlador.mostrarMensaje("", "Introduce el nombre del usuario: ");
                                        Usuario usuarioSeleccionado = usuariosControlador.buscarUsuarioPorNombre(nombre);
                                        usuariosControlador.desbloquearUsuario(usuarioSeleccionado);
                                    }
                    // SALIR
                    //====================================================
                                    case 4 -> {
                                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MENÚ PRINCIPAL ADMINISTRADOR");
                                        salirSubmenu = true;
                                    }
                                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                }
                            }
                        }
            // PROYECTOS
            //====================================================
                        case 2 -> {
                            boolean salirSubmenu = false;
                            while (!salirSubmenu) {
                                menusControlador.menuProyectos();
                                int opcion3 = sc.nextInt();
                                sc.nextLine();
                                switch (opcion3) {
                                    // VER PROYECTOS EXISTENTES
                                    //====================================================
                                    case 1 -> {
                                        proyectosControlador.mostrarTotalProyectos();
                                        boolean salirSubmenu2 = false;
                                        while (!salirSubmenu2) {
                                            menusControlador.menuGestionProyecto();
                                            int opcion4 = sc.nextInt();
                                            sc.nextLine();
                                            switch (opcion4) {
                                                // VISTA DETALLADA
                                                //====================================================
                                                case 1 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    Proyecto proyectoBuscado = proyectosControlador.buscarProyecto(posicion);
                                                    proyectosControlador.mostrarVistaDetallada(proyectoBuscado);
                                                }
                                                // MODIFICAR PROYECTO
                                                //====================================================
                                                case 2 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    Proyecto proyectoBuscado = proyectosControlador.buscarProyecto(posicion);
                                                    proyectosControlador.mostrarMensaje("","\nModifica el proyecto. \nIntroduce el atributo que quieres modificar: ");
                                                    String atributo = sc.nextLine();
                                                    proyectosControlador.mostrarMensaje("","\nIntroduce el nuevo valor: ");
                                                    String valor = sc.nextLine();
                                                    proyectosControlador.modificarProyecto(proyectoBuscado, atributo, valor);
                                                }
                                                // MODIFICAR RECOMPENSA
                                                //====================================================
                                                case 3 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    Proyecto proyectoBuscado = proyectosControlador.buscarProyecto(posicion);
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el índice de la recompensa (0, 1 ó 2): ");
                                                    int indice = sc.nextInt();
                                                    sc.nextLine();
                                                    proyectosControlador.mostrarMensaje("","\nModifica la recompensa. \nIntroduce el atributo que quieres modificar: ");
                                                    String atributo = sc.nextLine();
                                                    proyectosControlador.mostrarMensaje("","\nIntroduce el nuevo valor: ");
                                                    String valor = sc.nextLine();
                                                    proyectosControlador.modificarRecompensa(proyectoBuscado, indice, atributo, valor);
                                                }
                                                // ELIMINAR PROYECTO
                                                //====================================================
                                                case 4 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    Proyecto proyectoEliminado = proyectosControlador.buscarProyecto(posicion);
                                                    proyectosControlador.eliminarProyecto(posicion);
                                                    proyectosControlador.eliminarProyectoGestor(proyectoEliminado.getCreador(), posicion);
                                                }
                                                // SALIR
                                                //====================================================
                                                case 5 -> {
                                                    usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MIS PROYECTOS.");
                                                    salirSubmenu2 = true;
                                                }
                                                default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                            }
                                        }

                                    }
                                    // SALIR
                                    //====================================================
                                    case 2 -> {
                                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MENÚ PRINCIPAL GESTOR");
                                        salirSubmenu = true;
                                    }
                                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                }
                            }
                        }
            // CONFIGURACIÓN
            //====================================================
                        case 3 -> {
                            boolean salirSubmenu = false;
                            while (!salirSubmenu) {
                                menusControlador.menuConfiguracion();
                                int opcion3 = sc.nextInt();
                                sc.nextLine();
                                switch (opcion3) {
                    // CAMBIAR NOMBRE DE USUARIO
                    //====================================================
                                    case 1 -> {
                                        usuariosControlador.mostrarMensaje("", "Introduce tu nuevo nombre de usuario: ");
                                        String nuevoNombre = sc.nextLine();
                                        usuariosControlador.modificarUsuario(usuario, "nombre", nuevoNombre);
                                    }
                    // CAMBIAR CONTRASEÑA
                    //====================================================
                                    case 2 -> {
                                        usuariosControlador.mostrarMensaje("", "Introduce tu nueva contraseña: ");
                                        String nuevaClave = sc.nextLine();
                                        usuariosControlador.modificarUsuario(usuario, "contraseña", nuevaClave);
                                    }
                    // SALIR
                    //====================================================
                                    case 3 -> {
                                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MENÚ PRINCIPAL ADMINISTRADOR");
                                        salirSubmenu = true;
                                    }
                                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                }
                            }
                        }
            // CERRAR SESIÓN
            //====================================================
                        case 4 -> {
                            usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo al menú de inicio.");
                           salirMenu = true;
                            loginExitoso = false;
                        }
                        default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                    }
                }
        //============================================================
        // GESTOR
        //============================================================
                else if (usuario instanceof Gestor) {
                    Gestor usuarioGestor = (Gestor) usuario;
                    menusControlador.menuPrincipalGestor();
                    int opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion2) {
            // MIS PROYECTOS
            //====================================================
                        case 1 -> {
                            boolean salirSubmenu = false;
                            while (!salirSubmenu) {
                                menusControlador.menuMisProyectos();
                                int opcion3 = sc.nextInt();
                                sc.nextLine();
                                switch (opcion3) {
                    // VER PROYECTOS CREADOS
                    //====================================================
                                    case 1 -> {
                                        proyectosControlador.mostrarProyectosGestor(usuarioGestor);
                                        boolean salirSubmenu2 = false;
                                        while (!salirSubmenu2) {
                                            menusControlador.menuGestionProyecto();
                                            int opcion4 = sc.nextInt();
                                            sc.nextLine();
                                            switch (opcion4) {
                                // VISTA DETALLADA
                                //====================================================
                                                case 1 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    Proyecto proyectoBuscado = proyectosControlador.buscarProyecto(posicion);
                                                    proyectosControlador.mostrarVistaDetallada(proyectoBuscado);
                                                }
                                // MODIFICAR PROYECTO
                                //====================================================
                                                case 2 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    Proyecto proyectoBuscado = proyectosControlador.buscarProyecto(posicion);
                                                    proyectosControlador.mostrarMensaje("","\nModifica el proyecto. \nIntroduce el atributo que quieres modificar: ");
                                                    String atributo = sc.nextLine();
                                                    proyectosControlador.mostrarMensaje("","\nIntroduce el nuevo valor: ");
                                                    String valor = sc.nextLine();
                                                    proyectosControlador.modificarProyecto(proyectoBuscado, atributo, valor);
                                                }
                                // MODIFICAR RECOMPENSA
                                //====================================================
                                                case 3 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    Proyecto proyectoBuscado = proyectosControlador.buscarProyecto(posicion);
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el índice de la recompensa (0, 1 ó 2): ");
                                                    int indice = sc.nextInt();
                                                    sc.nextLine();
                                                    proyectosControlador.mostrarMensaje("","\nModifica la recompensa. \nIntroduce el atributo que quieres modificar: ");
                                                    String atributo = sc.nextLine();
                                                    proyectosControlador.mostrarMensaje("","\nIntroduce el nuevo valor: ");
                                                    String valor = sc.nextLine();
                                                    proyectosControlador.modificarRecompensa(proyectoBuscado, indice, atributo, valor);
                                                }
                                // ELIMINAR PROYECTO
                                //====================================================
                                                case 4 -> {
                                                    proyectosControlador.mostrarMensaje("", "\nSelecciona el ID del proyecto: ");
                                                    int idProyecto = sc.nextInt();
                                                    int posicion = proyectosControlador.buscarPosicion(idProyecto);
                                                    proyectosControlador.eliminarProyecto(posicion);
                                                    proyectosControlador.eliminarProyectoGestor(usuarioGestor, posicion);
                                                }
                                // SALIR
                                //====================================================
                                                case 5 -> {
                                                    usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MIS PROYECTOS.");
                                                    salirSubmenu2 = true;
                                                }
                                                default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                            }
                                        }

                                    }
                    // CREAR NUEVO PROYECTO
                    //====================================================
                                    case 2 -> {
                                        proyectosControlador.mostrarMensaje("","\nCrea un nuevo proyecto. \nIntroduce el nombre: ");
                                        String nombreProyecto = sc.nextLine();
                                        proyectosControlador.mostrarMensaje("","\nIntroduce la descripción: ");
                                        String descripcionProyecto = sc.nextLine();
                                        proyectosControlador.mostrarMensaje("","\nIntroduce la categoría (ARTE, TECNOLOGIA, CINE, COMIDA, MODA, JUEGOS): ");
                                        String categoriaTexto = sc.nextLine();
                                        Categoria categoria = proyectosControlador.getCategoria(categoriaTexto);
                                        proyectosControlador.mostrarMensaje("","\nIntroduce la fecha de creación (dd/MM/yyyy): ");
                                        String fechaTexto = sc.nextLine();
                                        LocalDate fechaInicio = FuncionesFechas.parsearFecha(fechaTexto);
                                        proyectosControlador.mostrarMensaje("", "\nIntroduce la fecha de finalización (dd/MM/yyyy): ");
                                        fechaTexto = sc.nextLine();
                                        LocalDate fechaFin = FuncionesFechas.parsearFecha(fechaTexto);
                                        proyectosControlador.mostrarMensaje("", "\nIntroduce el importe necesario para financiar el proyecto (€): ");
                                        float cantidadNecesaria = sc.nextFloat();
                                        sc.nextLine();
                                        Proyecto nuevoProyecto = new Proyecto(nombreProyecto, descripcionProyecto, categoria, fechaInicio, fechaFin, cantidadNecesaria, usuarioGestor);

                                        proyectosControlador.mostrarMensaje("", "\nCrea 3 recompensas para el proyecto. \nIntroduce la descripción de la recompensa 1: ");
                                        String descripcionRecompensa1 = sc.nextLine();
                                        proyectosControlador.mostrarMensaje("", "\nIntroduce el importe de la recompensa 1: ");
                                        float importeRecompensa1 = sc.nextFloat();
                                        sc.nextLine();
                                        Recompensa recompensa1 = new Recompensa(descripcionRecompensa1, importeRecompensa1);

                                        proyectosControlador.mostrarMensaje("", "\nIntroduce la descripción de la recompensa 2: ");
                                        String descripcionRecompensa2 = sc.nextLine();
                                        proyectosControlador.mostrarMensaje("", "\nIntroduce el importe de la recompensa 2: ");
                                        float importeRecompensa2 = sc.nextFloat();
                                        sc.nextLine();
                                        Recompensa recompensa2 = new Recompensa(descripcionRecompensa2, importeRecompensa2);

                                        proyectosControlador.mostrarMensaje("", "\nIntroduce la descripción de la recompensa 3: ");
                                        String descripcionRecompensa3 = sc.nextLine();
                                        proyectosControlador.mostrarMensaje("", "\nIntroduce el importe de la recompensa 3: ");
                                        float importeRecompensa3 = sc.nextFloat();
                                        sc.nextLine();
                                        Recompensa recompensa3 = new Recompensa(descripcionRecompensa3, importeRecompensa3);

                                        proyectosControlador.agregarRecompensa(nuevoProyecto, recompensa1);
                                        proyectosControlador.agregarRecompensa(nuevoProyecto, recompensa2);
                                        proyectosControlador.agregarRecompensa(nuevoProyecto, recompensa3);
                                        proyectosControlador.agregarProyecto(nuevoProyecto);
                                        usuariosControlador.agregarProyectoGestor(usuarioGestor, nuevoProyecto);
                                    }
                    // SALIR
                    //====================================================
                                    case 3 -> {
                                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MENÚ PRINCIPAL GESTOR");
                                        salirSubmenu = true;
                                    }
                                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                }
                            }
                        }
            // CONFIGURACIÓN
            //====================================================
                        case 2 -> {
                            boolean salirSubmenu = false;
                            while (!salirSubmenu) {
                                menusControlador.menuConfiguracion();
                                int opcion3 = sc.nextInt();
                                sc.nextLine();
                                switch (opcion3) {
                                    case 1 -> {
                                        usuariosControlador.mostrarMensaje("", "\nIntroduce tu nuevo nombre de usuario: ");
                                        String nuevoNombre = sc.nextLine();
                                        usuariosControlador.modificarUsuario(usuario, "nombre", nuevoNombre);
                                    }
                                    case 2 -> {
                                        usuariosControlador.mostrarMensaje("", "\nIntroduce tu nueva contraseña: ");
                                        String nuevaClave = sc.nextLine();
                                        usuariosControlador.modificarUsuario(usuario, "contraseña", nuevaClave);
                                    }
                                    case 3 -> {
                                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MENÚ PRINCIPAL GESTOR");
                                        salirSubmenu = true;
                                    }
                                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                }
                            }
                        }
            // CERRAR SESIÓN
            //====================================================
                        case 3 -> {
                            usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo al menú de inicio.");
                            salirMenu = true;
                            loginExitoso = false;
                        }
                        default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                    }
                }
        //============================================================
        // INVERSOR
        //============================================================
                else if (usuario instanceof Inversor) {
                    Inversor usuarioInversor = (Inversor) usuario;
                    menusControlador.menuPrincipalInversor();
                    int opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion2) {
                        case 1 -> {

                        }
                        case 2 -> {
                        }
                        case 3 -> {
                        }
            // INVITA A UN AMIGO
            //====================================================
                        case 4 -> {
                            boolean salirSubmenu = false;
                            while (!salirSubmenu) {
                                menusControlador.menuInvitaAmigo();
                                int opcion3 = sc.nextInt();
                                sc.nextLine();
                                switch (opcion3) {
                                    case 1 -> {
                                        usuariosControlador.mostrarListaAmigos(usuarioInversor);
                                    }
                                    case 2 -> {
                                        usuariosControlador.mostrarMensaje("", "Introduce el nombre del usuario que vas a invitar: ");
                                        String nombreUsuario = sc.nextLine();
                                        usuariosControlador.invitarAmigo(usuarioInversor, nombreUsuario);
                                    }
                                    case 3 -> {
                                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MENÚ PRINCIPAL INVERSOR");
                                        salirSubmenu = true;
                                    }
                                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                }
                            }
                        }
            // CONFIGURACIÓN
            //====================================================
                        case 5 -> {
                            boolean salirSubmenu = false;
                            while (!salirSubmenu) {
                                menusControlador.menuConfiguracion();
                                int opcion3 = sc.nextInt();
                                sc.nextLine();
                                switch (opcion3) {
                                    case 1 -> {
                                        usuariosControlador.mostrarMensaje("", "\nIntroduce tu nuevo nombre de usuario: ");
                                        String nuevoNombre = sc.nextLine();
                                        usuariosControlador.modificarUsuario(usuario, "nombre", nuevoNombre);
                                    }
                                    case 2 -> {
                                        usuariosControlador.mostrarMensaje("", "\nIntroduce tu nueva contraseña: ");
                                        String nuevaClave = sc.nextLine();
                                        usuariosControlador.modificarUsuario(usuario, "contraseña", nuevaClave);
                                    }
                                    case 3 -> {
                                        usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo a MENÚ PRINCIPAL INVERSOR");
                                        salirSubmenu = true;
                                    }
                                    default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                                }
                            }
                        }
                        case 6 -> {
                            usuariosControlador.mostrarMensaje(GestionUsuariosVista.VERDE, "Volviendo al menú de inicio.");
                            salirMenu = true;
                            loginExitoso = false;
                        }
                        default -> usuariosControlador.mostrarMensaje(GestionUsuariosVista.ROJO, "Error: El valor introducido no es válido");
                    }
                }
            }
        }
    }
}

