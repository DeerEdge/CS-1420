package checkpoint4;

import java.awt.*;

/**
 * Class that represents the button of the spaceship gameobject
 */
public class ButtonSpaceship extends GameObject implements Clickable
{
    private Control control;
    private GameState state;

    /**
     * Creates a new ButtonSpaceship instance
     *
     * @param control the Control object for the game
     * @param state the GameState object for the game
     */
    public ButtonSpaceship(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }

    @Override
    public void update(double timeElapsed) {}

    /**
     * Draws the spaceship button on the screen.
     *
     * @param g the Graphics object used to draw the button
     */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRoundRect(710, 400, 75, 75, 10, 10);
        g.setColor(Color.GRAY);
        g.fillRoundRect(712, 402, 71, 71, 10, 10);

        g.drawImage(control.getImage("spaceship.png"), 720, 410, null);
    }

    /**
     * Spawns a new Spaceship object when the button is clicked
     *
     * @return true if the click is consumed, false otherwise
     */
    @Override
    public boolean consumeClick()
    {
        Point mouseLoc = state.getMouseLoc();
        if (mouseLoc.x >= 710 && mouseLoc.x <= 710+75 &&
                mouseLoc.y >= 400 && mouseLoc.y <= 400+75)
        {
            state.addGameObject(new Spaceship(control, state));
            return true;
        }

        return false;
    }
}
