

package hotelideal;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;



public class HotelIdeal {

    public static void main(String[] args){
  
       HuespedData huespedData = null;
        Conexion conexion = null;
        try {
            conexion = new Conexion("jdbc:mysql://localhost/hotelidealgrupo5", "root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HotelIdeal.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        huespedData = new HuespedData(conexion);
        Huesped huesped = new Huesped("Pablo Alvarez",36777888,"Rivadavia 550","pabloa@ulp.edu.ar",266498766);
        huespedData.guardarHuesped(huesped);
        
    }
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package hotelideal;

import java.util.logging.Level;
import java.util.logging.Logger;

 *
 * @author Usuario

public class HotelIdeal {
    
     * @param args the command line arguments
    
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conexion;
        Huesped huesped = new Huesped("Sandra",1733344,"Las cañitas","sandra@gmail.com",26645566);
        try {
            conexion = new Conexion("jdbc:mysql://localhost/universidad", "root", "");
            HuespedData huespedData = new HuespedData(conexion);
            huespedData.guardarHuesped(huesped);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HotelIdeal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
} */
