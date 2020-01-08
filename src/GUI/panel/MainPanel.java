package GUI.panel;

import GUI.listener.ToolBarListener;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public static MainPanel instance = new MainPanel();

    public CenterPanel workingPanel;

    public JToolBar tb = new JToolBar();

    public JButton b1 = new JButton();
    public JButton b2 = new JButton();
    public JButton b3 = new JButton();
    //public JButton b4 = new JButton();
    //public JButton b5 = new JButton();
    //public JButton b6 = new JButton();

    private MainPanel() {
        b1.setText("Quais");
        b2.setText("Bateaux");
        b3.setText("Propriétaires");

        tb.setLayout(getLayout());

        tb.add(b1);
        tb.add(b2);
        tb.add(b3);

        tb.setFloatable(false);

        workingPanel = new CenterPanel(0.8);

        setLayout(new BorderLayout(20, 20));

        add(tb, BorderLayout.NORTH);

        add(workingPanel, BorderLayout.CENTER);

        ButtonListener();
    }

    public void ButtonListener(){

        /**
         * ToolBarListener extends ActionListener
         */
        ToolBarListener tbl = new ToolBarListener();

        /**
         * JButton.addctionListener(ActionListener l)
         * java.awt.event
         * ActionListener is a interface
         */
        b1.addActionListener(tbl);
        b2.addActionListener(tbl);
        b3.addActionListener(tbl);

    }
}
