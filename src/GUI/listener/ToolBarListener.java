package GUI.listener;

import GUI.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        MainPanel mp = MainPanel.instance;

        JButton b = (JButton) e.getSource();

        if (b == mp.b1) {
            mp.workingPanel.show(DockPanel.instance);
        }
        if (b == mp.b2) {
            mp.workingPanel.show(BoatPanel.instance);
        }
        if (b == mp.b3) {
            mp.workingPanel.show(HostPanel.instance);
        }
    }
}
