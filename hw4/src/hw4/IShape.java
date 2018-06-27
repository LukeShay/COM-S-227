package hw4;

import java.awt.Color;

import api.Block;
import api.Position;

/*
 * IShape implementation.
 * 
 * @author Robert Shay
 */
public class IShape extends AbstractShape {

	/**
	 * Constructs an IShape with the given position and magic state.
	 * 
	 * @param pos
	 *            Position variable to tell where the starting position
	 *            for the shape is.
	 * @param magic
	 *            Boolean that determines whether the shape has a magic
	 *            block.
	 */
	public IShape(Position pos, boolean magic) {
		// Call to the super class to give it the position and the magic
		// boolean
		super(pos, magic);

		updateCellsLength(3);
		
		updateCells(new Block(Color.CYAN, magic), pos, 0);
		updateCells(new Block(Color.CYAN), new Position(pos.row() + 1, pos.col()), 1);
		updateCells(new Block(Color.CYAN), new Position(pos.row() + 2, pos.col()), 2);
	}
}
