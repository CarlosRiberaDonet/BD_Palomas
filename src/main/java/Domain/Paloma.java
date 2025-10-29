/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Paloma {
 
    private int idPaloma;
    private String anilla;
    private String nombre;
    private LocalDate nacimiento;
    private LocalDate muerte;
    private char genre;
    private String color;
    private String observaciones;
    private List<Pareja> parejaList= new ArrayList<>();
    private List<Cria> criaList = new ArrayList<>();
    
    // CONSTRUCTOR

    public Paloma(int idPaloma, String anilla, String nombre, LocalDate nacimiento, LocalDate muerte, char genre, String color, String observaciones) {
        this.idPaloma = idPaloma;
        this.anilla = anilla;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.muerte = muerte;
        this.genre = genre;
        this.color = color;
        this.observaciones = observaciones;
    }

    public Paloma(String anilla, String nombre, LocalDate nacimiento, char genre, String color, String observaciones) {
        this.anilla = anilla;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.genre = genre;
        this.color = color;
        this.observaciones = observaciones;
    }
    
    
    public Paloma(String anilla, String nombre, LocalDate nacimiento,LocalDate muerte, char genre, String color, String observaciones) {
        this.anilla = anilla;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.muerte = muerte;
        this.genre = genre;
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

    public LocalDate getMuerte() {
        return muerte;
    }

    public void setMuerte(LocalDate muerte) {
        this.muerte = muerte;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
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

    public List<Pareja> getParejaList() {
        return parejaList;
    }

    public void setParejaList(List<Pareja> parejaList) {
        this.parejaList = parejaList;
    }

    public List<Cria> getCriaList() {
        return criaList;
    }

    public void setCriaList(List<Cria> criaList) {
        this.criaList = criaList;
    }

    @Override
    public String toString() {
        return "Paloma{" + "idPaloma=" + idPaloma + ", anilla=" + anilla + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", sexo=" + genre + ", color=" + color + ", observaciones=" + observaciones + ", parejaList=" + parejaList + ", criaList=" + criaList + '}';
    }
}
