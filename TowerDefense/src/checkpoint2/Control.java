package checkpoint2;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Control implements Runnable, ActionListener, MouseListener, MouseMotionListener
{
    private View view;
    private GameState state;
    private Timer timer;
    private Path path;
    private TreeMap<String,BufferedImage> imageCache;
    public boolean mousePressed;

    /**
     * Runs the game's main loop and initializes game objects and view.
     */
    public void run ()
    {
        imageCache = new TreeMap<String,BufferedImage>();
        mousePressed = false;

        path = loadPath("path.txt");

        state = new GameState();
        view = new View(this, state);
        view.addMouseListener(this);
        view.addMouseMotionListener(this);

        state.startFrame();

        MenuArea menuArea = new MenuArea(this, state);

        state.addGameObject(new Background(this, state));
        state.addGameObject(menuArea);
        state.addGameObject(new Asteroid(this, state));
        state.addGameObject(new Comet(this, state));

        menuArea.setUpMenuArea();

        state.finishFrame();

        timer = new Timer(16,this);
        timer.start();
    }

    // Loads an image

    // Load the background image.

    /**
     * Loads an image from a file.
     * @param filename the name of the file to load the image from
     * @return the loaded image
     */
    private BufferedImage loadImage (String filename)
    {
        System.out.println("Loading " + filename);
        try
        {
            return javax.imageio.ImageIO.read(new File(filename));
        }
        catch (IOException e)
        {
            System.out.println("Could not read " + filename);
            return null;
        }
    }

    /**
     * Retrieves an image from the image cache
     * @param filename the name of the file to retrieve the image from
     * @return the retrieved image
     */
    public BufferedImage getImage (String filename)
    {
        if (! imageCache.containsKey(filename))
        {
            BufferedImage b = loadImage(filename);
            imageCache.put(filename, b);
        }

        return imageCache.get(filename);
    }

    /**
     * Loads a path from a file
     * @param filename the name of the file to load the path from
     * @return the loaded path
     */
    private Path loadPath (String filename)
    {
        try
        {
            Scanner in = new Scanner(new File(filename));
            Path p = new Path(in);
            in.close();
            return p;
        }
        catch (IOException e)
        {
            System.out.println("Could not load the path.");

            return null;
        }
    }

    /**
     * Retrieves the path that game objects follow
     * @return the game object path
     */
    public Path getPath ()
    {
        return path;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Main update loop

        state.startFrame();

        // update objects
        for (Animatable a : state.getCurrentObjects())
            a.update(0);

        if (mousePressed)
            for (int pos = state.getCurrentObjects().size() - 1;
                 pos >= 0; pos--)
            {
                Animatable a = state.getCurrentObjects().get(pos);

                if (a instanceof Clickable) {
                    Clickable c = (Clickable) a;
                    if (c.consumeClick())
                        break;
                }
            }

        mousePressed = false;

        state.finishFrame();

        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
    }
}
