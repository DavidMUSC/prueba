package aplicacion;
import  baseDatos.*;
import  gui.*;
public class gestionOyentes {
    fachadaGui fgui;
    fachadaBaseDatos fbd;
    boolean admin;

    public gestionOyentes(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
        admin = false;
    }
    public boolean comprobarAutentificacion(String nombre, String contrasena){
        Oyente o;
        o=fbd.validarUsuario(nombre, contrasena);
        return o != null;
    }
}