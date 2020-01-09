package GUI.frame;

import GUI.panel.smallpanel.EditBoatPanel;
import GUI.panel.smallpanel.EditDockPanel;

import javax.swing.*;
import java.awt.*;

public class EditDockFrame extends JFrame {
    public static EditDockFrame instance = new EditDockFrame();

    private EditDockFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Modification");

        //get main panel
        JPanel p = EditDockPanel.instance;

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
        this.setDefaultCloseOperation(EditDockFrame.DISPOSE_ON_CLOSE);
    }

}
