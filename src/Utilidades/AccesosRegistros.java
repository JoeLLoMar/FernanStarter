package Utilidades;

import java.util.Scanner;
/**
 * Clase con funciones relacinadas con el login y los registros de usuario.
 *
 * @author Alejandro Vergara Pozo, José Luis López Martos
 * @version 1.0
 * @since 3.0
 */
import static Utilidades.EnviarCorreo.RegistroCorreo;

public class AccesosRegistros {


    /**
     * Gestiona el estado de bloqueo de los usuarios y permite desbloquearlos según la elección del administrador.
     *
     * @param usuarioGestorBlocked Estado inicial del bloqueo del usuario gestor.
     * @param usuarioNPC1Blocked Estado inicial del bloqueo del usuario inversor 1.
     * @param usuarioNPC2Blocked Estado inicial del bloqueo del usuario inversor 2.
     * @since 3.0
     */
    public static void usuariosBloqueados(boolean usuarioGestorBlocked,boolean usuarioNPC1Blocked, boolean usuarioNPC2Blocked){
        String usuarioGestor="tornaceitor", usuarioNPC1="soyunnpc1", usuarioNPC2="npcsisoy";
        usuarioGestorBlocked=usuarioGestorBlocked;
        usuarioNPC1Blocked=usuarioNPC1Blocked;
        usuarioNPC2Blocked=usuarioNPC2Blocked;
        Scanner lecturaDatos = new Scanner(System.in);

        System.out.println("Lista de usuarios bloqueados");
        if(usuarioGestorBlocked) System.out.println("1. Usuario gestor: " + usuarioGestor + " está bloqueado");
        else System.out.println("1. Usuario gestor: " + usuarioGestor + " NO está bloqueado");
        if(usuarioNPC1Blocked) System.out.println("2. Usuario inversor 1: " + usuarioNPC1 + " está bloqueado");
        else System.out.println("2. Usuario inversor 1: " + usuarioNPC1 + " NO está bloqueado");
        if(usuarioNPC2Blocked) System.out.println("3. Usuario inversor 2: " + usuarioNPC2 + " está bloqueado");
        else System.out.println("3. Usuario inversor 2: " + usuarioNPC2 + " NO está bloqueado");
        int eleccionDesbloqueo = Integer.parseInt(lecturaDatos.nextLine());

        switch(eleccionDesbloqueo){
            case 1:
                if(usuarioGestorBlocked){
                    usuarioGestorBlocked=false;
                    System.out.println("Usuario desbloqueado con éxito.");
                }
                else System.out.println("Error, no se puede desbloquear un usuario ya desbloqueado");
                break;
            case 2:
                if(usuarioNPC1Blocked){
                    usuarioNPC1Blocked=false;
                    System.out.println("Usuario desbloqueado con éxito.");
                }
                else System.out.println("Error, no se puede desbloquear un usuario ya desbloqueado");
                break;
            case 3:
                if(usuarioNPC2Blocked){
                    usuarioNPC2Blocked=false;
                    System.out.println("Usuario desbloqueado con éxito.");
                }
                else System.out.println("Error, no se puede desbloquear un usuario ya desbloqueado");
                break;
        }
    }

    /**
     * Permite iniciar sesión como administrador verificando las credenciales predefinidas.
     * Proporciona acceso solo si el usuario y la contraseña coinciden con los valores almacenados.
     *
     * @since 3.0
     */
    public static void registroAdmin(){
        //Variables log-in (admin)
        String usuarioLogin="", contraseniaLogin="";
        String usuarioAdmin = "pepito123", contraseniaAdmin = "12345";
        boolean registroAdmin = false;
        boolean admin = false;
        Scanner lecturaDatos = new Scanner(System.in);

        System.out.println();
        System.out.println("Usted ha elegido ingresar como administrador.");
        System.out.println();
        do {
            System.out.println("Para salir del programa, escribe SALIR");
            System.out.println("--------------------------------------");
            System.out.println("1.-Introduce usuario ");
            usuarioLogin = lecturaDatos.nextLine().toLowerCase();
            if (usuarioLogin.equalsIgnoreCase("salir")) break;
            System.out.println("2.-Introduce la contraseña");
            contraseniaLogin = lecturaDatos.nextLine().toLowerCase();
            if (contraseniaLogin.equalsIgnoreCase("salir")) break;

            if ((usuarioLogin.equalsIgnoreCase(usuarioAdmin) && contraseniaLogin.equalsIgnoreCase(contraseniaAdmin))) {
                registroAdmin = true;
                System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                admin=true;
            }
            else{
                System.out.println("Credenciales incorrectos, pruebe de nuevo.");
                System.out.println();
                continue;
            }
            break;
        } while (!registroAdmin);
    }

