package interfaz;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatorio.*;

public class PantallaPrincipal extends javax.swing.JFrame {

    Esquina esquina;

    public PantallaPrincipal() {

        initComponents();

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Icono_Aplicacion.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openJButton = new javax.swing.JButton();
        fondoJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        openJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/openButton.png"))); // NOI18N
        openJButton.setBorderPainted(false);
        openJButton.setContentAreaFilled(false);
        openJButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/openButtonCL.png"))); // NOI18N
        openJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openJButtonMouseClicked(evt);
            }
        });
        openJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(openJButton);
        openJButton.setBounds(540, 380, 150, 80);

        fondoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PantallaPrincipal.png"))); // NOI18N
        getContentPane().add(fondoJLabel);
        fondoJLabel.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJButtonActionPerformed

        esquina = new Esquina();
        try {
            esquina.getPersistencia().readObject();
            esquina.getPersistencia().readPartida();
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        MenuPrincipal mp = new MenuPrincipal(esquina);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_openJButtonActionPerformed

    private void openJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openJButtonMouseClicked

    }//GEN-LAST:event_openJButtonMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoJLabel;
    private javax.swing.JButton openJButton;
    // End of variables declaration//GEN-END:variables

}
