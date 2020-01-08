package GUI.panel;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private double rate; // Stretch ratio
    private JComponent c; // Displayed components
    private boolean strech; // Whether to stretch

    public CenterPanel(double rate, boolean strech){
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    /**
     * 默认拉伸
     * @param rate
     */
    public CenterPanel(double rate){
        this.rate = rate;
        this.strech = true;
    }

    public void repaint(){
        if(null != c){
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();

            if(strech){
                c.setSize((int)(containerSize.width * rate),
                        (int)(containerSize.height * rate));
            }else {
                c.setSize(componentSize);
            }
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
                    containerSize.height / 2 - c.getSize().height / 2);
        }
        super.repaint();
    }

    public void show(JComponent p){
        this.c = p; //c: JComponent
        Component[] cs = getComponents();
        for (Component c : cs){
            remove(c);
        }

        if(p instanceof WorkingPanel){
            ((WorkingPanel) p).updateDate();
        }
        add(p);
        this.updateUI();
    }
}
