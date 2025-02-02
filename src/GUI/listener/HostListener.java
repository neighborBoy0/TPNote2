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
            if(hs.createHost(nom,adr)){
                ap.lmsg.setText("Créé avec succès!");
            }else {
                ap.lmsg.setText("Échoué, il y a des erreurs!");
            }
            ap.tfnom.setText(null);
            ap.tfadr.setText(null);
            p.updateDate();
        }

        //EditHostPanel Listener
        if(button == ep.bEdit){
            if(ep.tfid.getText() == ""){
                ep.lmsg.setText("Veuillez vous saisir ID.");
            }
            int id = Integer.valueOf(ep.tfid.getText());
            String name = ep.tfname.getText();
            String address = ep.tfaddr.getText();
            //hs.editHost(id, name, address);
            if(hs.editHost(id, name, address)){
                ep.lmsg.setText("Modifié avec succès!");
            }else {
                ep.lmsg.setText("Il n'existe pas.");
            }
            ep.tfname.setText(null);
            ep.tfaddr.setText(null);
            p.updateDate();
        }

        //DeleteHostPanel Listener
        if(button == dp.bDelete){
            if(hs.delHost(Integer.valueOf(dp.tfid.getText()))){
                dp.lmsg.setText("Supprimé avec succès!");
            }else {
                dp.lmsg.setText("Échoué, il y a des erreurs!");
            }
            dp.tfid.setText(null);
            p.updateDate();
        }

        //SearchHostPanel Listener
        if(button == sp.bSearch1){
            String str = hs.rearchHostById(Integer.valueOf(sp.tfid.getText()));
            sp.ta.setText(str);
            sp.tfid.setText(null);
            sp.tfname.setText(null);
        }

        if(button == sp.bSearch2){
            String str = hs.rearchHostByName(sp.tfname.getText());
            sp.ta.setText(str);
            sp.tfid.setText(null);
            sp.tfname.setText(null);
        }
    }
}
