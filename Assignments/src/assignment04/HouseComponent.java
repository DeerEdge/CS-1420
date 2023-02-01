
package assignment04;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class HouseComponent extends JComponent{
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Roof
        g2.setColor(new Color(168, 94, 94, 255));
        g.fillPolygon(new int[] {30, 350, 670}, new int[] {220, 70, 220}, 3);

        //House Body
        Rectangle body = new Rectangle(50,220,600,400);
        g2.draw(body);
        g2.setColor(new Color(244, 252, 0, 255));
        g2.fill(body);

        //Door
        Rectangle door = new Rectangle(290,420,120,200);
        g2.draw(door);
        g2.setColor(new Color(114, 80, 59, 255));
        g2.fill(door);

        //Window1
        Rectangle window1 = new Rectangle(70,390,200,120);
        g2.draw(window1);
        g2.setColor(new Color(178, 178, 178, 255));
        g2.fill(window1);

        //Window2
        Rectangle window2 = new Rectangle(430,390, 200,120);
        g2.draw(window2);
        g2.setColor(new Color(178, 178, 178, 255));
        g2.fill(window2);
    }
}