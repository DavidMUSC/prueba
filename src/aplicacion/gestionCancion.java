package aplicacion;

import baseDatos.fachadaBaseDatos;
import gui.fachadaGui;
import java.util.List;

public class gestionCancion {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionCancion(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    public List<Cancion> buscarCanciones(String terminoBusqueda){
        return fbd.buscarCanciones(terminoBusqueda);
    }
    public void valorarCancion(String usuarioActual,int cancion,int valor){
        fbd.valorarCancion(usuarioActual,cancion,valor);
    }

    public String obtenerArtistaDeCancion(String nombreCancion){
        return fbd.obtenerArtistaDeCancion(nombreCancion);
    }

    public void publicarCancion(Cancion cancion, int IDAlbum){
        fbd.publicarCancion(cancion, IDAlbum);
    }

}
