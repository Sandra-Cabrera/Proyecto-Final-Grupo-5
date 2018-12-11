/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

/**
 *
 * @author Grupo5
 */
public class Habitacion {
    private int id_habitacion;
    private int numero;
    private int piso;
    private boolean estado;
    private TipoDeHabitacion tipo_de_habitacion;

    public Habitacion(int id_habitacion, int numero, int piso, boolean estado, TipoDeHabitacion tipo_de_habitacion) {
        this.id_habitacion = id_habitacion;
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tipo_de_habitacion = tipo_de_habitacion;
    }

    public Habitacion(int numero, int piso, boolean estado, TipoDeHabitacion tipo_de_habitacion ) {
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tipo_de_habitacion = tipo_de_habitacion;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public TipoDeHabitacion getTipo_de_habitacion() {
        return tipo_de_habitacion;
    }
    
    public void setTipo_de_habitacion(TipoDeHabitacion tipo_de_habitacion) {
        this.tipo_de_habitacion = tipo_de_habitacion;
    }
    
    
}
