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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ParejaDAO {
    
    private static final String SELECT_PAREJAS = "SELECT * FROM pareja WHERE id = ?";
    
    private static final String SELECT_ANILLA_PAREJA = "SELECT anilla_macho, anilla_hembra FROM pareja WHERE id = ?";
    
    private static final String SELECT_PAREJA_BY_ID = 
        "SELECT p.id, p.anilla, p.nombre, p.nacimiento, p.sexo, p.color, p.observaciones, " +
        "pa.id AS pareja_id, pa.anilla_macho, pa.anilla_hembra, " +
        "pa.fecha_union, pa.fecha_separacion " +
        "FROM paloma p " +
        "JOIN pareja pa ON (p.anilla = pa.anilla_macho OR p.anilla = anilla_hembra) " +
        "WHERE p.id = ?";

    private static final String INSERT_PAREJA = "INSERT INTO pareja (anilla_macho, anilla_hembra, fecha_union) VALUES (?, ?, ?)";
    
    private static final String FIND_PAREJA = 
        "SELECT COUNT(*) FROM pareja WHERE " +
        "((anilla_macho = ? AND anilla_hembra = ?) OR (anilla_hembra = ? AND anilla_macho = ?)) " +
        "AND fecha_separacion IS NULL";
    
    public static boolean createPareja(String anillaMacho, String anillaHembra){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(INSERT_PAREJA)){
            
            stmt.setString(1, anillaMacho);
            stmt.setString(2, anillaHembra);
            stmt.setObject(3, java.time.LocalDate.now());
            
            stmt.execute();
            return true;
        } catch(SQLException e){
            System.out.println("Error al crear pareja");
            e.printStackTrace();
        }
        return false;
    }
    
    public static String selectAnillaPareja(int idPaloma, char sexo){
        
        String anillaPareja = " SIN PAREJA";
        System.out.println("SEXO: " + sexo);
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(SELECT_PAREJA_BY_ID)){
            
            stmt.setInt(1, idPaloma);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                String macho = rs.getString("anilla_macho");
                String hembra = rs.getString("anilla_hembra");
                // Si la paloma es macho, selecciono la anilla de la pareja hembra
                if(sexo == 'M'){
                    anillaPareja = hembra;
                } else{
                    anillaPareja = macho;
                }
            }
        }catch(SQLException e){
            System.out.println("Error al obtener las parejas de la paloma");
            e.printStackTrace();
        }
        
        return anillaPareja;
    }
    
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
                
                parejaList.add(paloma);
            }
        }catch(SQLException e){
            System.out.println("Error al obtener las parejas de la paloma");
            e.printStackTrace();
        }
        
        return parejaList;
    }
    
    // Consultar si la pareja existe en la tabla Pareja de la BD
    public static boolean parejaExists(String anillaMacho, String anillaHembra){
        
        try(Connection conn = ConexionBD.connectionPalomas(); PreparedStatement stmt = conn.prepareStatement(FIND_PAREJA)){
            
            // Comparo anillaMacho con anillaHembra
            stmt.setString(1, anillaMacho);
            stmt.setString(2, anillaHembra);
            // Comparo anillaHembra con anillaMacho
            stmt.setString(3, anillaHembra);
            stmt.setString(4,anillaMacho);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return rs.getInt(1) > 0; // Si el conteo es mayor a 0, la pareja existe
            }
        } catch(SQLException e){
            System.out.println("ERROR SQL: " + e.getMessage()); // Esto te dirá "Parameter index out of range (3 > number of parameters, which is 2)" si ese es el problema.
            e.printStackTrace();
        }
        return false;
    }
}