package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Comet class represents a comet game object that moves along a predefined path and can be targeted by other game objects.
 */
public class Comet extends GameObject implements Targetable
{
    private Control control;
    private GameState state;
    private double pathPercentage;

    /**
     * Constructor for creating a Comet object
     *
     * @param control the game's Control object
     * @param state the current game state
     */
    public Comet(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
    }

    /**
     * Updates the Comet's position on the path.
     * @param timeElapsed the time elapsed since the last update
     */
    @Override
    public void update(double timeElapsed)
    {
        // The Comet moves 1/6 of the path per second, so increase the path percentage by (1.00/6.0) * timeElapsed.
        pathPercentage += (1.00/6.0) * timeElapsed;
    }

    /**
     * Draws the Comet on the screen
     * @param g the Graphics object used for drawing
     */
    @Override
    public void draw(Graphics g)
    {
        if (state.getCurrentObjects().size() < 50) {
            BufferedImage comet = control.getImage("comet.png");
            Point loc = control.getPath().convertToCoordinates(pathPercentage);
            g.drawImage(comet, loc.x - comet.getWidth() / 2, loc.y - comet.getHeight() / 2, null);
        }
    }

    /**
     * Returns the Comet's future location on the path after a specified additional time
     *
     * @param additionalTime the additional time to project the Comet's location
     * @return the Comet's future location on the path after the specified additional time
     */
    public Point getFutureLocation(double additionalTime)
    {
        return control.getPath().convertToCoordinates(pathPercentage+(1.00/6.0) * additionalTime);
    }
}
