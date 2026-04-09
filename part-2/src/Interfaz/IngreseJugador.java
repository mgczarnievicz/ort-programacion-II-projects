/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Interfaz;

import Dominio.Sistema;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IngreseJugador extends javax.swing.JFrame {

    private Sistema sis;

    //Constructor
    public IngreseJugador(Sistema s) {
        //Se inicializan las distintas variables.
        sis = s;
        initComponents();
        this.setTitle("Ingrese Jugador");
        this.setTitle("Menu Principal");
        ImagePanel panel = new ImagePanel(new ImageIcon("src/Imagenes/ImagenIngreso.png").getImage());
        this.pack();
        this.getContentPane().add(panel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cajaNombre = new javax.swing.JTextField();
        cajaAlias = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaAlias = new javax.swing.JLabel();
        botonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        etiquetaNombre.setText("NOMBRE:");

        etiquetaAlias.setText("ALIAS:");

        botonOk.setText("OK");
        botonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaAlias)
                                .addGap(18, 18, 18)
                                .addComponent(cajaAlias))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(botonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaAlias)
                    .addComponent(cajaAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(botonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-302)/2, (screenSize.height-201)/2, 302, 201);
    }// </editor-fold>//GEN-END:initComponents

    private void botonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOkActionPerformed
        //Método que valida que el ingreso no sea nulo y que no exista alguien con ese nombre.
        String seIngreso = sis.ingresoJugador(cajaNombre.getText(), cajaAlias.getText());
        //Si está bien se vacían las cajas y se muestra que el ingreso fue exitoso
        if (seIngreso.equalsIgnoreCase("BIEN")) {
            cajaNombre.setText("");
            cajaAlias.setText("");
            JOptionPane.showMessageDialog(this, "Se ha ingresado correctamente el jugador", "JUGADOR CORRECTO", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            //Se muestra el error.
            JOptionPane.showMessageDialog(this, seIngreso, "ERROR", JOptionPane.ERROR_MESSAGE);
            cajaNombre.setText("");
            cajaAlias.setText("");
        }
    }//GEN-LAST:event_botonOkActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonOk;
    private javax.swing.JTextField cajaAlias;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JLabel etiquetaAlias;
    private javax.swing.JLabel etiquetaNombre;
    // End of variables declaration//GEN-END:variables
}
