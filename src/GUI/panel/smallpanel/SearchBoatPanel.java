package GUI.panel.smallpanel;

import GUI.listener.DockListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SearchBoatPanel  extends JPanel {
    public static SearchBoatPanel instance = new SearchBoatPanel();

    JLabel lid = new JLabel("ID Bateau:");
    JLabel linfo = new JLabel("Informations:");
    JLabel ltype = new JLabel("Type:");
    JLabel lcara = new JLabel("Caractère:");
    JLabel lcont = new JLabel("Contrainte:");
    JLabel lvalue = new JLabel("Valeur:");
    JLabel lvalue2 = new JLabel("Valeur de poids:");
    JLabel lvide1 = new JLabel("");
    JLabel lvide2 = new JLabel("");
    JLabel lvide3 = new JLabel("");
    JLabel lvide4 = new JLabel("");
    JLabel lcondition = new JLabel("Recherche par condition:");
    JLabel ltitleW = new JLabel("Recherche par poids:");
    JLabel lcont2 = new JLabel("Contrainte de poids:");


    public JTextField tfid = new JTextField();
    public JTextField tfcara = new JTextField();
    public JTextField tfvalue = new JTextField();
    public JTextField tfvalue2 = new JTextField();

    public JTextArea ta = new JTextArea();

    public JButton bSearch = new JButton("Rechercher Par ID");
    public JButton bSearchCon = new JButton("Rechercher Par Contraintes");
    public JButton bSearchWight = new JButton("Rechercher Par Poids");

    public JComboBox cbtype =  new JComboBox();
    public JComboBox cbcont =  new JComboBox();
    public JComboBox cbcont2 =  new JComboBox();

    private SearchBoatPanel(){
        JPanel pOutNorth = new JPanel();
        JPanel pOutCenter = new JPanel();
        JPanel pOutSouth = new JPanel();
        JPanel pNorth = new JPanel();
        JPanel pCenter = new JPanel();
        JPanel pSouth = new JPanel();

        pNorth.add(lid);
        pNorth.add(tfid);
        pNorth.add(bSearch);
        pNorth.setLayout(new GridLayout(1, 3, 10, 10));
        pNorth.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        cbtype.addItem("");
        cbtype.addItem("Bateau à voile");
        cbtype.addItem("Bateau à moteur");
        cbtype.addItemListener(listener);

        cbcont.addItem("");
        cbcont.addItem(">");
        cbcont.addItem("=");
        cbcont.addItem("<");

        cbcont2.addItem("");
        cbcont2.addItem(">");
        cbcont2.addItem("=");
        cbcont2.addItem("<");

        pCenter.add(lcondition);
        pCenter.add(lvide1);
        pCenter.add(ltype);
        pCenter.add(cbtype);
        pCenter.add(lcara);
        pCenter.add(lvide2);
        pCenter.add(lcont);
        pCenter.add(cbcont);
        pCenter.add(lvalue);
        pCenter.add(tfvalue);
        pCenter.add(bSearchCon);
        pCenter.add(lvide3);
        pCenter.add(ltitleW);
        pCenter.add(lvide4);
        pCenter.add(lcont2);
        pCenter.add(cbcont2);
        pCenter.add(lvalue2);
        pCenter.add(tfvalue2);
        pCenter.add(bSearchWight);
        pCenter.setLayout(new GridLayout(11,2,10,10));
        pCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        pSouth.setLayout(new BorderLayout(10, 10));
        pSouth.add(linfo, BorderLayout.NORTH);
        pSouth.add(ta, BorderLayout.CENTER);
        pSouth.setPreferredSize(new Dimension(550, 200));

        pOutNorth.setBorder(BorderFactory.createEtchedBorder());
        pOutCenter.setBorder(BorderFactory.createEtchedBorder());
        pOutSouth.setBorder(BorderFactory.createEtchedBorder());
        pOutNorth.add(pNorth);
        pOutCenter.add(pCenter);
        pOutSouth.add(pSouth);

        this.setLayout(new BorderLayout(10,10));
        this.setBorder(new EmptyBorder(15,15,15,15));
        this.add(pOutNorth, BorderLayout.NORTH);
        this.add(pOutCenter, BorderLayout.CENTER);
        this.add(pOutSouth, BorderLayout.SOUTH);

        addListener();
    }

    public void addListener() {
        DockListener l = new DockListener();
        bSearch.addActionListener(l);
        bSearchCon.addActionListener(l);
        bSearchWight.addActionListener(l);
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
