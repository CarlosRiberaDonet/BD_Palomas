 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import DAO.ConexionBD;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class BD_Palomas {

    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        
        try{
            ConexionBD.connectionPalomas();
            System.out.println("Conexion exitosa");
        } catch(SQLException e){
            System.out.println("Error al conectar con la BD");
        }  
        
        // PalomaController.nuevaPaloma();
    }
}
