package aplicacion;

public class fachadaAplicacion {
    gui.fachadaGui fgui;
    baseDatos.fachadaBaseDatos fbd;

    //Atributos gestion
    gestionOyentes go;
    gestionArtista ga;
    gestionAdministrador gadmin;

    public fachadaAplicacion(){
        fgui=new gui.fachadaGui(this);
        fbd= new baseDatos.fachadaBaseDatos(this);
        //inicializar gestiones
        go = new gestionOyentes(fgui,fbd);
        ga = new gestionArtista(fgui,fbd);
        gadmin = new gestionAdministrador(fgui,fbd);
    }
    public static void main(String args[]) {

        fachadaAplicacion fa;
        fa= new fachadaAplicacion();
        fa.iniciaInterfazUsuario();

        /*String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        System.out.println("Fuentes disponibles en tu sistema:");
        for (String font : fonts) {
            System.out.println(font);
        }*/
    }

    //FUNCIONES GUI
    public void iniciaInterfazUsuario(){
        fgui.iniciaVista();
    }

    public void muestraExcepcion(String e){

        fgui.muestraExcepcion(e);
    }

    public void muestraBuscar(int op){
        fgui.muestraBuscar(this,op);
    }
    public void muestraPrincipal(int op){
        fgui.muestraPrincipal(op);
    }

    //FUNCIONES OYENTES
    public Oyente comprobarAutentificacionOyente(String nombre, String contrasena){
        return go.comprobarAutentificacionOyente(nombre, contrasena);
    }

    public void registrarOyente(String usuario, String correo, String contrasena, String fechaNacimiento) {
        go.registrarOyente(usuario, correo, contrasena, fechaNacimiento);
    }

    //FUNCIONES ARTISTAS
    public Artista comprobarAutentificacionArtista(String nombre, String contrasena){
        return  ga.comprobarAutentificacionArtista(nombre, contrasena);
    }

    //FUNCIONES ADMIN
    public Administrador comprobarAutentificacionAdministrador(String nombre, String contrasena){
        return gadmin.comprobarAutentificacionAdministrador(nombre, contrasena);
    }
}
