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

        //AddBoatPanel Listener
        if(button == ap.bAdd){
            String type;
            if(ap.cbtype.getSelectedIndex()==1){
                type = "s";
            }else if(ap.cbtype.getSelectedIndex()==2){
                type = "m";
            }else{
                type = "";
            }
            if(bs.addBoat(ap.tfnom.getText(),type,ap.tfwigh.getText(),ap.tfhost.getText(),ap.tfloca.getText(), ap.tfcara.getText())){
                ap.lmsg.setText("Créé avec succès!");
            } else{
                ap.lmsg.setText("Échoué, il y a des erreurs!");
            }
            ap.tfnom.setText(null);
            //ap.tftype.setText(null);
            ap.cbtype.setSelectedIndex(0);
            ap.tfcara.setText(null);
            ap.tfwigh.setText(null);
            ap.tfhost.setText(null);
            ap.tfloca.setText(null);
            p.updateDate();

        }

        //EditBoatPanel Listener
        if(button == ep.bEdit){
            if(bs.editBoat(Integer.valueOf(ep.tfid.getText()), ep.tfnom.getText(), ep.tfwigh.getText(),ep.tfhost.getText(),ep.tfloca.getText(),ep.tfcara.getText())){
                ep.lmsg.setText("Modifié avec succès!");
            }else {
                ep.lmsg.setText("Il n'existe pas.");
            }
            ep.tfid.setText(null);
            ep.tfcara.setText(null);
            ep.tfhost.setText(null);
            ep.tfloca.setText(null);
            ep.tfnom.setText(null);
            ep.tfwigh.setText(null);
            p.updateDate();
        }

        //DeleteBoatPanel Listener
        if(button == dp.bDelete){
            if(bs.delBoat(Integer.valueOf(dp.tfid.getText()))){
                dp.lmsg.setText("Supprimé avec succès!");
            }else{
                dp.lmsg.setText("Échoué, il y a des erreurs!");
            }
            dp.tfid.setText(null);
            p.updateDate();
        }

        //SearchBoatPanel Listener
        if(button == sp.bSearch){
            String str = bs.researchBoatByIndex(Integer.valueOf(sp.tfid.getText()));
            sp.ta.setText(str);
            sp.tfid.setText(null);
        }

        if(button == sp.bSearchCon){
            String type;
            String con;
            if(sp.cbtype.getSelectedIndex() == 1){
                type = "SailBoat";
            }else{
                type = "MotorBoat";
            }
            if(sp.cbcont.getSelectedIndex() == 1){
                con = ">";
            }else if(sp.cbcont.getSelectedIndex() == 2){
                con = "=";
            }else{
                con = "<";
            }
            String str = bs.researchBoatByCon(type,con,Float.valueOf(sp.tfvalue.getText()));
            sp.ta.setText(str);
            sp.tfvalue.setText(null);
        }

        if(button == sp.bSearchWight){
            String con;
            switch (sp.cbcont2.getSelectedIndex()){
                case 1:
                    con = ">";
                    break;
                case 2:
                    con = "=";
                    break;
                default:
                    con = "<";
            }
            String str = bs.researchBoatByWight(con,Float.valueOf(sp.tfvalue2.getText()));
            sp.ta.setText(str);
            sp.tfvalue2.setText(null);
        }
    }
}
