/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Interfaz;

import Dominio.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MuestraPartida extends javax.swing.JFrame implements Observer {

    private JButton[][] botones;
    private JButton[][] botonesL;
    private JButton[][] botonesN;
    int dimensionF = 8;
    int dimensionC = 8;
    private Sistema sis;
    private Partida part;
    int cant = 1;

    //Constructor de MuestraPartida
    public MuestraPartida(Sistema s) {
        //Se inicializan las variables
        sis = s;
        sis.addObserver(this);

        //Hago que la ultima partida, osa la que se esta gurdando sea observable
        Partida ultimapart=sis.getListaDePartidas().get(sis.getListaDePartidas().size()-1);
       ultimapart.addObserver(this);

        initComponents();
        this.setTitle("Repeticion de Partida");
        //Se le pone la imagen de fondo.
        ImagePanel panel = new ImagePanel(new ImageIcon("src/Imagenes/FondoTableroVerde.jpg").getImage());
        this.pack();
        this.getContentPane().add(panel);
       //Se le pone los iconos a los botones.
        botonMas.setIcon((new ImageIcon(getClass().getResource("/Imagenes/Flecha+.png"))));
        botonMenos.setIcon((new ImageIcon(getClass().getResource("/Imagenes/Flecha-.png"))));

        //Se crean los botones y se los agrega al panel de Letras al costado.
        String[] letra = {"A", "B", "C", " D", "E", " F", "G", "H"};
        panelLetra.setLayout(new GridLayout(1, dimensionC));
        botonesL = new JButton[1 + 2][dimensionC + 2];

        for (int i = 1; i <= 1; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                JButton jButtonL = new JButton();
                panelLetra.add(jButtonL);
                botonesL[i][j] = jButtonL;
                //Se le pasan las medidas a los botones.
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
                //Se le pasan las medidas a los botones.
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
                panelJuego.add(jButton);
                botones[i][j] = jButton;
                botones[i][j].setMargin(new Insets(48, 15, 15, 48));
                //Se pintan los botones de los colores correspondientes
                if ((i + j) % 2 == 0) {
                    botones[i][j].setBackground(Color.WHITE);
                } else {
                    botones[i][j].setBackground(Color.BLACK);
                }
            }
        }
        //Llamo al método que actualiza la ventana
        update(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        botonMenos = new javax.swing.JButton();
        botonMas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPartidas = new javax.swing.JList();
        etiquetaMuestraJugada = new javax.swing.JLabel();
        etiqueteLaJugadaRealizadaFue = new javax.swing.JLabel();
        panelLetra = new javax.swing.JPanel();
        panelNro = new javax.swing.JPanel();
        etiquetaElijaUnaPartida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        botonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenosActionPerformed(evt);
            }
        });

        botonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMasActionPerformed(evt);
            }
        });

        listaPartidas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaPartidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPartidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaPartidas);

        etiquetaMuestraJugada.setFont(new java.awt.Font("Century Gothic", 1, 12));
        etiquetaMuestraJugada.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaMuestraJugada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaMuestraJugada.setText("Jugada");

        etiqueteLaJugadaRealizadaFue.setFont(new java.awt.Font("Century Gothic", 1, 12));
        etiqueteLaJugadaRealizadaFue.setForeground(new java.awt.Color(255, 255, 255));
        etiqueteLaJugadaRealizadaFue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueteLaJugadaRealizadaFue.setText("La Jugada realizada fue:");

        javax.swing.GroupLayout panelLetraLayout = new javax.swing.GroupLayout(panelLetra);
        panelLetra.setLayout(panelLetraLayout);
        panelLetraLayout.setHorizontalGroup(
            panelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        panelLetraLayout.setVerticalGroup(
            panelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelNroLayout = new javax.swing.GroupLayout(panelNro);
        panelNro.setLayout(panelNroLayout);
        panelNroLayout.setHorizontalGroup(
            panelNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        panelNroLayout.setVerticalGroup(
            panelNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        etiquetaElijaUnaPartida.setFont(new java.awt.Font("Century Gothic", 1, 14));
        etiquetaElijaUnaPartida.setText("Elija una Partida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(etiquetaElijaUnaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiqueteLaJugadaRealizadaFue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaMuestraJugada, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(panelNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonMas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(panelLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiqueteLaJugadaRealizadaFue, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiquetaMuestraJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelNro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonMas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaElijaUnaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setBounds(0, 0, 1200, 760);
    }// </editor-fold>//GEN-END:initComponents

    private void botonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMasActionPerformed
        //boton el cual pasa a la siguiente jugada de la partida seleccionada.
        //Valida primero que tengas seleccionado una partida
        if (part == null) {
            JOptionPane.showMessageDialog(this, "DEBES ELEGIR UNA PARTIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Valida que no me pase de la cantidad de partidas que hay
            if (cant >= part.getListaDeJugadas().size() - 1) {

                JOptionPane.showMessageDialog(this, "NO HAY JUGADAS POSTERIORES", "ERROR", JOptionPane.ERROR_MESSAGE);
                //cant=part.getListaDeJugadas().size();
            } else {
                //Si hay jugada la muestro
                cant++;
                muestraTablero(cant, part);
                etiquetaMuestraJugada.setText(part.getListaDeJugadas().get(cant).getJugada());
            }
        }
    }//GEN-LAST:event_botonMasActionPerformed

    private void listaPartidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPartidasMouseClicked
        //Selecciono una partida de la lista
        part = (Partida) listaPartidas.getSelectedValue();
        cant = 1;       
        if(part.getListaDeJugadas().size()==1){
            muestraTablero(0, part);
            JOptionPane.showMessageDialog(this, "Esta partida fue abandonada al comienzo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
             muestraTablero(cant, part);
            etiquetaMuestraJugada.setText(part.getListaDeJugadas().get(cant).getJugada());
        }
       


    }//GEN-LAST:event_listaPartidasMouseClicked

    private void botonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenosActionPerformed
       //Boton que muestra la jugada posterior
        //Valida Primero que hallas seleccionado una partida
        if (part == null) {
            JOptionPane.showMessageDialog(this, "DEBES ELEGIR UNA PARTIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Valida si quedan jugadas posteriores
            if (cant == 1) {
                JOptionPane.showMessageDialog(this, "NO HAY JUGADAS ANTERIORES", "ERROR", JOptionPane.ERROR_MESSAGE);
                cant = 1;
            } else {
                //Si hay jugadas, la muestra
                cant--;
                muestraTablero(cant, part);
                etiquetaMuestraJugada.setText(part.getListaDeJugadas().get(cant).getJugada());
                
            }
        }
    }//GEN-LAST:event_botonMenosActionPerformed

    //Método que actuliza la ventana
    public void update(Observable o, Object arg) {
        listaPartidas.setListData(sis.getListaDePartidas().toArray());

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMas;
    private javax.swing.JButton botonMenos;
    private javax.swing.JLabel etiquetaElijaUnaPartida;
    private javax.swing.JLabel etiquetaMuestraJugada;
    private javax.swing.JLabel etiqueteLaJugadaRealizadaFue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaPartidas;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelLetra;
    private javax.swing.JPanel panelNro;
    // End of variables declaration//GEN-END:variables

    public void muestraTablero(int cant, Partida part) {
        for (int i = 1; i <= dimensionF; i++) {
            for (int j = 1; j <= dimensionC; j++) {
                botones[i][j].setMargin(new Insets(5, 10, 5, 10));
                if (part.getListaDeJugadas().get(cant).getTablero().getTablero()[i - 1][j - 1].colorPieza('B')) {
                    botones[i][j].setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilBlanco.png"))));
                }
                if (part.getListaDeJugadas().get(cant).getTablero().getTablero()[i - 1][j - 1].colorPieza('N')) {
                    botones[i][j].setIcon((new ImageIcon(getClass().getResource("/Imagenes/alfilNegro.png"))));
                }
                if (part.getListaDeJugadas().get(cant).getTablero().getTablero()[i - 1][j - 1].colorPieza(' ')) {
                    botones[i][j].setIcon(null);
                }
            }
        }
    }
}
