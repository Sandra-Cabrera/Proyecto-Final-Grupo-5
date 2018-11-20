/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal.vistas;

import javax.swing.JFrame;

/**
 *
 * @author Maqui's
 */
public class panelprincipal extends javax.swing.JFrame {

    /**
     * Creates new form panelprincipal
     */
    public panelprincipal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        reserva = new javax.swing.JMenu();
        nuevareserva = new javax.swing.JMenuItem();
        modificarreserva = new javax.swing.JMenuItem();
        habitacion = new javax.swing.JMenu();
        listadohabitaciones = new javax.swing.JMenuItem();
        nuevahabitacion = new javax.swing.JMenuItem();
        modificarhabitacion = new javax.swing.JMenuItem();
        quitarhabitacion = new javax.swing.JMenuItem();
        huesped = new javax.swing.JMenu();
        VistaHuespedes = new javax.swing.JMenuItem();
        contacto = new javax.swing.JMenu();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1026, 555));

        escritorio.setMaximumSize(new java.awt.Dimension(32767, 32767));
        escritorio.setPreferredSize(new java.awt.Dimension(1026, 534));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ImagenFondo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 153, 0));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gran Hotel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe Print", 3, 18)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MV Boli", 0, 24))); // NOI18N

        reserva.setBackground(new java.awt.Color(204, 153, 0));
        reserva.setText("Reserva");

        nuevareserva.setText("Nueva");
        nuevareserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevareservaActionPerformed(evt);
            }
        });
        reserva.add(nuevareserva);

        modificarreserva.setText("Modificar/Cancelar");
        modificarreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarreservaActionPerformed(evt);
            }
        });
        reserva.add(modificarreserva);

        jMenuBar1.add(reserva);

        habitacion.setText("Habitación");

        listadohabitaciones.setText("Listado");
        listadohabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadohabitacionesActionPerformed(evt);
            }
        });
        habitacion.add(listadohabitaciones);

        nuevahabitacion.setText("Nueva");
        nuevahabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevahabitacionActionPerformed(evt);
            }
        });
        habitacion.add(nuevahabitacion);

        modificarhabitacion.setText("Modificar");
        modificarhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarhabitacionActionPerformed(evt);
            }
        });
        habitacion.add(modificarhabitacion);

        quitarhabitacion.setText("Borrar");
        quitarhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarhabitacionActionPerformed(evt);
            }
        });
        habitacion.add(quitarhabitacion);

        jMenuBar1.add(habitacion);

        huesped.setText("Huesped");

        VistaHuespedes.setText("Actualización de Datos");
        VistaHuespedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VistaHuespedesActionPerformed(evt);
            }
        });
        huesped.add(VistaHuespedes);

        jMenuBar1.add(huesped);

        contacto.setText("Contacto");
        jMenuBar1.add(contacto);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listadohabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadohabitacionesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        listadodehabitaciones vh=new listadodehabitaciones();
        vh.setVisible(true);
        //vh.setLocation(200, 50);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        //escritorio.add(vh);
    }//GEN-LAST:event_listadohabitacionesActionPerformed

    private void VistaHuespedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VistaHuespedesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaHuespedes vh=new VistaHuespedes();
        vh.setVisible(true);
        //vh.setLocation(200, 50);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        //escritorio.add(vh);
    }//GEN-LAST:event_VistaHuespedesActionPerformed

    private void modificarreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarreservaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        modificarreserva vh=new modificarreserva();
        vh.setVisible(true);
        //vh.setLocation(200, 50);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        //escritorio.add(vh);
    }//GEN-LAST:event_modificarreservaActionPerformed

    private void nuevareservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevareservaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        nuevareserva vh=new nuevareserva();
        vh.setVisible(true);
        //vh.setLocation(200, 50);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        //escritorio.add(vh);
    }//GEN-LAST:event_nuevareservaActionPerformed

    private void nuevahabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevahabitacionActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        nuevahabitacion vh=new nuevahabitacion();
        vh.setVisible(true);
        //vh.setLocation(200, 50);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        //escritorio.add(vh);
    }//GEN-LAST:event_nuevahabitacionActionPerformed

    private void modificarhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarhabitacionActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        modificarhabitacion vh=new modificarhabitacion();
        vh.setVisible(true);
        //vh.setLocation(200, 50);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        //escritorio.add(vh);
    }//GEN-LAST:event_modificarhabitacionActionPerformed

    private void quitarhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarhabitacionActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        quitarhabitacion vh=new quitarhabitacion();
        vh.setVisible(true);
        //vh.setLocation(200, 50);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        //escritorio.add(vh);
    }//GEN-LAST:event_quitarhabitacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(panelprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panelprincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem VistaHuespedes;
    private javax.swing.JMenu contacto;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu habitacion;
    private javax.swing.JMenu huesped;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem listadohabitaciones;
    private javax.swing.JMenuItem modificarhabitacion;
    private javax.swing.JMenuItem modificarreserva;
    private javax.swing.JMenuItem nuevahabitacion;
    private javax.swing.JMenuItem nuevareserva;
    private javax.swing.JMenuItem quitarhabitacion;
    private javax.swing.JMenu reserva;
    // End of variables declaration//GEN-END:variables
}
