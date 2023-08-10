package checkpoint2;

/**
 * The Animatable interface defines methods for updating and drawing an object in an animation
 */
import java.awt.Graphics;

public interface Animatable
{
    // Update objects with elapsed time
    public void update(double timeElapsed);

    // Draw on frame
    public void draw(Graphics g);
}
