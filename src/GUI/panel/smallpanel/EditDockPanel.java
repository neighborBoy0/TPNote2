package GUI.panel.smallpanel;

import GUI.listener.DockListener;

import javax.swing.*;
import java.awt.*;

public class EditDockPanel extends JPanel {
    public static EditDockPanel instance = new EditDockPanel();

    //JLable
    JLabel laddL  = new JLabel("Ajouter un emplacement:");
    JLabel lvide1 = new JLabel("");
    JLabel lsize  = new JLabel("Taille de nouveau emplacement:");
    JLabel ldelL  = new JLabel("Supprimer un emplacement:");
    JLabel lvide2 = new JLabel("");
    JLabel lidL   = new JLabel("ID Emplacement:");
    public JLabel lmsg = new JLabel();

    //JTextField
    public JTextField tfsize  = new JTextField();
    public JTextField tfidDel = new JTextField();

    public JTextArea ta = new JTextArea();

    //JButton
    public JButton bAdd = new JButton("Ajouter un emplacement");
    public JButton bCon = new JButton("Confirmer");
    public JButton bDel = new JButton("Supprimer un emplacement");

    private EditDockPanel(){
        JPanel pNorth = new JPanel();
        JPanel pCenter = new JPanel();
        JPanel pSouth = new JPanel();

        pNorth.add(laddL);
        pNorth.add(lvide1);
        pNorth.add(lsize);
        pNorth.add(tfsize);
        pNorth.add(bAdd);

        pCenter.add(ta);
        pCenter.add(bCon);

        pSouth.add(ldelL);
        pSouth.add(lvide2);
        pSouth.add(lidL);
        pSouth.add(tfidDel);
        pSouth.add(bDel);
        pSouth.add(lmsg);

        //Disposition des panneaux
        pNorth.setLayout(new GridLayout(3,2,10,10));
        pCenter.setLayout(new GridLayout(2,1,20,20));
        pSouth.setLayout(new GridLayout(3, 2,10,10));

        this.setLayout(new BorderLayout());
        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        DockListener add = new DockListener();
        bAdd.addActionListener(add);
    }

}
