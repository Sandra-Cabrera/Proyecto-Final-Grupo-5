<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HuespedData {
    
     private Connection connection = null;

    public HuespedData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarHuesped(Huesped huesped){
        try {
            
            String sql = "INSERT INTO huesped ( nombre , dni , domicilio , correo , celular ) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4, huesped.getCorreo());
            statement.setInt(5, huesped.getCelular());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                huesped.setId_huesped(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un huésped");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huésped: " + ex.getMessage());
        }
    }
    
    
    
    //DEBEMOS AGREGAR ESTE METODO ???
    
    
    /*public List<Huesped> obtenerHuesped(){
       ArrayList<Huesped> huesped = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped"));
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getInt("celular"));
    
                huesped.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes: " + ex.getMessage());
        }
        
        
        return huesped;
    }*/
    
     //DELETE
     {
        
    String url = "jdbc:mysql://localhost/hotelidealgrupo5";
    String usuario="root";
    String password="";
    Connection conexion;
    PreparedStatement ps;
    try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
     
        ps=conexion.prepareStatement("DELETE FROM huesped WHERE id_huesped = ?;");
           ps.setInt(1, 2);
           ps.executeUpdate();
           ps.close();   
           
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(HotelIdeal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HotelIdeal.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HuespedData {
    
     private Connection connection = null;

    public HuespedData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarHuesped(Huesped huesped){
        try {
            
            String sql = "INSERT INTO huesped ( nombre , dni , domicilio , correo , celular ) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4, huesped.getCorreo());
            statement.setInt(5, huesped.getCelular());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                huesped.setId_huesped(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un huésped");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huésped: " + ex.getMessage());
        }
    }
    
    
    
    //DEBEMOS AGREGAR ESTE METODO ???
    
    
    /*public List<Huesped> obtenerHuesped(){
       ArrayList<Huesped> huesped = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped"));
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getInt("celular"));
    
                huesped.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes: " + ex.getMessage());
        }
        
        
        return huesped;
    }*/
    
     //DELETE
     {
        
    String url = "jdbc:mysql://localhost/hotelidealgrupo5";
    String usuario="root";
    String password="";
    Connection conexion;
    PreparedStatement ps;
    try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
     
        ps=conexion.prepareStatement("DELETE FROM huesped WHERE id_huesped = ?;");
           ps.setInt(1, 2);
           ps.executeUpdate();
           ps.close();   
           
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(HotelIdeal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HotelIdeal.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }
>>>>>>> 6405f3f879e4f7c188f58af1c830e45536ffb02c
