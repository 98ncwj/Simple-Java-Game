/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description Bucket moves horizontally at bottom of screen and bounces of edge of screen
 *              If ball intercepts bucket, player gets an additional shot
 *              inherits Sprite
 * @author Nicholas 956970
 */
import bagel.Window;
import bagel.util.Point;
import bagel.util.Vector2;

public class Bucket extends Sprite {
    private static final int SPEED = 4;
    private Vector2 velocity;

    public Bucket(Point point) {
        super(point, "res/bucket.png");
        velocity = Vector2.left.mul(SPEED);
    }
    @Override
    public void update() {

        super.move(velocity);

        //if bucket hits left/right edge of screen, it will reverse
        if (super.getRect().left() < 0 || super.getRect().right() > Window.getWidth()) {
            velocity = new Vector2(-velocity.x, velocity.y);
        }
        super.draw();
    }
}
