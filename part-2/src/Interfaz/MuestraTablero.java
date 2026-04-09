/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Interfaz;

import Dominio.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;

public class MuestraTablero extends javax.swing.JFrame {

    private JButton[][] botones;
    private JButton[][] botonesL;
    private JButton[][] botonesN;
    int dimensionF = 8;
    int dimensionC = 8;
    int cantidad = 0;
    int cantidadJug = 0;
    private Sistema sis;
    private Partida part;
    Tablero tablero;
    String mensaje[] = new String[4];
    int pos[] = new int[4];
    int cantAyuda;
    boolean yaClick = false;
    boolean cerroConFin = false;

    /** Creates new form Tablero */
    public MuestraTablero(Sistema s) {
        sis = s;
        initComponents();

        //le agrego la imagen a la ventana
        ImagePanel panel = new ImagePanel(new ImageIcon("src/Imagenes/FondoTableroVerde.jpg").getImage());
        this.pack();
        this.getContentPane().add(panel);

        //A los componentes de la ventana les digo que tengan fondo transparentes asi se
        //ve el fondo de la ventana y no el fondo de cada componente
        botonTodasAyuda.setOpaque(false);
        boton0Ayuda.setOpaque(false);
        boton1Ayuda.setOpaque(false);
        boton2Ayuda.setOpaque(false);

        //Agarro al ultima partida ingreada ya que es en la cual se va a jugar
        part = sis.getListaDePartidas().get(sis.getListaDePartidas().size() - 1);

        //le seteo quien comienza jugando a la etiqueta
        etiquetaTurno.setText("Es el turno de: " + part.getJugadorB().getNombre());

        //Me creo al tablero con el cual se jugará
        tablero = part.getListaDeJugadas().get(0).getTablero();

        //Se crean los botones y se los agrega al panel de Letras al costado.
        String[] letra = {"A", "B", "C", " D", "E", " F", "G", "H"};
        panelLetra.setLayout(new GridLayout(1, dimensionC));
        botonesL = new JButton[1 + 2][dimensionC + 2];

        for (int i = 1; i <= 1; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                JButton jButtonL = new JButton();
                panelLetra.add(jButtonL);
                botonesL[i][j] = jButtonL;
                //ALTO, MARGEN PARA CENTRAR, MAEGEN PARA CENTRAR, LARGO
                botonesL[i][j].setMargin(new Insets(5, 26, 5, 26));
                botonesL[i][j].setText(letra[j - 1]);
            }
        }

        //Se crean los botones y se los agrega al panel de números al costado.
        String[] nro = {"8", "7", "6", "5", "4", "3", "2", "1"};
        panelNro.setLayout(new GridLayout(dimensionF, 1));
        botonesN = new JButton[dimensionF + 2][1 + 2];
        for (int i = 1; i <= dimensionF; i++) {
            for (int j = 1; j <= 1; j++) {
                JButton jButtonN = new JButton();
                panelNro.add(jButtonN);
                botonesN[i][j] = jButtonN;
                //ALTO, MARGEN PARA CENTRAR, MARGEN PARA CENTRAR, LARGO
                botonesN[i][j].setMargin(new Insets(24, 10, 24, 10));
                botonesN[i][j].setText(nro[i - 1]);
            }
        }

        //Se crean los botones y se agregan al panel
        panelJuego.setLayout(new GridLayout(dimensionF, dimensionC));
        botones = new JButton[dimensionF + 2][dimensionC + 2];

        for (int i = 1; i <= dimensionF; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;
                botones[i][j].setMargin(new Insets(5, 10, 5, 10));


                if ((i + j) % 2 == 0) {
                    //Le pongo el color a las casilleros Blancoas
                    botones[i][j].setBackground(Color.WHITE);
                    //le coloca la imagen del alfil correspondiente al lugar corespondiente
                    if (tablero.getTablero()[i - 1][j - 1].colorPieza('B')) {
                        botones[i][j].setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilBlanco.png"))));
                    }
                    if (tablero.getTablero()[i - 1][j - 1].colorPieza('N')) {
                        botones[i][j].setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilNegro.png"))));
                    }
                } else {
                    //Le pongo color a los casilleros Negros
                    botones[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        panelJuego = new javax.swing.JPanel();
        botonColor1 = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonMuestraBlanco = new javax.swing.JButton();
        botonMuestraNegro = new javax.swing.JButton();
        botonColor2 = new javax.swing.JButton();
        boton0Ayuda = new javax.swing.JRadioButton();
        boton1Ayuda = new javax.swing.JRadioButton();
        boton2Ayuda = new javax.swing.JRadioButton();
        botonTodasAyuda = new javax.swing.JRadioButton();
        EtiquetaAyuda = new javax.swing.JLabel();
        panelLetra = new javax.swing.JPanel();
        etiquetaTurno = new javax.swing.JLabel();
        panelNro = new javax.swing.JPanel();
        etiquetaJugadaCompu = new javax.swing.JLabel();
        botonFin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        botonColor1.setText("COLOR");
        botonColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColor1ActionPerformed(evt);
            }
        });

