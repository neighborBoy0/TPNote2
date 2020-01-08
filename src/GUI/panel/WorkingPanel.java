package GUI.panel;
import javax.swing.*;

/**
 * Abstract Class
 * Main Working Panel at the center of Frame
 */
public abstract class WorkingPanel extends JPanel {
    /**
     * 活动界面保持和数据库同步
     */
    public abstract void updateDate();

    /**
     * 为活动界面添加监听器
     */
    public abstract void addListener();
}
