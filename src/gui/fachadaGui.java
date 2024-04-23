package gui;

import java.awt.*;
import aplicacion.*;

public class fachadaGui {
    aplicacion.fachadaAplicacion fa;


    public fachadaGui(aplicacion.fachadaAplicacion fa){
        this.fa=fa;
        //this.vp = new VPrincipal(fa);
    }

    public void iniciaVista(){
        VAutentificacion va;

        va = new VAutentificacion(fa);
        va.setVisible(true);
    }

    public void muestraExcepcion(String e){
        VAviso v;
        v = new VAviso(e);
        v.setVisible(true);
    }

    public void muestraBuscar(fachadaAplicacion fa,int op){
        VBuscar vb;
        vb = new VBuscar(fa,op);
        vb.setVisible(true);
    }
    public void muestraPrincipal(int op){
        VPrincipal va;
        va = new VPrincipal(fa,op);
        va.setVisible(true);
    }

    public void muestraBiblioteca(int op) {
        VBiblioteca vb;
        vb= new VBiblioteca(fa,op);
        vb.setVisible(true);
    }
}
