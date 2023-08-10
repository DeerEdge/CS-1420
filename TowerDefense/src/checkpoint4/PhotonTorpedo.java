package checkpoint4;

import java.awt.*;

/**
 * PhotonTorpedo class represents a photon torpedo object that can be launched from a spaceship to destroy a targetable object
 */
public class PhotonTorpedo extends GameObject
{
    GameState state;
    Control control;
    Point startLoc, endLoc;
    Path myPath;
    double percentage;

    /**
     * Constructor for the PhotonTorpedo object.
     *
     * @param state The current game state.
     * @param control The Control object used for managing game elements.
     * @param location The starting location of the photon torpedo.
     * @param targetLoc The target location for the photon torpedo to hit.
     */
    public PhotonTorpedo(GameState state, Control control, Point location, Point targetLoc)
    {
        this.state = state;
        this.control = control;
        this.startLoc = location;
        this.endLoc = targetLoc;
        myPath = new Path();
        myPath.add(startLoc.x, startLoc.y);
        myPath.add(endLoc.x, endLoc.y);
        percentage = 0;
    }

    /**
     * Updates the photon torpedo's position and checks for collisions with targetable objects.
     *
     * @param timeElapsed The amount of time that has elapsed since the last update.
     */
    @Override
    public void update(double timeElapsed)
    {
        percentage += (1.00 / 0.75) * timeElapsed;

        Point pos = myPath.convertToCoordinates(percentage);
        Targetable t = state.getNearestTargetable(pos, 0);
        if (t != null) {
            Point tLoc = t.getFutureLocation(0);
            if (tLoc.distance(pos) < 20)
            {
                this.hasExpired = true;
                ((GameObject)t).hasExpired = true;
            }
        }

        if (percentage >= 1.0)
            hasExpired = true;
    }

    /**
     * Draws the photon torpedo object on the game screen
     *
     * @param g The graphics object to draw with
     */
    @Override
    public void draw(Graphics g)
    {
        Point pos = myPath.convertToCoordinates(percentage);
        drawCenteredImage(g, control.getImage("photon.png"), pos.x, pos.y, 1);
    }
}
