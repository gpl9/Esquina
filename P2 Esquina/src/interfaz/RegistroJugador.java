package interfaz;

import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import obligatorio.Esquina;

public class RegistroJugador extends javax.swing.JFrame {

    Esquina esquina;
    DefaultListModel modeloLista;
    AudioClip musicaFondo;

    public RegistroJugador(Esquina esquina) {
        initComponents();
        musicaFondo = java.applet.Applet.newAudioClip(getClass().getResource("/musica/BrokenElegance.au"));
        musicaFondo.loop();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Icono_Aplicacion.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        this.esquina = esquina;
        modeloLista = new DefaultListModel();
        jListJugadores.setModel(modeloLista);
        listaJugadores();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TimerJLabel = new javax.swing.JLabel();
        timerJButton = new javax.swing.JButton();
        jButtonJugador2 = new javax.swing.JButton();
        jButtonJugador1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJugadores = new javax.swing.JList<>();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAlias = new javax.swing.JLabel();
        jLabelEdad = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        JButtonIrAtras = new javax.swing.JButton();
        textFieldTimer = new javax.swing.JTextField();
        textFieldEdad = new javax.swing.JTextField();
        textFieldAlias = new javax.swing.JTextField();
        textFieldNombre = new javax.swing.JTextField();
        jButtonBorrar = new javax.swing.JButton();
        jLabelLista = new javax.swing.JLabel();
        fondoRegistro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        TimerJLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TimerJLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimerJLabel.setText("Selecciona el tiempo por partida (Segundos):");
        getContentPane().add(TimerJLabel);
        TimerJLabel.setBounds(770, 530, 280, 30);

        timerJButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        timerJButton.setForeground(new java.awt.Color(255, 255, 255));
        timerJButton.setText("Tiempo");
        timerJButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        timerJButton.setContentAreaFilled(false);
        timerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(timerJButton);
        timerJButton.setBounds(1100, 570, 80, 17);

        jButtonJugador2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonJugador2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonJugador2.setText("Seleccionar Jugador 2");
        jButtonJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonJugador2.setContentAreaFilled(false);
        jButtonJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugador2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonJugador2);
        jButtonJugador2.setBounds(860, 330, 140, 30);

