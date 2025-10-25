/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.sql.Date;

/**
 *
 * @author Carlos
 */
public class Pareja {
    
    private int idPareja;
    private Date fechaUnion;
    private Date fechaSeparacion;
    
    // GETTERS Y SETTERS

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public Date getFechaUnion() {
        return fechaUnion;
    }

    public void setFechaUnion(Date fechaUnion) {
        this.fechaUnion = fechaUnion;
    }

    public Date getFechaSeparacion() {
        return fechaSeparacion;
    }

    public void setFechaSeparacion(Date fechaSeparacion) {
        this.fechaSeparacion = fechaSeparacion;
    }
    
}
