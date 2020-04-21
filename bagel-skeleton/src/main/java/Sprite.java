/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description abstract parent class of Ball and Peg
 *
 * @author Nicholas 956970
 */
import bagel.Image;
import bagel.util.Point;
import bagel.util.Rectangle;
import bagel.util.Vector2;

public abstract class Sprite {
    private Image image;
    protected Rectangle rect;

    public Sprite(Point point, String imageSrc) {
        image = new Image(imageSrc);
        rect = image.getBoundingBoxAt(point);
    }

    public boolean intersects(Sprite other) {
        return rect.intersects(other.rect);
    }

    public void move(Vector2 dx) {
        rect.moveTo(rect.topLeft().asVector().add(dx).asPoint());
    }

    public void draw() {
        image.draw(rect.centre().x, rect.centre().y);
    }

    public abstract void update();

    public Rectangle getRect() {
        return rect;
    }

    public Point getPoint(){
        return rect.centre();
    }

}
