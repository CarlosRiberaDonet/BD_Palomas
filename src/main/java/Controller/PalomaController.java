/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PalomaDAO;
import Domain.Paloma;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class PalomaController{
    
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
    
    // Filtrar Paloma por pareja
    public static List<Paloma> filtrarParejas(int idPaloma){
        
        List<Paloma> parejasList = new ArrayList<>();
        
        
        return parejasList;
    }
    
    // Método para recorrer lista de palomas
    public static List<Paloma> recorrerPalomasList(List<Paloma> palomasList){
        
        for(Paloma p : palomasList){
          
        }
        
        return palomasList;
    }
    
    // Método para comprobar género de la paloma
    public static boolean getGenre(Paloma paloma){
       return paloma.getSexo() == 'M'; // Devuelve "True" si es macho, "False" si es hembra
   }
}
