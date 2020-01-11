package GUI.model;

import GUI.listener.DockListener;
import entity.Dock;
import service.DockService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class DockTableModel implements TableModel {

    String columnNames[] = new String[]{"ID Quai", "Nombre d'emplacement"};

    public List<Dock> docks = new DockService().getAllDock();

    @Override
    public int getRowCount() {
        return docks.size();
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
        Dock dock = docks.get(rowIndex);
        switch (columnIndex){
            case 0:
                return dock.getId();
            case 1:
                return dock.getNbLocation();
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
