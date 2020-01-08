package GUI.Util;

import GUI.panel.CenterPanel;

import javax.swing.*;

public class GUIUtil {

    public static void showPanel(JPanel p, double strech){
        //GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(1200, 800);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strech);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }

    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }


    public static boolean checkEmpty(JTextField tf, String input){
        String text = tf.getText().trim();
        if(0 == text.length()){
            //
            JOptionPane.showMessageDialog(null, input+" checkEmpty");
            //
            tf.grabFocus();

            return false;
        }
        return true;
    }

    public static boolean checkNumber(JTextField tf ,String input){
        //
        if(!checkEmpty(tf, input)){
            return false;
        }
        //
        String text = tf.getText().trim();
        try{
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e) {
            //
            JOptionPane.showMessageDialog(null, input+" checkNumber");
            tf.grabFocus();
            return false;
        }
    }

    public static boolean checkZero(JTextField tf,String input){
        //
        if(!checkEmpty(tf, input)){
            return false;
        }
        //
        String text = tf.getText().trim();

        if(0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null, input+ " checkZero");
            tf.grabFocus();
            return false;
        }
        return true;
    }

}
