/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.vistas;

import hotelideal.Conexion;
import hotelideal.Huesped;
import hotelideal.HuespedData;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandra
 */
public class VistaHuespedes extends javax.swing.JInternalFrame {
    private int id_huesped, dni, celular;
    private String nombre, domicilio, correo;
    private HuespedData huespedData;
    private Conexion conexion;
    /**
     * Creates new form VistaHuespedes
     */
    public VistaHuespedes() {
        initComponents();
        
        try {
        conexion = new Conexion("jdbc:mysql://localhost/hotelidealgrupo5", "root", "");
        huespedData = new HuespedData(conexion);
        
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
        jBInformeH = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBBorrarH = new javax.swing.JButton();
        jBAgregarH = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jBInformeH.setText("INFORME POR DNI");

        jBActualizar.setText("ACTUALIZAR DATOS");

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

        jBSalir.setText("SALIR");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ImagenHuespedes_1.jpg"))); // NOI18N

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
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBInformeH, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBAgregarH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBBorrarH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLDomicilio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTNom)
                                    .addComponent(jTDni)
                                    .addComponent(jTDom)
                                    .addComponent(jTCorr)
                                    .addComponent(jTCel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBActualizar, jBAgregarH, jBBorrarH, jBInformeH, jBSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
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
                            .addComponent(jTCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInformeH)
                    .addComponent(jBActualizar)
                    .addComponent(jBBorrarH)
                    .addComponent(jBAgregarH)
                    .addComponent(jBSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBorrarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarHActionPerformed
        // TODO add your handling code here:
        int dni = Integer.parseInt(jTDni.getText());
        huespedData.borrarHuespedPorDni(dni);   
        
        // Bloqueo de Actualizar y Borrar
        jBActualizar.setEnabled(false);
        jBBorrarH.setEnabled(false);
        
    }//GEN-LAST:event_jBBorrarHActionPerformed

    private void jBAgregarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarHActionPerformed
        // TODO add your handling code here:
        nombre = jTNom.getText();
        dni=Integer.parseInt(jTDni.getText());
        domicilio =jTDom.getText();
        correo=jTCorr.getText();
        celular= Integer.parseInt(jTCel.getText());
        
        Huesped huesped = new Huesped(nombre ,dni ,domicilio ,correo ,celular );
        huespedData.guardarHuesped(huesped);
        
        
    }//GEN-LAST:event_jBAgregarHActionPerformed

    private void jTNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
          try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VistaHuespedes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBSalirActionPerformed
    
    
    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                             

        nombre = jTNom.getText();
        dni = Integer.parseInt(jTDni.getText());
        domicilio = jTDom.getText();
        correo = jTCorr.getText();
        celular= Integer.parseInt(jTCel.getText());
        
        Huesped huesped=new Huesped(id_huesped ,nombre ,dni ,domicilio ,correo ,celular );
        huespedData.actualizarHuesped(huesped);
        
    } 
    
    
    private void jBInformeHActionPerformed(java.awt.event.ActionEvent evt) {                                         

        int porDni = Integer.parseInt(jTDni.getText());
        
        Huesped huesped = huespedData.buscarHuespedPorDni(porDni);
        
        if(huesped!=null){
            jTNom.setText(huesped.getNombre());
            jTDni.setText(huesped.getDni()+"");
            jTDom.setText(huesped.getDomicilio());
            jTCorr.setText(huesped.getCorreo());
            jTCel.setText(huesped.getCelular()+"");
            id_huesped = huesped.getId_huesped();
        }
    }                                        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAgregarH;
    private javax.swing.JButton jBBorrarH;
    private javax.swing.JButton jBInformeH;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLCelular;
    private javax.swing.JLabel jLCorreo;
    private javax.swing.JLabel jLDni;
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLHuespedes;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTCel;
    private javax.swing.JTextField jTCorr;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTDom;
    private javax.swing.JTextField jTNom;
    // End of variables declaration//GEN-END:variables
}
