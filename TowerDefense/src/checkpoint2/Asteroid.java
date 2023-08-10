package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The Asteroid class represents an asteroid game object that moves along a predefined path and extends the GameObject class and implements the Animatable interface.
 */
public class Asteroid extends GameObject
{
    private Control control;
    private GameState state;
    private double pathPercentage;
    private long lastFrameTime;
    private long currentTime;
    private float elapsedTime;

    /**
     * Constructs a new Asteroid object with the given Control and GameState objects
     * @param control the Control object used to control the game
     * @param state the GameState object representing the current state of the game
     */
    public Asteroid (Control control, GameState state)
    {
        super(control, state);
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
    }

    /**
     * Updates the position of the asteroid along its predefined path
     * @param timeElapsed the time elapsed since the last update, in seconds
     */

    @Override
    public void update(double timeElapsed)
    {
        // Counting time
        currentTime = System.currentTimeMillis();
        if (lastFrameTime == 0) {
            lastFrameTime = currentTime;
        }

        elapsedTime = (currentTime - lastFrameTime) / 1000f;
        lastFrameTime = currentTime;

        pathPercentage += 0.4 * elapsedTime;

        if (pathPercentage >= 1.00)
        {
            // Remove and add
            hasExpired = true;
            state.addGameObject(new Asteroid(control, state));
        }
    }

    /**
     * Draws the asteroid at its current position along the predefined path.
     * @param g the Graphics object to use for drawing the asteroid
     */
    @Override
    public void draw(Graphics g)
    {
        BufferedImage asteroid = control.getImage("asteroid.png");
        Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(asteroid, loc.x - asteroid.getWidth()/2, loc.y - asteroid.getHeight()/2, null);
    }

    @Override
    public void update() {

    }
}
