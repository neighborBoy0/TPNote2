package GUI.model;

import entity.Boat;
import service.BoatService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class BoatInfoTableModel implements TableModel {
    BoatService<Boat> bs = new BoatService<Boat>();
    public List<Boat> boats = bs.getAllBoat();

    String columnNames[] = new String[]{"ID Bateau" ,"Nom", "Type", "Caractère", "Poids", "Propriétaire", "ID Quai", "ID Emplacement"};

    @Override
    public int getRowCount() {
        return boats.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Boat boat = boats.get(rowIndex);
        switch (columnIndex){
            case 0:
                return boat.getId();
            case 1:
                return boat.getName();
            case 2:
                return bs.getBoatType(boat.getId());
            case 3:
                return bs.getBoatCharacter(boat.getId());
            case 4:
                return boat.getWight();
            /*case 5:
                return boat.getHost().getName();*/
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }
}
