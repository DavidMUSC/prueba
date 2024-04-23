package aplicacion;
import baseDatos.*;
import gui.*;

public class gestionAdministrador {
    fachadaGui fgui;
    fachadaBaseDatos fbd;


    public gestionAdministrador(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;

    }

    public Administrador comprobarAutentificacionAdministrador(String nombre, String contrasena){
        Administrador a;
        a=fbd.validarAdministrador(nombre, contrasena);
        return a;
    }
}
