package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The Asteroid class represents a type of GameObject that can be targeted and animated on a path.
 * It updates its path percentage based on time elapsed and draws itself on the screen.
 */
public class Asteroid extends GameObject implements Targetable
{
    private Control control;
    private GameState state;
    private double pathPercentage;

    /**
     * Constructs an instance of Asteroid with the specified Control and GameState.
     *
     * @param control the Control object used for managing the game
     * @param state the GameState object used for tracking the state of the game
     */
    public Asteroid (Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
    }

    /**
     * Updates the path percentage of the Asteroid based on time elapsed.
     *
     * @param timeElapsed the time elapsed since the last update in seconds
     */
    @Override
    public void update(double timeElapsed)
    {
        pathPercentage += (1.00/10.0) * timeElapsed;
    }

    /**
     * Draws the Asteroid on the screen and displays the currency.
     *
     * @param g the Graphics object used for drawing
     */
    @Override
    public void draw(Graphics g)
    {
        g.drawString("Currency: " + control.getCurrency(), 630, 100);

        if (state.getCurrentObjects().size() < 50) {
            BufferedImage asteroid = control.getImage("asteroid.png");
            Point loc = control.getPath().convertToCoordinates(pathPercentage);
            g.drawImage(asteroid, loc.x - asteroid.getWidth()/2, loc.y - asteroid.getHeight()/2, null);
        }
        else {
            g.drawString("GAME OVER!", 200, 200);
        }
    }

    /**
     * Returns the future location of the Asteroid based on added time.
     *
     * @param additionalTime the additional time elapsed in seconds
     * @return the future location of the Asteroid as a Point
     */
    @Override
    public Point getFutureLocation(double additionalTime)
    {
        return control.getPath().convertToCoordinates(pathPercentage+(1.00/10.0) * additionalTime);
    }
}
