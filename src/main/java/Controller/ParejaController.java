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
    
    
    // Obtener parejas de una paloma mediante su id
    public static List<Paloma> getParejasList(int idPaloma){
 
        return ParejaDAO.selectPalomasList(idPaloma);
    }
}
