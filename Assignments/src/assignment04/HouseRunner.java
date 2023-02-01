package assignment04;

import javax.swing.*;
import java.awt.Color;

public class HouseRunner {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(700,700);
        frame.setTitle("House");
        //HSB Color applied to background
        frame.getContentPane().setBackground(new Color(134, 169, 231, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HouseComponent component = new HouseComponent();
        frame.add(component);
        frame.repaint();
        frame.setVisible(true);

    }
}