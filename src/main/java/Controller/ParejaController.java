/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ParejaDAO;
import Domain.Paloma;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ParejaController {
    
    
    // Crear pareja
    public static boolean crearPareja(String anilla, String anillaPareja){
       return ParejaDAO.createPareja(anilla, anillaPareja);
    }
    
    // Obtener pareja
    public static String getPareja(int idPaloma, char sexo){
        return ParejaDAO.selectAnillaPareja(idPaloma, sexo);
    }
    
    // Obtener parejas de una paloma mediante su id
    public static List<Paloma> getParejasList(int idPaloma){
        return ParejaDAO.selectPalomasList(idPaloma);
    }
    
    // Método para comprobar si una pareja ya existe
    public static boolean parejaExists(String anillaMacho, String anillaHembra){
        
        return ParejaDAO.parejaExists(anillaMacho, anillaHembra);
    }
}
