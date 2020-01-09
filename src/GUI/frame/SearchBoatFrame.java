package GUI.frame;

import GUI.panel.smallpanel.EditBoatPanel;
import GUI.panel.smallpanel.SearchBoatPanel;

import javax.swing.*;
import java.awt.*;

public class SearchBoatFrame extends JFrame {
    public static SearchBoatFrame instance = new SearchBoatFrame();

    private SearchBoatFrame(){
        //set frame size
        this.setSize(600, 400);

        //set frame title
        this.setTitle("Modification du bateau");

        //get main panel
        JPanel p = SearchBoatPanel.instance;

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
        this.setDefaultCloseOperation(SearchBoatFrame.DISPOSE_ON_CLOSE);
    }

    //test this module
    public static void main(String[] args){
        instance.setVisible(true);
    }

}

