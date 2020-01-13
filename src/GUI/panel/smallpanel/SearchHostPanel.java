package GUI.panel.smallpanel;

import GUI.listener.HostListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchHostPanel extends JPanel {
    public static SearchHostPanel instance = new SearchHostPanel();

    JLabel lid = new JLabel("ID Propriétaire:");
    JLabel lname = new JLabel("Nom Propriétaire:");
    JLabel linfo = new JLabel("Informations:");

    public JTextField tfid = new JTextField();
    public JTextField tfname = new JTextField();
    public JTextArea ta = new JTextArea();

    public JButton bSearch1 = new JButton("Rechercher");
    public JButton bSearch2 = new JButton("Rechercher");

    private SearchHostPanel(){
        JPanel pNorth = new JPanel();
        JPanel pCenter = new JPanel();

        pNorth.add(lid);
        pNorth.add(tfid);
        pNorth.add(bSearch1);
        pNorth.add(lname);
        pNorth.add(tfname);
        pNorth.add(bSearch2);
        pNorth.setLayout(new GridLayout(2, 3, 10, 10));

        pCenter.setLayout(new BorderLayout(10, 10));
        pCenter.add(linfo, BorderLayout.NORTH);
        JScrollPane sp = new JScrollPane(ta);
        pCenter.add(sp, BorderLayout.CENTER);

        this.setLayout(new BorderLayout(10,10));
        this.setBorder(new EmptyBorder(15,15,15,15));
        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);

        addListener();
    }

    public void addListener() {
        HostListener l = new HostListener();
        bSearch1.addActionListener(l);
        bSearch2.addActionListener(l);
    }
}
