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

    // Método para agregar una lista completa al modelo
    //@Override
    public void agregarLista(List<String> nuevaLista) {
        int sizeAnterior = lista.size();
        lista.addAll(nuevaLista);
        fireIntervalAdded(this, sizeAnterior, lista.size() - 1);
    }
}
