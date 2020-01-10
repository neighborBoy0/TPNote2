package GUI.panel.smallpanel;

import GUI.listener.BoatListener;
import entity.Boat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditBoatPanel extends JPanel {
    public static EditBoatPanel instance = new EditBoatPanel();

    //JLable
    JLabel lid = new JLabel("ID:");
    JLabel lnom = new JLabel("Nom:");
    JLabel ltype = new JLabel("Type:");
    JLabel lcara = new JLabel("Caractère:");
    JLabel lwigh = new JLabel("Poids:");
    JLabel lhost = new JLabel("Propriétaire");
    JLabel ldock = new JLabel("Quai ID:");
    JLabel lloca = new JLabel("Emplacement ID:");
    public JLabel lmsg = new JLabel();

    public JTextField tfid = new JTextField();
    public JTextField tfnom = new JTextField();
    public JTextField tftype = new JTextField();
    public JTextField tfcara = new JTextField();
    public JTextField tfwigh = new JTextField();
    public JTextField tfhost = new JTextField();
    public JTextField tfdock = new JTextField();
    public JTextField tfloca = new JTextField();

    public JButton bEdit = new JButton("Mise à jours");

    private EditBoatPanel(){

        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        pWork.add(lid);
        pWork.add(tfid);
        pWork.add(lnom);
        pWork.add(tfnom);
        pWork.add(ltype);
        pWork.add(tftype);
        pWork.add(lcara);
        pWork.add(tfcara);
        pWork.add(lwigh);
        pWork.add(tfwigh);
        pWork.add(lhost);
        pWork.add(tfhost);
        pWork.add(ldock);
        pWork.add(tfdock);
        pWork.add(lloca);
        pWork.add(tfloca);

        pSubmit.add(bEdit);
        pSubmit.add(lmsg);

        //Disposition des panneaux
        pWork.setLayout(new GridLayout(8,2,10,10));

        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(pWork, BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        BoatListener l = new BoatListener();
        bEdit.addActionListener(l);
    }

}
