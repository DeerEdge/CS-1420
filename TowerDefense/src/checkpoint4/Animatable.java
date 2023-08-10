package checkpoint4;

import java.awt.Graphics;

public interface Animatable
{
    /**
     * Updates the animation of the object based on the time elapsed since
     * the last update.
     *
     * @param timeElapsed the time elapsed since the last update in seconds
     */
    public void update(double timeElapsed);

    /**
     * Draws the current state of the object's animation using the given
     * Graphics object.
     *
     * @param g the Graphics object used for drawing
     */
    public void draw(Graphics g);
}
