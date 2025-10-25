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
public class Paloma {
 
    private int idPaloma;
    private String anilla;
    private String nombre;
    private LocalDate nacimiento;
    private char sexo;
    private String color;
    private  String observaciones;
    
    // CONSTRUCTOR
    
    public Paloma(String anilla, String nombre, LocalDate nacimiento, char sexo, String color, String observaciones) {
        this.anilla = anilla;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
        this.color = color;
        this.observaciones = observaciones;
    }

    public Paloma() {
    }
    
    // GETTERS Y SETTERS

    public int getIdPaloma() {
        return idPaloma;
    }

    public void setIdPaloma(int idPaloma) {
        this.idPaloma = idPaloma;
    }

    public String getAnilla() {
        return anilla;
    }

    public void setAnilla(String anilla) {
        this.anilla = anilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
