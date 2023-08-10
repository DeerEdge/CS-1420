package checkpoint4;

import java.awt.*;

/**
 * A class that represents a satellite gameobject
 */
public class ButtonSatellite extends GameObject implements Clickable
{
    private Control control;
    private GameState state;

    /**
     * Constructs an instance of ButtonSatellite with the specified Control and GameState.
     *
     * @param control the Control object used for managing the game
     * @param state the GameState object used for tracking the state of the game
     */
    public ButtonSatellite(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }

    /**
     * Updates the ButtonSatellite object
     *
     * @param timeElapsed the time elapsed since the last update in seconds
     */
    @Override
    public void update(double timeElapsed) {}

    /**
     * Draws the ButtonSatellite objecy on the screen
     *
     * @param g the Graphics object used for drawing
     */
    @Override
    public void draw(Graphics g)
    {
         g.setColor(Color.BLACK);
         g.fillRoundRect(630, 400, 75, 75, 10, 10);
         g.setColor(Color.GRAY);
         g.fillRoundRect(632, 402, 71, 71, 10, 10);

         g.drawImage(control.getImage("probe.png"), 640, 410, null);
    }

    /**
     * Consumes a mouse click if the click occurred within the ButtonSatellite's bounds, creating a new Satellite.
     *
     * @return true if the click was consumed and a new Satellite was created, false otherwise
     */
    @Override
    public boolean consumeClick()
    {
        Point mouseLoc = state.getMouseLoc();
        if (mouseLoc.x >= 630 && mouseLoc.x <= 630+75 &&
            mouseLoc.y >= 400 && mouseLoc.y <= 400+75)
        {
            state.addGameObject(new Satellite(control, state));
            return true;
        }

        return false;
    }
}
