package GUI.panel;

import GUI.Util.GUIUtil;

public class BoatPanel extends WorkingPanel{

    public static BoatPanel instance = new BoatPanel();

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BoatPanel.instance);
    }

}
