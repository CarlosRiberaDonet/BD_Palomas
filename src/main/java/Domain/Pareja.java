/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.time.LocalDate;

/**
 *
 * @author Carlos
 */
public class Pareja {
    
    private int idPareja;
    private LocalDate fechaUnion;
    private LocalDate fechaSeparacion;
    
    // GETTERS Y SETTERS

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public LocalDate getFechaUnion() {
        return fechaUnion;
    }

    public void setFechaUnion(LocalDate fechaUnion) {
        this.fechaUnion = fechaUnion;
    }

    public LocalDate getFechaSeparacion() {
        return fechaSeparacion;
    }

    public void setFechaSeparacion(LocalDate fechaSeparacion) {
        this.fechaSeparacion = fechaSeparacion;
    }
    
}
