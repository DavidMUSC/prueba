package gui;

import java.awt.*;

public class fachadaGui {
    aplicacion.fachadaAplicacion fa;
    VPrincipal vp;

    public fachadaGui(aplicacion.fachadaAplicacion fa){
        this.fa=fa;
        this.vp = new VPrincipal(fa);
    }

    public void iniciaVista(){
        VAutentificacion va;

        va = new VAutentificacion(vp, fa);
        vp.setVisible(true);
        va.setVisible(true);
    }
}
