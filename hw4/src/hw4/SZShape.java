package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/*
 * IShape implementation.
 * 
 * @author Robert Shay
 */
public class SZShape extends AbstractShape {
	private Cell[] cells = new Cell[4];

	/**
	 * Constructs a SZShape with the given position and magic state.
	 * 
	 * @param pos
	 *            Position variable to tell where the starting position
	 *            for the shape is.
	 * @param magic
	 *            Boolean that determines whether the shape has a magic
	 *            block.
	 */
	public SZShape(Position pos, boolean magic) {
		// Call to the super class to give it the position and the magic
		// boolean
		super(pos, magic);

		updateCellsLength(4);

		updateCells(new Block(Color.GREEN, magic), pos, 0);
		updateCells(new Block(Color.GREEN), new Position(pos.row() + 1, pos.col()), 1);
		updateCells(new Block(Color.GREEN), new Position(pos.row() + 1, pos.col() + 1), 2);
		updateCells(new Block(Color.GREEN), new Position(pos.row() + 2, pos.col() + 1), 3);
	}

	@Override
	public void transform() {
		cells = getCells();
		Color col = cells[0].getBlock().getColorHint();

		for (int i = 0; i < cells.length; i++) {
			if (col == Color.GREEN) {
				if (i < 2) {
					updateCells(new Block(Color.RED, cells[i].getBlock().isMagic()),
							new Position(cells[i].getRow(), cells[i].getCol() + 1), i);
				}
				else {
					updateCells(new Block(Color.RED, cells[i].getBlock().isMagic()),
							new Position(cells[i].getRow(), cells[i].getCol() - 1), i);
				}
			}
			else {
				if (i < 2) {
					updateCells(new Block(Color.GREEN, cells[i].getBlock().isMagic()),
							new Position(cells[i].getRow(), cells[i].getCol() - 1), i);
				}
				else {
					updateCells(new Block(Color.GREEN, cells[i].getBlock().isMagic()),
							new Position(cells[i].getRow(), cells[i].getCol() + 1), i);
				}
			}
		}
	}
}
