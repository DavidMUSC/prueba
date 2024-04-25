/*
 * Created by JFormDesigner on Thu Apr 25 18:13:38 CEST 2024
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import aplicacion.*;
import aplicacion.Artista;
/**
 * @author User
 */
public class VCancion extends JFrame {
    fachadaAplicacion fa;
    Cancion cancion;
    //static
    public VCancion(fachadaAplicacion fa,Cancion cancion) {
        this.fa=fa;
        this.cancion=cancion;
        initComponents();
        labelCancion.setText(cancion.getNombre());
        String strArtistas="";
        java.util.List<Artista> artistas = fa.obtenerArtistasDeCancion(cancion.getNombre());
        if(!artistas.isEmpty()){
            strArtistas+=artistas.get(0).getNombreArtistico();
        }
        for(int i=0;i<artistas.size();i++){
            if(i>0){
                strArtistas+=","+artistas.get(i).getNombreArtistico();
            }
        }
        labelArtistas.setText(strArtistas);
        labelDuracion.setText(cancion.getDuracion());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        panel2 = new JPanel();
        label6 = new JLabel();
        labelCancion = new JLabel();
        labelArtistas = new JLabel();
        button1 = new JButton();
        label9 = new JLabel();
        labelDuracion = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/fotos/siguiente-pista.png")));

            //---- label4 ----
            label4.setIcon(new ImageIcon(getClass().getResource("/fotos/play.png")));

            //---- label5 ----
            label5.setIcon(new ImageIcon(getClass().getResource("/fotos/siguiente-pistaizq.png")));

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x00d856));

                //---- label6 ----
                label6.setIcon(new ImageIcon(getClass().getResource("/fotos/spotipify100.png")));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(label6)
                            .addContainerGap(169, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(10, Short.MAX_VALUE)
                            .addComponent(label6)
                            .addContainerGap())
                );
            }

            //---- labelCancion ----
            labelCancion.setText("text");
            labelCancion.setFont(new Font("Franklin Gothic Demi", labelCancion.getFont().getStyle() | Font.BOLD, 16));

            //---- labelArtistas ----
            labelArtistas.setText("text");
            labelArtistas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));

            //---- button1 ----
            button1.setBackground(Color.black);

            //---- label9 ----
            label9.setText("00:00:00");
            label9.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            //---- labelDuracion ----
            labelDuracion.setText("text");
            labelDuracion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(label9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label4)
                                        .addGap(37, 37, 37)
                                        .addComponent(label5))
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDuracion, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(labelCancion, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelArtistas, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(26, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCancion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(labelArtistas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(label5)
                                    .addComponent(label4))
                                .addGap(18, 18, 18)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label9)
                            .addComponent(labelDuracion))
                        .addContainerGap(30, Short.MAX_VALUE))
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JPanel panel2;
    private JLabel label6;
    private JLabel labelCancion;
    private JLabel labelArtistas;
    private JButton button1;
    private JLabel label9;
    private JLabel labelDuracion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
