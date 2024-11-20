import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String opcionLogin;
        System.out.println("Bienvenido a FernanStarter");
        System.out.println();
        //Menú de log-in
        Scanner lecturaDatos = new Scanner(System.in);
        do{
            System.out.println("Para salir del programa, escribe SALIR");
            System.out.println("1.-Introduce usuario ");
            opcionLogin = lecturaDatos.nextLine().toLowerCase();
        }while(opcionLogin != "salir");
    }
}
