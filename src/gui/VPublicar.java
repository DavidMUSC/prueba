/*
 * Created by JFormDesigner on Thu Apr 25 12:26:21 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import aplicacion.Album;
import aplicacion.fachadaAplicacion;


/**
 * @author Uni
 */
public class VPublicar extends JFrame {
    fachadaAplicacion fa;
    String usuarioActual;
    public VPublicar(fachadaAplicacion fa, String usuarioActual) {
        this.fa = fa;
        this.usuarioActual = usuarioActual;
        initComponents();
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

        //poner en enabled false bttGuardar y bttCancion
        bttGuardar.setEnabled(false);
        bttCancion.setEnabled(false);
    }

    private void bttInicio(ActionEvent e) {
        fa.muestraPrincipal(2, usuarioActual);
        this.dispose();
    }

    private void bttAnadirCancion(ActionEvent e) {
        //NO HACER NADA
    }

    private void tipo(ActionEvent e) {
        // añadir los tipos de album que se pueden crear. Por ejemplo EP, Album y Single al JcomboBox



    }

    private void bttCancion(ActionEvent e) {
        //El boton está enabled solo si están los campos discografía y nombre rellenos
        if (discografica.getText().isEmpty() || nombre.getText().isEmpty()) {

        } else {
            //TODO:Crear ventana nueva cancion
            String discografica = this.discografica.getText();
            String nombre = this.nombre.getText();
            String tipo = (String) this.tipo.getSelectedItem();
            Integer idDiscografica;
            if(fa.buscarDiscografica(discografica) == null){
                fa.insertarDiscografica(discografica);
            }else{

            }
            Album album = new Album(-1, nombre,tipo, 0, 0);

        }
    }

    private void bttGuardarAlbum(ActionEvent e) {

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
        panel4 = new JPanel();
        label2 = new JLabel();
        nombre = new JTextField();
        label4 = new JLabel();
        discografica = new JTextField();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        label5 = new JLabel();

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

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addGap(0, 505, Short.MAX_VALUE)
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGap(0, 436, Short.MAX_VALUE)
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

                    //---- bttCancion ----
                    bttCancion.setText("NUEVA CANCI\u00d3N");
                    bttCancion.setFont(new Font("Arial", Font.BOLD, 14));
                    bttCancion.setForeground(Color.white);
                    bttCancion.setBackground(new Color(0x00d856));
                    bttCancion.addActionListener(e -> {
			bttAnadirCancion(e);
			bttCancion(e);
		});

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

                    //---- label5 ----
                    label5.setText("\u00c1LBUM");
                    label5.setForeground(new Color(0x00d856));
                    label5.setFont(new Font("Arial", Font.BOLD, 14));

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nombre, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(6, 6, 6)
                                        .addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(103, 103, 103)))
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(discografica))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(bttCancion)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bttGuardar))
                                    .addComponent(label5))
                                .addGap(35, 35, 35))
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3)
                                    .addComponent(discografica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(label4))
                                    .addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bttCancion)
                                        .addComponent(bttGuardar)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(label5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
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
    private JPanel panel4;
    private JLabel label2;
    private JTextField nombre;
    private JLabel label4;
    private JComboBox tipo;
    private JButton bttCancion;
    private JButton bttGuardar;
    private JTextField discografica;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList lista;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
