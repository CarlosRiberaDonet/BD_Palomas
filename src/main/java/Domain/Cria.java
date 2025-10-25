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
public class Cria {
    
    private int idCria;
    private Date fechaPuesta;
    private Date fechaNacimiento;
    
    // CONSTRUCTOR

    public Cria(int idCria, Date fechaPuesta, Date fechaNacimiento) {
        this.idCria = idCria;
        this.fechaPuesta = fechaPuesta;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // GETTERS Y SETTERS

    public int getIdCria() {
        return idCria;
    }

    public void setIdCria(int idCria) {
        this.idCria = idCria;
    }

    public Date getFechaPuesta() {
        return fechaPuesta;
    }

    public void setFechaPuesta(Date fechaPuesta) {
        this.fechaPuesta = fechaPuesta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
