package interfaz;

import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import obligatorio.*;

public class Ranking extends javax.swing.JFrame {

    Excel excel = new Excel();
    JFileChooser seleccionarAchivo = new JFileChooser();
    Esquina esquina;
    File archivo;
    int contAccion = 0;
    AudioClip musicaFondo;

    public Ranking(Esquina unaEsquina) {

        initComponents();
        this.esquina = unaEsquina;
        musicaFondo = java.applet.Applet.newAudioClip(getClass().getResource("/musica/BrokenElegance.au"));
        musicaFondo.loop();
        esquina.cantidadGanadas();
        tabla();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Icono_Aplicacion.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generarExcelJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JButtonIrAtras = new javax.swing.JButton();
        fondoRankingJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        generarExcelJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generarExcelJButton.setForeground(new java.awt.Color(255, 255, 255));
        generarExcelJButton.setText("Generar Excel");
        generarExcelJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        generarExcelJButton.setContentAreaFilled(false);
        generarExcelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarExcelJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(generarExcelJButton);
        generarExcelJButton.setBounds(580, 630, 130, 40);

        jScrollPane1.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Edad", "Alias", "Partidas Ganadas"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 290, 1160, 300);

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

        fondoRankingJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ranking.png"))); // NOI18N
        getContentPane().add(fondoRankingJLabel);
        fondoRankingJLabel.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonIrAtrasActionPerformed
        musicaFondo.stop();
        MenuPrincipal mp = new MenuPrincipal(esquina);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_JButtonIrAtrasActionPerformed

    private void generarExcelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarExcelJButtonActionPerformed
        contAccion++;
        //cuando se elije el boton el contador aumenta a 1
        if (contAccion == 1) {
            filtroArchivo();
        }
        if (evt.getSource() == generarExcelJButton) {
            if (seleccionarAchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionarAchivo.getSelectedFile();
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null, excel.exportarExcel(archivo, jTable1));
                } else {
                    JOptionPane.showMessageDialog(null, "Elija un formato válido.");
                }
            }
        }
    }//GEN-LAST:event_generarExcelJButtonActionPerformed
    public void filtroArchivo() {
        seleccionarAchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        seleccionarAchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }
//LLena la tabla con sus valores correspondientes

    public void tabla() {
        String[][] tabla = new String[esquina.getListaJugadores().size()][4];
        for (int i = 0; i < esquina.getListaJugadores().size(); i++) {
            tabla[i][0] = esquina.getListaJugadores().get(i).getNombre();
            tabla[i][1] = Integer.toString(esquina.getListaJugadores().get(i).getEdad());
            tabla[i][2] = esquina.getListaJugadores().get(i).getAlias();
            tabla[i][3] = Integer.toString(esquina.getListaJugadores().get(i).getCantGanadas());

        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "Nombre", "Edad", "Alias", "Partidas Ganadas"
                }
        ));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonIrAtras;
    private javax.swing.JLabel fondoRankingJLabel;
    private javax.swing.JButton generarExcelJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
