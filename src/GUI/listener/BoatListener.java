package GUI.listener;

import GUI.frame.*;
import GUI.panel.BoatPanel;
import GUI.panel.smallpanel.AddBoatPanel;
import GUI.panel.smallpanel.DeleteBoatPanel;
import GUI.panel.smallpanel.EditBoatPanel;
import GUI.panel.smallpanel.SearchBoatPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoatListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BoatPanel p = BoatPanel.instance;
        AddBoatPanel ap = AddBoatPanel.instance;
        EditBoatPanel ep = EditBoatPanel.instance;
        DeleteBoatPanel dp = DeleteBoatPanel.instance;
        SearchBoatPanel sp = SearchBoatPanel.instance;

        JButton button = (JButton)e.getSource();

        //DockPanel Listener
        if(button == p.bAdd){
            AddBoatFrame f = AddBoatFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bEdit){
            EditBoatFrame f = EditBoatFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bDelete){
            DeleteBoatFrame f = DeleteBoatFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bSearch){
            SearchBoatFrame f = SearchBoatFrame.instance;
            f.setVisible(true);
        }

        //AddDockPanel Listener
        if(button == ap.bAdd){

        }

        //EditDockPanel Listener
        if(button == ep.bEdit){

        }

        //DeleteDockPanel Listener
        if(button == dp.bDelete){

        }

        //SearchDockPanel Listener
        if(button == sp.bSearch){

        }

    }
}
