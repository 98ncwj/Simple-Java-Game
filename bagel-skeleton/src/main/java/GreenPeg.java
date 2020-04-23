/**
 * @description Green Pegs that may be horizontal / vertical /normal
 *              Grey Pegs generate two new balls when destroyed
 *              inherits Peg
 * @author 98ncwj
 */
import bagel.util.Point;

public class GreenPeg extends Peg{

    public GreenPeg(Point point, String imageSrc, String shape) { super(point, imageSrc,shape);
    }
}
