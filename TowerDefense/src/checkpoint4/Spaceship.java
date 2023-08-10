package checkpoint4;

import java.awt.*;

/**
 * Satellite is a game object that flashes or fires portals at targetables
 */
public class Spaceship extends GameObject implements Clickable
{
    private Control control;
    private GameState state;
    private Point location;
    private boolean isMoving;
    private double cooldownTime;  // seconds

    /**
     * Constructor for Spaceship object
     *
     * @param control the Control object to interact with the game
     * @param state the GameState object to keep track of the game state
     */
    public Spaceship(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        isMoving = true;
    }

    /**
     * Updates the Spaceship object's location and checks if it can fire a portal
     *
     * @param timeElapsed the time elapsed since the last update in seconds
     */
    @Override
    public void update(double timeElapsed)
    {
        cooldownTime -= timeElapsed;

        if (isMoving)
            location = state.getMouseLoc();
        else
        {
            // Target an entity
            double futureTime = 0.75;
            Targetable t = state.getNearestTargetable(location, futureTime);

            if (t != null)
            {
                Point targetLoc = t.getFutureLocation(futureTime);
                double dist = targetLoc.distance(location);

                if (dist < 110 && cooldownTime <= 0) {
                    // Fire a shot from here to the target
                    cooldownTime = 0.8;
                    state.addGameObject(new PortalAttack(state, control, location, targetLoc));
                }
            }
        }
    }

    @Override
    public void draw(Graphics g)
    {
        if (control.getCurrency() - 50 > 0) {
            control.setCurrency(control.getCurrency() - 50);
            g.drawString("Currency: " + control.getCurrency(), 630, 100);

            if (location != null)
                drawCenteredImage(g, control.getImage("spaceship.png"), location.x, location.y, 1);

            // Test

            if (!isMoving && location != null)
            {
                Targetable t = state.getNearestTargetable(location, 2);

//            if (t != null) {
//                Point p = t.getFutureLocation(2);
//                g.setColor(new Color(1.0f, 0.0f, 1.0f));
//                g.drawLine(location.x, location.y, p.x, p.y);
//
//                Point q = t.getFutureLocation(0);
//                g.setColor(new Color(0.0f, 1.0f, 0.0f));
//                g.drawLine(location.x, location.y, q.x, q.y);
//            }
            }
        }
    }

    @Override
    public boolean consumeClick()
    {
        if (isMoving)
        {
            Point mouseLoc = state.getMouseLoc();
            if (mouseLoc.x < 0 || mouseLoc.y < 0 || mouseLoc.x > 600 || mouseLoc.y > 600)
                hasExpired = true;
            isMoving = false;
            return true;
        }

        return false;
    }
}
