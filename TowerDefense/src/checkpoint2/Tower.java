//package checkpoint2;
//
//import java.awt.*;
//
//public class Tower extends GameObject {
//    private Point location;
//    private GameState gameState;
//
//    public Tower(Point location, GameState gameState, GameState state, Point control) {
//        super(control, state);
//        this.location = location;
//        this.gameState = gameState;
//    }
//
//    public void update() {
//        Targetable nearestTargetable = gameState.findNearest(location);
//
//        if (nearestTargetable != null) {
//            Point targetLocation = nearestTargetable.getLocation();
//            double distance = location.distance(targetLocation);
//
//            if (distance < 15) {
//                gameState.addGameObject(new PhotonTorpedo(location, targetLocation));
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
//
