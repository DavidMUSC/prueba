/*
 * Created by JFormDesigner on Thu Apr 25 12:26:21 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;

import aplicacion.Album;
import aplicacion.Discografica;
import aplicacion.fachadaAplicacion;


/**
 * @author Uni
 */
public class VPublicar extends JFrame {
    fachadaAplicacion fa;
    String usuarioActual;
    Album albumActual;
    boolean flagDisco;


    public VPublicar(fachadaAplicacion fa, String usuarioActual) {
        this.fa = fa;
        this.usuarioActual = usuarioActual;
        this.flagDisco = false;
        this.albumActual =null;
        initComponents();
        //poner botones bttNuevaCancion y bttGuardar a false
        bttNuevaCancion.setEnabled(false);
        bttGuardar.setEnabled(false);
    }

    private void bttBuscar(ActionEvent e) {
        fa.muestraBuscar(2, usuarioActual);
        this.dispose();
    }

    private void bttBiblioteca(ActionEvent e) {
        fa.muestraBiblioteca(2, usuarioActual);
        this.dispose();
    }

    private void bttPublicar(ActionEvent e) {

    }

    private void createUIComponents() {
        tipo = new JComboBox();
        tipo.addItem("EP");
        tipo.addItem("Album");
        tipo.addItem("Single");
        //el color de fondo de la pestaña es #00d856
        tipo.setBackground(new Color(0, 216, 86));
        // Configuración del color de selección a un verde más oscuro
        tipo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    c.setBackground(new Color(0, 153, 76)); // Un verde más oscuro, #00994C
                    c.setForeground(Color.WHITE); // Color de texto blanco para mejor contraste
                }
                return c;
            }
        });

        //Crear jlista
        lista = new JList();
        lista.setModel(new modeloListaBiblioteca());


    }

    private void bttInicio(ActionEvent e) {
        fa.muestraPrincipal(2, usuarioActual);
        this.dispose();
    }



    private void tipo(ActionEvent e) {
    }



    private void bttGuardarAlbum(ActionEvent e) {
        int tam = lista.getModel().getSize();
        //switch con tam
        switch(tam){
            case 0:
                fa.muestraExcepcion("El álbum está vacío. Añade alguna canción para poder guardarlo.");
                break;
            case 1:
                //Para poder guardarlo tienes que tener la opcion single en tipo
                if(tipo.getSelectedItem().equals("Single")){
                    salirAlbum();
                }else fa.muestraExcepcion("Un album de una sola canción tiene que ser un single.");

                break;
            default:
                salirAlbum();
        }
    }

    private void salirAlbum(){
        //limpia la clase
        flagDisco=false;
        albumActual = null;
        //poner los textfield a vacio
        nombre.setText("");
        discografica.setText("");
        //poner txtAlbum y txtDisco a ÁLBUM y -Discográfica
        txtAlbum.setText("ÁLBUM");
        txtDisco.setText("- Discográfica");
        //poner botones bttNuevaCancion y bttGuardar a false
        bttNuevaCancion.setEnabled(false);
    }

    private void bttNuevaCancion(ActionEvent e) {
        //Abrir VanadirCancion
        fa.muestraAnadirCancion(usuarioActual,albumActual.getIdAlbum(),this);
    }





    private void bttNuevaCancionStateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void crearAlbum(){
        String discografica = this.discografica.getText();
        String nombre = this.nombre.getText();
        String tipo = (String) this.tipo.getSelectedItem();
        Integer idDiscografica = -1;
        Discografica discografica1 = fa.buscarDiscografica(discografica);

        if(discografica1 == null){
            idDiscografica = fa.insertarDiscografica(discografica);
            //Si no existe y salimos de la ventana lo eliminamos
            flagDisco = true;
        }else{
            idDiscografica = discografica1.getIDDiscografica();
        }
        int idAlbum = fa.obtenerIDnuevo();
        albumActual = new Album(idAlbum, nombre,tipo, 0, idDiscografica);

        fa.publicarAlbum(albumActual,idDiscografica,usuarioActual);

        //Ponemos la informacion del nuevo Album encima de la lista
        txtAlbum.setText(albumActual.getNombre());
        txtDisco.setText(discografica);

        //poner botones bttNuevaCancion y bttGuardar a false
        bttNuevaCancion.setEnabled(true);
        bttGuardar.setEnabled(true);
    }


    //TODO: PONER ALGO PARA COMPROBAR QUE LAS LISTAS SE MANTENGAN
    private void bttNuevoAlbum(ActionEvent e) {
        //El boton está enabled solo si están los campos discografía y nombre rellenos
        if (discografica.getText().isEmpty() || nombre.getText().isEmpty()) {
            fa.muestraExcepcion("Completa los campos de nombre y discográfica antes de continuar.");
        } else {
            if(albumActual == null){
                crearAlbum();
            }else if(discografica.getText().equals(txtDisco.getText()) && nombre.getText().equals(txtAlbum.getText())){
                fa.muestraExcepcion("El álbum ya existe. Si deseas añadir canciones a este álbum, selecciona la opción 'Nueva canción'.");
            }
            else{
                fa.eliminarAlbum(albumActual.getIdAlbum());
                if(flagDisco){
                    fa.eliminarDiscografica(albumActual.getIDDiscografica());
                    flagDisco = false;
                }
                albumActual = null;
                crearAlbum();
            }
        }
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        bttInicio = new JButton();
        bttBuscar = new JButton();
        bttBiblioteca = new JButton();
        bttPerfil = new JButton();
        bttAjustes = new JButton();
        bttPublicar = new JButton();
        tabbedPane1 = new JTabbedPane();
        panel5 = new JPanel();
        label5 = new JLabel();
        nombrePodcast = new JTextField();
        button2 = new JButton();
        label6 = new JLabel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();
        label7 = new JLabel();
        scrollPane3 = new JScrollPane();
        list2 = new JList();
        label8 = new JLabel();
        label9 = new JLabel();
        textField1 = new JTextField();
        label10 = new JLabel();
        textField2 = new JTextField();
        checkBox1 = new JCheckBox();
        button3 = new JButton();
        button4 = new JButton();
        panel4 = new JPanel();
        label2 = new JLabel();
        nombre = new JTextField();
        label4 = new JLabel();
        bttGuardar = new JButton();
        discografica = new JTextField();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        txtAlbum = new JLabel();
        bttNuevaCancion = new JButton();
        txtDisco = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x00d856));

                //---- label1 ----
                label1.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify200.png")));

                //---- bttInicio ----
                bttInicio.setText("INICIO");
                bttInicio.setBackground(new Color(0x00d856));
                bttInicio.setForeground(Color.white);
                bttInicio.setBorder(null);
                bttInicio.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttInicio.addActionListener(e -> bttInicio(e));

                //---- bttBuscar ----
                bttBuscar.setText("BUSCAR");
                bttBuscar.setBackground(new Color(0x00d856));
                bttBuscar.setForeground(Color.white);
                bttBuscar.setBorder(null);
                bttBuscar.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttBuscar.addActionListener(e -> bttBuscar(e));

                //---- bttBiblioteca ----
                bttBiblioteca.setText("BIBLIOTECA");
                bttBiblioteca.setBackground(new Color(0x00d856));
                bttBiblioteca.setForeground(Color.white);
                bttBiblioteca.setBorder(null);
                bttBiblioteca.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttBiblioteca.addActionListener(e -> bttBiblioteca(e));

                //---- bttPerfil ----
                bttPerfil.setText("PERFIL");
                bttPerfil.setBackground(new Color(0x00d856));
                bttPerfil.setForeground(Color.white);
                bttPerfil.setBorder(null);
                bttPerfil.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));

                //---- bttAjustes ----
                bttAjustes.setText("AJUSTES");
                bttAjustes.setBackground(new Color(0x00d856));
                bttAjustes.setForeground(Color.white);
                bttAjustes.setBorder(null);
                bttAjustes.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));

                //---- bttPublicar ----
                bttPublicar.setText("PUBLICAR");
                bttPublicar.setBackground(new Color(0x00d856));
                bttPublicar.setForeground(Color.white);
                bttPublicar.setBorder(null);
                bttPublicar.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
                bttPublicar.addActionListener(e -> bttPublicar(e));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addComponent(bttInicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(bttBuscar, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttBiblioteca, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttPublicar, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttAjustes, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttPerfil, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttInicio)
                            .addGap(18, 18, 18)
                            .addComponent(bttBuscar)
                            .addGap(18, 18, 18)
                            .addComponent(bttBiblioteca)
                            .addGap(18, 18, 18)
                            .addComponent(bttPublicar)
                            .addGap(113, 113, 113)
                            .addComponent(bttPerfil)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bttAjustes)
                            .addGap(28, 28, 28))
                );
            }

            //======== tabbedPane1 ========
            {
                tabbedPane1.setFont(new Font("Arial", Font.BOLD, 14));
                tabbedPane1.setForeground(Color.white);
                tabbedPane1.setBackground(new Color(0x00d856));

                //======== panel5 ========
                {

                    //---- label5 ----
                    label5.setText("Nombre:");
                    label5.setFont(new Font("Arial", Font.PLAIN, 12));

                    //---- button2 ----
                    button2.setText("NUEVO PODCAST");
                    button2.setBackground(new Color(0x00d856));
                    button2.setFont(new Font("Arial", Font.BOLD, 14));
                    button2.setForeground(Color.white);

                    //---- label6 ----
                    label6.setText("TUS PODCAST");
                    label6.setBackground(new Color(0x00d856));
                    label6.setForeground(new Color(0x00d856));
                    label6.setFont(new Font("Arial", Font.BOLD, 14));

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(list1);
                    }

                    //---- label7 ----
                    label7.setText("CAP\u00cdTULOS");
                    label7.setFont(new Font("Arial", Font.BOLD, 14));
                    label7.setBackground(new Color(0x00d856));
                    label7.setForeground(new Color(0x00d856));

                    //======== scrollPane3 ========
                    {
                        scrollPane3.setViewportView(list2);
                    }

                    //---- label8 ----
                    label8.setText("PODCAST");
                    label8.setFont(new Font("Arial", Font.BOLD, 14));
                    label8.setForeground(new Color(0x00d856));

                    //---- label9 ----
                    label9.setText("Nombre:");

                    //---- label10 ----
                    label10.setText("Duraci\u00f3n:");

                    //---- checkBox1 ----
                    checkBox1.setText("Expl\u00edcito");
                    checkBox1.setFont(new Font("Arial", Font.PLAIN, 12));

                    //---- button3 ----
                    button3.setText("A\u00d1ADIR CAP\u00cdTULO");
                    button3.setFont(new Font("Arial", Font.BOLD, 14));
                    button3.setForeground(Color.white);
                    button3.setBackground(new Color(0x00d856));

                    //---- button4 ----
                    button4.setText("ELIMINAR CAP\u00cdTULO");
                    button4.setFont(new Font("Arial", Font.BOLD, 14));
                    button4.setForeground(Color.white);
                    button4.setBackground(new Color(0x00d856));

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label7)
                                .addGap(116, 116, 116))
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombrePodcast, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(button2)
                                .addGap(89, 89, 89))
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel5Layout.createParallelGroup()
                                    .addGroup(panel5Layout.createSequentialGroup()
                                        .addGroup(panel5Layout.createParallelGroup()
                                            .addComponent(label8)
                                            .addComponent(checkBox1))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                                        .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel5Layout.createSequentialGroup()
                                                .addComponent(button3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(button4))
                                            .addGroup(panel5Layout.createSequentialGroup()
                                                .addComponent(label9)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField1)
                                                .addGap(18, 18, 18)
                                                .addComponent(label10)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(58, 58, 58))
                                    .addGroup(panel5Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)))
                                .addContainerGap())
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5)
                                    .addComponent(nombrePodcast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button2))
                                .addGap(18, 18, 18)
                                .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(label7))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel5Layout.createParallelGroup()
                                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label9)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label10)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBox1)
                                .addGap(24, 24, 24)
                                .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button3)
                                    .addComponent(button4))
                                .addGap(30, 30, 30))
                    );
                }
                tabbedPane1.addTab("Podcast", panel5);

                //======== panel4 ========
                {

                    //---- label2 ----
                    label2.setText("Nombre:");
                    label2.setFont(new Font("Arial", Font.PLAIN, 14));

                    //---- label4 ----
                    label4.setText("Tipo:");
                    label4.setFont(new Font("Arial", Font.PLAIN, 14));

                    //---- tipo ----
                    tipo.setFont(new Font("Arial", Font.PLAIN, 14));
                    tipo.setForeground(Color.white);
                    tipo.setBackground(new Color(0x00d856));
                    tipo.addActionListener(e -> tipo(e));

                    //---- bttGuardar ----
                    bttGuardar.setText("GUARDAR");
                    bttGuardar.setBackground(new Color(0x00d856));
                    bttGuardar.setForeground(Color.white);
                    bttGuardar.setFont(new Font("Arial", Font.BOLD, 14));
                    bttGuardar.addActionListener(e -> bttGuardarAlbum(e));

                    //---- label3 ----
                    label3.setText("Discogr\u00e1fica:");
                    label3.setFont(new Font("Arial", Font.PLAIN, 14));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(lista);
                    }

                    //---- txtAlbum ----
                    txtAlbum.setText("\u00c1LBUM");
                    txtAlbum.setForeground(new Color(0x00d856));
                    txtAlbum.setFont(new Font("Arial", Font.BOLD, 14));

                    //---- bttNuevaCancion ----
                    bttNuevaCancion.setText("NUEVA CANCI\u00d3N");
                    bttNuevaCancion.setBackground(new Color(0x00d856));
                    bttNuevaCancion.setForeground(Color.white);
                    bttNuevaCancion.setFont(new Font("Arial", Font.BOLD, 14));
                    bttNuevaCancion.addActionListener(e -> bttNuevaCancion(e));
                    bttNuevaCancion.addChangeListener(e -> bttNuevaCancionStateChanged(e));

                    //---- txtDisco ----
                    txtDisco.setText("- Discogr\u00e1fica");
                    txtDisco.setForeground(new Color(0x00d856));
                    txtDisco.setFont(new Font("Arial", Font.BOLD, 14));

                    //---- button1 ----
                    button1.setText("CREAR \u00c1LBUM");
                    button1.setBackground(new Color(0x00d856));
                    button1.setFont(new Font("Arial", Font.BOLD, 14));
                    button1.setForeground(Color.white);
                    button1.addActionListener(e -> bttNuevoAlbum(e));

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nombre, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(discografica, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button1))
                                .addGap(35, 35, 35))
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(panel4Layout.createParallelGroup()
                                            .addComponent(bttGuardar)
                                            .addComponent(bttNuevaCancion)))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(txtAlbum)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDisco)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label2)
                                            .addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label3)
                                            .addComponent(discografica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addContainerGap(64, Short.MAX_VALUE)
                                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label4)
                                            .addComponent(button1))
                                        .addGap(18, 18, 18)))
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAlbum)
                                    .addComponent(txtDisco))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                        .addComponent(bttNuevaCancion)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bttGuardar)
                                        .addGap(50, 50, 50))))
                    );
                }
                tabbedPane1.addTab("\u00c1lbum", panel4);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JButton bttInicio;
    private JButton bttBuscar;
    private JButton bttBiblioteca;
    private JButton bttPerfil;
    private JButton bttAjustes;
    private JButton bttPublicar;
    private JTabbedPane tabbedPane1;
    private JPanel panel5;
    private JLabel label5;
    private JTextField nombrePodcast;
    private JButton button2;
    private JLabel label6;
    private JScrollPane scrollPane2;
    private JList list1;
    private JLabel label7;
    private JScrollPane scrollPane3;
    private JList list2;
    private JLabel label8;
    private JLabel label9;
    private JTextField textField1;
    private JLabel label10;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JButton button3;
    private JButton button4;
    private JPanel panel4;
    private JLabel label2;
    private JTextField nombre;
    private JLabel label4;
    private JComboBox tipo;
    private JButton bttGuardar;
    private JTextField discografica;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList lista;
    private JLabel txtAlbum;
    private JButton bttNuevaCancion;
    private JLabel txtDisco;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
