package GUI.panel;

import GUI.Util.GUIUtil;
import GUI.listener.DockListener;
import GUI.model.DockInfoTableModel;
import GUI.model.DockTableModel;
import service.DockService;
import service.HostService;
import service.LocationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DockPanel extends WorkingPanel{

    public static DockPanel instance = new DockPanel();
    private int selectedId = 0;

    //JButton
    public JButton bAdd = new JButton("Création");
    public JButton bEdit = new JButton("Éditation");
    public JButton bDelete = new JButton("Supprimation");
    public JButton bSearch = new JButton("Recherche");

    //JLabel
    JLabel ltitle = new JLabel("Liste de quais:");

    String columnListe[] = new String[]{"ID Quai", "Nombre d'emplacement"};

    String columnNames[] = new String[]{"ID d'Emplacement", "Taille d'Emplacement" ,"ID Bateau" ,"Nom", "Type", "Caractère", "Poids", "Propriétaire"};

    //JTable
    public DockTableModel tm1 = new DockTableModel();
    public DockInfoTableModel tm2 = new DockInfoTableModel();

    public JTable t = new JTable(tm1);
    public JTable tInfo = new JTable(tm2);


    private DockPanel(){
        //JSplitPane p = new JSplitPane();

        JScrollPane sp1 = new JScrollPane(t);
        JScrollPane sp2 = new JScrollPane(tInfo);
        JPanel pLeft = new JPanel();
        JPanel pRight = new JPanel();
        JPanel pSubmit = new JPanel();

        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
        pSubmit.add(bSearch);
        pSubmit.setLayout(new GridLayout(1, 4, 10,10));

        sp1.setPreferredSize(new Dimension(280, 500));
        pLeft.add(sp1);
        pLeft.setPreferredSize(new Dimension(290, 600));

        pRight.setLayout(new BorderLayout(20,20));
        pRight.setPreferredSize(new Dimension(600, 600));
        pRight.add(sp2, BorderLayout.CENTER);
        pRight.add(pSubmit, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout(20,20));
        this.setPreferredSize(new Dimension(900, 600));
        this.add(ltitle, BorderLayout.NORTH);
        this.add(pLeft, BorderLayout.WEST);
        this.add(pRight, BorderLayout.EAST);
        //p.setLeftComponent(pLeft);
        //p.setRightComponent(pRight);
        //this.add(p, BorderLayout.CENTER);

        addListener();

        //if double check the table, open right information table
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    int rowIndex = t.getSelectedRow();
                    if(rowIndex >= 0){
                        tm2.locations = tm1.docks.get(rowIndex).getLocations();
                        tInfo.updateUI();
                    }
                }
            }
        });
    }

    @Override
    public void updateDate() {
        tm1.docks = new DockService().getAllDock();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        /*tm2.locations = tm1.docks.get(tm2.indexDock).getLocations();
        tInfo.updateUI();
        tInfo.getSelectionModel().setSelectionInterval(0, 0);*/
        if( 0 == tm1.docks.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    @Override
    public void addListener() {
        DockListener l = new DockListener();
        bAdd.addActionListener(l);
        bEdit.addActionListener(l);
        bDelete.addActionListener(l);
        bSearch.addActionListener(l);
    }

    private void initLeftPane(){
        JPanel pLeft = new JPanel();

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(DockPanel.instance);
    }

}
