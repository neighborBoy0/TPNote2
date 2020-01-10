package startup;

import GUI.frame.MainFrame;
import GUI.panel.DockPanel;
import GUI.panel.MainPanel;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        //GUIUtil.useLNF();

        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(DockPanel.instance);
            }
        });
    }
}
