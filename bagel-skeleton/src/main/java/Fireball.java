/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description Fireball destroys all pegs within 70 pixel when intercept with all pegs other than grey peg
 *              otherwise behaviour is the same as NormalBall
 * @author Nicholas 956970
 */
import bagel.util.Point;
import bagel.util.Vector2;

public class Fireball  extends Ball {

    public Fireball(Point point, Vector2 velocity){
        super(point,velocity,"res/fireball.png");
    }
}
