/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PalomaDAO;
import Domain.Paloma;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class PalomaController {
    
    private static Scanner sc = new Scanner(System.in);
    public static Paloma nuevaPaloma(){
        
        try{
            System.out.println("Ingrese codigo de anilla:");
            String anilla = sc.nextLine();
            System.out.println("Ingrese el nombre:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese fecha de nacimiento (yyyy-MM-dd):");
            String fechaNacimientoStr = sc.nextLine();
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("Ingrese sexo (H/M):");
            String sexoStr = sc.nextLine(); // lee toda la línea
            char sexo = sexoStr.charAt(0);  // toma el primer carácter;
            System.out.println("Ingrese color:");
            String color = sc.nextLine();
            System.out.println("Ingrese observaciones:");
            String observaciones = sc.nextLine();
            
            Paloma nuevaPaloma = new Paloma(anilla, nombre, fechaNacimiento, sexo, color, observaciones);
            
            PalomaDAO.insertPaloma(nuevaPaloma);
        }catch(Exception e){
            System.out.println("Error a intentar agregar nueva paloma a la BD");
            e.printStackTrace();
        }
        return null;
    }
    
    
}
