package GUI.panel.smallpanel;

import GUI.listener.BoatListener;

import javax.swing.*;
import java.awt.*;

public class DeleteBoatPanel extends JPanel {
    public static DeleteBoatPanel instance = new DeleteBoatPanel();

    //JLable
    JLabel lid = new JLabel("ID Bateau:");

    public JLabel lmsg = new JLabel();

    public JTextField tfid = new JTextField();

    public JButton bDelete = new JButton("Supprimer");


    private DeleteBoatPanel(){


        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        pWork.add(lid);
        pWork.add(tfid);

        pSubmit.add(bDelete);
        pSubmit.add(lmsg);

        //Disposition des panneaux
        int gap = 10;
        pWork.setLayout(new GridLayout(1,3,gap,gap));
        //pSubmit.setLayout(new GridLayout(2,1,gap,gap));

        this.setLayout(new BorderLayout(40,40));
        this.add(pWork, BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        BoatListener l = new BoatListener();
        bDelete.addActionListener(l);
    }

}
