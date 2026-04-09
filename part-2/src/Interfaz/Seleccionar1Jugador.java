/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */

package Interfaz;

import Dominio.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Seleccionar1Jugador extends javax.swing.JFrame implements Observer {

    private Jugador j;
    ArrayList<Jugador>jug;
    private Sistema sis;
    Partida part;

    /** Creates new form Seleccionar1Jugador */
    public Seleccionar1Jugador(Sistema s) {
        sis = s;
        sis.addObserver(this);
        initComponents();
        //Le sete al slider que su fondo sea transparente
        jSlider1.setOpaque(false);

        //Le agrego el nombre a la ventana
        this.setTitle("Jugar de un Jugador");

        //le agrego la imagen a la ventana
         ImagePanel panel = new ImagePanel(new ImageIcon("src/Imagenes/alfilBlancoFondoColor.png").getImage());
        this.pack();
        this.getContentPane().add(panel);

        //Seteo el maximo y minimo del slider
        jSlider1.setMaximum(12);
        jSlider1.setMinimum(2);
        //Marco la poscion en la que inicialmente se muestra la flecha del slider
        jSlider1.setValue(6);
        //Me Muestra las lineas grandes
        jSlider1.setMajorTickSpacing(2);
        //Me muestra las lineas intermadias
        jSlider1.setMinorTickSpacing(1);
        //Hace que se muestren los Tick (Lineas de marcacion)
        jSlider1.setPaintTicks(true);
        //Hace que me mustre los numeros debajo de las MajorTick
        jSlider1.setPaintLabels(true);
        jSlider1.setVisible(true);

        update(null, null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaJugadoresBlancos = new javax.swing.JScrollPane();
        listaJugadorBlanco = new javax.swing.JList();
        etiquetaJugadorBlanco = new javax.swing.JLabel();
        etiquetaMuestraNombre = new javax.swing.JLabel();
        etiquetaMuestraAlias = new javax.swing.JLabel();
        botonCargaNormal = new javax.swing.JButton();
        botonCargaManual = new javax.swing.JButton();
        etiquetaModoJuego = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        etiquetaCantDePiezas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        listaJugadorBlanco.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaJugadorBlanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJugadorBlancoMouseClicked(evt);
            }
        });
        listaJugadoresBlancos.setViewportView(listaJugadorBlanco);

        etiquetaJugadorBlanco.setFont(new java.awt.Font("Century Gothic", 1, 14));
        etiquetaJugadorBlanco.setForeground(new java.awt.Color(51, 102, 0));
        etiquetaJugadorBlanco.setText("JUGADOR BLANCO");

        botonCargaNormal.setText("NORMAL");
        botonCargaNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaNormalActionPerformed(evt);
            }
        });

        botonCargaManual.setText("MANUAL");
        botonCargaManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaManualActionPerformed(evt);
            }
        });

        etiquetaModoJuego.setFont(new java.awt.Font("Century Gothic", 1, 12));
        etiquetaModoJuego.setForeground(new java.awt.Color(51, 102, 0));
        etiquetaModoJuego.setText("SELECCIONE EL MODO DE JUEGO");

        jSlider1.setBackground(new java.awt.Color(208, 239, 116));
        jSlider1.setForeground(new java.awt.Color(0, 0, 0));
        jSlider1.setMinorTickSpacing(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        etiquetaCantDePiezas.setText("Cantidad de Piezas a Jugar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(listaJugadoresBlancos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(etiquetaCantDePiezas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCargaNormal)
                        .addGap(18, 18, 18)
                        .addComponent(botonCargaManual))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaMuestraNombre)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaMuestraAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiquetaJugadorBlanco))
                        .addComponent(etiquetaModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listaJugadoresBlancos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(etiquetaJugadorBlanco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaMuestraNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaMuestraAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etiquetaCantDePiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(etiquetaModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonCargaManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonCargaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        setBounds(0, 0, 450, 448);
    }// </editor-fold>//GEN-END:initComponents

    private void listaJugadorBlancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJugadorBlancoMouseClicked
        //Selecciono un jugador y muestros sus datos en las etiquetas
        j = (Jugador) listaJugadorBlanco.getSelectedValue();
        etiquetaMuestraAlias.setText("Alias: " + j.getAlias());
        etiquetaMuestraNombre.setText("Nombre: " + j.getNombre());
    }//GEN-LAST:event_listaJugadorBlancoMouseClicked

    private void botonCargaNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargaNormalActionPerformed
        //Valido que haya seleccionado un jugador
        if (j == null) {
            //notifica al usuario
            JOptionPane.showMessageDialog(this, "Debe elegir un jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Si la entrada es correcta, comienza una partida
            part = sis.ingresoPartida(j, sis.getListaDeJugadores().get(0), jSlider1.getValue());
            MuestraTablero tab = new MuestraTablero(sis);
            tab.setVisible(true);
            dispose();
        }        
    }//GEN-LAST:event_botonCargaNormalActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        //Evento que notifica que el slider cambio de posicion
    }//GEN-LAST:event_jSlider1StateChanged

    private void botonCargaManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargaManualActionPerformed
       //Valido que haya selecionado un Jugador
        if (j == null) {
            //Notifico al usuario
            JOptionPane.showMessageDialog(this, "Debe elegir un jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Si fue correcto, inicializo una partida
            part = sis.ingresoPartida(j, sis.getListaDeJugadores().get(0), 0);
            CargaManual cMan = new CargaManual(sis);           
            cMan.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_botonCargaManualActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargaManual;
    private javax.swing.JButton botonCargaNormal;
    private javax.swing.JLabel etiquetaCantDePiezas;
    private javax.swing.JLabel etiquetaJugadorBlanco;
    private javax.swing.JLabel etiquetaModoJuego;
    private javax.swing.JLabel etiquetaMuestraAlias;
    private javax.swing.JLabel etiquetaMuestraNombre;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JList listaJugadorBlanco;
    private javax.swing.JScrollPane listaJugadoresBlancos;
    // End of variables declaration//GEN-END:variables

    //Método que mantiene actualizada la ventana
    public void update(Observable o, Object arg) {      
        jug=Sistema.clonoLista(sis.getListaDeJugadores());
        listaJugadorBlanco.setListData(jug.toArray());
    }
}
