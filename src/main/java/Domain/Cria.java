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
public class Cria {
    
    private int idCria;
    private LocalDate fechaPuesta;
    private LocalDate fechaNacimiento;
    
    // CONSTRUCTOR

    public Cria(int idCria, LocalDate fechaPuesta, LocalDate fechaNacimiento) {
        this.idCria = idCria;
        this.fechaPuesta = fechaPuesta;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Cria(){
        
    }
    
    // GETTERS Y SETTERS

    public int getIdCria() {
        return idCria;
    }

    public void setIdCria(int idCria) {
        this.idCria = idCria;
    }

    public LocalDate getFechaPuesta() {
        return fechaPuesta;
    }

    public void setFechaPuesta(LocalDate fechaPuesta) {
        this.fechaPuesta = fechaPuesta;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
