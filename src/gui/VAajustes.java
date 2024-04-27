/*
 * Created by JFormDesigner on Sat Apr 27 20:34:14 CEST 2024
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author davra
 */
public class VAajustes extends JDialog {
    public VAajustes(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        slider1 = new JSlider();
        label1 = new JLabel();
        label2 = new JLabel();
        checkBox1 = new JCheckBox();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x00d856));

            //---- label1 ----
            label1.setText("AJUSTES");
            label1.setForeground(Color.white);
            label1.setFont(new Font("Franklin Gothic Demi", label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 10));

            //---- label2 ----
            label2.setText("Volumen");
            label2.setFont(new Font("Arial", Font.BOLD, 14));
            label2.setForeground(Color.white);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setText("Deseo recibir notificaciones y correo promocional \nde Spotipify a mi correo electr\u00f3nico");
                textArea1.setBackground(new Color(0x00d856));
                textArea1.setForeground(Color.white);
                textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 2f));
                textArea1.setCaretColor(Color.white);
                textArea1.setBorder(null);
                scrollPane1.setViewportView(textArea1);
            }

            //---- button1 ----
            button1.setText("\u00bfNecesitas ayuda? Contacta con nuestro equipo aqu\u00ed.");
            button1.setForeground(Color.white);
            button1.setFont(new Font("Arial", Font.BOLD, 12));
            button1.setBackground(new Color(0x00d856));
            button1.setBorder(null);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(label1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(slider1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(checkBox1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button1))))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBox1))
                        .addGap(18, 18, 18)
                        .addComponent(button1)
                        .addContainerGap(55, Short.MAX_VALUE))
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
    private JSlider slider1;
    private JLabel label1;
    private JLabel label2;
    private JCheckBox checkBox1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
