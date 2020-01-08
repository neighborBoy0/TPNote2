package GUI.frame;

import GUI.panel.MainPanel;

import javax.swing.*;

public class MainFrame extends JFrame {

    public static MainFrame instance  = new MainFrame();

    private MainFrame(){

        //设置窗体大小
        this.setSize(1000,700);

        //设置窗口标题
        this.setTitle("La gestion des quais d'un port de plaisance");

        //设置主面板
        this.setContentPane(MainPanel.instance);

        //窗体居中显示
        this.setLocationRelativeTo(null);

        //设置窗体大小是否可调
        this.setResizable(false);

        //设置窗口关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //test this module
    public static void main(String[] args){
        instance.setVisible(true);
    }
}
