package GUI.frame;

import GUI.panel.smallpanel.DeleteBoatPanel;
import GUI.panel.smallpanel.DeleteHostPanel;

import javax.swing.*;
import java.awt.*;

public class DeleteHostFrame extends JFrame {
    public static DeleteHostFrame instance = new DeleteHostFrame();

    private DeleteHostFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Supprimation");

        //get main panel
        JPanel p = DeleteHostPanel.instance;

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
        this.setDefaultCloseOperation(DeleteHostFrame.DISPOSE_ON_CLOSE);
    }

    //test this module
    public static void main(String[] args){
        instance.setVisible(true);
    }
}
