/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

/**
 *
 * @author Maqui's
 */
public class TipoDeHabitacion {
    private int id_tipo_de_habitacion;
    private String tipo;
    private int max_personas;
    private int cant_camas;
    private String tipo_camas;
    private double precio_noche;

    public TipoDeHabitacion(int id_tipo_de_habitacion, String tipo, int max_personas, int cant_camas, String tipo_camas, double precio_noche) {
        this.id_tipo_de_habitacion = id_tipo_de_habitacion;
        this.tipo = tipo;
        this.max_personas = max_personas;
        this.cant_camas = cant_camas;
        this.tipo_camas = tipo_camas;
        this.precio_noche = precio_noche;
    }

    public TipoDeHabitacion(String tipo, int max_personas, int cant_camas, String tipo_camas, double precio_noche) {
        this.tipo = tipo;
        this.max_personas = max_personas;
        this.cant_camas = cant_camas;
        this.tipo_camas = tipo_camas;
        this.precio_noche = precio_noche;
    }
    
    public TipoDeHabitacion() {
        id_tipo_de_habitacion=-1;
    }

    public int getId_tipo_de_habitacion() {
        return id_tipo_de_habitacion;
    }

    public void setId_tipo_de_habitacion(int id_tipo_de_habitacion) {
        this.id_tipo_de_habitacion = id_tipo_de_habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMax_personas() {
        return max_personas;
    }

    public void setMax_personas(int max_personas) {
        this.max_personas = max_personas;
    }

    public int getCant_camas() {
        return cant_camas;
    }

    public void setCant_camas(int cant_camas) {
        this.cant_camas = cant_camas;
    }

    public String getTipo_camas() {
        return tipo_camas;
    }

    public void setTipo_camas(String tipo_camas) {
        this.tipo_camas = tipo_camas;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }
      
}
