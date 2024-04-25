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

    public void muestraBuscar(fachadaAplicacion fa,int op, String usuarioActual){
        VBuscar vb;
        vb = new VBuscar(fa,op, usuarioActual);
        vb.setVisible(true);
    }
    public void muestraCrearPlaylist(Frame owner, fachadaAplicacion fa,int op, String usuarioActual){
        VCrearPlaylist vcp = new VCrearPlaylist(owner,fa,usuarioActual);
        vcp.setVisible(true);
    }

    public void muestraPrincipal(int op,String usuarioActual ){
        VPrincipal va;
        va = new VPrincipal(fa,op, usuarioActual);
        va.setVisible(true);
    }

    public void muestraBiblioteca(int op, String usuarioActual) {
        VBiblioteca vb;
        vb= new VBiblioteca(fa,op, usuarioActual);
        vb.setVisible(true);
    }

    public void muestraPublicar(String usuarioActual) {
        VPublicar vp;
        vp = new VPublicar(fa, usuarioActual);
        vp.setVisible(true);
    }
}
