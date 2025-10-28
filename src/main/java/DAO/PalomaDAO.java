/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Domain.Cria;
import Domain.Paloma;
import Domain.Pareja;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class PalomaDAO {
    
    private static final String GET_PALOMAS = "SELECT * FROM paloma";
    
    private static final String INSERT_PALOMA = "INSERT INTO paloma(anilla, nombre, "
            + "nacimiento, sexo, color, observaciones) VALUES (?, ?, ?, ?, ?, ?)";
    
    private static final String DELETE_PALOMA = "DELETE FROM paloma WHERE anilla = ?";
    
    private static final String SELECT_PALOMA_BY_ANILLA = "SELECT p.id, " +
            "p.anilla, " +
            "p.nombre ," +
            "p.nacimiento, "+
            "p.sexo, " +
            "p.color, " +
            "p.observaciones, " +
            "pa.id as pareja_id, " +
            "pa.fecha_union, " +
            "pa.fecha_separacion," +
            "pp.id_paloma, " +
            "pp.id_pareja, " +
            "c.id AS id_cria, " +
            "c.fecha_puesta, " +
            "c.fecha_nacimiento AS nacimiento_cria " +
            "FROM paloma p " +
            "LEFT JOIN pareja_paloma pp ON pp.id_paloma = p.id " +
            "LEFT JOIN pareja pa ON pp.id_pareja = pa.id " +
            "LEFT JOIN cria c ON pa.id = c.id_pareja " +
            "WHERE p.anilla = ?";
    
    private static final String GET_LAST_PAREJA = "SELECT p.* " +
            "FROM pareja p " +
            "JOIN pareja_paloma pp ON p.id = pp.id_pareja " +
            "WHERE pp.id_paloma = ? " +
            "ORDER BY p.fecha_union DESC " +
            "LIMIT 1;";
    
    
    // Obtener todas las palomas
    public static List<Paloma> getPalomasList(){
        
        List<Paloma> palomasList = new ArrayList<>();
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(GET_PALOMAS)){
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Paloma paloma = new Paloma();
                paloma.setIdPaloma(rs.getInt("id"));
                paloma.setAnilla(rs.getString("anilla"));
                paloma.setNombre(rs.getString("nombre"));
                paloma.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                paloma.setGenre(rs.getString("sexo").charAt(0));
                paloma.setColor(rs.getString("color"));
                paloma.setObservaciones(rs.getString("observaciones"));
                
                palomasList.add(paloma);
            }
            return palomasList;
            
        }catch(SQLException e){
            System.out.println("Error al obtener la lista de palomas");
            e.printStackTrace();
        }
        
        return null;
    }
    // Agregar nueva paloma a la BD
    public static boolean insertPaloma(Paloma paloma){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(INSERT_PALOMA)){
             
            stmt.setString(1, paloma.getAnilla());
            stmt.setString(2, paloma.getNombre());
            stmt.setDate(3, java.sql.Date.valueOf(paloma.getNacimiento()));
            stmt.setString(4, String.valueOf(paloma.getGenre()));
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
    
    // Eliminar paloma de la BD
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
    
    // Obtener todos los datos de una paloma
    public static Paloma selectPaloma(String anilla){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(SELECT_PALOMA_BY_ANILLA)){
            
            stmt.setString(1, anilla);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                
                Paloma paloma = new Paloma();
                paloma.setIdPaloma(rs.getInt("id"));
                paloma.setAnilla(rs.getString("anilla"));
                paloma.setNombre(rs.getString("nombre"));
                paloma.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                paloma.setGenre(rs.getString("sexo").charAt(0));
                paloma.setColor(rs.getString("color"));
                paloma.setObservaciones(rs.getString("observaciones"));
                
                int idPareja = rs.getInt("pareja_id");
                if(idPareja > 0){
                    Pareja pareja = new Pareja();
                    pareja.setIdPareja(rs.getInt("pareja_id"));
                    pareja.setFechaUnion(rs.getDate("fecha_union").toLocalDate());
                    pareja.setFechaSeparacion(rs.getDate("fecha_separacion").toLocalDate());
                    paloma.getParejaList().add(pareja);
                }
                
                int id_cria = rs.getInt("id_cria");
                if(id_cria > 0){
                    Cria cria = new Cria();
                    cria.setIdCria(rs.getInt("id_cria"));
                    cria.setFechaPuesta(rs.getDate("fecha_puesta").toLocalDate());
                    cria.setFechaNacimiento(rs.getDate("nacimiento_cria").toLocalDate());
                    paloma.getCriaList().add(cria);
                }
                
                return paloma;
            }
            
        }catch(SQLException e){
            System.out.println("Error al intentar obtener la paloma");
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    // Obtener la última pareja
    public static Paloma getLastPareja(Pareja pareja){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(GET_LAST_PAREJA)){
            
            
        }catch(SQLException e){
            System.out.println("Error al obtener la ultima pareja");
            e.printStackTrace();
        }
        
        return null;
    }
}
