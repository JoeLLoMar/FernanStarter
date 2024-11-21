import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String usuarioLogin,contraseniaLogin;
        int contadorIntentos=0, intentos=2;
        String usuarioAdmin = "pepito123", contraseniaAdmin = "12345";
        boolean admin=false;
        String usuarioGestor = "tornaceitor", contraseniaGestor = "54321";
        boolean gestor=false;
        String usuarioNPC1 = "soyunnpc1", contraseniaNPC1 = "6969";
        String usuarioNPC2 = "npcsisoy", contraseniaNPC2 = "9696";
        boolean inversor=false;
        boolean registroCompleto=false;
        int tipoUsuario = 0;
        System.out.println("----------------------------");
        System.out.println("¡Bienvenido a FernanStarter!");
        System.out.println("----------------------------");
        System.out.println();

        //Elección de perfil de usuario
        System.out.println("""
                Inicia sesión:
                1. Como administrador
                2. Como gestor
                3. Como inversor""");


        switch (tipoUsuario) {
            case 1:
                admin = true;
                break;
            case 2:
                gestor = true;
                break;
            case 3:
                inversor = true;
                break;
            default:
                System.out.println("Error");
                break;
        }

        //Menú de log-in
        Scanner lecturaDatos = new Scanner(System.in);
        do{
            if (contadorIntentos<3){
                System.out.println();
                System.out.println("Para salir del programa, escribe SALIR");
                System.out.println("--------------------------------------");
                System.out.println("1.-Introduce usuario ");
                usuarioLogin = lecturaDatos.nextLine().toLowerCase();
                if (usuarioLogin.equalsIgnoreCase("salir")) break;
                System.out.println("2.-Introduce la contraseña");
                contraseniaLogin = lecturaDatos.nextLine().toLowerCase();
                if (contraseniaLogin.equalsIgnoreCase("salir")) break;

                if ((usuarioLogin.equalsIgnoreCase(usuarioAdmin) && contraseniaLogin.equalsIgnoreCase(contraseniaAdmin)) ||
                        (usuarioLogin.equalsIgnoreCase(usuarioGestor) && contraseniaLogin.equalsIgnoreCase(contraseniaGestor)) ||
                        (usuarioLogin.equalsIgnoreCase(usuarioNPC1) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC1)) ||
                        (usuarioLogin.equalsIgnoreCase(usuarioNPC2) && contraseniaLogin.equalsIgnoreCase(contraseniaNPC2))) {
                    registroCompleto = true;
                    System.out.println("Inicio de sesión exitoso, bienvenido " + usuarioLogin + ".");
                }else if(contadorIntentos<3) {
                    System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo, le quedan " + intentos-- + " intentos.");
                    contadorIntentos++;
                }
            }else{
                break;
            }
        } while (!registroCompleto);
    }
}
