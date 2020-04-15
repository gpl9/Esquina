package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import obligatorio.Esquina;
import obligatorio.Ficha;
import java.applet.*;
import java.io.IOException;
import java.util.logging.*;

public class PartidaJugar extends javax.swing.JFrame implements ActionListener {

    Image fichaRoja = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/fichaRoja.png"));
    Image fichaAzul = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/fichaAzul.png"));
    Image esquina2Roja = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina2Roja.png"));
    Image esquina2Azul = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina2Azul.png"));
    Image esquina3Roja = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina3Roja.png"));
    Image esquina3Azul = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina3Azul.png"));
    Image esquina4Roja = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina4Roja.png"));
    Image esquina4Azul = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina4Azul.png"));
    Image esquina5Roja = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina5Roja.png"));
    Image esquina5Azul = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/esquina5Azul.png"));
    Image fichaJ1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/fichaJ1.png"));
    Image fichaJ2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/fichaJ2.png"));

    Image rolloverButton = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/rolloverButtonIcon.png"));
    ImageIcon icon = new ImageIcon(rolloverButton);
    ImageIcon fichaEsquina2Roja = new ImageIcon(esquina2Roja);
    ImageIcon fichaEsquina2Azul = new ImageIcon(esquina2Azul);
    ImageIcon fichaEsquina3Roja = new ImageIcon(esquina3Roja);
    ImageIcon fichaEsquina3Azul = new ImageIcon(esquina3Azul);
    ImageIcon fichaEsquina4Roja = new ImageIcon(esquina4Roja);
    ImageIcon fichaEsquina4Azul = new ImageIcon(esquina4Azul);
    ImageIcon fichaEsquina5Roja = new ImageIcon(esquina5Roja);
    ImageIcon fichaEsquina5Azul = new ImageIcon(esquina5Azul);
    ImageIcon fichaAzulBoton = new ImageIcon(fichaAzul);
    ImageIcon fichaRojaBoton = new ImageIcon(fichaRoja);
    ImageIcon fichasAzul = new ImageIcon(fichaAzul);
    ImageIcon fichaRojaJ1 = new ImageIcon(fichaJ1);
    ImageIcon fichaAzulJ2 = new ImageIcon(fichaJ2);
    private Timer timer;
    private int contador;
    private Esquina esquina;
    private JButton[][] botones;
    private JButton[][] botonesJ1;
    private JButton[][] botonesJ2;
    private AudioClip musica;
    DefaultListModel modeloLista;

