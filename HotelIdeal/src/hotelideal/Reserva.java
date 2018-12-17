/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Sandra
 */
public class Reserva {
    private int id_reserva;
    private LocalDate ingreso;
    private LocalDate egreso;
    private double importe_total;
    private boolean estado;
    private Huesped huesped;
    private Habitacion habitacion;
    private int cantidad_personas;

    public Reserva(int id_reserva, LocalDate ingreso, LocalDate egreso, int cantidad_personas, double importe_total, boolean estado, Huesped huesped, Habitacion habitacion) {
        this.id_reserva = id_reserva;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.cantidad_personas = cantidad_personas;
        this.importe_total = importe_total;
        this.estado = estado;
        this.huesped = huesped;
        this.habitacion = habitacion;
    }
        
    public Reserva(LocalDate ingreso, LocalDate egreso, int cantidad_personas, double importe_total, boolean estado, Huesped huesped, Habitacion habitacion) {
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.cantidad_personas = cantidad_personas;
        this.importe_total = importe_total;
        this.estado = estado;
        this.huesped = huesped;
        this.habitacion = habitacion;
    }

    public Reserva() {
        id_reserva=-1;
    }

    public Reserva(Date ingreso, Date egreso, double importe_total, int id_huesped, int id_habitacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDate ingreso) {
        this.ingreso = ingreso;
    }

    public LocalDate getEgreso() {
        return egreso;
    }

    public void setEgreso(LocalDate egreso) {
        this.egreso = egreso;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Object getNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public int getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    } 
}
