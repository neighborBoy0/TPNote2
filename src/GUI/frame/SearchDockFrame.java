package GUI.frame;

import GUI.panel.smallpanel.SearchBoatPanel;
import GUI.panel.smallpanel.SearchDockPanel;

import javax.swing.*;
import java.awt.*;

public class SearchDockFrame extends JFrame {
    public static SearchDockFrame instance = new SearchDockFrame();

    private SearchDockFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Modification");

        //get main panel
        JPanel p = SearchDockPanel.instance;

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
        this.setDefaultCloseOperation(SearchDockFrame.DISPOSE_ON_CLOSE);
    }

}

