package checkpoint2;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class GameState
{
    // Uncommented -- add contracts/comments to understand what's going
    // on.  (Style requirements checked on each checkpoint.)

    // Fields

    private List<GameObject> currentFrameObjects;
    private List<GameObject> nextFrameObjects;
    private int cityCount;
    private Point mouseLocation;
    private long lastFrameTime;
    private long currentTime;
    private float elapsedTime;
    private boolean isMoving;

    public GameState ()
    {
        currentFrameObjects = new ArrayList<GameObject>();
        cityCount = 20;
    }

    public int getCityCount ()
    {
        return cityCount;
    }

    public void adjustCityCount (int amount)
    {
        cityCount += amount;
    }

    public Point getMouseLoc()
    {
        return mouseLocation;
    }

    public void setMouseLocation(Point mouseLoc)
    {
        this.mouseLocation = mouseLoc;
    }

    public List<GameObject> getCurrentObjects ()
    {
        return currentFrameObjects;
    }

    public void startFrame ()
    {
        nextFrameObjects = new ArrayList<GameObject>();    // Creates empty list
        nextFrameObjects.addAll(currentFrameObjects);      // Add all the current ones to the new list.
        currentTime = System.currentTimeMillis();
        if (lastFrameTime == 0) {
            lastFrameTime = currentTime;
        }
        elapsedTime = (currentTime - lastFrameTime) / 1000f;
        lastFrameTime = currentTime;
    }

    public float getElapsedTime() { return elapsedTime; }

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

    public Targetable findNearest(Point somePoint) {
        Targetable closestTarget = null;
        double closestDistance = Double.MAX_VALUE;

        for (GameObject ob : currentFrameObjects) {
            if (ob instanceof Targetable) {
                Targetable target = (Targetable)ob;
                double distance = somePoint.distance(target.getLocation());
                if (distance < closestDistance) {
                    closestTarget = target;
                    closestDistance = distance;
                }
            }
        }

        return closestTarget;
    }



}
