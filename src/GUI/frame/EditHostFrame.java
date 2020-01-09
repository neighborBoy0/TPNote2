package GUI.frame;

import GUI.panel.smallpanel.EditBoatPanel;
import GUI.panel.smallpanel.EditHostPanel;

import javax.swing.*;
import java.awt.*;

public class EditHostFrame extends JFrame {
    public static EditHostFrame instance = new EditHostFrame();

    private EditHostFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Modification du propriétaire");

        //get main panel
        JPanel p = EditHostPanel.instance;

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
        this.setDefaultCloseOperation(EditHostFrame.DISPOSE_ON_CLOSE);
    }

    //test this module
    public static void main(String[] args){
        instance.setVisible(true);
    }

}

