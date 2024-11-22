import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String usuarioLogin,contraseniaLogin;
        int contadorIntentos=0, intentos=2;
        String usuarioAdmin = "pepito123", contraseniaAdmin = "12345";
        String usuarioGestor = "tornaceitor", contraseniaGestor = "54321";
        String usuarioNPC1 = "soyunnpc1", contraseniaNPC1 = "6969";
        String usuarioNPC2 = "npcsisoy", contraseniaNPC2 = "9696";
        boolean admin=false, gestor=false, inversor=false;
        boolean registroCompleto=false;

        Scanner lecturaDatos = new Scanner(System.in);

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

        int tipoUsuario = lecturaDatos.nextInt();

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

        // PROYECTOS

        int numeroProyecto = 0, numeroRecompensa = 0;
        String nombreProyecto = "", descripcionProyecto = "", categoriaProyecto = "", recompensaDescripcion = "";
        float cantidadNecesaria = 0, cantidadFinanciada = 0, cantidadAportada = 0, recompensaPrecio = 0;
        LocalDate fechaInicio = LocalDate.now(), fechaFin = LocalDate.now();

        // Creación de proyecto - Gestor

        if (gestor) {

            while (numeroProyecto < 4) {
                System.out.println("¿Quieres crear un nuevo proyecto? (S/N)");
                String creaProyecto = lecturaDatos.nextLine().toLowerCase();

                if (creaProyecto.equals("s")) {
                    numeroProyecto++;
                    if (numeroProyecto >= 4) System.out.println("No se pueden crear más proyectos");
                    System.out.println("Escribe el nombre de tu proyecto");
                    nombreProyecto = lecturaDatos.nextLine();
                    System.out.println("Escribe una descripción:");
                    descripcionProyecto = lecturaDatos.nextLine();
                    System.out.println("Introduce la categoría a la que pertenece");
                    categoriaProyecto = lecturaDatos.nextLine();
                    System.out.println("Introduce la cantidad de dinero necesaria");
                    cantidadNecesaria = lecturaDatos.nextFloat();
                    System.out.println("Introduce la cantidad invertida actualmente");
                    cantidadFinanciada = lecturaDatos.nextFloat();
                    System.out.println("Introduce la fecha en la que se abrirá la recaudación");
                    fechaInicio = LocalDate.parse(lecturaDatos.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    System.out.println("Introduce la fecha de cierre de recaudaciones");
                    fechaFin = LocalDate.parse(lecturaDatos.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    while (numeroRecompensa < 4) {
                        System.out.println("¿Quieres añadir una recompensa? (S/N)");
                        String creaRecompensa = lecturaDatos.nextLine().toLowerCase();
                        if (creaRecompensa.equals("s")){
                            numeroRecompensa++;
                            if (numeroRecompensa >= 4) System.out.println("No se pueden crear más recompensas");

                        }
                    }
                }
            }
            // Menú gestor
                int seleccionGestor;
                do {
                    System.out.println("""
                            1. Mis proyectos
                            2. Configuración
                            3. Cerrar sesión""");

                    seleccionGestor = lecturaDatos.nextInt();
                }
                while (seleccionGestor < 1 || seleccionGestor > 3);

                switch (seleccionGestor) {
                    case 1:
                    case 2:
                    case 3:
                    default:
                        System.out.println("Has introducido un valor incorrecto.");
                }


        }
            //Menu inversor

            if (inversor) {
                int seleccionInversor;
                do {
                    System.out.println("""
                            1. Mis inversiones
                            2. Proyectos
                            3. Cartera digital
                            4. Invita a un amigo
                            5. Configuración
                            6. Cerrar sesión""");

                    seleccionInversor = lecturaDatos.nextInt();
                }
                while (seleccionInversor < 1 || seleccionInversor > 6);

                switch (seleccionInversor) {
                    case 1:
                    case 2:
                        System.out.println("Nombre: " + nombreProyecto);
                        System.out.println("Descripción: " + descripcionProyecto);
                        System.out.println("Categoría: " + categoriaProyecto);
                        System.out.println("Cantidad necesaria: " + cantidadNecesaria);
                        System.out.println("Cantidad aportada: " + cantidadAportada);
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    default:
                        System.out.println("Has introducido un valor incorrecto.");
                }
            }

            System.out.println("Fecha de apertura para recibir inversiones: " + fechaInicio);
            System.out.println("Fecha de apertura para recibir inversiones: " + fechaInicio);
            System.out.println("Fecha de cierre de inversiones: " + fechaFin);
            System.out.println(": " + fechaInicio);



    }
}
