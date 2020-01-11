package GUI.model;

import entity.Host;
import service.HostService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;
import java.util.ArrayList;

public class HostTableModel implements TableModel {
    HostService hs = new HostService();
    public List<Host> hosts;

    public final String[] columnNames = new String[]{"ID", "Nom", "Adresse", "ID Bateau", "Nom Bateau", "Poids", "Type", "Caratère", "ID Quai", "ID Emplacement"};

    public List<Host> list = new ArrayList<Host>();

    @Override
    public int getRowCount() {
        return list.size();
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
        Host host = hosts.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return host.getId();
            case 1:
                return host.getName();
            case 2:
                return host.getAddress();
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
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

    public List<Host> getList(){
        return list;
    }

    public void setList(List<Host> list){
        this.list = list;
    }

}
