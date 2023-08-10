package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A background class that represents an object that displays the game's background
 */
public class Background extends GameObject
{
    private Control control;
    private GameState state;

    /**
     * Constructs an instance of Background with the specified Control and GameState.
     *
     * @param control the Control object used for managing the game
     * @param state the GameState object used for tracking the state of the game
     */
    public Background(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }

    /**
     * Updates the object
     *
     * @param timeElapsed the time elapsed since the last update in seconds
     */
    @Override
    public void update(double timeElapsed) {}

    /**
     * Draws the Background on the screen
     *
     * @param g the Graphics object used for drawing
     */
    @Override
    public void draw(Graphics g)
    {
        BufferedImage background = control.getImage("background.png");
        g.drawImage(background, 0, 0, null);
    }
}
