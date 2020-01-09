package GUI.frame;

import GUI.panel.smallpanel.AddBoatPanel;
import GUI.panel.smallpanel.AddDockPanel;

import javax.swing.*;
import java.awt.*;

public class AddBoatFrame extends JFrame {
    public static AddBoatFrame instance = new AddBoatFrame();

    private AddBoatFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Création du bateau");

        //get main panel
        JPanel p = AddBoatPanel.instance;

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
        this.setDefaultCloseOperation(AddBoatFrame.DISPOSE_ON_CLOSE);
    }

    //test this module
    public static void main(String[] args){
        instance.setVisible(true);
    }

}
