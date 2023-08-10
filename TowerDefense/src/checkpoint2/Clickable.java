package checkpoint2;

/**
 * An interface for objects that can consume mouse clicks.
 */
public interface Clickable
{
    /**
     * Mouse click to perform an action
     * @return true if the click was consumed, false otherwise.
     */
    public boolean consumeClick();
}



