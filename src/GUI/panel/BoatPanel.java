package GUI.panel;

import GUI.Util.GUIUtil;
import GUI.listener.BoatListener;
import GUI.model.BoatInfoTableModel;
import service.BoatService;


import javax.swing.*;
import java.awt.*;

public class BoatPanel extends WorkingPanel{

    public static BoatPanel instance = new BoatPanel();

    public JButton bAdd = new JButton("Création");
    public JButton bEdit = new JButton("Éditation");
    public JButton bDelete = new JButton("Supprimation");
    public JButton bSearch = new JButton("Recherche");

    //JLabel
    JLabel ltitle = new JLabel("Liste de bateaux:");


    String columnNames[] = new String[]{"ID Bateau" ,"Nom", "Type", "Caractère", "Poids", "Propriétaire", "ID Quai", "ID Emplacement"};

    //JTable
    public BoatInfoTableModel tm2 = new BoatInfoTableModel();

    public JTable t = new JTable(tm2);


    private BoatPanel() {

        JScrollPane sp2 = new JScrollPane(t);
        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
        pSubmit.add(bSearch);
        pSubmit.setLayout(new GridLayout(1, 4, 10, 10));


        pWork.setLayout(new BorderLayout(20,20));
        pWork.setPreferredSize(new Dimension(600, 600));
        pWork.add(ltitle, BorderLayout.NORTH);
        pWork.add(sp2, BorderLayout.CENTER);
        pWork.add(pSubmit, BorderLayout.SOUTH);



        this.setLayout(new BorderLayout(20, 20));
        this.setPreferredSize(new Dimension(900, 600));
        this.add(pWork, BorderLayout.CENTER);

        addListener();
    }

    @Override
    public void updateDate() {
        tm2.boats = new BoatService().getAllBoat();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);
        if( 0 == tm2.boats.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    @Override
    public void addListener() {
        BoatListener l = new BoatListener();
        bAdd.addActionListener(l);
        bEdit.addActionListener(l);
        bDelete.addActionListener(l);
        bSearch.addActionListener(l);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BoatPanel.instance);
    }

}
