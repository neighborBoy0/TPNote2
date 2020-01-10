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

        }
        if(button == ap.bCon){
            ds.addDock(locations);
            ap.tfsize.setText(null);
            ap.ta.setText(null);
            locations.clear();
            //p.t.setValueAt("0",1,1);
            /* 修改table显示 */
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
            ds.delDock(Integer.valueOf(dp.tfid.getText()));
            dp.tfid.setText(null);
            /* 修改table显示 */
        }

        //SearchDockPanel Listener
        if(button == sp.bSearch){
            String info = ds.ResearchDock(Integer.valueOf(sp.tfid.getText()));
            sp.ta.setText(info);
        }

    }

}
