package checkpoint0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PathEditor extends JPanel implements Runnable, MouseListener, ActionListener {
    BufferedImage background;
    JMenuItem menuItem1, menuItem2, menuItem3;
    private Path path;

    public void run() {
        path = new Path();
        try
        {
            background = javax.imageio.ImageIO.read(new File("/Users/macbookpro/Documents/GitHub/CS-1420-Spring-2023/TowerDefense/src/checkpoint0/background.png"));
        }
        catch (IOException e)
        {
            // Do something sensible here.
        }

        JFrame frame = new JFrame("My Frame");

        // Set the close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the JPanel
        this.setMinimumSize(new Dimension(600, 600));
        this.setPreferredSize(new Dimension(600, 600));

        // Add mouse listener
        this.addMouseListener(this);

        // Create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuItem1 = new JMenuItem("Option 1");
        menuItem2 = new JMenuItem("Option 2");
        menuItem3 = new JMenuItem("Option 3");

        // Add action listener to menu items
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);

        // Add menu items to menu
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

        // Add menu to menu bar
        menuBar.add(menu);

        // Set menu bar to frame
        frame.setJMenuBar(menuBar);

        // Add the JPanel to the content area of the JFrame
        frame.setContentPane(this);

        // Pack the frame
        frame.pack();

        // Show the frame
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Draw background image
        g.drawImage(background, 0, 0, null);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);

        for (int i = 0; i < path.getSize() - 1; i++) {
            Point p1 = path.getPoint(i);
            Point p2 = path.getPoint(i + 1);

            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released at: " + e.getX() + ", " + e.getY());
        path.addPoint(e.getPoint());
        repaint();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem1) {
            System.out.println("Option 1 selected.");
        }
        else if (e.getSource() == menuItem2) {
            System.out.println("Option 2 selected.");
        }
        else if (e.getSource() == menuItem3) {
            System.out.println("Option 3 selected.");
        }
//        if (e.getSource() == loadMenuItem) {
//            // TODO: implement loading path from file
//        } else if (e.getSource() == saveMenuItem) {
//            // TODO: implement saving path to file
//        }
    }
}
