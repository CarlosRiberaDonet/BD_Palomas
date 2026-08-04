/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Window;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/**
 *
 * @author Carlos
 */
public class Utils {
    
 
    // Comprobar campo DateChooser y Castear a LocalDate
    public static LocalDate checkDateChooser(JDateChooser dateChooser){
        Date date = dateChooser.getDate();
        if (date == null) {
            return null;
        }
        return date.toInstant()
                   .atZone(ZoneId.systemDefault())
                   .toLocalDate();
    }

    
    // Métodos para comprobar campos vacíos
    public static boolean checkField(JTextField field, int maxLength){
        
        String text = field.getText().trim();
        return !text.isEmpty() && text.length() <= maxLength; // Devuelve "true" si el texto no está vacío ni tiene más de 30 caracteres
    }
    
    // Método para cerrar Panel
    public static void closePanel(Component component) {
        Window window = SwingUtilities.getWindowAncestor(component);
        if (window != null) {
            window.dispose();
        }
    }
    
    // Método para refrescar una tabla
    public static void refreshTable(JTable table, TableModel newModel) {
        table.setModel(newModel);
        table.revalidate();
        table.repaint();
    }
    
    // Método para 
}
