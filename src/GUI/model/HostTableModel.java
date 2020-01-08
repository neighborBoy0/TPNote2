package GUI.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class HostTableModel implements TableModel {

    String columnNames[] = new String[]{"ID", "Nom", "Adresse", "ID Bateau", "Nom Bateau", "Poids", "Type", "Caratère", "ID Quai", "ID Emplacement"};

    //public List<Host> hs = new HostService()

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
