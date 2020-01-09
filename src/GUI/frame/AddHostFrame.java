package GUI.frame;

import GUI.panel.smallpanel.AddDockPanel;
import GUI.panel.smallpanel.AddHostPanel;

import javax.swing.*;
import java.awt.*;

public class AddHostFrame extends JFrame {
    public static AddHostFrame instance = new AddHostFrame();

    private AddHostFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Création");

        //get main panel
        JPanel p = AddHostPanel.instance;

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
        this.setDefaultCloseOperation(AddDockFrame.DISPOSE_ON_CLOSE);
    }

    //test this module
    public static void main(String[] args){
        instance.setVisible(true);
    }
}
