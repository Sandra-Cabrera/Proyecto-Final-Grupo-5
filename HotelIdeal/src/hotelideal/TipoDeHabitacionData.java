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
public class TipoDeHabitacionData {
    private Connection connection = null;
    private Conexion conexion;
    
    //conexion de la clase con su excepcion 
    public TipoDeHabitacionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
            this.conexion = conexion;
            
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    //metodo guardar un tipo de habitacion con todos sus campos
    public void guardarTipoDeHabitaion(TipoDeHabitacion tipoDeHabitacion){
        try {
            String sql = "INSERT INTO tipoDeHabitacion ( tipo , max_personas , cant_camas , tipo_camas , precio_noche ) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, tipoDeHabitacion.getTipo());
            statement.setInt(2, tipoDeHabitacion.getMax_personas());
            statement.setInt(3, tipoDeHabitacion.getCant_camas());
            statement.setString(4, tipoDeHabitacion.getTipo_camas());
            statement.setDouble(5, tipoDeHabitacion.getPrecio_noche());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                tipoDeHabitacion.setId_tipo_de_habitacion(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un Tipo De Habitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al guardar un Tipo De Habitacion: " + ex.getMessage());
        }
    }
    
    
    
    public List<TipoDeHabitacion> obtenerTipoDeHabitacion(){
       List<TipoDeHabitacion> tipoDeHabitaciones = new ArrayList<TipoDeHabitacion>();
            

        try {
            String sql = "SELECT * FROM tipoDeHabitacion;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoDeHabitacion tipoDeHabitacion;
            while(resultSet.next()){
                tipoDeHabitacion = new TipoDeHabitacion();
                tipoDeHabitacion.setId_tipo_de_habitacion(resultSet.getInt("id_tipo_de_habitacion"));
                tipoDeHabitacion.setTipo(resultSet.getString("tipo"));
                tipoDeHabitacion.setMax_personas(resultSet.getInt("max_personas"));
                tipoDeHabitacion.setCant_camas(resultSet.getInt("cant_camas"));
                tipoDeHabitacion.setTipo_camas(resultSet.getString("tipo_camas"));
                tipoDeHabitacion.setPrecio_noche(resultSet.getDouble("precio_noche"));
    
                tipoDeHabitaciones.add(tipoDeHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener un Tipo De Habitacion: " + ex.getMessage());
        }
        
        return tipoDeHabitaciones;
    }
    
    
    
    
    public void borrarTipoDeHabitacion(int id_tipo_de_habitacion){
    
        try {  
        
                String sql = "DELETE FROM tipoDeHabitacion WHERE id_tipo_de_habitacion = ?;";
           
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, id_tipo_de_habitacion);
           
                statement.executeUpdate();
           
                statement.close();   
           
        } catch (SQLException ex) {
            System.out.println("Error al borrar un Tipo De Habitacion: " + ex.getMessage());
        }

    }
    
    
    public void cambiarPrecio(TipoDeHabitacion tipoDeHabitacion){
         
        try {
             
             String sql = "UPDATE tipoDeHabitacion SET tipo = ? , max_personas = ? , cant_camas = ? , tipo_camas = ? , precio_noche = ? WHERE id_tipo_de_habitacion = ? ;";
             
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
                statement.setString(1, tipoDeHabitacion.getTipo());
                statement.setInt(2, tipoDeHabitacion.getMax_personas());
                statement.setInt(3, tipoDeHabitacion.getCant_camas());
                statement.setString(4, tipoDeHabitacion.getTipo_camas());
                statement.setDouble(5, tipoDeHabitacion.getPrecio_noche());
                statement.setInt(6, tipoDeHabitacion.getId_tipo_de_habitacion());
                statement.executeUpdate();
          
                statement.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el precio del Tipo De Habitacion: " + ex.getMessage());
        }
        
    }
    
  
    
    public TipoDeHabitacion buscarTipoDeHabitacion(int id_tipo_de_habitacion){
        TipoDeHabitacion tipoDeHabitacion = null;
        try {
            
            String sql = "SELECT * FROM tipoDeHabitacion WHERE id_tipo_de_habitacion = ? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_tipo_de_habitacion);
           
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                tipoDeHabitacion = new TipoDeHabitacion();
                tipoDeHabitacion.setId_tipo_de_habitacion(resultSet.getInt("id_tipo_de_habitacion"));
                tipoDeHabitacion.setTipo(resultSet.getString("tipo"));
                tipoDeHabitacion.setMax_personas(resultSet.getInt("max_personas"));
                tipoDeHabitacion.setCant_camas(resultSet.getInt("cant_camas"));
                tipoDeHabitacion.setTipo_camas(resultSet.getString("tipo_camas"));
                tipoDeHabitacion.setPrecio_noche(resultSet.getDouble("precio_noche"));

                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar un Tipo De Habitacion: " + ex.getMessage());
        }
        
        return tipoDeHabitacion;
    }
}
