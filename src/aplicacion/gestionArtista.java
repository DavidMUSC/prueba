package aplicacion;
import baseDatos.*;
import gui.*;

public class gestionArtista {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionArtista(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public boolean comprobarAutentificacion(String nombre, String contrasena){
        Artista a;
        a=fbd.validarUsuario(nombre, contrasena);
        return a != null;
    }


}
