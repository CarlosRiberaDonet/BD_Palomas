/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Domain.Paloma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Carlos
 */
public class PalomaDAO {
    
    private static final String INSERT_PALOMA = "INSERT INTO paloma(anilla, nombre, "
            + "nacimiento, sexo, color, observaciones) VALUES (?, ?, ?, ?, ?, ?)";
    
    private static final String DELETE_PALOMA = "DELETE FROM paloma WHERE anilla = ?";
    
    private static final String SELECT_PALOMA = "SELECT * FROM paloma WHERE anilla = ?";
    
    public static boolean insertPaloma(Paloma paloma){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(INSERT_PALOMA)){
             
            stmt.setString(1, paloma.getAnilla());
            stmt.setString(2, paloma.getNombre());
            stmt.setDate(3, java.sql.Date.valueOf(paloma.getNacimiento()));
            stmt.setString(4, String.valueOf(paloma.getSexo()));
            stmt.setString(5, paloma.getColor());
            stmt.setString(6, paloma.getObservaciones());
            
            stmt.execute();
            return true;
        } catch(SQLException e){
            System.out.println("Error al ingresar nueva paloma");
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deletePaloma(String anilla){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(DELETE_PALOMA)){
            
            stmt.setString(1, anilla);
            int filasAfectadas = stmt.executeUpdate();
            
            return filasAfectadas > 0;

        } catch(SQLException e){
            System.out.println("Error al eliminar paloma");
            e.printStackTrace();
            return false;
        }
    }
    
    public static Paloma selectPaloma(String anilla){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(SELECT_PALOMA)){
            
            stmt.setString(1, anilla);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                Paloma paloma = new Paloma();
                paloma.setIdPaloma(rs.getInt("id"));
                paloma.setAnilla(rs.getString("anilla"));
                paloma.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                paloma.setSexo(rs.getString("sexo").charAt(0));
                paloma.setColor(rs.getString("color"));
                paloma.setObservaciones(rs.getString("observaciones"));
                
                return paloma;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return null;
    }
}
