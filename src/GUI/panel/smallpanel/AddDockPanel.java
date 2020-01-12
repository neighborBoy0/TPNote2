package GUI.panel.smallpanel;

import GUI.listener.DockListener;
import entity.Dock;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddDockPanel extends JPanel {
    public static AddDockPanel instance = new AddDockPanel();

    //JLable
    JLabel lsize = new JLabel("Nombre des nouveaux emplacements:");
    public JLabel lmsg = new JLabel();

    //JTextField
    public JTextField tfsize = new JTextField();

    public JTextArea ta = new JTextArea();

    //JButton
    public JButton bAdd = new JButton("Ajouter");

    public JButton bCon = new JButton("Confirmer");

    private AddDockPanel(){
        JPanel pNorth = new JPanel();
        JPanel pCenter = new JPanel();
        JPanel pSubmit = new JPanel();

        pNorth.add(lsize);
        pNorth.add(tfsize);
        pNorth.add(bAdd);


        pCenter.add(ta);

        pSubmit.add(bCon);
        pSubmit.add(lmsg);

        //Disposition des panneaux
        pNorth.setLayout(new GridLayout(2,1,10,10));
        pCenter.setLayout(new GridLayout(1,1,20,20));

        this.setLayout(new BorderLayout(10,10));
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        DockListener l = new DockListener();
        bAdd.addActionListener(l);
        bCon.addActionListener(l);
    }
}
