/**
 * @description Fireball destroys all pegs within 70 pixel when intercept with all pegs other than grey peg
 *              otherwise behaviour is the same as NormalBall
 * @author 98ncwj
 */
import bagel.util.Point;
import bagel.util.Vector2;

public class Fireball  extends Ball {

    public Fireball(Point point, Vector2 velocity){
        super(point,velocity,"res/fireball.png");
    }
}
