/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PalomaDAO;
import Domain.Paloma;
import Domain.Pareja;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class PalomaController {
    
    
    // Obtener todas las palomas
    public static List<Paloma> getPalomas(){
        return PalomaDAO.getPalomasList();
    }
    public static boolean nuevaPaloma(Paloma nuevaPaloma){   
        return PalomaDAO.insertPaloma(nuevaPaloma);
  
    }
    
    public static boolean eliminarPaloma(String anilla){
        return PalomaDAO.deletePaloma(anilla);
    }
    
    public static Paloma buscarPaloma(String anilla){
        return PalomaDAO.selectPaloma(anilla);
    }
    
    // Método para comporbar género de la paloma
   public static boolean getGenre(Paloma paloma){
       return paloma.getGenre() == 'M'; // Devuelve "True" si es macho, "False" si es hembra
   }
   
   // Obtener última pareja
   public static Paloma getLastPareja(Pareja pareja){
       return null;
   }
}
