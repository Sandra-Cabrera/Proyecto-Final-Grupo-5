/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HotelIdeal {

    /**
     * @param args the command line arguments
     */
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
    
}
