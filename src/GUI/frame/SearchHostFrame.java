package GUI.frame;

import GUI.panel.smallpanel.SearchBoatPanel;
import GUI.panel.smallpanel.SearchHostPanel;

import javax.swing.*;
import java.awt.*;

public class SearchHostFrame extends JFrame {
    public static SearchHostFrame instance = new SearchHostFrame();

    private SearchHostFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Modification");

        //get main panel
        JPanel p = SearchHostPanel.instance;

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
        this.setDefaultCloseOperation(SearchHostFrame.DISPOSE_ON_CLOSE);
    }

}

