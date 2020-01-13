package GUI.model;

import GUI.panel.DockPanel;
import entity.Dock;
import entity.Location;
import service.BoatService;
import service.DockService;
import service.LocationService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class DockInfoTableModel implements TableModel {
    public int indexDock = 0;
    private DockService ds = new DockService();
    private BoatService bs = new BoatService();
    public List<Location> locations = ds.getAllDock().get(indexDock).getLocations();

    String columnNames[] = new String[]{"ID d'Emplacement","Taille d'Emplacement" ,"ID Bateau" ,"Nom", "Type", "Caractère", "Poids", "Propriétaire"};

    @Override
    public int getRowCount() {
        return locations.size();
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
        Location location = locations.get(rowIndex);
        if(columnIndex == 0){
            return location.getId();
        }
        if(columnIndex == 1 ){
            return location.getSize();
        }
        if(columnIndex == 2 && location.getBoat() != null){
            return location.getBoat().getId();
        }
        if(columnIndex == 3 && location.getBoat() != null){
            return location.getBoat().getName();
        }
        if(columnIndex == 4 && location.getBoat() != null){
            return bs.getBoatType(location.getBoat().getId());
        }
        if(columnIndex == 5 && location.getBoat() != null){
            return bs.getBoatCharacter(location.getBoat().getId());
        }
        if(columnIndex == 6 && location.getBoat() != null){
            return location.getBoat().getWight();
        }
        if(columnIndex == 7 && location.getBoat() != null){
            return location.getBoat().getHost().getName();
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
