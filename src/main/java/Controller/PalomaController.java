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
    
    // Obtener todas las palomas de la BD
    public static List<Paloma> getPalomasList(){
        return PalomaDAO.getPalomasList();
    }
    
    // Crear nueva paloma en la BD
    public static boolean nuevaPaloma(Paloma nuevaPaloma){   
        return PalomaDAO.insertPaloma(nuevaPaloma);
    }
    
    // Eliminar paloma de la BD
    public static boolean eliminarPaloma(int idPaloma){
        return PalomaDAO.deletePaloma(idPaloma);
    }
    
    // Buscar paloma por anilla en la BD
    public static Paloma buscarPaloma(String anilla){
        return PalomaDAO.selectPaloma(anilla);
    }
    
    // Modificar datos de paloma
    public static boolean modificarPaloma(Paloma paloma){
        return PalomaDAO.modifyPaloma(paloma);
    }
    
    // Método para comporbar género de la paloma
   public static boolean getGenre(Paloma paloma){
       return paloma.getSexo() == 'M'; // Devuelve "True" si es macho, "False" si es hembra
   }
   
   // Obtener última pareja
   public static Paloma getLastPareja(Pareja pareja){
       return null;
   }
}
