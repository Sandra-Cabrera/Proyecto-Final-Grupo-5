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
public class Habitacion {
    private int id_habitacion;
    private int numero;
    private int piso;
    private Boolean estado;
    private TipoDeHabitacion tipoDeHabitacion;

    public Habitacion(int id_habitacion, int numero, int piso, Boolean estado, TipoDeHabitacion tipoDeHabitacion) {
        this.id_habitacion = id_habitacion;
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public Habitacion(int numero, int piso, Boolean estado, TipoDeHabitacion tipoDeHabitacion ) {
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

     public Habitacion() {
        id_habitacion=-1;
    }
    
    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public TipoDeHabitacion getTipodeHabitacion() {
        return tipoDeHabitacion;
    }
    
    public void setTipoDeHabitacion(TipoDeHabitacion tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }
    
    
}
