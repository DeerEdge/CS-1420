package checkpoint0;

import java.awt.*;
import java.util.ArrayList;

public class Path {
    private ArrayList<Point> points = new ArrayList<Point>();

    public Path() {
        points = new ArrayList<Point>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public int getSize() {
        return points.size();
    }
}
