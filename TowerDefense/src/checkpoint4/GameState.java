package checkpoint4;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

/**
 * Represents the state of the game at a particular point in time
 */
public class GameState
{
    // Fields
    private List<GameObject> currentFrameObjects;
    private List<GameObject> nextFrameObjects;
    private int cityCount;
    private Point mouseLocation;

    private long lastFrameStartTime;
    private double elapsedTime;

    /**
     * Creates a new GameState object with an empty current frame
     */
    public GameState ()
    {
        currentFrameObjects = new ArrayList<GameObject>();

        lastFrameStartTime = System.currentTimeMillis();
        elapsedTime = 0;
    }

    /**
     * Returns the number of cities in the game.
     *
     * @return the number of cities
     */
    public int getCityCount ()
    {
        return cityCount;
    }

    /**
     * Adjusts the number of cities in the game by the given amount.
     *
     * @param amount the amount to adjust the city count by
     */
    public void adjustCityCount (int amount)
    {
        cityCount += amount;
    }

    /**
     * Returns the current mouse location in the game.
     *
     * @return the current mouse location
     */
    public Point getMouseLoc()
    {
        return mouseLocation;
    }

    public void setMouseLocation(Point mouseLoc)
    {
        this.mouseLocation = mouseLoc;
    }

    /**
     * Returns a list of the objects in the current frame.
     *
     * @return a list of the current frame objects
     */
    public List<GameObject> getCurrentObjects ()
    {
        return currentFrameObjects;
    }

    /**
     * Returns the elapsed time since the last frame started.
     *
     * @return the elapsed time in seconds
     */
    public double getElapsedTime()
    {
        return elapsedTime;
    }

    public void startFrame ()
    {
        // Calculate how much time has elapsed since the previous start frame
        long currentFrameStartTime = System.currentTimeMillis();
        elapsedTime = (currentFrameStartTime - lastFrameStartTime)/1000.0;
        lastFrameStartTime = currentFrameStartTime;

        nextFrameObjects = new ArrayList<GameObject>();    // Creates empty list
        nextFrameObjects.addAll(currentFrameObjects);      // Add all the current ones to the new list.
    }

    /**
     * Adds the given GameObject to the next frame.
     *
     * @param a the object to add to the next frame
     */
    public void addGameObject (GameObject a)
    {
        nextFrameObjects.add(a);
    }

    public void finishFrame ()
    {
        // Remove any current objects that are expired from the
        // next frame.

        for (GameObject go : currentFrameObjects)
            if (go.hasExpired())
                nextFrameObjects.remove(go);

        currentFrameObjects = nextFrameObjects;
        nextFrameObjects = null;  // This makes it clear there is only a current list now.
    }

    /**
     * Finds the closest targetable object to the given location
     * from the current frame.  If there are no targetable objects,
     * null is returned.
     *
     * @param loc
     * @param additionalTime
     * @return
     */
    public Targetable getNearestTargetable(Point loc, double additionalTime)
    {
        Targetable closest = null;

        for (GameObject go : currentFrameObjects)
        {
            if (! (go instanceof Targetable))
                continue;

            Targetable t = (Targetable) go;

            if (go.hasExpired())
                continue;

            if (closest == null)
            {
                closest = t;
                continue;
            }

            double closestDist = loc.distance(closest.getFutureLocation(additionalTime));
            double tDist       = loc.distance(t.getFutureLocation(additionalTime));

            if (tDist < closestDist)
                closest = t;
        }

        return closest;
    }
}
