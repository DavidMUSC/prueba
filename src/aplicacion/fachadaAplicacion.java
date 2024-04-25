package aplicacion;
import gui.VCrearPlaylist;

import java.awt.*;
import java.util.List;

public class fachadaAplicacion {
    gui.fachadaGui fgui;
    baseDatos.fachadaBaseDatos fbd;

    //Atributos gestion
    gestionOyentes go;
    gestionArtista ga;
    gestionAdministrador gadmin;
    gestionPlaylist gp;
    gestionPodcast gpo;
    gestionAlbum gal;
    gestionCancion gc;

    public fachadaAplicacion(){
        fgui=new gui.fachadaGui(this);
        fbd= new baseDatos.fachadaBaseDatos(this);
        //inicializar gestiones
        go = new gestionOyentes(fgui,fbd);
        ga = new gestionArtista(fgui,fbd);
        gadmin = new gestionAdministrador(fgui,fbd);
        gp = new gestionPlaylist(fgui,fbd);
        gpo = new gestionPodcast(fgui, fbd);
        gal = new gestionAlbum(fgui, fbd);
        gc = new gestionCancion(fgui, fbd);
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
    public void muestraCrearPlaylist(Frame owner, fachadaAplicacion fa, int op, String usuarioActual){
        fgui.muestraCrearPlaylist(owner,fa,op,usuarioActual);
    }
    public void muestraExcepcion(String e){

        fgui.muestraExcepcion(e);
    }
    public void muestraBuscar(int op, String usuarioActual){
        fgui.muestraBuscar(this,op, usuarioActual);
    }
    public void muestraBiblioteca(int op, String usuarioActual) {
        fgui.muestraBiblioteca(op, usuarioActual);
    }
    public void muestraPrincipal(int op, String usuarioActual){
        fgui.muestraPrincipal(op, usuarioActual );
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
    public List<Artista> buscarArtistas(String terminoBusqueda){
        return ga.buscarArtistas(terminoBusqueda);
    }

    //FUNCIONES ADMIN
    public Administrador comprobarAutentificacionAdministrador(String nombre, String contrasena){
        return gadmin.comprobarAutentificacionAdministrador(nombre, contrasena);
    }

    //FUNCIONES PLAYLIST
    public void registrarPlaylist(String nombre, String usuario) {
        gp.registrarPlaylist(nombre,usuario);
    }

    public List<Playlist> buscarPlaylists(String terminoBusqueda){
        return gp.buscarPlaylists(terminoBusqueda);
    }

    public List<Elemento> buscarPlaylistsUsuario(String nombreUsuario){
        return gp.buscarPlaylistsUsuario(nombreUsuario);
    }
    public int buscarIDPlaylists(String terminoBusqueda,String usuario) {
        return gp.buscarIDPlaylists(terminoBusqueda,usuario);
    }
    public void insertarCancionEnPlaylist(String nombreCancion,int IDPlaylist){
        fbd.insertarCancionEnPlaylist(nombreCancion,IDPlaylist);
    }

    //FUNCIONES CANCION
    public List<Cancion> buscarCanciones(String terminoBusqueda){
        return gc.buscarCanciones(terminoBusqueda);
    }

    public String obtenerArtistaDeCancion(String nombreCancion){
        return gc.obtenerArtistaDeCancion(nombreCancion);
    }

    //FUNCIONES ALBUM
    public List<Album> buscarAlbum(String terminoBusqueda){
        return gal.buscarAlbumes(terminoBusqueda);
    }

    public String obtenerArtistaDeAlbum(String nombreAlbum){
        return gal.obtenerArtistaDeAlbum(nombreAlbum);
    }

    //FUNCIONES PODCAST
    public List<Podcast> buscarPodcasts(String terminoBusqueda){
        return gpo.buscarPodcasts(terminoBusqueda);
    }

    public String obtenerArtistaDePodcast(String nombrePodcast){
        return gpo.obtenerArtistaDePodcast(nombrePodcast);
    }

}
