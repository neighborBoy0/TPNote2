package GUI.panel.smallpanel;

import GUI.listener.DockListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchBoatPanel  extends JPanel {
    public static SearchBoatPanel instance = new SearchBoatPanel();

    JLabel lid = new JLabel("ID Bateau:");
    JLabel linfo = new JLabel("Informations:");

    public JTextField tfid = new JTextField();

    public JTextArea ta = new JTextArea();

    public JButton bSearch = new JButton("Rechercher");

    private SearchBoatPanel(){
        JPanel pNorth = new JPanel();
        JPanel pCenter = new JPanel();

        pNorth.add(lid);
        pNorth.add(tfid);
        pNorth.add(bSearch);
        pNorth.setLayout(new GridLayout(1, 3, 10, 10));

        pCenter.setLayout(new BorderLayout(10, 10));
        pCenter.add(linfo, BorderLayout.NORTH);
        pCenter.add(ta, BorderLayout.CENTER);

        this.setLayout(new BorderLayout(10,10));
        this.setBorder(new EmptyBorder(15,15,15,15));
        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);

        addListener();
    }

    public void addListener() {
        DockListener l = new DockListener();
        bSearch.addActionListener(l);
    }
}
