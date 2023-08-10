package checkpoint2;

abstract public class GameObject implements Animatable
{
    protected boolean hasExpired;

    public GameObject (Control control, GameState state)
    {
        hasExpired = false;
    }

    public boolean hasExpired ()
    {
        return hasExpired;
    }

    public abstract void update();
}
