package hw4;

import java.awt.Color;

import api.Block;
import api.Position;

/*
 * IShape implementation.
 * 
 * @author Robert Shay
 */
public class TShape extends AbstractShape {

	/**
	 * Constructs a TShape with the given position and magic state.
	 * 
	 * @param pos
	 *            Position variable to tell where the starting position
	 *            for the shape is.
	 * @param magic
	 *            Boolean that determines whether the shape has a magic
	 *            block.
	 */
	public TShape(Position pos, boolean magic) {
		// Call to the super class to give it the position and the magic
		// boolean
		super(pos, magic);

		updateCellsLength(4);

		updateCells(new Block(Color.MAGENTA, magic), new Position(pos.row() - 1, pos.col()), 0);
		updateCells(new Block(Color.MAGENTA), new Position(pos.row(), pos.col() - 1), 1);
		updateCells(new Block(Color.MAGENTA), new Position(pos.row(), pos.col()), 2);
		updateCells(new Block(Color.MAGENTA), new Position(pos.row(), pos.col() + 1), 3);
	}
}
