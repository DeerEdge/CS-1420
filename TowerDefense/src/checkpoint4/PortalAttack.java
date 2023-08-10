package checkpoint4;

import java.awt.*;

/**
 * Attack using portal icon (flashes and follows)
 */
public class PortalAttack extends GameObject
{
    GameState state;
    Control control;
    Point startLoc, endLoc;
    Path myPath;
    double percentage;

    /**
     * Creates a new PortalAttack object with the given parameters.
     *
     * @param state The current GameState object.
     * @param control The current Control object.
     * @param location The starting location of the PortalAttack.
     * @param targetLoc The target location of the PortalAttack.
     */
    public PortalAttack(GameState state, Control control, Point location, Point targetLoc)
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
     * Updates the position of the PortalAttack along its path and checks for collisions with targetable objects.
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
            if (tLoc.distance(pos) < 100)
            {
                this.hasExpired = true;
                ((GameObject)t).hasExpired = true;
            }
        }

        if (percentage >= 1.0)
            hasExpired = true;
    }

    @Override
    public void draw(Graphics g)
    {
        Point pos = myPath.convertToCoordinates(percentage);
        drawCenteredImage(g, control.getImage("portal.png"), pos.x - 10 , pos.y - 5, 1);
        drawCenteredImage(g, control.getImage("portal.png"), pos.x, pos.y, 1);
        drawCenteredImage(g, control.getImage("portal.png"), pos.x - 10 , pos.y + 5, 1);
    }
}
