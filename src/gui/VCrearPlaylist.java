/*
 * Created by JFormDesigner on Wed Apr 24 18:04:33 CEST 2024
 */

package gui;

import java.awt.event.*;
import aplicacion.fachadaAplicacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VCrearPlaylist extends JDialog {
    fachadaAplicacion fa;
    String usuarioActual;
    public VCrearPlaylist(Frame owner, fachadaAplicacion fa, String usuarioActual){
        super(owner);
        this.usuarioActual=usuarioActual;
        this.fa=fa;
        initComponents();
    }

    private void bttLupa(ActionEvent e) {
        // TODO add your code here
    }

    private void lupaKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel3 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        buscadorNombre = new JTextField();
        buscadorCancion = new JTextField();
        bttLupa = new JButton();
        scrollPane1 = new JScrollPane();
        listaBuscador = new JList();
        scrollPane2 = new JScrollPane();
        listaPlaylist = new JList();
        bttGuardar = new JButton();
        label4 = new JLabel();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel3 ========
        {

            //======== panel4 ========
            {
                panel4.setBackground(new Color(0x00d856));

                //---- label1 ----
                label1.setText("CREAR PLAYLIST");
                label1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
                label1.setForeground(Color.white);

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addComponent(label1)
                            .addContainerGap(138, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                            .addContainerGap(28, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(26, 26, 26))
                );
            }

            //---- label2 ----
            label2.setText("Nombre:");
            label2.setFont(new Font("Arial", Font.PLAIN, 12));

            //---- bttLupa ----
            bttLupa.setIcon(new ImageIcon(getClass().getResource("/fotos/lupa20.png")));
            bttLupa.setBorder(null);
            bttLupa.setBackground(new Color(0xf2f2f2));
            bttLupa.addActionListener(e -> bttLupa(e));
            bttLupa.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    lupaKeyPressed(e);
                }
            });

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(listaBuscador);
            }

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(listaPlaylist);
            }

            //---- bttGuardar ----
            bttGuardar.setText("GUARDAR");
            bttGuardar.setFont(new Font("Arial", Font.BOLD, 12));
            bttGuardar.setBackground(new Color(0x00d856));
            bttGuardar.setForeground(Color.white);

            //---- label4 ----
            label4.setText("PLAYLIST");
            label4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 14));
            label4.setForeground(new Color(0x00d856));

            //---- button2 ----
            button2.setText("A\u00d1ADIR");
            button2.setFont(new Font("Arial", Font.BOLD, 12));
            button2.setForeground(Color.white);
            button2.setBackground(new Color(0x00d856));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bttLupa)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(scrollPane1))
                                    .addComponent(buscadorCancion, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39))
                            .addGroup(GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscadorNombre, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(button2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttGuardar)
                        .addGap(31, 31, 31))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(buscadorNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(label3))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buscadorCancion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttLupa))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(bttGuardar)
                            .addComponent(button2))
                        .addGap(11, 11, 11))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel3;
    private JPanel panel4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField buscadorNombre;
    private JTextField buscadorCancion;
    private JButton bttLupa;
    private JScrollPane scrollPane1;
    private JList listaBuscador;
    private JScrollPane scrollPane2;
    private JList listaPlaylist;
    private JButton bttGuardar;
    private JLabel label4;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
