package Utilidades;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class EnviarCorreo {

    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        String remitente = "alejandro.vergara.0512@fernando3martos.com";
        String clave = "rgcw usrh ttma esmj";
        // Propiedades de la conexión que se va a establecer con el servidor de correo SMTP
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); // Conectar de manera segura
        props.put("mail.smtp.port", "587"); // Puerto SMTP seguro de Google
        // Se obtiene la sesión en el servidor de correo
        Session session = Session.getDefaultInstance(props);
        try {
            // Creación del mensaje a enviar
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            //message.setText(cuerpo); // Para enviar texto plano
            message.setContent(cuerpo, "text/html; charset=utf-8"); // Para enviar html
            // Definición de los parámetros del protocolo de transporte
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception me) {
            me.printStackTrace();
        }
    }

    public static Boolean RegistroCorreo(String[] usuarios,String[] contrasenias, String usuario, String contrasenia) {
        int codigoUsuario=0;
        int codigo= (int) (Math.random()*9999 )+1;
        String correoUsuario;
        Scanner lecturaDatos = new Scanner(System.in);

        for(int i=0; i<usuarios.length;i++){
            if (usuarios[i].equalsIgnoreCase(usuario) && contrasenias[i].equalsIgnoreCase(contrasenia)){
                System.out.println("Se va a proceder a hacer una comprobación por email para verificar la integridad de su cuenta");
                System.out.println("Introduce correo de usuario");
                correoUsuario = lecturaDatos.nextLine();
                String destinatario = correoUsuario; // Destinatario del mensaje
                String asunto = "Código de verificación FernanStarter";
                String cuerpo = "<h1>Automáticamente se ha solicitado un código de verificación a este gmail para comprobar que usted sea un usuario real.</h1>" +
                        "<p>Código: </p>" + codigo;
                enviarConGMail(destinatario, asunto, cuerpo);
                System.out.println("Introduce el código de verificación");
                codigoUsuario = Integer.parseInt(lecturaDatos.nextLine());
                if(codigoUsuario == codigo){
                    System.out.println("Credenciales correctos.");
                    System.out.println();
                    return true;
                }
            } else {
                System.out.println("Credenciales incorrectos");
                break;
            }
        }
        return false;
    }
}
