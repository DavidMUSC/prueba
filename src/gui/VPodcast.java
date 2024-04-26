/*
 * Created by JFormDesigner on Thu Apr 25 22:49:47 CEST 2024
 */

package gui;

import aplicacion.Artista;
import aplicacion.Podcast;
import aplicacion.fachadaAplicacion;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author User
 */
public class VPodcast extends JFrame {
    fachadaAplicacion fa;
    Podcast podcast;
    public VPodcast(fachadaAplicacion fa,Podcast podcast) {
        this.fa=fa;
        this.podcast=podcast;
        initComponents();
        label1.setText(podcast.getNombre());
        String strArtistas="";
        java.util.List<Artista> artistas = fa.obtenerArtistasDePodcast(podcast.getNombre());
        if(!artistas.isEmpty()){
            strArtistas+=artistas.get(0).getNombreArtistico();
        }
        for(int i=0;i<artistas.size();i++){
            if(i>0){
                strArtistas+=","+artistas.get(i).getNombreArtistico();
            }
        }
        /*List<Capitulo>
        labelArtistas.setText(strArtistas);
        labelDuracion.setText(cancion.getDuracion());*/
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        panel2 = new JPanel();
        label6 = new JLabel();
        label1 = new JLabel();
        labelCancion = new JLabel();
        labelArtistas = new JLabel();
        button1 = new JButton();
        label9 = new JLabel();
        labelDuracion = new JLabel();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();

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

                //---- label1 ----
                label1.setText("text");
                label1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 24));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label6)
                            .addGap(54, 54, 54))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap(10, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label6)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

            //======== panel3 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addGap(14, 14, 14))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
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
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(labelCancion, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelArtistas, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDuracion, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
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
                                            .addComponent(label9)))
                                    .addComponent(labelDuracion, GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
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
    private JLabel label1;
    private JLabel labelCancion;
    private JLabel labelArtistas;
    private JButton button1;
    private JLabel label9;
    private JLabel labelDuracion;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}