package aplicacion;

import baseDatos.fachadaBaseDatos;
import gui.fachadaGui;
import java.util.List;

public class gestionAlbum {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionAlbum(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    public List<Album> buscarAlbumes(String terminoBusqueda){
        return fbd.buscarAlbumes(terminoBusqueda);
    }

    public String obtenerArtistaDeAlbum(String nombreAlbum){
        return fbd.obtenerArtistaDeAlbum(nombreAlbum);
    }
    public int publicarAlbum(Album album, int IDDiscografica, String IDArtista){
        return fbd.publicarAlbum(album, IDDiscografica, IDArtista);
    }
    public int obtenerIDnuevo() {
        return fbd.obtenerIDnuevo();
    }
}
