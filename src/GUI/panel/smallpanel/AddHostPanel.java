package GUI.panel.smallpanel;

import GUI.listener.DockListener;
import GUI.listener.HostListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddHostPanel extends JPanel {
    public static AddHostPanel instance = new AddHostPanel();

    //JLable
    JLabel lnom = new JLabel("Nom:");
    JLabel ladr = new JLabel("Adresse:");
    public JLabel lmsg = new JLabel("");

    //JTextField
    public JTextField tfnom = new JTextField();
    public JTextField tfadr = new JTextField();

    //JButton
    public JButton bAdd = new JButton("Ajouter");

    private AddHostPanel(){
        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        pWork.add(lnom);
        pWork.add(tfnom);
        pWork.add(ladr);
        pWork.add(tfadr);

        pSubmit.add(bAdd);
        pSubmit.add(lmsg);

        //Disposition des panneaux
        pWork.setLayout(new GridLayout(2,2,10,10));

        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(pWork, BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        HostListener l = new HostListener();
        bAdd.addActionListener(l);
    }
}
