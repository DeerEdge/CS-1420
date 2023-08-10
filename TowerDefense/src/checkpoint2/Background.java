package checkpoint2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Background extends GameObject implements Animatable {

    private Control control;
    private GameState state;

    /**
     * Constructs a new Background object with the given Control and GameState objects.
     * @param control the Control object used to control the game
     * @param state the GameState object representing the current state of the game
     */
    public Background(Control control, GameState state) {
        super(control, state);
        this.control = control;
        this.state = state;
    }

    /**
     * Updates the background object (empty)
     */
    @Override
    public void update() {
        // Empty method since the background does not need to be updated
    }

    @Override
    public void update(double timeElapsed) {

    }

    /**
     * Draws the background image on the screen
     * @param g the Graphics object to use for drawing the background image
     */
    @Override
    public void draw(Graphics g) {
        BufferedImage background = control.getImage("background.png");
        g.drawImage(background, 0, 0, null);
    }
}
