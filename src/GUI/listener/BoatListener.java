package GUI.listener;

import GUI.frame.*;
import GUI.panel.BoatPanel;
import GUI.panel.smallpanel.AddBoatPanel;
import GUI.panel.smallpanel.DeleteBoatPanel;
import GUI.panel.smallpanel.EditBoatPanel;
import GUI.panel.smallpanel.SearchBoatPanel;
import service.BoatService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoatListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BoatService bs = new BoatService();

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
            if(bs.addBoat(ap.tfnom.getText(),(String)ap.cbtype.getSelectedItem(),ap.tfwigh.getText(),ap.tfhost.getText(),ap.tfloca.getText())){
                ap.lmsg.setText("Créé avec succès!");
            } else{
                ap.lmsg.setText("Échoué, il y a des erreurs!");
            }
            ap.tfnom.setText(null);
            //ap.tftype.setText(null);
            ap.tfwigh.setText(null);
            ap.tfhost.setText(null);
            ap.tfloca.setText(null);

        }

        //EditDockPanel Listener
        if(button == ep.bEdit){

        }

        //DeleteDockPanel Listener
        if(button == dp.bDelete){
            if(bs.delBoat(Integer.valueOf(dp.tfid.getText()))){
                dp.lmsg.setText("Supprimé avec succès!");
            }else{
                dp.lmsg.setText("Échoué, il y a des erreurs!");
            }
            dp.tfid.setText(null);
        }

        //SearchDockPanel Listener
        if(button == sp.bSearch){

        }

    }
}
