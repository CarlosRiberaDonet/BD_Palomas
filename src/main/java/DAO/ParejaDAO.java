/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Domain.Paloma;
import Domain.Pareja;
import Domain.ParejaPaloma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ParejaDAO {
    
private static final String SELECT_PAREJA_BY_ID = 
    "SELECT p.id, p.anilla, p.nombre, p.nacimiento, p.sexo, p.color, p.observaciones, " +
    "pp.id AS pareja_paloma_id, pp.id_paloma, pp.id_pareja, " +
    "pa.id AS pareja_id, pa.fecha_union, pa.fecha_separacion " +
    "FROM paloma p " +
    "JOIN pareja_paloma pp ON pp.id_paloma = p.id " +
    "JOIN pareja pa ON pa.id = pp.id_pareja " +
    "WHERE pp.id_paloma = ?";

    
    public static List<Paloma> selectPalomasList(int idPaloma){
        
        List<Paloma> parejaList = new ArrayList<>();
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(SELECT_PAREJA_BY_ID)){
            
            stmt.setInt(1, idPaloma);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){               
                Paloma paloma = new Paloma();
                paloma.setIdPaloma(rs.getInt("id"));
                paloma.setAnilla(rs.getString("anilla"));
                paloma.setNombre(rs.getString("nombre"));
                paloma.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                paloma.setSexo(rs.getString("sexo").charAt(0));
                paloma.setColor(rs.getString("color"));
                paloma.setObservaciones(rs.getString("observaciones"));
                
//                ParejaPaloma parejaPaloma = new ParejaPaloma();
//                parejaPaloma.setIdPaloma(rs.getInt("pareja_paloma_id"));
//                parejaPaloma.setIdPareja(rs.getInt("id_Paloma"));
//                parejaPaloma.setIdParejaPaloma(rs.getInt("id_pareja"));
                
                Pareja pareja = new Pareja();
                pareja.setIdPareja(rs.getInt("pareja_id"));
                pareja.setFechaUnion(rs.getDate("fecha_union").toLocalDate());
                pareja.setFechaSeparacion(rs.getDate("fecha_separacion").toLocalDate());
                
                System.out.println("Añadiendo pareja a la lista");
                paloma.getParejaList().add(pareja);
                parejaList.add(paloma);
            }
            return parejaList;
        }catch(SQLException e){
            System.out.println("Error al obtener las parejas de la paloma");
            e.printStackTrace();
        }
        
        return null;
    }
}