    /**
     * Permite iniciar sesión como gestor verificando las credenciales predefinidas.
     * Bloquea al usuario tras tres intentos fallidos consecutivos.
     *
     * @since 3.0
     */
    public static void registroGestor(){
        //Variables log-in gestor
        String usuarioLogin="", contraseniaLogin="";
        boolean usuarioGestorBlocked=false;
        int contadorIntentos = 0, intentos = 2;;
        boolean registroGestor = false;
        String[] nombresGestores = new String[10];
        nombresGestores[0]="tornaceitor";
        nombresGestores[1]="toranceitor";
        nombresGestores[2]="ElXokas";
        nombresGestores[3]="M.Rajoy";
        nombresGestores[4]="Guts";
        String[] contraseniasGestores = new String[10];
        contraseniasGestores[0]="0000";
        contraseniasGestores[1]="1111";
        contraseniasGestores[2]="2222";
        contraseniasGestores[3]="3333";
        contraseniasGestores[4]="4444";
        Scanner lecturaDatos = new Scanner(System.in);

        if (usuarioGestorBlocked) {
            System.out.println("Este usuario ha sido bloqueado por el administrador.");
            return;
        } else {
            System.out.println();
            System.out.println("Usted ha elegido ingresar como gestor.");
            do {
                if (contadorIntentos < 3) {
                    System.out.println();
                    System.out.println("Para salir del programa, escribe SALIR");
                    System.out.println("--------------------------------------");
                    System.out.println("1.-Introduce usuario ");
                    usuarioLogin = lecturaDatos.nextLine().toLowerCase();
                    if (usuarioLogin.equalsIgnoreCase("salir")) break;
                    System.out.println("2.-Introduce la contraseña");
                    contraseniaLogin = lecturaDatos.nextLine().toLowerCase();
                    if (contraseniaLogin.equalsIgnoreCase("salir")) break;

                    if (RegistroCorreo(nombresGestores,contraseniasGestores,usuarioLogin,contraseniaLogin)) {
                        registroGestor = true;
                        System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                    } else if (contadorIntentos < 3) {
                        System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo, le quedan " + intentos-- + " intentos.");
                        contadorIntentos++;
                    }
                } else {
                    System.out.println();
                    System.out.println("Intentos agotados, usuario bloqueado.");
                    usuarioGestorBlocked=true;
                    break; //Agotas intentos y te manda al inicio del login gestor
                }
            } while (!registroGestor);
            contadorIntentos=0;
            // Te lleva a la creación de Proyectos
        }
    }
    /**
     * Permite iniciar sesión como inversor verificando las credenciales predefinidas.
     * Bloquea a los usuarios tras tres intentos fallidos consecutivos.
     * Gestiona dos usuarios inversores con credenciales diferentes.
     *
     * @since 3.0
     */
    public static void registroInversor(){
        String usuarioLogin="", contraseniaLogin="";
        int contadorIntentos = 0, intentos = 2;
        String usuarioNPC1 = "soyunnpc1", contraseniaNPC1 = "6969";
        String usuarioNPC2 = "npcsisoy", contraseniaNPC2 = "9696";
        String[] nombresInversores = new String[10];
        nombresInversores[0]="Pepito";
        nombresInversores[1]="Npc";
        nombresInversores[2]="Cr7";
        nombresInversores[3]="Messi";
        nombresInversores[4]="Chicote";
        String[] contraseniasInversores = new String[10];
        contraseniasInversores[0]="0000";
        contraseniasInversores[1]="1111";
        contraseniasInversores[2]="2222";
        contraseniasInversores[3]="3333";
        contraseniasInversores[4]="4444";
        boolean  usuarioNPC1Blocked=false, usuarioNPC2Blocked=false, registroInversor = false, npc1=false,npc2=false;
        Scanner lecturaDatos = new Scanner(System.in);

        if (usuarioNPC1Blocked && (usuarioLogin.equalsIgnoreCase(usuarioNPC1) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC1))) {
            System.out.println("Este usuario ha sido bloqueado por el administrador.");
            return;
        } else if (usuarioNPC2Blocked && (usuarioLogin.equalsIgnoreCase(usuarioNPC2) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC2))) {
            System.out.println("Este usuario ha sido bloqueado por el administrador.");
            return;
        } else {
            System.out.println();
            System.out.println("Usted ha elegido ingresar como inversor.");
            do {
                if (contadorIntentos < 3) {
                    System.out.println();
                    System.out.println("Para salir del programa, escribe SALIR");
                    System.out.println("--------------------------------------");
                    System.out.println("1.-Introduce usuario ");
                    usuarioLogin = lecturaDatos.nextLine().toLowerCase();
                    if (usuarioLogin.equalsIgnoreCase("salir")) break;
                    System.out.println("2.-Introduce la contraseña");
                    contraseniaLogin = lecturaDatos.nextLine().toLowerCase();
                    if (contraseniaLogin.equalsIgnoreCase("salir")) break;

                    if ((usuarioLogin.equalsIgnoreCase(usuarioNPC1) && usuarioNPC1Blocked) ||
                            (usuarioLogin.equalsIgnoreCase(usuarioNPC2) && usuarioNPC2Blocked)) {
                        System.out.println("Este usuario ha sido bloqueado por el administrador.");
                        break;
                    }
                    if(RegistroCorreo(nombresInversores,contraseniasInversores,usuarioLogin,contraseniaLogin)){
                        System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                        registroInversor=true;
                    } else if (contadorIntentos < 3) {
                        System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo, le quedan " + intentos-- + " intentos.");
                        contadorIntentos++;
                    }

                } else {
                    System.out.println();
                    System.out.println("Intentos agotados, usuario bloqueado.");
                    usuarioNPC1Blocked=true;
                    usuarioNPC2Blocked=true;
                    break; //Agotas intentos y te manda al inicio del login gestor
                }
            } while (!registroInversor);
            contadorIntentos=0;
            return;
        }
    }
}
