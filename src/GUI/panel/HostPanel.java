package GUI.panel;

import GUI.Util.GUIUtil;

public class HostPanel extends WorkingPanel{

    public static HostPanel instance = new HostPanel();

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(HostPanel.instance);
    }

}