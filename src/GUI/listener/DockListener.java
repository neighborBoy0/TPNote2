package GUI.listener;

import GUI.frame.AddDockFrame;
import GUI.frame.DeleteDockFrame;
import GUI.frame.EditDockFrame;
import GUI.frame.SearchDockFrame;
import GUI.panel.DockPanel;
import GUI.panel.smallpanel.*;
import entity.Dock;
import entity.Location;
import service.DockService;
import service.LocationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DockListener implements ActionListener {
    private Dock dock;
    private List<Location> locations = new ArrayList<Location>();

    @Override
    public void actionPerformed(ActionEvent e) {
        LocationService ls = new LocationService();
        DockService ds = new DockService();

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
            locations.add(ls.createLocation(ap.tfsize.getText()));
            ap.tfsize.setText(null);
            String AppText = "";
            for (int i=0;i<locations.size();i++){
                AppText += locations.get(i).getSize();
                AppText += '\n';
            }
            ap.ta.setText(AppText);
            p.updateDate();

        }
        if(button == ap.bCon){
            if(ds.addDock(locations)){
                ap.lmsg.setText("Créé avec succès!");
            } else{
                ap.lmsg.setText("Échoué, il y a des erreurs!");
            }
            ap.tfsize.setText(null);
            ap.ta.setText(null);
            locations.clear();
            p.updateDate();
        }

        //EditDockPanel Listener
        if(button == ep.bAdd){
            String info = ds.addLoucation(Integer.valueOf(ep.tfid.getText()),ep.tfsize.getText());
            ep.ta.setText(info);
            ep.tfid.setText(null);
            ep.tfsize.setText(null);
        }
        //if(button == ep.bCon){

        //}
        if(button == ep.bDel){
            if(ls.delLocation(Integer.valueOf(ep.tfidDel.getText()))){
                ep.lmsg.setText("Supprimé avec succès!");
            }else{
                ep.lmsg.setText("Il n'existe pas.");
            }
            ep.tfidDel.setText(null);
            p.updateDate();
        }

        //DeleteDockPanel Listener
        if(button == dp.bDelete){
            if(ds.delDock(Integer.valueOf(dp.tfid.getText()))){
                dp.lmsg.setText("Créé avec succès!");
            } else{
                dp.lmsg.setText("Échoué, il y a des erreurs!");
            }
            dp.tfid.setText(null);
            p.updateDate();
        }

        //SearchDockPanel Listener
        if(button == sp.bSearch){
            String info = ds.ResearchDock(Integer.valueOf(sp.tfid.getText()));
            sp.ta.setText(info);
            sp.tfid.setText(null);
        }

    }

}
