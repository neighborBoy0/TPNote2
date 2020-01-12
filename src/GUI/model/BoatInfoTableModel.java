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
        if(columnIndex == 0){
            return boat.getId();
        }
        if(columnIndex == 1){
            return boat.getName();
        }
        if(columnIndex == 2){
            return bs.getBoatType(boat.getId());
        }
        if(columnIndex == 3){
            return bs.getBoatCharacter(boat.getId());
        }
        if(columnIndex == 4){
            return boat.getWight();
        }
        if(columnIndex == 5 && boat.getHost() != null){
            return boat.getHost().getName();
        }
        if(columnIndex == 6 && boat.getLocation() != null){
            return boat.getLocation().getDock().getId();
        }
        if(columnIndex == 7 && boat.getLocation() != null){
            return boat.getLocation().getId();
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
