/*
 * Created by JFormDesigner on Tue Apr 23 13:05:55 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VAviso extends JDialog {
    public VAviso(String mensaje) {
        super();
        initComponents();
        this.mensaje.setText(mensaje);
    }

    private void cerrar(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        buttonCerrar = new JButton();
        scrollPane1 = new JScrollPane();
        mensaje = new JTextArea();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- buttonCerrar ----
            buttonCerrar.setText("Cerrar");
            buttonCerrar.setFont(new Font("Arial", Font.PLAIN, 12));
            buttonCerrar.addActionListener(e -> cerrar(e));

            //======== scrollPane1 ========
            {

                //---- mensaje ----
                mensaje.setFont(new Font("Arial", Font.PLAIN, 14));
                mensaje.setForeground(Color.red);
                mensaje.setBackground(Color.white);
                mensaje.setBorder(null);
                scrollPane1.setViewportView(mensaje);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(99, Short.MAX_VALUE)
                        .addComponent(buttonCerrar)
                        .addGap(98, 98, 98))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(buttonCerrar)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JButton buttonCerrar;
    private JScrollPane scrollPane1;
    private JTextArea mensaje;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
