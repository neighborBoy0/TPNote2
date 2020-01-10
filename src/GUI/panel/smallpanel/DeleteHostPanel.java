package GUI.panel.smallpanel;

import GUI.listener.BoatListener;
import GUI.listener.HostListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteHostPanel extends JPanel {
    public static DeleteHostPanel instance = new DeleteHostPanel();

    //JLable
    JLabel lid = new JLabel("ID Propriétaire:");

    public JLabel lmsg = new JLabel();

    public JTextField tfid = new JTextField();

    public JButton bDelete = new JButton("Supprimer");


    private DeleteHostPanel(){


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
        HostListener l = new HostListener();
        bDelete.addActionListener(l);
    }

}
