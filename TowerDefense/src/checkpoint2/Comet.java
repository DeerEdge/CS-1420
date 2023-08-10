package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Comet is a game object that represents a comet moving along a specific path
 */
public class Comet extends GameObject
{
    private Control control;
    private GameState state;
    private double pathPercentage;
    private long lastFrameTime;
    private long currentTime;
    private float elapsedTime;
    private float totalTime;
    private int numCometsToAdd;

    /**
     * Constructor to make Comet object
     * @param control the Control object that manages the game.
     * @param state the GameState object that stores the state of the game.
     */
    public Comet(Control control, GameState state)
    {
        super(control, state);
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
    }

    @Override
    public void update() {

    }

    /**
     * Updates the position of the comet based on the amount of time elapsed
     * If the comet has reached the end of its path, it is removed and a new one is added to the game.
     * @param timeElapsed the amount of time that has elapsed since the last update.
     */
    @Override
    public void update(double timeElapsed)
    {
        currentTime = System.currentTimeMillis();
        totalTime += currentTime;
        if (lastFrameTime == 0) {
            lastFrameTime = currentTime;
        }
        elapsedTime = (currentTime - lastFrameTime) / 1000f;
        lastFrameTime = currentTime;

        pathPercentage += 0.5 * elapsedTime;

        if (pathPercentage >= 1.00)
        {
            // Remove and add

            hasExpired = true;
            state.addGameObject(new Comet(control, state));
        }
    }

    /**
     * Returns the amount of time that has elapsed since the last update
     * @return time
     */
    public float getElapsedTime() { return elapsedTime; }

    /**
     * Draws the comet on the screen
     * @param g the Graphics object
     */
    @Override
    public void draw(Graphics g)
    {
        BufferedImage comet = control.getImage("comet.png");
        Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(comet, loc.x - comet.getWidth()/2, loc.y - comet.getHeight()/2, null);
    }
}
