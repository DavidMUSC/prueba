package aplicacion;

import java.awt.*;

public class fachadaAplicacion {
    gui.fachadaGui fgui;
    baseDatos.fachadaBaseDatos fbd;
    gestionOyentes go;
    public fachadaAplicacion(){
        fgui=new gui.fachadaGui(this);
        fbd= new baseDatos.fachadaBaseDatos(this);
        go = new gestionOyentes(fgui,fbd);
    }
    public static void main(String args[]) {

        fachadaAplicacion fa;
        fa= new fachadaAplicacion();
        fa.iniciaInterfazUsuario();

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        System.out.println("Fuentes disponibles en tu sistema:");
        for (String font : fonts) {
            System.out.println(font);
        }
    }

    public void iniciaInterfazUsuario(){
        fgui.iniciaVista();
    }

    public void muestraExcepcion(String e){
        //TODO: implementar mostrar excepcion
        //fgui.muestraExcepcion(e);
    }

    public boolean comprobarAutentificacion(String nombre, String contrasena){
        return go.comprobarAutentificacion(nombre, contrasena);
    }
}
