package aplicacion;
import  baseDatos.*;
import  gui.*;

import java.util.List;

public class gestionPlaylist {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionPlaylist(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void registrarPlaylist(String nombre, String usuario) {
        fbd.registrarPlaylist(nombre,usuario);
    }

    public List<Playlist> buscarPlaylists(String terminoBusqueda){
        return fbd.buscarPlaylists(terminoBusqueda);
    }

    public List<Playlist> buscarPlaylistsUsuario(String nombreUsuario){
        return fbd.buscarPlaylistsUsuario(nombreUsuario);
    }
}