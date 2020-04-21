/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description parent class of Normal and Fireball
 *              inherits Sprite
 * @author Nicholas 956970
 */
import bagel.Window;
import bagel.util.Point;
import bagel.util.Vector2;

public class Ball extends Sprite {
    private Vector2 velocity;
    private static final double GRAVITY = 0.15;

    public Ball(Point point, Vector2 velocity,String image) {
        super(point, image);
        this.velocity = velocity;
    }

    public boolean outOfScreen() {
        return getRect().top() > Window.getHeight();
    }

    public Vector2 getVelocity() { return velocity; }

    public void reverseTop(){
        velocity= new Vector2(velocity.x,-velocity.y);
    }

    public void reverseSide(){
        velocity= new Vector2(-velocity.x,velocity.y);
    }

    @Override
    public void update() {
        velocity = velocity.add(Vector2.down.mul(GRAVITY));
        super.move(velocity);

        //if ball hits left/right edge of screen, it will bounce off
        if (super.getRect().left() < 0 || super.getRect().right() > Window.getWidth()) {
            velocity = new Vector2(-velocity.x, velocity.y);
        }

        super.draw();
    }
}
