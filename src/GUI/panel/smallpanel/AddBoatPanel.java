package GUI.panel.smallpanel;

import GUI.listener.BoatListener;
import GUI.listener.DockListener;

import javax.swing.*;
import java.awt.*;

public class AddBoatPanel extends JPanel {
    public static AddBoatPanel instance = new AddBoatPanel();

    //JLable
    JLabel lnb = new JLabel("Veuillez entrer le nombre d'emplacements pour le nouveau quai:");
    public JLabel lmsg = new JLabel();

    //JTextField
    public JTextField tfnb = new JTextField();

    //JButton
    public JButton bAdd = new JButton("Ajouter");

    private AddBoatPanel(){
        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        pWork.add(lnb);
        pWork.add(tfnb);

        pSubmit.add(bAdd);
        pSubmit.add(lmsg);

        //Disposition des panneaux
        pWork.setLayout(new GridLayout(2,1,10,10));

        this.setLayout(new BorderLayout());
        this.add(pWork, BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        BoatListener add = new BoatListener();
        bAdd.addActionListener(add);
    }
}
