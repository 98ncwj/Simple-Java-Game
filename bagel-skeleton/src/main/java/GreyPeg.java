/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description Grey Pegs that may be horizontal / vertical / normal
 *              Grey Pegs cannot be destoyed
 *              inherits Peg
 * @author Nicholas 956970
 */

import bagel.util.Point;

public class GreyPeg extends Peg {

    public GreyPeg(Point point, String imageSrc,String shape) { super(point, imageSrc,shape);
    }
}
