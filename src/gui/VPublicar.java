/*
 * Created by JFormDesigner on Thu Apr 25 12:26:21 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
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
        // TODO: add custom component creation code here
    }

    private void bttInicio(ActionEvent e) {
        fa.muestraPrincipal(2, usuarioActual);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        bttInicio = new JButton();
        bttBuscar = new JButton();
        bttBiblioteca = new JButton();
        bttPerfil = new JButton();
        bttAjustes = new JButton();
        bttPublicar = new JButton();
        label2 = new JLabel();

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

            //---- label2 ----
            label2.setText("LO QUE NO TE PUEDES PERDER:");
            label2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
            label2.setForeground(new Color(0x00d856));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 188, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
