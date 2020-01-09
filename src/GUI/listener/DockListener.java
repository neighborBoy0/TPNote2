package GUI.listener;

import GUI.frame.AddDockFrame;
import GUI.frame.DeleteDockFrame;
import GUI.frame.EditDockFrame;
import GUI.frame.SearchDockFrame;
import GUI.panel.DockPanel;
import GUI.panel.smallpanel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DockListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DockPanel p = DockPanel.instance;
        AddDockPanel ap = AddDockPanel.instance;
        EditDockPanel ep = EditDockPanel.instance;
        DeleteDockPanel dp = DeleteDockPanel.instance;
        SearchDockPanel sp = SearchDockPanel.instance;

        JButton button = (JButton)e.getSource();

        //DockPanel Listener
        if(button == p.bAdd){
            AddDockFrame f = AddDockFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bEdit){
            EditDockFrame f = EditDockFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bDelete){
            DeleteDockFrame f = DeleteDockFrame.instance;
            f.setVisible(true);
        }
        if(button == p.bSearch){
            SearchDockFrame f = SearchDockFrame.instance;
            f.setVisible(true);
        }

        //AddDockPanel Listener
        if(button == ap.bAdd){

        }
        if(button == ap.bCon){

        }

        //EditDockPanel Listener
        if(button == ep.bAdd){

        }
        if(button == ep.bCon){

        }
        if(button == ep.bDel){

        }

        //DeleteDockPanel Listener
        if(button == dp.bDelete){

        }

        //SearchDockPanel Listener
        if(button == sp.bSearch){

        }

    }

}
