/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Connection;
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
//conexion de la clase con su excepcion 
    public ReservaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    //metodo guardar un huesped con todos sus campos
    public void crearReserva(Reserva reserva){
        try {
            String sql = "INSERT INTO reserva ( ingreso , egreso , importe_total , estado ) VALUES ( ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, reserva.getIngreso());
            statement.setDate(2, reserva.getEgreso());
            statement.setDouble(3, reserva.getImporte_total());
            statement.setBoolean(4, reserva.getEstado());
            
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
    
    
    
    public List<Reserva> obtenerReserva(){
       List<Reserva> reservas = new ArrayList<Reserva>();
            

        try {
            String sql = "SELECT * FROM reserva;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso"));
                reserva.setEgreso(resultSet.getDate("egreso"));
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                reserva.setEstado(resultSet.getBoolean("estado"));
    
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
             
             String sql = "UPDATE reserva SET ingreso = ? , egreso = ? , importe_total = ? , estado = ? WHERE id_reserva = ? ;";
             
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
                statement.setDate(1, reserva.getIngreso());
                statement.setDate(2, reserva.getEgreso());
                statement.setDouble(3, reserva.getImporte_total());
                statement.setBoolean(4, reserva.getEstado());
                statement.executeUpdate();
          
                statement.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una reserva: " + ex.getMessage());
        }
        
    }
    
    
    public Reserva buscarReserva(int id_reserva){
    Reserva reserva =null;
    try {
            
            String sql = "SELECT * FROM reserva WHERE id_reserva =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_reserva);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso")); 
                reserva.setEgreso(resultSet.getDate("egreso"));
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar una reserva por huesped: " + ex.getMessage());
        }
        
        return reserva;
    }
    
    
    public Reserva buscarReservaPorHuesped(String nombre){
    Reserva reserva =null;
    try {
            
            String sql = "SELECT * FROM reserva WHERE reserva.id_huesped = huesped.id_huesped AND huesped.nombre LIKE nombre ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombre);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso")); 
                reserva.setEgreso(resultSet.getDate("egreso"));
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                
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
            
            String sql = "SELECT * FROM reserva WHERE reserva.id_huesped = huesped.id_huesped AND huesped.dni = dni ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId_reserva(resultSet.getInt("id_reserva"));
                reserva.setIngreso(resultSet.getDate("ingreso")); 
                reserva.setEgreso(resultSet.getDate("egreso"));
                reserva.setImporte_total(resultSet.getDouble("importe_total"));
                
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
}