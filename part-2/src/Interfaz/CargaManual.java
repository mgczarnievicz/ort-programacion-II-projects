/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Interfaz;

import Dominio.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CargaManual extends javax.swing.JFrame {
    //Inicio de variables
    private JButton[][] botones;
    private JButton[][] botonesL;
    private JButton[][] botonesN;
    int dimensionF = 8;
    int dimensionC = 8;
    char turno = 'B';
    private Sistema sis;
    private Partida part;
    private Tablero tablero;

    //Constructor de la ventana
    public CargaManual(Sistema s) {
        //Se cargan las variables.
        sis = s;
        part = sis.getListaDePartidas().get(sis.getListaDePartidas().size() - 1);
        tablero = part.getListaDeJugadas().get(0).getTablero();
        initComponents();
        //Se coloca la imagen de fondo.
        ImagePanel panel = new ImagePanel(new ImageIcon("src/Imagenes/FondoTableroVerde.jpg").getImage());
        this.pack();
        this.getContentPane().add(panel);

        //Se crean botones y se agregan al panel
        String[] letra = {"A", "B", "C", " D", "E", " F", "G", "H"};
        panelLetra.setLayout(new GridLayout(1, dimensionC));
        botonesL = new JButton[1 + 2][dimensionC + 2];
        //Se agregan los botones al panelLetra
        for (int i = 1; i <= 1; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                JButton jButtonL = new JButton();
                panelLetra.add(jButtonL);
                botonesL[i][j] = jButtonL;
                //Se indican las diferentes medidas para los botones.
                botonesL[i][j].setMargin(new Insets(5, 26, 5, 26));
                botonesL[i][j].setText(letra[j - 1]);
            }
        }
        //Se colocan los números al costado del tablero.
        String[] nro = {"8", "7", "6", "5", "4", "3", "2", "1"};
        panelNro.setLayout(new GridLayout(dimensionF, 1));
        botonesN = new JButton[dimensionF + 2][1 + 2];
        //Se agregan los botones al panelNro.
        for (int i = 1; i <= dimensionF; i++) {
            for (int j = 1; j <= 1; j++) {
                JButton jButtonN = new JButton();
                panelNro.add(jButtonN);
                botonesN[i][j] = jButtonN;
                //Se indican las diferentes medidas para los botones.
                botonesN[i][j].setMargin(new Insets(24, 10, 24, 10));
                botonesN[i][j].setText(nro[i - 1]);
            }
        }

        //Se crean botones y se agregan al panel, en este caso el Tablero.
        panelJuego.setLayout(new GridLayout(dimensionF, dimensionC));
        botones = new JButton[dimensionF + 2][dimensionC + 2];

        for (int i = 1; i <= dimensionF; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                //Se agregan los botones
                panelJuego.add(jButton);
                botones[i][j] = jButton;
                //Se le colocan las medidas de los botones
                botones[i][j].setMargin(new Insets(48, 15, 15, 48));
                //Se colorean los botones según sean negros o blancos.
                if ((i + j) % 2 == 0) {
                    botones[i][j].setBackground(Color.WHITE);
                } else {
                    botones[i][j].setBackground(Color.BLACK);
                }
            }
        }
        //Ponemos los diferentes iconos para los botones correspondientes.
        botonAlfilBlanco.setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilBlanco.png"))));
        botonAlfilNegro.setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilNegro.png"))));
        botonEstoyColocando.setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilBlanco.png"))));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        botonAlfilBlanco = new javax.swing.JButton();
        botonAlfilNegro = new javax.swing.JButton();
        botonFin = new javax.swing.JButton();
        etiquetaEstaColocando = new javax.swing.JLabel();
        botonEstoyColocando = new javax.swing.JButton();
        panelLetra = new javax.swing.JPanel();
        panelNro = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        botonAlfilBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlfilBlancoActionPerformed(evt);
            }
        });

        botonAlfilNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlfilNegroActionPerformed(evt);
            }
        });

        botonFin.setText("FIN");
        botonFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinActionPerformed(evt);
            }
        });

        etiquetaEstaColocando.setText("ESTA COLOCANDO:");

        javax.swing.GroupLayout panelLetraLayout = new javax.swing.GroupLayout(panelLetra);
        panelLetra.setLayout(panelLetraLayout);
        panelLetraLayout.setHorizontalGroup(
            panelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );
        panelLetraLayout.setVerticalGroup(
            panelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelNroLayout = new javax.swing.GroupLayout(panelNro);
        panelNro.setLayout(panelNroLayout);
        panelNroLayout.setHorizontalGroup(
            panelNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        panelNroLayout.setVerticalGroup(
            panelNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelLetra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJuego, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(botonFin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonAlfilBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonAlfilNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(botonEstoyColocando, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(etiquetaEstaColocando)))))
                .addGap(312, 312, 312))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panelLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonAlfilNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAlfilBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaEstaColocando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEstoyColocando, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(botonFin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelNro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelJuego, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(328, Short.MAX_VALUE))
        );

        setBounds(0, 0, 900, 765);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAlfilNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlfilNegroActionPerformed
        //Se cambia el turno a Negro y se cambia el icono del botón que muestra que pieza se esta colocando por una pieza negra.
        turno = 'N';
        botonEstoyColocando.setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilNegro.png"))));
    }//GEN-LAST:event_botonAlfilNegroActionPerformed

    private void botonAlfilBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlfilBlancoActionPerformed
        //Se cambia el turno a Blanco y se cambia el icono del botón que muestra que pieza se esta colocando por una pieza blanca.
        turno = 'B';
        botonEstoyColocando.setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilBlanco.png"))));
    }//GEN-LAST:event_botonAlfilBlancoActionPerformed

    private void botonFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinActionPerformed
        //Se valida que haya fichas de ambos colores para que se pueda jugar.
        if (tablero.hayDeAmbosColores()) {
            //Se le setea el tablero a la partida.
            sis.getListaDePartidas().get(sis.getListaDePartidas().size() - 1).getListaDeJugadas().get(0).setTablero(tablero);
            //Se muestra la ventana donde se juega.
            MuestraTablero tab = new MuestraTablero(sis);
            tab.setVisible(true);
            //Cierra la ventana actual.
            dispose();
        } else {
            //Muestra el error.
            JOptionPane.showMessageDialog(this, "Debe haber al menos un alfil de cada color", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonFinActionPerformed

    private class ListenerBoton implements ActionListener {
        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
        // En el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
        // Cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {
        //Realiza la validación simple de que la casilla sea blanca.
        if ((fila + columna) % 2 == 0) {
            //Se pone una ficha del color actual, que es un char llamado turno que se actualiza con los botones que cambian que color de alfil se coloca.
            tablero.getTablero()[fila - 1][columna - 1].setPieza(turno);
            for (int i = 1; i <= dimensionF; i++) {
                for (int j = 1; j <= dimensionC; j++) {
                    botones[i][j].setMargin(new Insets(5, 10, 5, 10));
                }
            }
            //Se coloca el icono correspondiente al alfil que se colocó.
            botones[fila][columna].setIcon(botonEstoyColocando.getIcon());
        } else {
            //Indica el error.
            JOptionPane.showMessageDialog(this, "Los alfiles se colocan en las casillas blancas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlfilBlanco;
    private javax.swing.JButton botonAlfilNegro;
    private javax.swing.JButton botonEstoyColocando;
    private javax.swing.JButton botonFin;
    private javax.swing.JLabel etiquetaEstaColocando;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelLetra;
    private javax.swing.JPanel panelNro;
    // End of variables declaration//GEN-END:variables
}
