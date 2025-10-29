/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos
 */
public class PalomaTableModel extends AbstractTableModel{
    
    private List<Paloma> palomasList;
    private final String[] columnNames = {"ANILLA", "NOMBRE", "NACIMIENTO", "COLOR", "SEXO"};
    
      public PalomaTableModel(List<Paloma> palomas) {
        this.palomasList = palomas;
    }

    @Override
    public int getRowCount() {
        return palomasList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paloma p = palomasList.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getAnilla().toUpperCase();
            case 1: return p.getNombre().toUpperCase();
            case 2: return p.getNacimiento();
            case 3: return p.getColor().toUpperCase();
            case 4: return p.getGenre();
            default: return null;
        }
    }
}
