package GUI.listener;

import GUI.frame.AddHostFrame;
import GUI.frame.DeleteHostFrame;
import GUI.frame.EditHostFrame;
import GUI.frame.SearchHostFrame;
import GUI.panel.HostPanel;
import GUI.panel.smallpanel.AddHostPanel;
import GUI.panel.smallpanel.DeleteHostPanel;
import GUI.panel.smallpanel.EditHostPanel;
import GUI.panel.smallpanel.SearchHostPanel;
import service.HostService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        HostService hs = new HostService();

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

        //AddHostPanel Listener
        if(button == ap.bAdd){
            String nom = ap.tfnom.getText();
            String adr = ap.tfadr.getText();
            hs.createHost(nom,adr);
            ap.tfnom.setText(null);
            ap.tfadr.setText(null);
        }

        //EditHostPanel Listener
        if(button == ep.bEdit){
            int id = Integer.valueOf(ep.tfid.getText());
            String name = ep.tfname.getText();
            String address = ep.tfaddr.getText();
            hs.editHost(id, name, address);
        }

        //DeleteHostPanel Listener
        if(button == dp.bDelete){
            hs.delHost(Integer.valueOf(dp.tfid.getText()));
            dp.tfid.setText(null);
        }

        //SearchHostPanel Listener
        if(button == sp.bSearch){

        }

    }
}
