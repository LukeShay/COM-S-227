package hw4;

import java.awt.Color;

import api.Block;
import api.Position;


/*
 * JShape implementation.
 * 
 * @author Robert Shay
 */
public class LShape extends AbstractShape {

	/**
	 * Constructs an LShape with the given position and magic state.
	 * 
	 * @param pos
	 *            Position variable to tell where the starting position
	 *            for the shape is.
	 * @param magic
	 *            Boolean that determines whether the shape has a magic
	 *            block.
	 */
	public LShape(Position pos, boolean magic) {
		// Call to the super class to give it the position and the magic
		// boolean
		super(pos, magic);

		updateCellsLength(4);

		updateCells(new Block(Color.ORANGE, magic), pos, 0);
		updateCells(new Block(Color.ORANGE), new Position(pos.row() + 1, pos.col() - 2), 1);
		updateCells(new Block(Color.ORANGE), new Position(pos.row() + 1, pos.col() - 1), 2);
		updateCells(new Block(Color.ORANGE), new Position(pos.row() + 1, pos.col()), 3);
	}

}
