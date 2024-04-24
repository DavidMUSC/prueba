/*
 * Created by JFormDesigner on Wed Apr 24 18:04:33 CEST 2024
 */

package gui;

import aplicacion.fachadaAplicacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VCrearPlaylist extends JDialog {
    fachadaAplicacion fa;
    public VCrearPlaylist(Frame owner, fachadaAplicacion fa) {
        super(owner);
        this.fa=fa;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel3 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();

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
                            .addContainerGap(135, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                            .addContainerGap(28, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(26, 26, 26))
                );
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 280, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
