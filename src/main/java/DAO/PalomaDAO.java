/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Domain.Paloma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class PalomaDAO {
    
    private static final String INSERT_PALOMA = "INSERT INTO paloma(anilla, nombre, "
            + "nacimiento, sexo, color, observaciones) VALUES (?, ?, ?, ?, ?, ?)";
    
    public static void insertPaloma(Paloma paloma){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(INSERT_PALOMA)){
             
            stmt.setString(1, paloma.getAnilla());
            stmt.setString(2, paloma.getNombre());
            stmt.setDate(3, java.sql.Date.valueOf(paloma.getNacimiento()));
            stmt.setString(4, String.valueOf(paloma.getSexo()));
            stmt.setString(5, paloma.getColor());
            stmt.setString(6, paloma.getObservaciones());
            
            stmt.execute();
            
        } catch(SQLException e){
            System.out.println("Error al ingresar nueva paloma");
            e.printStackTrace();
        }
    }
}
