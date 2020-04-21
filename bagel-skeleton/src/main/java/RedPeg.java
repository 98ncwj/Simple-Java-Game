/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description Red Pegs that may be horizontal / vertical / normal
 *              Proceeds to next stage when all red pegs are destroyed
 *              inherits Peg
 * @author Nicholas 956970
 */
import bagel.util.Point;

public class RedPeg extends Peg {

    public RedPeg(Point point, String imageSrc,String shape) { super(point, imageSrc,shape);
    }
}