        botonGuardar.setText("GUARDAR");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonMuestraBlanco.setBackground(new java.awt.Color(255, 255, 255));

        botonMuestraNegro.setBackground(new java.awt.Color(0, 0, 0));

        botonColor2.setText("COLOR");
        botonColor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColor2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(boton0Ayuda);
        boton0Ayuda.setFont(new java.awt.Font("Century Gothic", 1, 12));
        boton0Ayuda.setText("0 ");
        boton0Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton0AyudaActionPerformed(evt);
            }
        });

        buttonGroup1.add(boton1Ayuda);
        boton1Ayuda.setFont(new java.awt.Font("Century Gothic", 1, 12));
        boton1Ayuda.setText("1");
        boton1Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1AyudaActionPerformed(evt);
            }
        });

        buttonGroup1.add(boton2Ayuda);
        boton2Ayuda.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        boton2Ayuda.setText("2");
        boton2Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2AyudaActionPerformed(evt);
            }
        });

        buttonGroup1.add(botonTodasAyuda);
        botonTodasAyuda.setFont(new java.awt.Font("Century Gothic", 1, 12));
        botonTodasAyuda.setText("Todos");
        botonTodasAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTodasAyudaActionPerformed(evt);
            }
        });

        EtiquetaAyuda.setFont(new java.awt.Font("Century Gothic", 1, 12));
        EtiquetaAyuda.setText("Seleccione la Cantidad de ayuda");

        javax.swing.GroupLayout panelLetraLayout = new javax.swing.GroupLayout(panelLetra);
        panelLetra.setLayout(panelLetraLayout);
        panelLetraLayout.setHorizontalGroup(
            panelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        panelLetraLayout.setVerticalGroup(
            panelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        etiquetaTurno.setFont(new java.awt.Font("Century Gothic", 1, 14));
        etiquetaTurno.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelNroLayout = new javax.swing.GroupLayout(panelNro);
        panelNro.setLayout(panelNroLayout);
        panelNroLayout.setHorizontalGroup(
            panelNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        panelNroLayout.setVerticalGroup(
            panelNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        etiquetaJugadaCompu.setFont(new java.awt.Font("Century Gothic", 1, 14));
        etiquetaJugadaCompu.setForeground(new java.awt.Color(255, 255, 255));

        botonFin.setText("FIN");
        botonFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(etiquetaTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EtiquetaAyuda)
                                .addComponent(botonTodasAyuda)
                                .addComponent(boton2Ayuda)
                                .addComponent(boton1Ayuda)
                                .addComponent(boton0Ayuda)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botonMuestraNegro)
                                        .addComponent(botonMuestraBlanco))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botonColor2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(etiquetaJugadaCompu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonFin)
                        .addGap(150, 150, 150)))
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaJugadaCompu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(etiquetaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonMuestraBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonColor1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonMuestraNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonColor2))
                        .addGap(64, 64, 64)
                        .addComponent(EtiquetaAyuda)
                        .addGap(18, 18, 18)
                        .addComponent(boton0Ayuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton1Ayuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton2Ayuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonTodasAyuda)
                        .addGap(46, 46, 46)
                        .addComponent(botonFin))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelNro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelJuego, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        setBounds(0, 0, 950, 695);
    }// </editor-fold>//GEN-END:initComponents

    private void botonColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColor1ActionPerformed
        //Boton que muestra el panel de colores para cambiar de color de los casilleros Blancos
        Color r = JColorChooser.showDialog(null, "COLORES", Color.WHITE);
        if (r != null) {
            botonMuestraBlanco.setBackground(r);
            llenarFondo();
        }
        ayuda(cantAyuda, cantidadJug, pos, tablero, pos);
    }//GEN-LAST:event_botonColor1ActionPerformed

    private void botonColor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColor2ActionPerformed
        //Boton que muestra el panel de colores para cambiar de color de los casilleros Negros
        Color r = JColorChooser.showDialog(null, "COLORES", Color.BLACK);
        if (r != null) {
            botonMuestraNegro.setBackground(r);
            llenarFondo();
        }
        ayuda(cantAyuda, cantidadJug, pos, tablero, pos);
    }//GEN-LAST:event_botonColor2ActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        //Boton que guarda la jugada actual
        JFileChooser fc = new JFileChooser();
        int retorno = fc.showSaveDialog(this);
        File f = fc.getSelectedFile();
        if (retorno == fc.APPROVE_OPTION) {
            part.grabarPartida(f.getPath());
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void boton1AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1AyudaActionPerformed
        //Boton de una ayuda
        cantAyuda = 1;
        if (yaClick) {
            llenarFondo();
            ayuda(cantAyuda, cantidadJug, pos, tablero, pos);
        }
    }//GEN-LAST:event_boton1AyudaActionPerformed

    private void boton0AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton0AyudaActionPerformed
        //Boton de 0 ayuda
        cantAyuda = 0;
        llenarFondo();
    }//GEN-LAST:event_boton0AyudaActionPerformed

    private void boton2AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2AyudaActionPerformed
        //Boton de 2 ayudas
        cantAyuda = 2;
        if (yaClick) {
            llenarFondo();
            ayuda(cantAyuda, cantidadJug, pos, tablero, pos);
        }
    }//GEN-LAST:event_boton2AyudaActionPerformed

    private void botonTodasAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTodasAyudaActionPerformed
        //Boton que muestra todas las posibles movimientos de un alfil.
        //como Muhco, un alfil va a tener 13 posiciones posibles
        cantAyuda = 13;
        ayuda(cantAyuda, cantidadJug, pos, tablero, pos);
    }//GEN-LAST:event_botonTodasAyudaActionPerformed

    private void botonFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinActionPerformed
        //Boton para finalizar una partida
        int ce;
        JOptionPane op = new JOptionPane();
        //Se avisa como se tomara el abandono de la partida
        ce = op.showConfirmDialog(this, "Si sale se tomará como abandono", null, JOptionPane.OK_CANCEL_OPTION);
        setVisible(true);
        if (ce == 2 || ce == -1) {
            //Lo que sucede si pone "Cancelas"
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            //Si Acepta, se pasa por el metodo jugar para setear los juegos jugados y quien gana
            mensaje = part.jugar(cantidadJug, sis, tablero, "FIN");
            //Se notifica al usuario el ganador de la partida
            JOptionPane.showMessageDialog(this, mensaje[0], "VICTORIA", JOptionPane.INFORMATION_MESSAGE);
            cerroConFin = true;
            dispose();
        }

    }//GEN-LAST:event_botonFinActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Método que cierra la ventana
        int ce;
        JOptionPane op = new JOptionPane();
        //Se notifica al usuario como se tomara la partida si se abandona
        ce = op.showConfirmDialog(this, "Si sale se tomará como abandono", null, JOptionPane.OK_CANCEL_OPTION);
        setVisible(true);
        if (ce == 2 || ce == -1) {
            //Si "Cancela"
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            if (!cerroConFin) {
                //Seteo los juegos Jugados y los ganados al pasar por el método jugar
                mensaje = part.jugar(cantidadJug, sis, tablero, "FIN");
                //Se notifica al usuario quien gano la partida
                JOptionPane.showMessageDialog(this, mensaje[0], "VICTORIA", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }

    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EtiquetaAyuda;
    private javax.swing.JRadioButton boton0Ayuda;
    private javax.swing.JRadioButton boton1Ayuda;
    private javax.swing.JRadioButton boton2Ayuda;
    private javax.swing.JButton botonColor1;
    private javax.swing.JButton botonColor2;
    private javax.swing.JButton botonFin;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonMuestraBlanco;
    private javax.swing.JButton botonMuestraNegro;
    private javax.swing.JRadioButton botonTodasAyuda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel etiquetaJugadaCompu;
    private javax.swing.JLabel etiquetaTurno;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelLetra;
    private javax.swing.JPanel panelNro;
    // End of variables declaration//GEN-END:variables

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {
        yaClick = true;
        mensaje[0] = "";
        mensaje[1] = "";
        mensaje[2] = "";
        mensaje[3] = "";

        //le suma uno a la variable cantidad
        cantidad++;


        if (cantidad == 1) {
            //Guarda las posiciones del primer clik
            pos[0] = fila - 1;
            pos[1] = columna - 1;
            //Muestra la cantidad e ayuda dependiendo de la seleccionada
            if (tablero.esTurno(cantidadJug, pos[0], pos[1])) {
                ayuda(cantAyuda, cantidadJug, pos, tablero, pos);
            } else {
                //Notifica al usuario si la pieza Seleccionada no es del turno correspondiente
                JOptionPane.showMessageDialog(this, "La pieza no es de color del turno", "ERROR", JOptionPane.ERROR_MESSAGE);
                cantidad = 0;
            }
        }

        if (cantidad == 2) {
            //Vuelve a la cantidada el  valor inicial
            cantidad = 0;

            //Guarda la posicion del segundo clik
            pos[3] = columna - 1;
            pos[2] = fila - 1;
            //Vuelve a los casilleros pintados por la ayuda al color correpondiente
            if (tablero.esTurno(cantidadJug, pos[2], pos[3])) {
                pos[0] = fila - 1;
                pos[1] = columna - 1;
                llenarFondo();
                ayuda(cantAyuda, cantidadJug, pos, tablero, pos);
                cantidad = 1;
            } else {
                String jugada = "";
                llenarFondo();
                //Si no le toca a la computadora, pido una jugada.
                jugada = Jugada.traductorPosicion(pos);

                mensaje = part.jugar(cantidadJug, sis, tablero, jugada);

                if (!mensaje[2].equals("")) {
                    JOptionPane.showMessageDialog(this, mensaje[2], "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    etiquetaJugadaCompu.setText(null);
                    cantidadJug++;

                    fichasTablero(tablero);

                    etiquetaTurno.setText(mensaje[3]);

                    if (mensaje[1].equals("FIN")) {
                        JOptionPane.showMessageDialog(this, mensaje[0], "VICTORIA", JOptionPane.INFORMATION_MESSAGE);
                        cerroConFin = true;
                        dispose();
                    }
                }
                //Valido si le toca o no a la computadora.
                if ((part.getJugadorN().getNombre().equalsIgnoreCase("Computadora")) && !mensaje[1].equals("FIN") && mensaje[2].equals("")) {


                    mensaje = part.jugar(cantidadJug, sis, tablero, jugada);

                    if (!mensaje[2].equals("")) {
                        JOptionPane.showMessageDialog(this, mensaje[2], "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        etiquetaJugadaCompu.setText(mensaje[0]);
                        cantidadJug++;

                        fichasTablero(tablero);
                    }
                    etiquetaTurno.setText(mensaje[3]);

                    if (mensaje[1].equals("FIN")) {
                        JOptionPane.showMessageDialog(this, mensaje[0], "VICTORIA", JOptionPane.INFORMATION_MESSAGE);
                        cerroConFin = true;
                        dispose();
                    }
                }
            }
        }
    }

    //Me coloca en las posiciones de los char la imagen correspondiente
    public void fichasTablero(Tablero tablero) {
        for (int i = 1; i <= dimensionF; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                botones[i][j].setMargin(new Insets(5, 10, 5, 10));
                if (tablero.getTablero()[i - 1][j - 1].colorPieza('B')) {
                    botones[i][j].setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilBlanco.png"))));
                }
                if (tablero.getTablero()[i - 1][j - 1].colorPieza('N')) {
                    botones[i][j].setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilNegro.png"))));
                }
                if (tablero.getTablero()[i - 1][j - 1].colorPieza(' ')) {
                    botones[i][j].setIcon(null);
                }

            }
        }
    }

    public void llenarFondo() {
        for (int i = 1; i <= dimensionF; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                if ((i + j) % 2 == 0) {
                    botones[i][j].setBackground(botonMuestraBlanco.getBackground());
                } else {
                    botones[i][j].setBackground(botonMuestraNegro.getBackground());
                }
                botones[i][j].setMargin(new Insets(5, 10, 5, 10));
            }
        }
    }

    public void ayuda(int cant, int cantJug, int[] posiciones, Tablero tab, int[] posi) {
        if (yaClick) {
            if (tab.esTurno(cantJug, posi[0], posi[1])) {
                Casillero cas[] = tab.casillasPosibles(posiciones[0], posiciones[1], cantJug);
                for (int i = 0; i < cant; i++) {
                    if (cas[i] != null) {
                        botones[cas[i].getCoordenadaI() + 1][cas[i].getCoordenadaJ() + 1].setBackground(Color.GREEN);
                    }
                }
            }
        }
    }
}
