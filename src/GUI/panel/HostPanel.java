package GUI.panel;

import GUI.Util.GUIUtil;
import GUI.model.DockInfoTableModel;
import GUI.model.DockTableModel;
import GUI.model.HostTableModel;
import GUI.listener.HostListener;
import service.HostService;

import javax.swing.*;
import java.awt.*;

public class HostPanel extends WorkingPanel{

    public static HostPanel instance = new HostPanel();

    public JButton bAdd = new JButton("Création");
    public JButton bEdit = new JButton("Modification");
    public JButton bDelete = new JButton("Supprimation");
    public JButton bSearch = new JButton("Recherche");

    //JLabel
    JLabel ltitle = new JLabel("Liste de propriétaire:");

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
        this.add(ltitle, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);

        addListener();

    }

    @Override
    public void updateDate() {
        tm.hosts = new HostService().getAllHost();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);
        if( 0 == tm.hosts.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    @Override
    public void addListener() {
        HostListener l = new HostListener();
        bAdd.addActionListener(l);
        bEdit.addActionListener(l);
        bDelete.addActionListener(l);
        bSearch.addActionListener(l);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(HostPanel.instance);
    }

}