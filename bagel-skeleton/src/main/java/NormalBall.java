/**
 * @description Ball moves at speed 10pixels per frame
 *              initially move towards mouse when clicked
 *              affected by gravity(0.15 pixels )
 *              bounces off pegs
 *              destroy all pegs excepts grey peg
 * @author 98ncwj
 */
import bagel.util.Point;
import bagel.util.Vector2;

public class NormalBall extends Ball {
    private static final double SPEED = 10;

    public NormalBall(Point point, Vector2 direction){ super(point,direction.mul(SPEED),"res/ball.png");
    }
}
