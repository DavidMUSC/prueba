package aplicacion;

public class fachadaAplicacion {
    gui.fachadaGui fgui;
    baseDatos.fachadaBaseDatos fbd;
    public fachadaAplicacion(){
        fgui=new gui.fachadaGui(this);
        // fbd= new baseDatos.fachadaBaseDatos(this);
    }
    public static void main(String args[]) {

        fachadaAplicacion fa;
        fa= new fachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario(){
        fgui.iniciaVista();
    }

    public void muestraExcepcion(String e){
        //TODO: implementar mostrar excepcion
        //fgui.muestraExcepcion(e);
    }
}
