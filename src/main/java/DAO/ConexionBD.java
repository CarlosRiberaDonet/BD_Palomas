/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class ConexionBD {
    
    private static final String URL = "jdbc:mysql://localhost:3306/palomas";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection connectionPalomas() throws SQLException{

        try{
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException e){
            System.out.println("Error al conectar con la BD");
            e.printStackTrace();
        }
        return null;
    }
}
