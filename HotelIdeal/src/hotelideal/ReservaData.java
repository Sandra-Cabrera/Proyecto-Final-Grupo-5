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
    public void guardarReserva(Reserva reserva){
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
    
    
    
    
    public void borrarReserva(int id_reserva){
    
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
    
    
    public void actualizarHuesped(Huesped huesped){
         
        try {
             
             String sql = "UPDATE huesped SET nombre = ? , dni = ? , domicilio = ? , correo = ? , celular = ? WHERE id_huesped = ? ;";
             
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
                statement.setString(1, huesped.getNombre());
                statement.setInt(2, huesped.getDni());
                statement.setString(3, huesped.getDomicilio());
                statement.setString(4, huesped.getCorreo());
                statement.setInt(5, huesped.getCelular());
                statement.setInt(6, huesped.getId_huesped());
                statement.executeUpdate();
          
                statement.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al actualizar un huésped: " + ex.getMessage());
        }
        
    }
    
    
    public Huesped buscarHuesped(int id_huesped){
    Huesped huesped =null;
    try {
            
            String sql = "SELECT * FROM huesped WHERE id_huesped =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_huesped);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped"));
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getInt("celular"));

                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar un huesped: " + ex.getMessage());
        }
        
        return huesped;
    }
   
}
