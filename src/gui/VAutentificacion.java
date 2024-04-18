package gui;

import javax.swing.*;
import java.awt.event.*;

public class VAutentificacion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JTextField textField2;
    private JButton buttonCancel;

    aplicacion.fachadaAplicacion fa;

    public VAutentificacion(aplicacion.fachadaAplicacion fa) {
        this.fa=fa;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1ActionPerformed(e);
            }
        });
        textField2.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2ActionPerformed(e);
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }
    private void textField1ActionPerformed(ActionEvent e){
        
    }
    private void textField2ActionPerformed(ActionEvent e){

    }


}
