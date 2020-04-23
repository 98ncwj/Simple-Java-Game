/**
 * @description Powerup moves randomly on screen
 *              moves at speed 3 pixels per frame
 *              It only has a 1/10 chance to be created each turn
 *              Disappears when intercepted by ball and turns ball into fireball
 *              inherits Sprite
 * @author 98ncwj
 */
import bagel.Window;
import bagel.util.Point;
import bagel.util.Vector2;
import java.util.Random;
import static java.lang.Math.sqrt;

public class Powerup extends Sprite{
    private Vector2 velocity;
    private static final int SPEED =3;
    private double unit;  //unit is used to calculate unit vector
    private Point point,end ; //point is starting point, end is ending point

    public Powerup (Point point, Point end ){
        super(point, "res/powerup.png");
        unit = sqrt(Math.pow(end.x-point.x,2)+Math.pow(end.y-point.y,2));
        Vector2 direction = new Vector2((end.x - point.x)/unit, (end.y - point.y)/unit);
        velocity = direction.mul(SPEED);
        this.end=end;
        this.point=point;
    }

    @Override
    public void update() {

        point=super.getPoint();

        //if powerup is within 5 pixels of ending point, create a new end point
        if (sqrt(Math.pow(point.x-end.x,2)+Math.pow(point.y-end.y,2))<5){
            Random rand = new Random();
            point=new Point(end.x,end.y);
            end=new Point(Window.getWidth() * rand.nextDouble(), Window.getHeight() * rand.nextDouble());
            unit = sqrt(Math.pow(end.x-point.x,2)+Math.pow(end.y-point.y,2));
            Vector2 direction = new Vector2((end.x - point.x)/unit, (end.y - point.y)/unit);
            velocity = direction.mul(SPEED);

        }
        super.move(velocity);

        super.draw();
    }
}
