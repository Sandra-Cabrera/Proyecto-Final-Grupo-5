/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelideal;

import java.sql.Date;

/**
 *
 * @author Sandra
 */
public class Reserva {
    private int id_reserva;
    private Date ingreso;
    private Date egreso;
    private Double importe_total;
    private Boolean estado;
    private int id_habitacion;
    private int id_huesped;

    public Reserva(int id_reserva, Date ingreso, Date egreso, Double importe_total, Boolean estado, int id_huesped, int id_habitacion) {
        this.id_reserva = id_reserva;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.importe_total = importe_total;
        this.estado = estado;
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
    }
        
    public Reserva(Date ingreso, Date egreso, Double importe_total, Boolean estado, int id_huesped, int id_habitacion) {
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.importe_total = importe_total;
        this.estado = estado;
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
    }

    public Reserva() {
        id_reserva=-1;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public Date getEgreso() {
        return egreso;
    }

    public void setEgreso(Date egreso) {
        this.egreso = egreso;
    }

    public Double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(Double importe_total) {
        this.importe_total = importe_total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getId_uesped() {
        return id_huesped;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public int getId_Habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Object getNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getTipoDeHabitacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
