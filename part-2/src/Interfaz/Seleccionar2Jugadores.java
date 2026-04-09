/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */

package Interfaz;

import Dominio.*;
import java.util.*;
import javax.swing.*;

public class Seleccionar2Jugadores extends javax.swing.JFrame implements Observer {

    private Sistema sis;
    Partida part;
    ArrayList<Jugador>jug=new ArrayList();

    /** Creates new form Seleccionar2Jugadores */
    public Seleccionar2Jugadores(Sistema s) {
        sis = s;
        sis.addObserver(this);        
        initComponents();
        //Le agrego el nombre a la ventana
        this.setTitle("Jugar de dos Jugadores");

        //Le agrego al imagena  la ventana
         ImagePanel panel = new ImagePanel(new ImageIcon("src/Imagenes/FondoSeleccionar2.png").getImage());
        this.pack();
        this.getContentPane().add(panel);

        //Dejo como transparente el fondo de los elementos
        jSlider1.setOpaque(false);

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

        jLabel1 = new javax.swing.JLabel();
        listaJugadoresBalncos = new javax.swing.JScrollPane();
        listaJugBlanco = new javax.swing.JList();
        listaJugadoresNegros = new javax.swing.JScrollPane();
        listaJugNegro = new javax.swing.JList();
        jSlider1 = new javax.swing.JSlider();
        botonCargaManual = new javax.swing.JButton();
        etiquetaJugadorBlanco = new javax.swing.JLabel();
        etiquetaJugadorNegro = new javax.swing.JLabel();
        etiquetaMuestraJugBlancoAlias = new javax.swing.JLabel();
        etiquetaMuestraJugNegro = new javax.swing.JLabel();
        etiquetaMuestraJugBlancoNombre = new javax.swing.JLabel();
        etiquetaMuestraJugNegro1 = new javax.swing.JLabel();
        botonCargaNormal = new javax.swing.JButton();
        etiquetaSeleccionTipoJugar = new javax.swing.JLabel();
        etiquetaCantPiezas = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        listaJugBlanco.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaJugBlanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJugBlancoMouseClicked(evt);
            }
        });
        listaJugadoresBalncos.setViewportView(listaJugBlanco);

        listaJugNegro.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaJugNegro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJugNegroMouseClicked(evt);
            }
        });
        listaJugadoresNegros.setViewportView(listaJugNegro);

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        botonCargaManual.setText("MANUAL");
        botonCargaManual.setCursor(new java.awt.Cursor(java.awt.Cursor.SW_RESIZE_CURSOR));
        botonCargaManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaManualActionPerformed(evt);
            }
        });

        etiquetaJugadorBlanco.setText("JUGADOR BLANCO:");

        etiquetaJugadorNegro.setText("JUGADOR NEGRO:");

        botonCargaNormal.setText("NORMAL");
        botonCargaNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaNormalActionPerformed(evt);
            }
        });

        etiquetaSeleccionTipoJugar.setFont(new java.awt.Font("Century Gothic", 1, 12));
        etiquetaSeleccionTipoJugar.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaSeleccionTipoJugar.setText("SELECCIONE TIPO DE JUGADA");

        etiquetaCantPiezas.setText("Cantidad de piezas a Jugar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaJugadoresBalncos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etiquetaMuestraJugBlancoAlias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaMuestraJugBlancoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaJugadorBlanco))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etiquetaMuestraJugNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaJugadorNegro)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(etiquetaMuestraJugNegro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(75, 75, 75)
                .addComponent(listaJugadoresNegros, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(etiquetaCantPiezas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonCargaNormal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCargaManual))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(etiquetaSeleccionTipoJugar)
                        .addGap(24, 24, 24)))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaJugadoresNegros, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(listaJugadoresBalncos, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaJugadorBlanco)
                        .addGap(9, 9, 9)
                        .addComponent(etiquetaMuestraJugBlancoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(etiquetaMuestraJugBlancoAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(etiquetaJugadorNegro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaMuestraJugNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaMuestraJugNegro1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaSeleccionTipoJugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonCargaNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonCargaManual, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaCantPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        setBounds(0, 0, 562, 425);
    }// </editor-fold>//GEN-END:initComponents

    private void listaJugBlancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJugBlancoMouseClicked
        //Selecciono un Jugador y muestros uss datos en las etiquetas correspondientes
        Jugador j = (Jugador) listaJugBlanco.getSelectedValue();
        etiquetaMuestraJugBlancoAlias.setText("Alias: " + j.getAlias());
        etiquetaMuestraJugBlancoNombre.setText("Nombre: " + j.getNombre());
    }//GEN-LAST:event_listaJugBlancoMouseClicked

    private void listaJugNegroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJugNegroMouseClicked
        //Selecciono un Jugador y muestros uss datos en las etiquetas correspondientes
        Jugador j = (Jugador) listaJugNegro.getSelectedValue();
        etiquetaMuestraJugNegro1.setText("Alias: " + j.getAlias());
        etiquetaMuestraJugNegro.setText("Nombre: " + j.getNombre());
    }//GEN-LAST:event_listaJugNegroMouseClicked

    private void botonCargaNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargaNormalActionPerformed
        Jugador jN = (Jugador) listaJugNegro.getSelectedValue();
        Jugador jB = (Jugador) listaJugBlanco.getSelectedValue();
        //Valido que ninguno de los dos jugadores seleccionados sea nulo
        if (jB == null || jN == null) {
            //Notifico al usuario
            JOptionPane.showMessageDialog(this, "DEBES SELLECIONAR ALGUN JUGADOR", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Vaslido que los jugadores Seleccionados sean Diferentes
            if (jB.equals(jN)) {
                //Notifico sl usuario
                JOptionPane.showMessageDialog(this, "Los Jugadores deben ser distintos", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                //Si es Valido inicializo la partida
                part = sis.ingresoPartida(jB, jN, jSlider1.getValue());
                MuestraTablero tab = new MuestraTablero(sis);
                tab.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_botonCargaNormalActionPerformed

    private void botonCargaManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargaManualActionPerformed
        Jugador jN = (Jugador) listaJugNegro.getSelectedValue();
        Jugador jB = (Jugador) listaJugBlanco.getSelectedValue();
        //Valido que ninguno de los dos jugadores seleccionados sea nulo
        if (jB == null || jN == null) {
            //Notifico sl usuario
            JOptionPane.showMessageDialog(this, "DEBES SELLECIONAR ALGUN JUGADOR", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Vaslido que los jugadores Seleccionados sean Diferentes
            if (jB.equals(jN)) {
                //Notifico sl usuario
                JOptionPane.showMessageDialog(this, "Los Jugadores deben ser distintos", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                //Si es Valido inicializo la partida
                part = sis.ingresoPartida(jB, jN, 0);
                CargaManual cMan = new CargaManual(sis);
                cMan.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_botonCargaManualActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        //Evento que notifica cuando el slider cambio de valor
    }//GEN-LAST:event_jSlider1StateChanged

//Método que mentiene a la vetana actualizada
    public void update(Observable o, Object arg) {
        jug=Sistema.clonoLista(sis.getListaDeJugadores());
        listaJugBlanco.setListData(jug.toArray());
        listaJugNegro.setListData(jug.toArray());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargaManual;
    private javax.swing.JButton botonCargaNormal;
    private javax.swing.JLabel etiquetaCantPiezas;
    private javax.swing.JLabel etiquetaJugadorBlanco;
    private javax.swing.JLabel etiquetaJugadorNegro;
    private javax.swing.JLabel etiquetaMuestraJugBlancoAlias;
    private javax.swing.JLabel etiquetaMuestraJugBlancoNombre;
    private javax.swing.JLabel etiquetaMuestraJugNegro;
    private javax.swing.JLabel etiquetaMuestraJugNegro1;
    private javax.swing.JLabel etiquetaSeleccionTipoJugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JList listaJugBlanco;
    private javax.swing.JList listaJugNegro;
    private javax.swing.JScrollPane listaJugadoresBalncos;
    private javax.swing.JScrollPane listaJugadoresNegros;
    // End of variables declaration//GEN-END:variables
}
