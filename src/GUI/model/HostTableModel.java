package GUI.model;

import entity.Boat;
import entity.Host;
import entity.SailBoat;
import service.BoatService;
import service.HostService;
import service.session.session;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class HostTableModel implements TableModel {
    Map mapHost = new HashMap();
    Map mapBoat = new HashMap();
    //private int indexHost = 0;
    //private int indexBoat = 0;
    private int row = 0;
    private int addRow = 0;
    HostService hs = new HostService();
    BoatService bs = new BoatService();
    private boolean nextHost = false;
    public List<Host> hosts = new HostService().getAllHost();

    public final String[] columnNames = new String[]{"ID", "Nom", "Adresse", "ID Bateau", "Nom Bateau", "Poids", "Type", "Caratère", "ID Quai", "ID Emplacement"};

    //public List<Host> list = new ArrayList<Host>();

    @Override
    public int getRowCount() {
        int n = hosts.size();
        int indexHost = 0;
        int indexBoat = 0;
        for (Host host :hosts) {
            if(host.getBoats().size()>1){
                n += host.getBoats().size() - 1;
            }
        }
        for(int i = 0; i < hosts.size(); i++){
            do{
                mapHost.put(i+addRow,i);
                mapBoat.put(i+addRow,indexBoat);
                addRow++;
                indexBoat++;
            }while (indexBoat < hosts.get(i).getBoats().size());
            addRow = 0;
            indexBoat = 0;
        }
        return n;
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
        Host host = hosts.get((Integer) mapHost.get(rowIndex));

        int boatId;
        if(columnIndex == 0){
            return host.getId();
        }
        if(columnIndex == 1){
            return host.getName();
        }
        if(columnIndex == 2){
            return host.getAddress();
        }
        if(columnIndex == 3 && host.getBoats().size() > 0){
            return host.getBoats().get((Integer) mapBoat.get(rowIndex)).getId();
        }
        if(columnIndex == 4 && host.getBoats().size() > 0){
            return host.getBoats().get((Integer) mapBoat.get(rowIndex)).getName();
        }
        if(columnIndex == 5 && host.getBoats().size() > 0){
            return host.getBoats().get((Integer) mapBoat.get(rowIndex)).getWight();
        }
        if(columnIndex == 6 && host.getBoats().size() > 0){
            boatId = host.getBoats().get((Integer) mapBoat.get(rowIndex)).getId();
            return bs.getBoatType(boatId);
        }
        if(columnIndex == 7 && host.getBoats().size() > 0){
            boatId = host.getBoats().get((Integer) mapBoat.get(rowIndex)).getId();
            return bs.getBoatCharacter(boatId);
        }
        /*if(columnIndex == 8 && host.getBoats().size() > 0){
            return host.getBoats().get((Integer) mapBoat.get(rowIndex)).getLocation().getDock().getId();
        }*/
        /*if(columnIndex == 9 && host.getBoats().size() > 0){
            return host.getBoats().get((Integer) mapBoat.get(rowIndex)).getLocation().getId();
        }*/


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
        return hosts;
    }

    public void setList(List<Host> list){
        this.hosts = list;
    }

}
