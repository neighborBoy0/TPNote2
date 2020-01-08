package GUI.panel;

import GUI.Util.GUIUtil;
import GUI.model.DockInfoTableModel;
import GUI.model.DockTableModel;

import javax.swing.*;
import java.awt.*;

public class HostPanel extends WorkingPanel{

    public static HostPanel instance = new HostPanel();

    public JButton bAdd = new JButton("Création");
    public JButton bEdit = new JButton("Éditation");
    public JButton bDelete = new JButton("Supprimation");
    public JButton bSearch = new JButton("Recherche");

    //JLabel
    JLabel ltitle = new JLabel("Liste de quais");


    //JTextField

    String columnNames1[] = new String[]{"ID", "Nombre d'emplacement"};

    String columnNames2[] = new String[]{"ID d'Emplacement", "ID Bateau" ,"Nom", "Type", "Caractère", "Poids", "Propriétaire"};

    //JTable
    public DockTableModel dtm = new DockTableModel();
    public DockInfoTableModel ditm = new DockInfoTableModel();

    public JTable t = new JTable(dtm);
    public JTable tInfo = new JTable(ditm);


    private HostPanel() {

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
        GUIUtil.showPanel(HostPanel.instance);
    }

}