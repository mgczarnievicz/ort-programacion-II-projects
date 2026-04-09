/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Interfaz;

import Dominio.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class MenuPrincipal extends javax.swing.JFrame {

    private Sistema sis;

    //Constructor del MenuPrincipal
    public MenuPrincipal(Sistema s) {
        //Se inicializan las variables.
        sis = s;
        initComponents();
        this.setTitle("Menu Principal");
        ImagePanel panel = new ImagePanel(new ImageIcon("src/Imagenes/MenuPrincipal.png").getImage());
        this.pack();
        this.getContentPane().add(panel);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonIngresarJugador = new javax.swing.JButton();
        botonJugar1Jugador = new javax.swing.JButton();
        botonJugar2 = new javax.swing.JButton();
        botonRepetirPartida = new javax.swing.JButton();
        botonRanking = new javax.swing.JButton();
        botonFin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        botonIngresarJugador.setBackground(new java.awt.Color(102, 153, 0));
        botonIngresarJugador.setText("Ingresar Jugador");
        botonIngresarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarJugadorActionPerformed(evt);
            }
        });

        botonJugar1Jugador.setBackground(new java.awt.Color(102, 153, 0));
        botonJugar1Jugador.setText("JUGAR 1 JUGADOR");
        botonJugar1Jugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugar1JugadorActionPerformed(evt);
            }
        });

        botonJugar2.setBackground(new java.awt.Color(102, 153, 0));
        botonJugar2.setText("JUGAR 2 JUGADORES");
        botonJugar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugar2ActionPerformed(evt);
            }
        });

        botonRepetirPartida.setBackground(new java.awt.Color(102, 153, 0));
        botonRepetirPartida.setText("Repetir Partida");
        botonRepetirPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRepetirPartidaActionPerformed(evt);
            }
        });

        botonRanking.setBackground(new java.awt.Color(102, 153, 0));
        botonRanking.setText("Ranking");
        botonRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRankingActionPerformed(evt);
            }
        });

        botonFin.setBackground(new java.awt.Color(102, 153, 0));
        botonFin.setText("SALIR");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonJugar1Jugador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(botonFin, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRepetirPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonJugar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonIngresarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(337, 337, 337))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(botonIngresarJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonJugar1Jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonJugar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRepetirPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRanking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonFin)
                .addGap(32, 32, 32))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-500)/2, (screenSize.height-400)/2, 500, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void botonJugar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugar2ActionPerformed
        //Valida que haya al menos 2 jugadores aparte de la computadora.
        if (sis.getListaDeJugadores().size() < 3) {
            //Muestra el error.
            JOptionPane.showMessageDialog(this, "Debes Ingresar al Menos 2 Jugadores", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Se muestra la ventana para seleccionar 2 jugadores.
            Seleccionar2Jugadores unV = new Seleccionar2Jugadores(sis);
            unV.setVisible(true);
        }
    }//GEN-LAST:event_botonJugar2ActionPerformed

    private void botonIngresarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarJugadorActionPerformed
        //Se muestra la ventana para ingresar el jugador.
        IngreseJugador unV = new IngreseJugador(sis);
        unV.setVisible(true);
    }//GEN-LAST:event_botonIngresarJugadorActionPerformed

    private void botonJugar1JugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugar1JugadorActionPerformed
        //Se valida que haya otro jugador distinto de la computadora.
        if (sis.getListaDeJugadores().size() < 2) {
            //Se muestra el error.
            JOptionPane.showMessageDialog(this, "Debes Ingresar al Menos 1 Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Se muestra la ventana para seleccionar 1 jugador.
            Seleccionar1Jugador unV = new Seleccionar1Jugador(sis);
            unV.setVisible(true);
        }
    }//GEN-LAST:event_botonJugar1JugadorActionPerformed

    private void botonRepetirPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRepetirPartidaActionPerformed
        //Se valida que haya al menos una partida.
        if (sis.getListaDePartidas().size() < 1) {
            //Se muestra el error.
            JOptionPane.showMessageDialog(this, "NO HAY PARTIDAS JUGADAS", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Se muestra la ventana donde se repiten las partidas.
            MuestraPartida unV = new MuestraPartida(sis);
            unV.setVisible(true);
        }
    }//GEN-LAST:event_botonRepetirPartidaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int ce;
        JOptionPane op = new JOptionPane();
        //Se muestra un diálogo preguntando si se desea salir.
        ce = op.showConfirmDialog(this, "Estas Seguro que desea Salir", null, JOptionPane.OK_CANCEL_OPTION);
        setVisible(true);
        //Si se elige cancelar o se cierra la ventana que no haga nada.
        if (ce == 2 || ce == -1) {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            //Si elige aceptar que guarde el sistema.
            try {
                Sistema.guardarSistema(sis);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //Finalmente cierra el programa.
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void botonRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRankingActionPerformed
        //Se valida que haya al menos otro jugador aparte de la computadora.
        if (sis.getListaDeJugadores().size() < 2) {
            //Se muestra el Error
            JOptionPane.showMessageDialog(this, "Debes Ingresar al Menos 1 Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //Se muestra la ventana del Ranking
            Ranking unV = new Ranking(sis);
            unV.setVisible(true);
        }
    }//GEN-LAST:event_botonRankingActionPerformed

    private void botonFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinActionPerformed
        //Boton para salir del programa.
        int ce;
        JOptionPane op = new JOptionPane();
        //Se muestra un diálogo si se desea salir del programa.
        ce = op.showConfirmDialog(this, "Estas Seguro que desea Salir", null, JOptionPane.OK_CANCEL_OPTION);
        setVisible(true);
        //Si selecciona cancelar o cierra el diálogo que no haga nada.
        if (ce == 2 || ce == -1) {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            try {
                //En caso de aceptar se guarda el sistema.
                Sistema.guardarSistema(sis);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //Se cierra el programa.
                dispose();
                System.exit(0);
            }
        }
    }//GEN-LAST:event_botonFinActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonFin;
    private javax.swing.JButton botonIngresarJugador;
    private javax.swing.JButton botonJugar1Jugador;
    private javax.swing.JButton botonJugar2;
    private javax.swing.JButton botonRanking;
    private javax.swing.JButton botonRepetirPartida;
    // End of variables declaration//GEN-END:variables
}
