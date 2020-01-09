package GUI.listener;

import GUI.frame.AddHostFrame;
import GUI.frame.DeleteHostFrame;
import GUI.frame.EditHostFrame;
import GUI.frame.SearchHostFrame;
import GUI.panel.BoatPanel;
import GUI.panel.HostPanel;
import GUI.panel.smallpanel.AddHostPanel;
import GUI.panel.smallpanel.DeleteHostPanel;
import GUI.panel.smallpanel.EditHostPanel;
import GUI.panel.smallpanel.SearchHostPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        HostPanel p = HostPanel.instance;
        AddHostPanel ap = AddHostPanel.instance;
        EditHostPanel ep = EditHostPanel.instance;
        DeleteHostPanel dp = DeleteHostPanel.instance;
        SearchHostPanel sp = SearchHostPanel.instance;

        JButton button = (JButton)e.getSource();

        //DockPanel Listener
        if(button == p.bAdd){
            AddHostFrame f = AddHostFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bEdit){
            EditHostFrame f = EditHostFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bDelete){
            DeleteHostFrame f = DeleteHostFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bSearch){
            SearchHostFrame f = SearchHostFrame.instance;
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
