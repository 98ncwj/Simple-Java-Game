/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description Parent class of all pegs
 *              inherits Sprite
 * @author Nicholas 956970
 */
import bagel.util.Point;

public class Peg extends Sprite {
    private Point pos;
    private String shape;
    public Peg(Point point, String imageSrc, String shape) {
        super(point, imageSrc);
        this.pos=point;
        this.shape=shape;
    }
    public Point getPoint(){return this.pos;}

    public String getShape(){ return this.shape;}

    @Override
    public void update() {
        super.draw();
    }
}
