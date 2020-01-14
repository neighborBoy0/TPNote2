package GUI.panel.smallpanel;

import GUI.listener.BoatListener;
import GUI.listener.DockListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteDockPanel extends JPanel {
    public static DeleteDockPanel instance = new DeleteDockPanel();

    //JLable
    JLabel lid = new JLabel("ID Quai:");

    public JLabel lmsg = new JLabel("");

    public JTextField tfid = new JTextField();

    public JButton bDelete = new JButton("Supprimer");


    private DeleteDockPanel(){


        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        pWork.add(lid);
        pWork.add(tfid);

        pSubmit.add(bDelete);
        pSubmit.add(lmsg);

        //Disposition des panneaux
        pWork.setLayout(new GridLayout(1,3,10,10));

        this.setLayout(new BorderLayout(40,40));
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(pWork, BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        DockListener l = new DockListener();
        bDelete.addActionListener(l);
    }
}
