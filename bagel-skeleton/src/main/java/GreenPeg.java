/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description Green Pegs that may be horizontal / vertical /normal
 *              Grey Pegs generate two new balls when destroyed
 *              inherits Peg
 * @author Nicholas 956970
 */
import bagel.util.Point;

public class GreenPeg extends Peg{

    public GreenPeg(Point point, String imageSrc, String shape) { super(point, imageSrc,shape);
    }
}
