package GUI.panel.smallpanel;

import GUI.listener.BoatListener;
import GUI.listener.DockListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddBoatPanel extends JPanel {
    public static AddBoatPanel instance = new AddBoatPanel();

    //JLable

    JLabel lnom = new JLabel("Nom:");
    JLabel ltype = new JLabel("Type:");
    JLabel lcara = new JLabel("Caractère:");
    JLabel lwigh = new JLabel("Poids:");
    JLabel lhost = new JLabel("Propriétaire ID:");
    JLabel ldock = new JLabel("Quai ID:");
    JLabel lloca = new JLabel("Emplacement ID:");
    public JLabel lmsg = new JLabel("");


    public JTextField tfnom = new JTextField();
    //public JTextField tftype = new JTextField();
    public JComboBox cbtype =  new JComboBox();
    public JTextField tfcara = new JTextField();
    public JTextField tfwigh = new JTextField();
    public JTextField tfhost = new JTextField();
    public JTextField tfdock = new JTextField();
    public JTextField tfloca = new JTextField();



    //JButton
    public JButton bAdd = new JButton("Ajouter");

    private AddBoatPanel(){
        JPanel pWork = new JPanel();
        JPanel pSubmit = new JPanel();

        cbtype.addItem("");
        cbtype.addItem("Bateau à voile");
        cbtype.addItem("Bateau à moteur");
        cbtype.addItemListener(listener);

        pWork.add(lnom);
        pWork.add(tfnom);
        pWork.add(ltype);
        //pWork.add(tftype);
        pWork.add(cbtype);
        pWork.add(lcara);
        pWork.add(tfcara);
        pWork.add(lwigh);
        pWork.add(tfwigh);
        pWork.add(lhost);
        pWork.add(tfhost);
        pWork.add(lloca);
        pWork.add(tfloca);

        pSubmit.add(bAdd);
        pSubmit.add(lmsg);


        //Disposition des panneaux
        pWork.setLayout(new GridLayout(6,2,0,20));

        this.setLayout(new BorderLayout(0, 30));
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(pWork, BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        BoatListener add = new BoatListener();
        bAdd.addActionListener(add);
    }


    ItemListener listener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                String type = (String)cbtype.getSelectedItem();
                if(type == "Bateau à voile"){
                    lcara.setText("Surface totale des voiles:");
                }
                if(type == "Bateau à moteur"){
                    lcara.setText("Cheveux vapeur:");
                }
            }
        }
    };


}
