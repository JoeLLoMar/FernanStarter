package controlador;

import modelo.*;

public class GestionInversionesControlador {
    public boolean invertir(String nombreInversor, String nombreProyecto, float cantidad) {
        Usuario usuario = RegistroUsuarios.getUsuarios().get(nombreInversor);

        if (usuario instanceof Inversor inversor) {
            Proyecto proyecto = RegistroProyectos.getProyecto(nombreProyecto);
            if (proyecto == null) {
                return false;
            }

            Inversion inversion = new Inversion(proyecto,cantidad,inversor);
            RegistroInversiones.registrarInversion(inversion);
            return true;
        }

        return false;
    }
}
