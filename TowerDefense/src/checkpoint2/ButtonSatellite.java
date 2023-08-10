package checkpoint2;

import java.awt.*;

public class ButtonSatellite extends GameObject implements Clickable {

    private Control control;
    private GameState state;

    /**
     * Constructs a new ButtonSatellite object with the given Control and GameState objects.
     * @param control the Control object used to control the game
     * @param state the GameState object representing the current state of the game
     */
    public ButtonSatellite(Control control, GameState state) {
        super(control, state);
        this.control = control;
        this.state = state;
    }

    /**
     * Draws the satellite button on the screen
     * @param g the Graphics object to use for drawing the satellite button
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRoundRect(630, 400, 75, 75, 10, 10);
        g.setColor(Color.GRAY);
        g.fillRoundRect(632, 402, 71, 71, 10, 10);

        g.drawImage(control.getImage("probe.png"), 640, 410, null);
    }

    /**
     * Checks if the button has been clicked and adds a new Satellite object to the game if so.
     * @return true if the button has been clicked, false otherwise
     */
    @Override
    public boolean consumeClick() {
        Point mouseLoc = state.getMouseLoc();
        if (mouseLoc.x >= 630 && mouseLoc.x <= 630+75 &&
                mouseLoc.y >= 400 && mouseLoc.y <= 400+75)
        {
            state.addGameObject(new Satellite(control, state));
            return true;
        }

        return false;
    }

    /**
     * Unused method since the button does not need to be updated
     */
    @Override
    public void update() {
        // Empty method since the button does not need to be updated
    }

    /**
     * Unused method since the button does not need to be updated with elapsed time
     * @param timeElapsed the time elapsed since the last update (in seconds)
     */
    @Override
    public void update(double timeElapsed) {
        // Empty method since the button does not need to be updated with elapsed time
    }
}
