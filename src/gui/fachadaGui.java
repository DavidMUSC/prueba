package gui;

public class fachadaGui {
    aplicacion.fachadaAplicacion fa;

    public fachadaGui(aplicacion.fachadaAplicacion fa){
        this.fa=fa;
        //this.vp = new VPrincipal(fa);
    }

    public void iniciaVista(){
        VAutentificacion va;

        va = new VAutentificacion(fa);
        //vp.setVisible(true);
        va.setVisible(true);
    }
}
