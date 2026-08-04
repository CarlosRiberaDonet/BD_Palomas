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
    private char sexo;
    private String color;
    private boolean tipo;
    private String observaciones;
    private List<Pareja> parejaList= new ArrayList<>();
    private List<Cria> criaList = new ArrayList<>();
    
    // CONSTRUCTOR

    public Paloma(int idPaloma, String nombre, LocalDate nacimiento, LocalDate muerte, char sexo, String color, boolean tipo, String observaciones) {
        this.idPaloma = idPaloma;
        this.anilla = anilla;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.muerte = muerte;
        this.sexo = sexo;
        this.color = color;
        this.tipo = tipo;
        this.observaciones = observaciones;
    }

    public Paloma(String anilla, String nombre, LocalDate nacimiento, char sexo, String color, boolean tipo, String observaciones) {
        this.anilla = anilla;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
        this.color = color;
        this.tipo = tipo;
        this.observaciones = observaciones;
    }
    
    
    public Paloma(String anilla, String nombre, LocalDate nacimiento,LocalDate muerte, char sexo, String color, boolean tipo, String observaciones) {
        this.anilla = anilla;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.muerte = muerte;
        this.sexo = sexo;
        this.color = color;
        this.tipo = tipo;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
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
        return "Paloma: {\n" 
                + " idPaloma=" + idPaloma + "\n"
                + " anilla=" + anilla + "\n"
                + " nombre=" + nombre + "\n"
                + " nacimiento=" + nacimiento + "\n"
                + " sexo=" + sexo + "\n"
                + " color=" + color + "\n"
                + " tipo=" + tipo + "\n"
                + " observaciones=" + observaciones + "\n"
                + " parejaList=" + parejaList + "\n"
                + " criaList=" + criaList + "\n"
                + '}';
    }

}
