package checkpoint4;

import java.awt.*;

/**
 * The MenuArea class represents the menu area of the game screen
 */
public class MenuArea extends GameObject
{
    private Control control;
    private GameState state;

    /**
     * Creates a new MenuArea with the given Control and GameState objects
     *
     * @param control The Control object for the game.
     * @param state The GameState object for the game.
     */
    public MenuArea(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }

    /**
     * Adds ButtonSpaceship and ButtonSatellite objects to the GameState's current frame objects list.
     */
    public void setUpMenuArea()
    {
        state.addGameObject(new ButtonSpaceship(control, state));
        state.addGameObject(new ButtonSatellite(control, state));
    }

    @Override
    public void update(double timeElapsed)
    {

    }

    /**
     * Draws the menu area on the game screen.
     * @param g The graphics object used to draw the menu area.
     */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(600, 0, 200, 600);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Astral", 630, 50);
        control.setCurrency(500);
    }

}
