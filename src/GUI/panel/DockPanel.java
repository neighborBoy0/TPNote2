package GUI.panel;

import GUI.Util.GUIUtil;

public class DockPanel extends WorkingPanel{

    public static DockPanel instance = new DockPanel();

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(DockPanel.instance);
    }

}
