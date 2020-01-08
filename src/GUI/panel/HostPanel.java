package GUI.panel;

import GUI.Util.GUIUtil;
import GUI.model.DockInfoTableModel;
import GUI.model.DockTableModel;
import GUI.model.HostTableModel;

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

    //Table Column Name
    String columnNames[] = new String[]{"ID", "Nom", "Adresse", "ID Bateau", "Nom Bateau", "Poids", "Type", "Caratère", "ID Quai", "ID Emplacement"};

    //JTable
    public HostTableModel tm = new HostTableModel();
    public JTable t = new JTable(tm);


    private HostPanel() {

        JScrollPane sp1 = new JScrollPane(t);

        JPanel pCenter = new JPanel();
        JPanel pSubmit = new JPanel();

        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
        pSubmit.add(bSearch);
        pSubmit.setLayout(new GridLayout(1, 4, 10, 10));

        sp1.setPreferredSize(new Dimension(890, 540));
        pCenter.add(sp1);
        pCenter.setPreferredSize(new Dimension(900, 550));

        this.setLayout(new BorderLayout(20, 20));
        this.setPreferredSize(new Dimension(900, 600));
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);

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