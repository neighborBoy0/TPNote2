package GUI.model;

import entity.Dock;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class DockTableModel implements TableModel {

    String columnNames[] = new String[]{"ID", "Nombre d'emplacement"};

    //public List<Dock> ds = new DockService()

    @Override
    public int getRowCount() {
        return 0;
        //return ds.size();
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
