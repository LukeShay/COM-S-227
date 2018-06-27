
package hw4;

import java.util.List;
import java.util.ArrayList;

import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 * 
 * @author Robert Shay
 */
public class MagicTetris extends AbstractGame {

	/**
	 * int to keep track of the score for the current game of magic
	 * tetris.
	 */
	private int score = 0;
	/**
	 * boolean to determine whether or not gravity mode is on. True if it
	 * is gravity mode, false if not.
	 */
	private boolean gravity = false;

	/**
	 * Constructs a game with the given width (columns) and height (rows).
	 * This game will use a new instance of BasicGenerator to generate new
	 * shapes.
	 * 
	 * @param width
	 *            width of the game grid (number of columns)
	 * @param height
	 *            height of the game grid (number of rows)
	 */
	public MagicTetris(int width, int height) {
		super(width, height, new BasicGenerator());
	}

	@Override
	public List<Position> determinePositionsToCollapse() {
		List<Position> finalArr = new ArrayList<Position>();

		// If that determines which loop that needs to be used based on
		// whether gravity mode is activated.
		if (!gravity) {

			// Loop that gets each row from the grid.
			for (int i = 0; i < super.getHeight(); i++) {
				List<Position> temp = new ArrayList<Position>();
				int tempMagic = 0;

				// Loops throw a row of the grid.
				for (int j = 0; j < super.getWidth(); j++) {
					if (super.getBlock(i, j) != null) {
						if (super.getBlock(i, j).isMagic()) tempMagic++;

						temp.add(new Position(i, j));
					}
				}

				// If the temp List is the same size as the width of the grid, the
				// coordinates get added to the List that is returned.
				if (temp.size() == super.getWidth()) {
					if (tempMagic >= 3) gravity = true;
					
					// Adds score as defined in the PDF.
					score += (int) Math.pow(2, tempMagic);
					
					finalArr.addAll(temp);
				}
			}
		}
		else {
			gravity = false;

			// Loop to check each column.
			for (int i = 0; i < super.getWidth(); i++) {
				boolean block = false;

				// Checks each column for blocks.
				for (int j = 0; j < super.getHeight(); j++) {

					// Adds the empty blocks to the returned array if there is a block
					// above it.
					if (super.getBlock(j, i) != null) {
						block = true;
					}
					else if (block) {
						finalArr.add(new Position(j, i));
					}
				}
			}
		}

		return finalArr;
	}

	@Override
	public int determineScore() {
		return score;
	}
}