        jButtonJugador1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonJugador1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonJugador1.setText("Seleccionar Jugador 1");
        jButtonJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonJugador1.setContentAreaFilled(false);
        jButtonJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugador1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonJugador1);
        jButtonJugador1.setBounds(860, 270, 140, 30);

        jListJugadores.setToolTipText("");
        jScrollPane1.setViewportView(jListJugadores);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(510, 270, 310, 180);

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre);
        jLabelNombre.setBounds(20, 260, 140, 40);

        jLabelAlias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAlias.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAlias.setText("Alias:");
        getContentPane().add(jLabelAlias);
        jLabelAlias.setBounds(20, 330, 140, 40);

        jLabelEdad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdad.setText("Edad:");
        getContentPane().add(jLabelEdad);
        jLabelEdad.setBounds(20, 400, 140, 40);

        jButtonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrar);
        jButtonRegistrar.setBounds(170, 490, 280, 40);

        JButtonIrAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VolverAtras.png"))); // NOI18N
        JButtonIrAtras.setContentAreaFilled(false);
        JButtonIrAtras.setMaximumSize(new java.awt.Dimension(1280, 720));
        JButtonIrAtras.setMinimumSize(new java.awt.Dimension(1280, 720));
        JButtonIrAtras.setPreferredSize(new java.awt.Dimension(1280, 720));
        JButtonIrAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VolverAtrasColor.png"))); // NOI18N
        JButtonIrAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonIrAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(JButtonIrAtras);
        JButtonIrAtras.setBounds(1160, 630, 80, 70);

        textFieldTimer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        textFieldTimer.setOpaque(false);
        textFieldTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTimerActionPerformed(evt);
            }
        });
        textFieldTimer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldTimerKeyTyped(evt);
            }
        });
        getContentPane().add(textFieldTimer);
        textFieldTimer.setBounds(1050, 530, 180, 30);

        textFieldEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        textFieldEdad.setOpaque(false);
        textFieldEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldEdadKeyTyped(evt);
            }
        });
        getContentPane().add(textFieldEdad);
        textFieldEdad.setBounds(170, 410, 280, 30);

        textFieldAlias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        textFieldAlias.setOpaque(false);
        getContentPane().add(textFieldAlias);
        textFieldAlias.setBounds(170, 340, 280, 30);

        textFieldNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        textFieldNombre.setOpaque(false);
        textFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreActionPerformed(evt);
            }
        });
        textFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldNombreKeyTyped(evt);
            }
        });
        getContentPane().add(textFieldNombre);
        textFieldNombre.setBounds(170, 270, 280, 30);

        jButtonBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonBorrar.setContentAreaFilled(false);
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBorrar);
        jButtonBorrar.setBounds(620, 490, 73, 17);

        jLabelLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLista.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLista.setText("Lista de Jugadores");
        jLabelLista.setAutoscrolls(true);
        getContentPane().add(jLabelLista);
        jLabelLista.setBounds(600, 230, 140, 30);

        fondoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Registro_Jugador.png"))); // NOI18N
        fondoRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(fondoRegistro);
        fondoRegistro.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonIrAtrasActionPerformed
        musicaFondo.stop();
        MenuPrincipal mp = new MenuPrincipal(esquina);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_JButtonIrAtrasActionPerformed


    private void textFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreActionPerformed

    }//GEN-LAST:event_textFieldNombreActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        int edad = 0;
        String nombre;
        String alias;
        nombre = this.textFieldNombre.getText();
        alias = this.textFieldAlias.getText();
        if (textFieldNombre.getText().isEmpty() || textFieldAlias.getText().isEmpty() || textFieldEdad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la infomarción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        try {
            edad = Integer.parseInt(this.textFieldEdad.getText());
            
                if (esquina.getListaJugadores().equals(alias)) {
                    JOptionPane.showMessageDialog(null, "El Alias debe ser único", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (edad < 1 || edad > 150) {
                    JOptionPane.showMessageDialog(null, "Deb ingresar una edad aceptable.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    esquina.registroJugador(nombre, alias, edad);
                    listaJugadores();
                }
            

        } catch (NumberFormatException nfe) {

        }
        textFieldNombre.setText(null);
        textFieldAlias.setText(null);
        textFieldEdad.setText(null);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void textFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_textFieldNombreKeyTyped

    private void textFieldEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEdadKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_textFieldEdadKeyTyped

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?");

        if (respuesta == 0) {
            int posicion = jListJugadores.getSelectedIndex();
            modeloLista.remove(posicion);
            esquina.getListaJugadores().remove(posicion);
        }
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugador1ActionPerformed
        int posicion = jListJugadores.getSelectedIndex();
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            esquina.getJugador1().setAlias((String) modeloLista.get(posicion));
        }

    }//GEN-LAST:event_jButtonJugador1ActionPerformed

    public void listaJugadores() {
        modeloLista.clear();
        for (int i = 0; i < esquina.getListaJugadores().size(); i++) {
            modeloLista.addElement(esquina.getListaJugadores().get(i).getAlias());
        }

    }
    private void jButtonJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugador2ActionPerformed
        int posicion = jListJugadores.getSelectedIndex();
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            esquina.getJugador2().setAlias((String) modeloLista.get(posicion));
        }

    }//GEN-LAST:event_jButtonJugador2ActionPerformed

    private void textFieldTimerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldTimerKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_textFieldTimerKeyTyped

    private void textFieldTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTimerActionPerformed

    private void timerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerJButtonActionPerformed

        if (textFieldTimer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        try {
            int timer = Integer.parseInt(textFieldTimer.getText());
            if (timer < 1000) {
                esquina.setCantidadSegundos(timer);
            } else {
                textFieldTimer.setText(null);
                JOptionPane.showMessageDialog(null, "El tiempo excede el tiempo permitido.");
            }
        } catch (NumberFormatException nfe) {

        }
    }//GEN-LAST:event_timerJButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonIrAtras;
    private javax.swing.JLabel TimerJLabel;
    private javax.swing.JLabel fondoRegistro;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonJugador1;
    private javax.swing.JButton jButtonJugador2;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabelAlias;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelLista;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JList<String> jListJugadores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textFieldAlias;
    private javax.swing.JTextField textFieldEdad;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldTimer;
    private javax.swing.JButton timerJButton;
    // End of variables declaration//GEN-END:variables
}
