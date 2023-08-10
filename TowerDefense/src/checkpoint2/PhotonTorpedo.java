//package checkpoint2;
//
//import java.awt.Graphics;
//import java.awt.Point;
//import java.util.ArrayList;
//
//public class PhotonTorpedo extends GameObject {
//    private ArrayList<Point> path;
//    private int pathIndex;
//    private int pathPercentage;
//    private final int SPEED = 10;
//    private final int LIFETIME = 50;
//    private int lifetime;
//
//    public PhotonTorpedo(Point control, Point source) {
//        super(control, state);
//
//        path = new ArrayList<Point>();
//        path.add(source);
//        path.add(target);
//        pathIndex = 0;
//        pathPercentage = 0;
//    }
//
//    public PhotonTorpedo(Point location, GameState targetLocation) {
//        super(location, targetLocation);
//    }
//
//    @Override
//    public void update() {
//        // Move along the path
//        if (pathIndex < path.size()-1) {
//            Point from = path.get(pathIndex);
//            Point to = path.get(pathIndex+1);
//
//            double distance = from.distance(to);
//            double dx = (to.x - from.x) / distance * SPEED;
//            double dy = (to.y - from.y) / distance * SPEED;
//
//            pathPercentage += SPEED;
//            if (pathPercentage > distance) {
//                pathIndex++;
//                pathPercentage = 0;
//            }
//        }
//    }
//
//    @Override
//    public void update(double timeElapsed) {
//
//    }
//
//    @Override
//    public void draw(Graphics g) {
//
//    }
//}