    public PartidaJugar(Esquina esquina) {

        initComponents();
        this.esquina = esquina;

        musicaFondo();
        contador = esquina.getCantidadSegundos();
        timer = new Timer(1000, this);
        timer.start();
        cantFichas();

        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Icono_Aplicacion.png"));
        setIconImage(icono);
        iconoCantFichas();
        this.setLocationRelativeTo(null);
        this.esquina.getPartida().getJugador1().setAlias(esquina.getJugador1().getAlias());
        this.esquina.getPartida().getJugador2().setAlias(esquina.getJugador2().getAlias());
        aliasJugadores();
        tableroBotonesJPanel.setLayout(new GridLayout(7, 7, 4, 4));
        //Con esto modificamos el grid layout del tablero
        tableroBotonesJPanel.setBounds(73, 75, 503, 662);
        botones = new JButton[7][7];

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                JButton jButton = new JButton();
                jButton.setPreferredSize(new Dimension(40, 80));
                jButton.addActionListener(new ListenerBoton(i, j));
                tableroBotonesJPanel.add(jButton);
                botones[i][j] = jButton;
                botones[i][j].setContentAreaFilled(false);
                botones[i][j].setRolloverIcon(icon);

            }
        }
        modeloLista = new DefaultListModel();
        listaPartidas.setModel(modeloLista);
        listaPartidas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listadoDePartidas = new javax.swing.JScrollPane();
        listaPartidas = new javax.swing.JList<>();
        contadorLabel = new javax.swing.JLabel();
        recuperarPartidaJButton = new javax.swing.JButton();
        suspenderPartidaJButton = new javax.swing.JButton();
        listadoDeMovimientos = new javax.swing.JScrollPane();
        listaMovimientos = new javax.swing.JList<>();
        panelCantidadFichasJ1 = new javax.swing.JPanel();
        panelCantidadFichasJ2 = new javax.swing.JPanel();
        jLabelJugador2 = new javax.swing.JLabel();
        jLabelJugador1Alias = new javax.swing.JLabel();
        jLabelJugador2Alias = new javax.swing.JLabel();
        jLabelJugador1 = new javax.swing.JLabel();
        JButtonIrAtras = new javax.swing.JButton();
        tableroBotonesJPanel = new javax.swing.JPanel();
        fondoJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        listadoDePartidas.setViewportView(listaPartidas);

        getContentPane().add(listadoDePartidas);
        listadoDePartidas.setBounds(950, 520, 190, 130);

        contadorLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        contadorLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(contadorLabel);
        contadorLabel.setBounds(610, 570, 110, 100);

        recuperarPartidaJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        recuperarPartidaJButton.setForeground(new java.awt.Color(255, 255, 255));
        recuperarPartidaJButton.setText("Recuperar Partida");
        recuperarPartidaJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        recuperarPartidaJButton.setContentAreaFilled(false);
        recuperarPartidaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperarPartidaJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(recuperarPartidaJButton);
        recuperarPartidaJButton.setBounds(770, 590, 160, 60);

        suspenderPartidaJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        suspenderPartidaJButton.setForeground(new java.awt.Color(255, 255, 255));
        suspenderPartidaJButton.setText("Suspender Partida");
        suspenderPartidaJButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        suspenderPartidaJButton.setContentAreaFilled(false);
        suspenderPartidaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspenderPartidaJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(suspenderPartidaJButton);
        suspenderPartidaJButton.setBounds(770, 520, 160, 60);

        listadoDeMovimientos.setViewportView(listaMovimientos);

        getContentPane().add(listadoDeMovimientos);
        listadoDeMovimientos.setBounds(600, 70, 330, 440);

        panelCantidadFichasJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelCantidadFichasJ1.setOpaque(false);

        javax.swing.GroupLayout panelCantidadFichasJ1Layout = new javax.swing.GroupLayout(panelCantidadFichasJ1);
        panelCantidadFichasJ1.setLayout(panelCantidadFichasJ1Layout);
        panelCantidadFichasJ1Layout.setHorizontalGroup(
            panelCantidadFichasJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        panelCantidadFichasJ1Layout.setVerticalGroup(
            panelCantidadFichasJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        getContentPane().add(panelCantidadFichasJ1);
        panelCantidadFichasJ1.setBounds(950, 90, 280, 190);

        panelCantidadFichasJ2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelCantidadFichasJ2.setOpaque(false);

        javax.swing.GroupLayout panelCantidadFichasJ2Layout = new javax.swing.GroupLayout(panelCantidadFichasJ2);
        panelCantidadFichasJ2.setLayout(panelCantidadFichasJ2Layout);
        panelCantidadFichasJ2Layout.setHorizontalGroup(
            panelCantidadFichasJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        panelCantidadFichasJ2Layout.setVerticalGroup(
            panelCantidadFichasJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        getContentPane().add(panelCantidadFichasJ2);
        panelCantidadFichasJ2.setBounds(950, 320, 280, 190);

        jLabelJugador2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelJugador2.setForeground(new java.awt.Color(0, 0, 255));
        jLabelJugador2.setText("Jugador 2:");
        getContentPane().add(jLabelJugador2);
        jLabelJugador2.setBounds(950, 300, 70, 15);

        jLabelJugador1Alias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelJugador1Alias.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJugador1Alias.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabelJugador1AliasAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jLabelJugador1Alias);
        jLabelJugador1Alias.setBounds(1030, 60, 210, 30);

        jLabelJugador2Alias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelJugador2Alias.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelJugador2Alias);
        jLabelJugador2Alias.setBounds(1030, 290, 210, 30);

        jLabelJugador1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelJugador1.setForeground(new java.awt.Color(255, 51, 51));
        jLabelJugador1.setText("Jugador 1:");
        getContentPane().add(jLabelJugador1);
        jLabelJugador1.setBounds(950, 70, 70, 15);

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

        tableroBotonesJPanel.setMaximumSize(new java.awt.Dimension(505, 575));
        tableroBotonesJPanel.setMinimumSize(new java.awt.Dimension(505, 575));
        tableroBotonesJPanel.setOpaque(false);
        tableroBotonesJPanel.setPreferredSize(new java.awt.Dimension(505, 575));

        javax.swing.GroupLayout tableroBotonesJPanelLayout = new javax.swing.GroupLayout(tableroBotonesJPanel);
        tableroBotonesJPanel.setLayout(tableroBotonesJPanelLayout);
        tableroBotonesJPanelLayout.setHorizontalGroup(
            tableroBotonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        tableroBotonesJPanelLayout.setVerticalGroup(
            tableroBotonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        getContentPane().add(tableroBotonesJPanel);
        tableroBotonesJPanel.setBounds(65, 75, 500, 560);

        fondoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TableroJugar.gif"))); // NOI18N
        getContentPane().add(fondoJLabel);
        fondoJLabel.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonIrAtrasActionPerformed
        musica.stop();
        timer.stop();
        MenuPrincipal mp = new MenuPrincipal(esquina);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_JButtonIrAtrasActionPerformed

    private void jLabelJugador1AliasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabelJugador1AliasAncestorAdded

    }//GEN-LAST:event_jLabelJugador1AliasAncestorAdded

    private void suspenderPartidaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspenderPartidaJButtonActionPerformed
        esquina.agregarListadoPartida(esquina.getPartida());
        try {
            esquina.getPersistencia().writePartida();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaPartidas();
    }//GEN-LAST:event_suspenderPartidaJButtonActionPerformed

    private void recuperarPartidaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperarPartidaJButtonActionPerformed
        int posicion = listaPartidas.getSelectedIndex();
        if (posicion < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Partida", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            esquina.setPartida(esquina.getListaPartida().get(posicion));
            JOptionPane.showMessageDialog(null, "Se ha recuperado la partida con exito", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_recuperarPartidaJButtonActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        contador--;
        contadorLabel.setForeground(Color.white);
        if (contador < 11) {
            contadorLabel.setText(String.valueOf(contador));
            contadorLabel.setForeground(Color.red);
        } else {
            contadorLabel.setText(String.valueOf(contador));
        }
        if (contador == 0) {
            esquina.getPartida().setTerminado(true);
            timer.stop();
            if (esquina.getTablero().getFicha().isColor()) {
                JOptionPane.showMessageDialog(null, "El jugador 1 no ingreso ningún movimiento, el ganador es: " + esquina.getPartida().getJugador2().getAlias());
                esquina.getPartida().getJugador2().setCantGanadas(esquina.getPartida().getJugador2().getCantGanadas() + 1);
            } else {
                JOptionPane.showMessageDialog(null, "El jugador 2 no ingreso ningún movimiento, el ganador es: " + esquina.getPartida().getJugador1().getAlias());
                esquina.getPartida().getJugador1().setCantGanadas(esquina.getPartida().getJugador1().getCantGanadas() + 1);
            }
            musica.stop();
            dispose();
            MenuPrincipal mp = new MenuPrincipal(esquina);
            mp.setVisible(true);
        }
    }

    public void registroMoviminto(int fila, int columna) {
        DefaultListModel lista = new DefaultListModel();
        lista.clear();
        char filas = (char) ('A' + (fila - 1));
        String registro = "Fila: " + filas + "   Columna: " + columna;
        esquina.agregarRegistro(registro);
        for (int i = 0; i < esquina.getListaRegistro().size(); i++) {
            lista.addElement(esquina.getListaRegistro().get(i));
        }

        listaMovimientos.setModel(lista);

    }

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
// en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            clickBoton(x, y);

        }
    }

    private void clickBoton(int fila, int columna) {
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/musica/click.au"));
        sonido.play();
        
//El if se encarga de saber si la partida se terminó o no la partida
        if (!esquina.getPartida().isPartidaComputadora()) {
            esquina.getPartida().turnos(esquina.getTablero(), esquina.getTablero().getTablero(), fila - 1, columna - 1, esquina.getFicha());
            
        } else {
            esquina.getPartida().turnoComputadora(esquina.getTablero(), fila - 1, columna - 1, esquina.getTablero().getTablero(), esquina.getFicha());
        }

        cantFichas();
        iconoCantFichas();
        if (esquina.getTablero().getTablero()[fila - 1][columna - 1].getFicha() != 0) {
            registroMoviminto(fila, columna);
            iconoBotones();
            contador = 60;
            contadorLabel.setText(String.valueOf(contador));
            if (esquina.getPartida().getJugador1().getCantFichas() < 1 || esquina.getPartida().getJugador2().getCantFichas() < 1 || esquina.getPartida().isTerminado()) {
                timer.stop();
                partidaTerminada();
            }
        }

    }

    private void iconoBotones() {
        for (int i = 0; i < esquina.getTablero().getTablero().length; i++) {
            for (int j = 0; j < esquina.getTablero().getTablero()[0].length; j++) {
                Ficha ficha = esquina.getTablero().getTablero()[i][j];

                if (esquina.getTablero().getTablero()[i][j].isColor()) {
                    if (ficha.getFicha() != 0) {
                        switch (ficha.getFicha()) {
                            case 1:
                                botones[i + 1][j + 1].setIcon(fichaRojaBoton);
                                break;
                            case 2:
                                botones[i + 1][j + 1].setIcon(fichaEsquina2Roja);
                                break;
                            case 3:
                                botones[i + 1][j + 1].setIcon(fichaEsquina3Roja);
                                break;
                            case 4:
                                botones[i + 1][j + 1].setIcon(fichaEsquina4Roja);
                                break;
                            case 5:
                                botones[i + 1][j + 1].setIcon(fichaEsquina5Roja);
                                break;
                            default:
                                botones[i + 1][j + 1].setIcon(null);
                                break;
                        }
                    }
                } else if (ficha.getFicha() != 0) {
                    switch (ficha.getFicha()) {
                        case 1:
                            botones[i + 1][j + 1].setIcon(fichasAzul);
                            break;
                        case 2:
                            botones[i + 1][j + 1].setIcon(fichaEsquina2Azul);
                            break;
                        case 3:
                            botones[i + 1][j + 1].setIcon(fichaEsquina3Azul);
                            break;
                        case 4:
                            botones[i + 1][j + 1].setIcon(fichaEsquina4Azul);
                            break;
                        case 5:
                            botones[i + 1][j + 1].setIcon(fichaEsquina5Azul);
                            break;
                        default:
                            botones[i + 1][j + 1].setIcon(null);
                            break;
                    }
                }
            }
        }

    }

    public void aliasJugadores() {
        jLabelJugador1Alias.setText(esquina.getPartida().getJugador1().getAlias());
        if (esquina.getPartida().isPartidaComputadora()) {
            esquina.getPartida().getJugador2().setAlias("Computadora");
            jLabelJugador2Alias.setText(esquina.getPartida().getJugador2().getAlias());
        } else {
            jLabelJugador2Alias.setText(esquina.getPartida().getJugador2().getAlias());
        }
    }

    public void cantFichas() {
        panelCantidadFichasJ1.removeAll();
        panelCantidadFichasJ2.removeAll();
        panelCantidadFichasJ1.setLayout(new GridLayout(5, 5, 1, 1));
        panelCantidadFichasJ2.setLayout(new GridLayout(5, 5, 1, 1));
        //Con esto modificamos el grid layout del tablero
        botonesJ1 = new JButton[5][5];
        botonesJ2 = new JButton[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JButton jButton1 = new JButton();
                JButton jButton2 = new JButton();
                panelCantidadFichasJ1.add(jButton1);
                panelCantidadFichasJ2.add(jButton2);
                botonesJ1[i][j] = jButton1;
                botonesJ2[i][j] = jButton2;
                botonesJ1[i][j].setContentAreaFilled(false);
                botonesJ2[i][j].setContentAreaFilled(false);
            }
        }
    }

    public void partidaTerminada() {
        if (esquina.getPartida().getJugador1().isGanadas()) {
            JOptionPane.showMessageDialog(null, "Se ha terminado la partida el ganador es: " + esquina.getPartida().getJugador1().getAlias());
        } else if (esquina.getPartida().getJugador2().isGanadas()) {
            JOptionPane.showMessageDialog(null, "Se ha terminado la partida el ganador es: " + esquina.getPartida().getJugador2().getAlias());
        }
        musica.stop();
        dispose();
        MenuPrincipal mp = new MenuPrincipal(esquina);
        mp.setVisible(true);
    }

    public void iconoCantFichas() {
        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < botonesJ1.length; i++) {
            for (int j = 0; j < botonesJ1[0].length; j++) {
                cont1++;
                cont2++;
                if (esquina.getPartida().getJugador1().getCantFichas() >= cont1) {
                    botonesJ1[i][j].setIcon(fichaRojaJ1);
                }

                if (esquina.getPartida().getJugador2().getCantFichas() >= cont2) {
                    botonesJ2[i][j].setIcon(fichaAzulJ2);
                }

            }
        }
    }

    public void musicaFondo() {
        musica = java.applet.Applet.newAudioClip(getClass().getResource("/musica/EscapebyLegna.au"));
        musica.loop();
    }

    public void listaPartidas() {
        modeloLista.clear();
        for (int i = 0; i < esquina.getListaPartida().size(); i++) {
            modeloLista.addElement(esquina.getListaPartida().get(i));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonIrAtras;
    private javax.swing.JLabel contadorLabel;
    private javax.swing.JLabel fondoJLabel;
    private javax.swing.JLabel jLabelJugador1;
    private javax.swing.JLabel jLabelJugador1Alias;
    private javax.swing.JLabel jLabelJugador2;
    private javax.swing.JLabel jLabelJugador2Alias;
    private javax.swing.JList<String> listaMovimientos;
    private javax.swing.JList<String> listaPartidas;
    private javax.swing.JScrollPane listadoDeMovimientos;
    private javax.swing.JScrollPane listadoDePartidas;
    private javax.swing.JPanel panelCantidadFichasJ1;
    private javax.swing.JPanel panelCantidadFichasJ2;
    private javax.swing.JButton recuperarPartidaJButton;
    private javax.swing.JButton suspenderPartidaJButton;
    private javax.swing.JPanel tableroBotonesJPanel;
    // End of variables declaration//GEN-END:variables

}
