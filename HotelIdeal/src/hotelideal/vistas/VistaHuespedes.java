/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.vistas;

import hotelideal.Conexion;
import hotelideal.Huesped;
import hotelideal.HuespedData;
import hotelideal.Reserva;
import hotelideal.ReservaData;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sandra
 */
public class VistaHuespedes extends javax.swing.JInternalFrame {
    private int id_huesped, dni;    
    private String nombre, domicilio, correo, celular;
    private HuespedData huespedData;
    private Conexion conexion;
    private ReservaData reservaData;
    /**
     * Creates new form VistaHuespedes
     */
    public VistaHuespedes() {
        initComponents();
        
        try {
        conexion = new Conexion("jdbc:mysql://localhost/hotelidealgrupo5", "root", "");
        huespedData = new HuespedData(conexion);
        reservaData = new ReservaData(conexion);
        
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(VistaHuespedes.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLHuespedes = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLDni = new javax.swing.JLabel();
        jLDomicilio = new javax.swing.JLabel();
        jLCorreo = new javax.swing.JLabel();
        jLCelular = new javax.swing.JLabel();
        jTNom = new javax.swing.JTextField();
        jTDni = new javax.swing.JTextField();
        jTDom = new javax.swing.JTextField();
        jTCorr = new javax.swing.JTextField();
        jTCel = new javax.swing.JTextField();
        BuscarXDNI = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBBorrarH = new javax.swing.JButton();
        jBAgregarH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLHuespedes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLHuespedes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLHuespedes.setText("- HUESPEDES -");

        jLNombre.setText("NOMBRE");

        jLDni.setText("DNI");

        jLDomicilio.setText("DOMICILIO");

        jLCorreo.setText("CORREO");

        jLCelular.setText("CELULAR");

        jTNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomActionPerformed(evt);
            }
        });

        BuscarXDNI.setText("BUSCAR POR DNI");
        BuscarXDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarXDNIActionPerformed(evt);
            }
        });

        jBActualizar.setText("ACTUALIZAR DATOS");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBBorrarH.setText("BORRAR HUESPED");
        jBBorrarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarHActionPerformed(evt);
            }
        });

        jBAgregarH.setText("AGREGAR HUESPED");
        jBAgregarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarHActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ImagenHuespedes_1.jpg"))); // NOI18N

        jButton1.setText("LIMPIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Complete los campos\\n para agregar un nuevo huesped.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAgregarH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jBBorrarH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BuscarXDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLDomicilio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTNom)
                                            .addComponent(jTDni)
                                            .addComponent(jTDom)
                                            .addComponent(jTCorr)
                                            .addComponent(jTCel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4))
                                .addGap(49, 49, 49)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BuscarXDNI, jBActualizar, jBAgregarH, jBBorrarH});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(BuscarXDNI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDni, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCorr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBActualizar)
                    .addComponent(jBAgregarH)
                    .addComponent(jButton1)
                    .addComponent(jBBorrarH))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBorrarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarHActionPerformed
        // TODO add your handling code here:
        
        int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI del Huésped"));
        int id_reserva = -1;
        ArrayList<Reserva> listaDeReservas = (ArrayList)reservaData.obtenerReservas();
        
        for(Reserva r:listaDeReservas){
            if (r.getHuesped().getDni()==dni){
                id_reserva=r.getId_reserva();
            //nuevalista.add(r);
            }
        }
        
        if (id_reserva>-1){
            JOptionPane.showMessageDialog(null, "No se puede borrar porque tiene una reserva cargada en la base de datos");
  
        }else{
            huespedData.borrarHuespedPorDni(dni);
            JOptionPane.showMessageDialog(null, "Eliminación exitosa");
            jTNom.setText(""); jTDni.setText(""); jTDom.setText("");
            jTCorr.setText(""); jTCel.setText("");
            
        }
        
        
    }//GEN-LAST:event_jBBorrarHActionPerformed

    private void jBAgregarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarHActionPerformed
        // TODO add your handling code here:
        nombre = jTNom.getText();
        dni=Integer.parseInt(jTDni.getText());
        domicilio =jTDom.getText();
        correo=jTCorr.getText();
        celular= jTCel.getText();
        
        Huesped huesped = new Huesped(nombre ,dni ,domicilio ,correo ,celular );
        huespedData.guardarHuesped(huesped);
        JOptionPane.showMessageDialog(null, "¡¡Huésped ingresado!!");
        
        
    }//GEN-LAST:event_jBAgregarHActionPerformed

    private void jTNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        
        nombre = jTNom.getText();
        dni = Integer.parseInt(jTDni.getText());
        domicilio = jTDom.getText();
        correo = jTCorr.getText();
        celular = jTCel.getText();
        
        id_huesped = huespedData.buscarHuespedPorDni(dni).getId_huesped();
        Huesped huesped =new Huesped(id_huesped ,nombre ,dni ,domicilio ,correo ,celular);
        
        huespedData.actualizarHuesped(huesped);
        JOptionPane.showMessageDialog(this, "¡¡Datos de Huésped actualizado!!");
        
        
        
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void BuscarXDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarXDNIActionPerformed
        // TODO add your handling code here:
        
        int porDni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI del Huésped"));
        Huesped huesped = huespedData.buscarHuespedPorDni(porDni);
        
        if(huesped!=null){
            jTNom.setText(huesped.getNombre());
            jTDni.setText(huesped.getDni()+"");
            jTDom.setText(huesped.getDomicilio());
            jTCorr.setText(huesped.getCorreo());
            jTCel.setText(huesped.getCelular()+"");
            id_huesped = huesped.getId_huesped();
        }else{
            JOptionPane.showMessageDialog(this, "El Huésped no se encuentra cargado\n Complete los campos para agregar uno nuevo");
        }
    }//GEN-LAST:event_BuscarXDNIActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        jTNom.setText(""); jTDni.setText(""); jTDom.setText("");
        jTCorr.setText(""); jTCel.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
       
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarXDNI;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAgregarH;
    private javax.swing.JButton jBBorrarH;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLCelular;
    private javax.swing.JLabel jLCorreo;
    private javax.swing.JLabel jLDni;
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLHuespedes;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTCel;
    private javax.swing.JTextField jTCorr;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTDom;
    private javax.swing.JTextField jTNom;
    // End of variables declaration//GEN-END:variables
}
