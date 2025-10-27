/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JTextField;

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
}
