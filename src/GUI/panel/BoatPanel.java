package GUI.panel;

import GUI.Util.GUIUtil;
import GUI.model.BoatInfoTableModel;
import GUI.model.BoatTableModel;
import GUI.model.DockInfoTableModel;
import GUI.model.DockTableModel;

import javax.swing.*;
import java.awt.*;

public class BoatPanel extends WorkingPanel{

    public static BoatPanel instance = new BoatPanel();

    public JButton bAdd = new JButton("Création");
    public JButton bEdit = new JButton("Éditation");
    public JButton bDelete = new JButton("Supprimation");
    public JButton bSearch = new JButton("Recherche");

    //JLabel
    JLabel ltitle = new JLabel("Liste de quais");


    //JTextField

    String columnNames1[] = new String[]{"ID", "Nom", "Type"};

    String columnNames2[] = new String[]{"ID Bateau" ,"Nom", "Type", "Caractère", "Poids", "Propriétaire", "ID Quai", "ID Emplacement"};

    //JTable
    public BoatTableModel tm1 = new BoatTableModel();
    public BoatInfoTableModel tm2 = new BoatInfoTableModel();

    public JTable t = new JTable(tm1);
    public JTable tInfo = new JTable(tm2);


    private BoatPanel() {

        JScrollPane sp1 = new JScrollPane(t);
        JScrollPane sp2 = new JScrollPane(tInfo);
        JPanel pLeft = new JPanel();
        JPanel pRight = new JPanel();
        JPanel pSubmit = new JPanel();

        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
        pSubmit.add(bSearch);
        pSubmit.setLayout(new GridLayout(1, 4, 10, 10));

        pLeft.add(sp1);

        pRight.add(sp2);
        pRight.add(pSubmit);

        this.setLayout(new BorderLayout(20, 20));
        this.setPreferredSize(new Dimension(800, 600));
        this.add(pLeft, BorderLayout.EAST);
        this.add(pRight, BorderLayout.WEST);

        addListener();
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BoatPanel.instance);
    }

}
