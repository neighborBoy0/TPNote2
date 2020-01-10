package GUI.panel.smallpanel;

import GUI.listener.DockListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

    public JTextArea ta = new JTextArea("Liste de l'emplacement: \n");

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

        pCenter.setLayout(new BorderLayout());
        pCenter.add(ta, BorderLayout.CENTER);
        pCenter.add(bCon, BorderLayout.SOUTH);

        pSouth.add(ldelL);
        pSouth.add(lvide2);
        pSouth.add(lidL);
        pSouth.add(tfidDel);
        pSouth.add(bDel);
        pSouth.add(lmsg);
        pSouth.setBorder(BorderFactory.createLineBorder(Color.black));

        //Disposition des panneaux
        pNorth.setLayout(new GridLayout(3,2,10,10));
        pSouth.setLayout(new GridLayout(3, 2,10,10));

        this.setLayout(new BorderLayout(20,20));
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        DockListener l = new DockListener();
        bAdd.addActionListener(l);
        bCon.addActionListener(l);
        bDel.addActionListener(l);
    }

}
