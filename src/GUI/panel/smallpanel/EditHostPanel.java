package GUI.panel.smallpanel;

import GUI.listener.DockListener;
import GUI.listener.HostListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditHostPanel  extends JPanel {
    public static EditHostPanel instance = new EditHostPanel();

    //JLable
    JLabel lid = new JLabel("ID Propriétaire:");
    JLabel lname = new JLabel("Nouveau nom:");
    JLabel laddr = new JLabel("Nouveau adresse:");

    public JLabel lmsg = new JLabel();

    public JTextField tfid = new JTextField();
    public JTextField tfname = new JTextField();
    public JTextField tfaddr = new JTextField();

    public JButton bEdit = new JButton("Modifier");

    private EditHostPanel(){
        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        pWork.add(lid);
        pWork.add(tfid);
        pWork.add(lname);
        pWork.add(tfname);
        pWork.add(laddr);
        pWork.add(tfaddr);
        pWork.setLayout(new GridLayout(3,2,10,10));

        pSubmit.add(bEdit);

        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(15,15,15,15));
        this.add(pWork, BorderLayout.NORTH);
        this.add(pSubmit, BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        HostListener l = new HostListener();
        bEdit.addActionListener(l);
    }



}
