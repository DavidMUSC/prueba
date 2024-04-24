package aplicacion;

import baseDatos.fachadaBaseDatos;
import gui.fachadaGui;
import java.util.List;

public class gestionPodcast {
    fachadaGui fgui;
    fachadaBaseDatos fbd;

    public gestionPodcast(fachadaGui fgui, fachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public List<Podcast> buscarPodcasts(String terminoBusqueda){
        return fbd.buscarPodcasts(terminoBusqueda);
    }
}