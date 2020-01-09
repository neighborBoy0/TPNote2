package GUI.listener;

import GUI.panel.DockPanel;
import GUI.panel.smallpanel.AddDockPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DockListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DockPanel p = DockPanel.instance;
        AddDockPanel ap = AddDockPanel.instance;

        JButton button = (JButton)e.getSource();

        if(button == p.bAdd){

        }



    }

}
