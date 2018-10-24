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
 * @author Maqui's
 */
public class HabitacionData {
   private Connection connection = null;
//conexion de la clase con su excepcion 
    public HabitacionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    //metodo guardar un huesped con todos sus campos
    public void guardarHabitaion(Habitacion habitacion){
        try {
            String sql = "INSERT INTO habitacion ( numero , piso , estado ) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getNumero());
            statement.setInt(2, habitacion.getPiso());
            statement.setBoolean(3, habitacion.getEstado());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                habitacion.setId_habitacion(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una Habitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al guardar una Habitacion: " + ex.getMessage());
        }
    }
    
    
    
    public List<Habitacion> obtenerHabitacion(){
       List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            

        try {
            String sql = "SELECT * FROM habitacion;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNumero(resultSet.getInt("numero"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
    
                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener una Habitacion: " + ex.getMessage());
        }
        
        
        return habitaciones;
    }
    
    
    
    
    public void borrarHabitacion(int id_habitacion){
    
        try {  
        
                String sql = "DELETE FROM habitacion WHERE id_habitacion = ?;";
           
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, id_habitacion);
           
                statement.executeUpdate();
           
                statement.close();   
           
        } catch (SQLException ex) {
            System.out.println("Error al borrar una Habitacion: " + ex.getMessage());
        }

    }
    
    
    public void actualizarHabitacion(Habitacion habitacion){
         
        try {
             
             String sql = "UPDATE habitacion SET numero = ? , piso = ? , estado = ? WHERE id_habitacion = ? ;";
             
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
                statement.setInt(1, habitacion.getNumero());
                statement.setInt(2, habitacion.getPiso());
                statement.setBoolean(3, habitacion.getEstado());
                statement.setInt(4, habitacion.getId_habitacion());
                statement.executeUpdate();
          
                statement.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una Habitacion: " + ex.getMessage());
        }
        
    }
    
    
    public Habitacion buscarHabitacion(int id_habitacion){
    Habitacion habitacion =null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE id_habitacion =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_habitacion);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId_habitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNumero(resultSet.getInt("numero"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));

                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar una Habitacion: " + ex.getMessage());
        }
        
        return habitacion;
    } 
}
