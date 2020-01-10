package GUI.frame;

import GUI.panel.smallpanel.AddBoatPanel;
import GUI.panel.smallpanel.DeleteBoatPanel;

import javax.swing.*;
import java.awt.*;

public class DeleteBoatFrame extends JFrame {
    public static DeleteBoatFrame instance = new DeleteBoatFrame();

    private DeleteBoatFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Supprimation du bateau");

        //get main panel
        JPanel p = DeleteBoatPanel.instance;

        //set panel size
        p.setPreferredSize(new Dimension(200, 400));

        //add main panel
        this.setContentPane(p);

        //set frame center
        this.setLocationRelativeTo(null);

        //set frame is not resizable
        this.setResizable(false);

        //set close method:
        // DISPOSE_ON_CLOSE: only close this frame
        this.setDefaultCloseOperation(DeleteBoatFrame.DISPOSE_ON_CLOSE);
    }

    //test this module
    public static void main(String[] args){
        instance.setVisible(true);
    }


}
