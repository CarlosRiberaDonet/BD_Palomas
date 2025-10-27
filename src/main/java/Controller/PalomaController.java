/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PalomaDAO;
import Domain.Paloma;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class PalomaController {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static boolean nuevaPaloma(Paloma nuevaPaloma){   
        return PalomaDAO.insertPaloma(nuevaPaloma);
  
    }
    
    public static boolean eliminarPaloma(String anilla){
        return PalomaDAO.deletePaloma(anilla);
    }
    
    public static Paloma buscarPaloma(String anilla){
        return PalomaDAO.selectPaloma(anilla);
    }
}
