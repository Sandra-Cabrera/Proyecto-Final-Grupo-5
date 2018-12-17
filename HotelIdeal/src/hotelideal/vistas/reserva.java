package hotelideal.vistas;

import hotelideal.Conexion;
import hotelideal.Habitacion;
import hotelideal.HabitacionData;
import hotelideal.Huesped;
import hotelideal.Reserva;
import hotelideal.ReservaData;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class reserva extends javax.swing.JInternalFrame {
    private int id_habitacion, id_reserva;
    private int numero;
    private int cant_personas;
    private double importe_total;
    private int cambio;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int id_huesped=0;
    private Conexion conexion;
    private ReservaData reservaData;
    private HabitacionData habitacionData;
    private Huesped huesped;
    private Habitacion habitacion;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<Reserva> listaReservas;
    private DefaultTableModel modelo;
    public static DefaultTableModel modelofecha;
    private Object fechaelejida;
    
    public reserva() {
        try {
            initComponents();
            
            conexion=new Conexion("jdbc:mysql://localhost/hotelidealgrupo5","root","");
            reservaData=new ReservaData(conexion);
            habitacionData=new HabitacionData(conexion);
            modelo=new DefaultTableModel();
            modelofecha=new DefaultTableModel();
            modelofecha.addColumn("Fechas");
            tablaFechas.setModel(modelofecha);
               
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        cabezalTabla();
        etiqueta.setVisible(false);
        limpiar();
        
    }

    //armar cabezal de la tabla
    public void cabezalTabla(){
        ArrayList<Object> columnas=new ArrayList<>();
        
        columnas.add("Numero");
        columnas.add("Estado");
        columnas.add("Piso");
        columnas.add("Tipo Habitacion");
        columnas.add("Codigo");
        columnas.add("Tipo Cama");
        columnas.add("Numero de Camas");
        columnas.add("Numero de Personas");
        columnas.add("Precio por Noche");
        
        for (Object it:columnas){
            modelo.addColumn(it);
        }
        tablaGestionReserva.setModel(modelo);
        
    }
        
    //Limpiar tabla
    public void limpiarTabla(){
        int a =modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
    }

   //cargar datos
    public void cargaDatos(){
        if(!(txtId.getText().equalsIgnoreCase(""))){
            int id=Integer.parseInt(txtId.getText());
            listaReservas=(ArrayList)reservaData.obtenerReservas();
            limpiarTabla();
            for(Reserva r:listaReservas){
                if (id==r.getHuesped().getId_huesped()&&r.getIngreso().equals(this.fechaelejida)) {
                    modelo.addRow(new Object[]{r.getHabitacion().getNumero(),"Ocupado",r.getHabitacion().getPiso()
                            ,r.getHabitacion().getTipo_de_habitacion().getTipo(),
                            r.getHabitacion().getTipo_de_habitacion().getTipo_camas(),r.getHabitacion().getTipo_de_habitacion().getCant_camas(),
                            r.getHabitacion().getTipo_de_habitacion().getMax_personas(),r.getHabitacion().getTipo_de_habitacion().getPrecio_noche()});
                    txtFechaEntrada.setText(r.getIngreso().toString());
                    txtFechaSalida.setText(r.getEgreso().toString());
                    txtCantidad.setText(r.getCantidad_personas()+"");
                    txtTotal.setText(r.getImporte_total()+"");
                    idReserva.setText(r.getId_reserva()+"");
                
                    if(r.getEstado()){
                        chcActiva.setSelected(true);
                    }else{chcInactiva.setSelected(false);}
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGestionReserva = new javax.swing.JTable();
        txtModificarReserva = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        chcActiva = new javax.swing.JCheckBox();
        chcInactiva = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxTipoHabitacion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFechas = new javax.swing.JTable();
        etiqueta = new javax.swing.JLabel();
        btnCargarHuesped = new javax.swing.JButton();
        txtFechaEntrada = new javax.swing.JFormattedTextField();
        txtFechaSalida = new javax.swing.JFormattedTextField();
        btnCalcularNuevoImporte = new javax.swing.JButton();
        btnBuscarH1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idReserva = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setTitle("RESERVAS");

        tablaGestionReserva =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndes){
                return false;
            }
        };
        tablaGestionReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Estado", "Piso", "Tipo de Habitacion", "Tipo de Cama", "Nro de Camas", "Nro de Personas", "Precio por Noche"
            }
        ));
        tablaGestionReserva.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaGestionReserva);
        if (tablaGestionReserva.getColumnModel().getColumnCount() > 0) {
            tablaGestionReserva.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaGestionReserva.getColumnModel().getColumn(1).setMaxWidth(50);
            tablaGestionReserva.getColumnModel().getColumn(2).setMaxWidth(50);
            tablaGestionReserva.getColumnModel().getColumn(3).setMaxWidth(140);
            tablaGestionReserva.getColumnModel().getColumn(4).setMaxWidth(50);
            tablaGestionReserva.getColumnModel().getColumn(5).setMaxWidth(140);
            tablaGestionReserva.getColumnModel().getColumn(6).setMaxWidth(90);
            tablaGestionReserva.getColumnModel().getColumn(7).setMaxWidth(100);
            tablaGestionReserva.getColumnModel().getColumn(8).setMaxWidth(110);
        }

        txtModificarReserva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtModificarReserva.setText("Modificar Reserva");
        txtModificarReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModificarReservaActionPerformed(evt);
            }
        });

        btnCancelarReserva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelarReserva.setText("Finalizar Reserva");
        btnCancelarReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DATOS DEL HUESPED");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("DNI");

        jLabel4.setText("DOMICILIO");

        jLabel5.setText("CORREO");

        jLabel6.setText("CELULAR");

        txtCorreo.setEditable(false);

        txtNombre.setEditable(false);

        txtDni.setEditable(false);

        txtDomicilio.setEditable(false);

        txtCelular.setEditable(false);

        jLabel9.setText("Importe Total");

        txtTotal.setEditable(false);

        jLabel10.setText("Fecha Entrada ");

        jLabel11.setText("Fecha Salida ");

        jLabel12.setText("Cantidad de Personas");

        chcActiva.setText("Activa");

        chcInactiva.setText("Inactiva");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("ESTADO DE RESERVA");

        jLabel15.setText("Tipo de Habitacion");

        cbxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Estándar Simple", "Doble", "Triple", "Suite Lujo", " " }));
        cbxTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoHabitacionActionPerformed(evt);
            }
        });

        jLabel16.setText("ID");

        txtId.setEditable(false);
        txtId.setInheritsPopupMenu(true);

        tablaFechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Título 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFechas.setInheritsPopupMenu(true);
        tablaFechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFechasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaFechas);

        etiqueta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etiqueta.setText("Elegir una Fecha");

        btnCargarHuesped.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCargarHuesped.setText("Buscar Huesped");
        btnCargarHuesped.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCargarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarHuespedActionPerformed(evt);
            }
        });

        btnCalcularNuevoImporte.setBackground(new java.awt.Color(204, 204, 204));
        btnCalcularNuevoImporte.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnCalcularNuevoImporte.setText("Calcular Nuevo Importe");
        btnCalcularNuevoImporte.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCalcularNuevoImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularNuevoImporteActionPerformed(evt);
            }
        });

        btnBuscarH1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarH1.setText("Buscar por Fecha");
        btnBuscarH1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBuscarH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarH1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Salir");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Reserva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBuscarH1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModificarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(372, 372, 372)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(idReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(55, 55, 55)
                                            .addComponent(jLabel16)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnCargarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(etiqueta))
                                    .addGap(64, 64, 64)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(42, 42, 42)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(chcActiva)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(chcInactiva))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addGap(19, 19, 19)
                                                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(jLabel12)
                                            .addGap(12, 12, 12)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(16, 16, 16))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel15))
                                        .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(59, 59, 59))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCalcularNuevoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel16))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(etiqueta)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chcActiva)
                            .addComponent(chcInactiva))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel10))
                            .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel11))
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel12)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(6, 6, 6)
                                .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCargarHuesped, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtModificarReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(idReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarH1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcularNuevoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Cancelar
    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        int cel=tablaGestionReserva.getSelectedRow();
        int celda=tablaFechas.getSelectedRow();
        
        if(!(txtNombre.getText().equalsIgnoreCase(""))&&!(tablaFechas.getValueAt(celda,0)==null)){
            if (cel>-1){
                int confi=JOptionPane.showConfirmDialog(null, "Esta seguro que desea\n Cancelar la Reserva", "ATENCION!!!", JOptionPane.WARNING_MESSAGE);
                if (confi==0){
                    int num=Integer.parseInt(String.valueOf(tablaGestionReserva.getValueAt(cel, 0)));
                    String fec=tablaFechas.getValueAt(celda, 0).toString();
                    Date fecha = null;
                    
                    reservaData.actualizarEstado(true, num);
                    reservaData.cancelarReserva(id_reserva);
                }
            }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un campo de la\n tabla de tipos de habitaciones","Atencion!!!",JOptionPane.INFORMATION_MESSAGE);}
        }else{JOptionPane.showMessageDialog(null, "Debe cargar una Reserva \npara poder cancelarla!!!","Atencion!!!",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    //modificar reserva
    private void txtModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModificarReservaActionPerformed
        Huesped hues;
        Habitacion h;
        int confirma=JOptionPane.showConfirmDialog(null, "Esta seguro de Modificar\n la Reserva","Confirmar",JOptionPane.OK_CANCEL_OPTION);
        if(confirma==0){
            int cel=tablaGestionReserva.getSelectedRow();
            int celda=tablaFechas.getSelectedRow();
            if(!(txtNombre.getText().equalsIgnoreCase(""))&&!(tablaFechas.getValueAt(celda,0)==null)){

                int id_reserva=Integer.parseInt(idReserva.getText());
                boolean estado;
                if (chcActiva.isSelected()){estado=true;}else{estado=false;}
                if (cel>-1){
                    numero=Integer.parseInt(String.valueOf(tablaGestionReserva.getValueAt(cel, 0)));
                    Habitacion ha=habitacionData.buscarHabitacion(numero);
                    id_habitacion=ha.getId_habitacion();
                    if(id_huesped>0 && id_habitacion>0 && !txtFechaEntrada.getText().equals(null)&& !txtFechaSalida.getText().equals(null)){
                        h=new Habitacion(id_habitacion);
                        hues=new Huesped(id_huesped);
                        
                        Reserva reserva=new Reserva(id_reserva, fechaEntrada, fechaSalida, cant_personas, importe_total, estado, hues, h);
                        reservaData.actualizarReserva(reserva);
                        reservaData.actualizarEstado(false, numero);
                        reservaData.actualizarEstado(true, cambio);
                        JOptionPane.showMessageDialog(null, "Se creo la reserva en forma correcta!");
                        limpiar();
                    }else{JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!!!");}
                }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar una Habitacion de la Lista");}
            }else{JOptionPane.showMessageDialog(null, "Debe cargar una Reserva \npara poder Modificarla!!!","Atencion!!!",JOptionPane.WARNING_MESSAGE);}
        }
    }//GEN-LAST:event_txtModificarReservaActionPerformed
    
    
    private void cbxTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoHabitacionActionPerformed
        String tipo=(String)cbxTipoHabitacion.getSelectedItem();
        int cel=tablaGestionReserva.getSelectedRow();
        if(cel >-1){
            cambio=(int) tablaGestionReserva.getValueAt(cel, 0);
            limpiarTabla();
            cargaHabitaciones(tipo);
        }else{
            cbxTipoHabitacion.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null,"Seleccione una Habitacion de la tabla!!!","ATENCION",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cbxTipoHabitacionActionPerformed

    
    //*******Boton para cargar un huesped *****
    //*****************************************
    private void btnCargarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarHuespedActionPerformed
       
    }//GEN-LAST:event_btnCargarHuespedActionPerformed

    
    private void btnCalcularNuevoImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularNuevoImporteActionPerformed
        int suma=0;
        int cel=tablaGestionReserva.getSelectedRow();
        if (cel>-1){
            cant_personas=Integer.parseInt(txtCantidad.getText());
            fechaEntrada=LocalDate.parse((CharSequence) txtFechaEntrada.getText());
            fechaSalida=LocalDate.parse((CharSequence) txtFechaSalida.getText());
            id_huesped=Integer.parseInt(txtId.getText());
            suma=fechaEntrada.getDayOfYear()-fechaSalida.getDayOfYear();
            importe_total=  (double) tablaGestionReserva.getValueAt(cel, 8)*suma;
            numero=(int) tablaGestionReserva.getValueAt(cel, 0);
            txtTotal.setText(importe_total+"");
        }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un campo de la tabla de tipos de habitaciones");}
    }//GEN-LAST:event_btnCalcularNuevoImporteActionPerformed
    
    //****Boton para la busqueda por fecha****
    //****************************************
    private void btnBuscarH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarH1ActionPerformed
        int a =modelofecha.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelofecha.removeRow(i);
        }
        limpiar();
        etiqueta.setVisible(true);
        VistaHuespedes vdh=new VistaHuespedes();
        panelprincipal.centrarVentana(vdh);
        vdh.setTitle("BUSCAR POR FECHA");
        
    }//GEN-LAST:event_btnBuscarH1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFechasMouseClicked
        id_huesped=Integer.parseInt(txtId.getText());
        int cel=tablaFechas.getSelectedRow();
        String fec=tablaFechas.getValueAt(cel, 0).toString();
        fechaelejida=LocalDate.parse((CharSequence)fec, DateTimeFormatter.ISO_DATE);
        cargaDatos();
    }//GEN-LAST:event_tablaFechasMouseClicked
    
    //Limpiar
    void limpiar(){
        txtNombre.setText(null);
        txtDni.setText("");
        txtDomicilio.setText("");
        txtCorreo.setText("");
        txtCelular.setText("");
        txtId.setText("");
        txtFechaEntrada.setText("");
        txtFechaSalida.setText("");
        chcActiva.setSelected(false);
        chcInactiva.setSelected(false);
        idReserva.setText("");
        txtTotal.setText("");
        limpiarTabla();
        int b=modelofecha.getRowCount()-1;
        for(int z=b;z>=0;z--){
            modelofecha.removeRow(z);
        }
    }
    
    /*
     *******Metodo para cargar habitaciones por un tipo de habitacion, 
     *******utilizado a la hora de modificar la reserva *************
     */
    public void cargaHabitaciones(String tipo){
        listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
        limpiarTabla();
        int valorSpinner=Integer.parseInt(txtCantidad.getText());
        for (Habitacion h:listaHabitaciones){
            if (h.isEstado()){
                if (h.getTipo_de_habitacion().getTipo().equalsIgnoreCase(tipo)&&h.getTipo_de_habitacion().getMax_personas()==valorSpinner) {
                    modelo.addRow(new Object[]{h.getNumero(),"Libre",h.getPiso(),h.getTipo_de_habitacion().getTipo(),
                        h.getTipo_de_habitacion().getTipo_camas(),
                        h.getTipo_de_habitacion().getCant_camas(),h.getTipo_de_habitacion().getMax_personas(),
                        h.getTipo_de_habitacion().getPrecio_noche()});
                    id_habitacion=h.getId_habitacion();
                }
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarH1;
    private javax.swing.JButton btnCalcularNuevoImporte;
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnCargarHuesped;
    private javax.swing.JComboBox<String> cbxTipoHabitacion;
    private javax.swing.JCheckBox chcActiva;
    private javax.swing.JCheckBox chcInactiva;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JTextField idReserva;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tablaFechas;
    private javax.swing.JTable tablaGestionReserva;
    private javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtDomicilio;
    private javax.swing.JFormattedTextField txtFechaEntrada;
    private javax.swing.JFormattedTextField txtFechaSalida;
    public static javax.swing.JTextField txtId;
    private javax.swing.JButton txtModificarReserva;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
