package interfaz;

import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import obligatorio.*;
//import java.applet.*;

public class MenuPrincipal extends javax.swing.JFrame {

    Esquina esquina;
    AudioClip musicaFondo;

    public MenuPrincipal(Esquina esquina) {
        this.esquina = esquina;
        initComponents();

        musicaFondo = java.applet.Applet.newAudioClip(getClass().getResource("/musica/ThreeChainLinks.au"));
        musicaFondo.loop();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Icono_Aplicacion.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registroJugadorJButton = new javax.swing.JButton();
        partidaManualJButton = new javax.swing.JButton();
        partidaComputadoraJButton = new javax.swing.JButton();
        rankingJButton = new javax.swing.JButton();
        salirJButton = new javax.swing.JButton();
        fondoJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        registroJugadorJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroSinLuz.png"))); // NOI18N
        registroJugadorJButton.setBorderPainted(false);
        registroJugadorJButton.setContentAreaFilled(false);
        registroJugadorJButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro.png"))); // NOI18N
        registroJugadorJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroJugadorJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registroJugadorJButton);
        registroJugadorJButton.setBounds(70, 310, 330, 60);

        partidaManualJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/partidaManualSLBoton.png"))); // NOI18N
        partidaManualJButton.setBorderPainted(false);
        partidaManualJButton.setContentAreaFilled(false);
        partidaManualJButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/partidaManualBoton.png"))); // NOI18N
        partidaManualJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partidaManualJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(partidaManualJButton);
        partidaManualJButton.setBounds(70, 380, 330, 60);

        partidaComputadoraJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/partidaCSLBoton.png"))); // NOI18N
        partidaComputadoraJButton.setBorderPainted(false);
        partidaComputadoraJButton.setContentAreaFilled(false);
        partidaComputadoraJButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/partidaCBoton.png"))); // NOI18N
        partidaComputadoraJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partidaComputadoraJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(partidaComputadoraJButton);
        partidaComputadoraJButton.setBounds(60, 450, 330, 60);

        rankingJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rankingSL.png"))); // NOI18N
        rankingJButton.setBorderPainted(false);
        rankingJButton.setContentAreaFilled(false);
        rankingJButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rankingLuz.png"))); // NOI18N
        rankingJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rankingJButton);
        rankingJButton.setBounds(70, 520, 330, 60);

        salirJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salirSL.png"))); // NOI18N
        salirJButton.setBorderPainted(false);
        salirJButton.setContentAreaFilled(false);
        salirJButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        salirJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(salirJButton);
        salirJButton.setBounds(70, 590, 330, 60);

        fondoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu_PrincipalEsq.gif"))); // NOI18N
        getContentPane().add(fondoJLabel);
        fondoJLabel.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void partidaManualJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partidaManualJButtonActionPerformed
        PartidaJugar pm = new PartidaJugar(esquina);
        esquina.setPartida(new Partida());
        esquina.setTablero(new Tablero());

        if (esquina.getListaJugadores().size() < 2) {
            JOptionPane.showMessageDialog(null, "Debe registrar jugadores", "ERROR", JOptionPane.ERROR_MESSAGE);
            pm.setVisible(false);
        } else {
            musicaFondo.stop();
            pm.setVisible(true);
            esquina.getPartida().getJugador1().setAlias(esquina.getJugador1().getAlias());
            esquina.getPartida().getJugador2().setAlias(esquina.getJugador2().getAlias());
            dispose();
        }
    }//GEN-LAST:event_partidaManualJButtonActionPerformed

    private void partidaComputadoraJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partidaComputadoraJButtonActionPerformed
        PartidaJugar pm = new PartidaJugar(esquina);
        esquina.setPartida(new Partida());
        esquina.setTablero(new Tablero());
        esquina.getPartida().setPartidaComputadora(true);
        esquina.setTablero(new Tablero());
        
        if (esquina.getListaJugadores().size() < 1) {
            JOptionPane.showMessageDialog(null, "Debe registrar jugadores", "ERROR", JOptionPane.ERROR_MESSAGE);
            pm.setVisible(false);
        } else {
            musicaFondo.stop();
            pm.setVisible(true);
            esquina.getPartida().getJugador1().setAlias(esquina.getJugador1().getAlias());
            esquina.getPartida().getJugador2().setAlias(esquina.getJugador2().getAlias());
            dispose();
        }
    }//GEN-LAST:event_partidaComputadoraJButtonActionPerformed

    private void salirJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirJButtonActionPerformed
        try {
            esquina.getPersistencia().writeObject();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_salirJButtonActionPerformed

    private void registroJugadorJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroJugadorJButtonActionPerformed
        musicaFondo.stop();
        RegistroJugador rj = new RegistroJugador(esquina);
        rj.setVisible(true);
        dispose();
    }//GEN-LAST:event_registroJugadorJButtonActionPerformed

    private void rankingJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingJButtonActionPerformed
        musicaFondo.stop();
        Ranking r = new Ranking(esquina);
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_rankingJButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoJLabel;
    private javax.swing.JButton partidaComputadoraJButton;
    private javax.swing.JButton partidaManualJButton;
    private javax.swing.JButton rankingJButton;
    private javax.swing.JButton registroJugadorJButton;
    private javax.swing.JButton salirJButton;
    // End of variables declaration//GEN-END:variables
}
