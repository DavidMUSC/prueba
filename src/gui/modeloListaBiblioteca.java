package gui;

import aplicacion.Elemento;

import java.util.*;


public class modeloListaBiblioteca extends javax.swing.AbstractListModel {

    private List<String> lista;

    public modeloListaBiblioteca(){
        this.lista=new java.util.ArrayList<String>();
    }
    @Override
    public int getSize() {
        return lista.size();
    }


    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }
}
