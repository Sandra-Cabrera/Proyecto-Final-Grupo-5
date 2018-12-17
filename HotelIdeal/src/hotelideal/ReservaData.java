/*j
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandra
 */
public class ReservaData {
    private Connection connection = null;
    private Conexion conexion;
     
    //conexion de la clase con su excepcion 
    public ReservaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
            this.conexion = conexion;
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    //metodo guardar una reserva con todos sus campos
    public void crearReserva(Reserva reserva){
        try {
            String sql = "INSERT INTO reserva ( ingreso , egreso , importe_total , estado, cantidad_personas, id_huesped , id_habitacion )  VALUES ( ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(reserva.getIngreso()));
            statement.setDate(2, Date.valueOf(reserva.getEgreso()));
            statement.setDouble(3, reserva.getImporte_total());
            statement.setBoolean(4, reserva.getEstado());
            statement.setInt(5, reserva.getCantidad_personas());
            statement.setInt(6, reserva.getHuesped().getId_huesped());
            statement.setInt(7, reserva.getHabitacion().getId_habitacion());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                reserva.setId_reserva(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una reserva");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al guardar una reserva: " + ex.getMessage());
        }
    }
    
    
    
    public List<Reserva> obtenerReservas(){
       List<Reserva> reservas = new ArrayList<Reserva>();
            

        try {
            String sql = "SELECT * FROM reserva;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso").toLocalDate());
                reserva.setEgreso(resultSet.getDate("egreso").toLocalDate());
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                reserva.setEstado(resultSet.getBoolean("estado"));
                reserva.setCantidad_personas(resultSet.getInt("cantidad_personas"));
                
                Huesped h = this.buscarHuesped(resultSet.getInt("id_huesped"));
                reserva.setHuesped(h);
                
                Habitacion hab = this.buscarHabitacion(resultSet.getInt("id_habitacion"));
                reserva.setHabitacion(hab);
    
                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las reservas: " + ex.getMessage());
        }
                
        return reservas;
    }
    
    
    
    
    public void cancelarReserva(int id_reserva){
    
        try {  
        
                String sql = "DELETE FROM reserva WHERE id_reserva = ?;";
           
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, id_reserva);
           
                statement.executeUpdate();
           
                statement.close();   
           
        } catch (SQLException ex) {
            System.out.println("Error al borrar una reserva: " + ex.getMessage());
        }

    }
    
    
    public void actualizarReserva(Reserva reserva){
         
        try {
             
             String sql = "UPDATE reserva SET ingreso = ? , egreso = ? , importe_total = ? , estado = ? , cantidad_personas = ? WHERE id_reserva = ? ;";
             
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
                statement.setDate(1, Date.valueOf(reserva.getIngreso()));
                statement.setDate(2, Date.valueOf(reserva.getEgreso()));
                statement.setDouble(3, reserva.getImporte_total());
                statement.setBoolean(4, reserva.getEstado());
                statement.setInt(5, reserva.getCantidad_personas());
                statement.setInt(6, reserva.getHuesped().getId_huesped());
                statement.setInt(7, reserva.getHabitacion().getId_habitacion());
                statement.setInt(8, reserva.getId_reserva());
                
                statement.executeUpdate();
          
                statement.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una reserva: " + ex.getMessage());
        }
        
    }
    
    
    public Reserva buscarReserva(int id_reserva){
        Reserva reserva = null;
        
        try {
            
            String sql = "SELECT * FROM reserva WHERE id_reserva =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_reserva);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso").toLocalDate()); 
                reserva.setEgreso(resultSet.getDate("egreso").toLocalDate());
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                reserva.setCantidad_personas(resultSet.getInt("cantidad_personas"));
                
                Huesped h = this.buscarHuesped(resultSet.getInt("id_huesped"));
                reserva.setHuesped(h);
                
                Habitacion hab = this.buscarHabitacion(resultSet.getInt("id_habitacion"));
                reserva.setHabitacion(hab);
                                          
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar una reserva por huesped: " + ex.getMessage());
        }
        
        return reserva;
    }
    
    
    public Reserva buscarReservaPorHuesped(String nombre){
        Reserva reserva = null;
    
        try {
            
            String sql = "SELECT * FROM reserva WHERE reserva.id_huesped = huesped.id_huesped AND huesped.nombre LIKE nombre ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombre);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso").toLocalDate()); 
                reserva.setEgreso(resultSet.getDate("egreso").toLocalDate());
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                reserva.setCantidad_personas(resultSet.getInt("cantidad_personas"));
                
                Huesped h = this.buscarHuesped(resultSet.getInt("id_huesped"));
                reserva.setHuesped(h);
                
                Habitacion hab = this.buscarHabitacion(resultSet.getInt("id_habitacion"));
                reserva.setHabitacion(hab);
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar una reserva por huesped: " + ex.getMessage());
        }
        
        return reserva;
    }
    
    public Reserva buscarReservaPorDni(int dni){
        Reserva reserva =null;
        try {
            
            String sql = "SELECT * FROM reserva, huesped WHERE reserva.id_huesped = huesped.id_huesped AND huesped.dni = dni ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso").toLocalDate()); 
                reserva.setEgreso(resultSet.getDate("egreso").toLocalDate());
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                reserva.setCantidad_personas(resultSet.getInt("cantidad_personas"));
                
                Huesped h = this.buscarHuesped(resultSet.getInt("id_huesped"));
                reserva.setHuesped(h);
                
                Habitacion hab = this.buscarHabitacion(resultSet.getInt("id_habitacion"));
                reserva.setHabitacion(hab);
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar una reserva por dni: " + ex.getMessage());
        }
        
        return reserva;
    }
    
    public int cant_dias() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        
        java.util.Date ingreso=dateFormat.parse("2016-02-12");
        java.util.Date egreso=dateFormat.parse("2016-03-22");
        
        int cant_dias=(int)  ((egreso.getTime()-ingreso.getTime())/86400000);
        return cant_dias;
    }
    
    public Huesped buscarHuesped(int idhuesped){
         
        HuespedData huespeddata = new HuespedData(conexion);
        Huesped h = huespeddata.buscarHuesped(idhuesped);
                
        return h;
    }
    
    public Habitacion buscarHabitacion(int idhabitacion){
         
        HabitacionData habitaciondata = new HabitacionData(conexion);
        Habitacion hab = habitaciondata.buscarHabitacion(idhabitacion);
                
        return hab;
    }
     public void actualizarEstado(boolean estado, int num){
        try {
            
            String sql = "UPDATE habitacion SET estado = ? WHERE num = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, estado);
            statement.setInt(2, num);
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el ESTADO de habitación: " + ex.getMessage());
        }
    
    }
     
}