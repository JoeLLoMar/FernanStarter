package modelo;

public class UsuarioInvitado extends Usuario{
    public UsuarioInvitado() {
        super("invitado", "", "invitado");
    }

    public String getTipo() {
        return "Invitado";
    }
}
