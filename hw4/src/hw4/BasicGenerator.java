
package hw4;

import api.Generator;
import java.util.Random;
import api.Shape;
import api.Position;

/**
 * Generator for Shape objects in MagicTetris. All six shapes are
 * equally likely, and the generated shape is magic with 20%
 * probability.
 * 
 * @author Robert Shay
 */
public class BasicGenerator implements Generator {

	@Override
	public Shape getNext(int width) {

		Random rand = new Random();

		int shape = rand.nextInt(6);

		// Used to determine whether the shape is magic. Only one number will
		// make it magic, which gives us 1/5 or 20% chance.
		int magicNum = rand.nextInt(5);

		if (shape == 0) {
			return new IShape(new Position(-2, width / 2), magicNum == 0);
		}
		else if (shape == 1) {
			return new LShape(new Position(-1, width / 2 + 1), magicNum == 0);
		}
		else if (shape == 2) {
			return new JShape(new Position(-1, width / 2), magicNum == 0);
		}
		else if (shape == 3) {
			return new OShape(new Position(-1, width / 2), magicNum == 0);
		}
		else if (shape == 4) {
			return new TShape(new Position(0, width / 2), magicNum == 0);
		}
		else if (shape == 5) {
			return new SZShape(new Position(-1, width / 2), magicNum == 0);
		}

		// Should never happen
		return null;
	}
}
