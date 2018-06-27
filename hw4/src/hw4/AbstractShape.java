
package hw4;

import api.Cell;
import api.Block;
import api.Shape;
import api.Position;

/**
 * Abstract superclass for implementations of the Shape interface.
 * 
 * @author Robert Shay
 */
public abstract class AbstractShape implements Shape {

	/**
	 * Position variable that stores the starting position of the shape.
	 */
	private Position donde;

	/**
	 * Cell array that keeps track of the cells of the shape.
	 */
	private Cell cells[];

	/**
	 * int variable that is used to keep track of the number of cycles of the magic block.
	 */
	private int cycle = 0;
	
	/**
	 * boolean to keep track of wether there is a magic block in the current shape.
	 */
	private boolean magic;

	/**
	 * Constructor to create an abstract shape.
	 * 
	 * @param pos
	 *            Given starting position of the shape.
	 * @param magic
	 *            Boolean for whether the shape has a magic block.
	 */
	protected AbstractShape(Position pos, boolean magic) {
		donde = pos;
		this.magic = magic;
	}

	@Override
	public Shape clone() {
		try {
			AbstractShape s = (AbstractShape) super.clone();

			// Then make it into a deep copy
			s.donde = new Position(donde);
			s.cells = new Cell[cells.length];
			for (int i = 0; i < cells.length; i++) {
				s.cells[i] = new Cell(cells[i]);
			}
			return s;
		}
		catch (CloneNotSupportedException e) {
			// can't happen
			return null;
		}
	}

	@Override
	public Cell[] getCells() {
		Cell[] copy = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			copy[i] = new Cell(cells[i]);
		}
		return copy;
	}

	@Override
	public void shiftDown() {
		donde.setRow(donde.row() + 1);
		for (int i = 0; i < cells.length; i++) {
			cells[i].setRow(cells[i].getRow() + 1);
		}
	}

	@Override
	public void shiftLeft() {
		donde.setCol(donde.col() - 1);
		for (int i = 0; i < cells.length; i++) {
			cells[i].setCol(cells[i].getCol() - 1);
		}
	}

	@Override
	public void shiftRight() {
		donde.setCol(donde.col() + 1);
		for (int i = 0; i < cells.length; i++) {
			cells[i].setCol(cells[i].getCol() + 1);
		}
	}

	@Override
	public void transform() {
		int col = donde.col();
		int row = donde.row();

		for (int i = 0; i < cells.length; i++) {
			int tempRow = cells[i].getRow() - row;
			cells[i].setRow(((cells[i].getCol() - col) * -1) + row);
			cells[i].setCol(tempRow + col);
		}

	}

	@Override
	public void cycle() {
		cycle++;
		if (cycle == cells.length && magic) {
			cells[0].setBlock(new Block(cells[0].getBlock().getColorHint(), magic));
			cells[cycle - 1].setBlock(new Block(cells[cycle - 1].getBlock().getColorHint(), false));
			cycle = 0;
		}
		else if(magic){
			cells[cycle].setBlock(new Block(cells[cycle].getBlock().getColorHint(), magic));
			cells[cycle - 1].setBlock(new Block(cells[cycle - 1].getBlock().getColorHint(), false));
		}
	}

	/**
	 * Updates the length of cells[] to the given length.
	 * 
	 * @param length
	 *            Given number of cells in the shape.
	 */
	protected void updateCellsLength(int length) {
		cells = new Cell[length];
	}

	/**
	 * Updates a cell from cells[] at the given index.
	 * 
	 * @param block
	 *            The given block to be used to update the cell.
	 * @param pos
	 *            The given position to be used to update the cell.
	 * @param index
	 *            The given index of the cell that needs to be updated.
	 */
	protected void updateCells(Block block, Position pos, int index) {
		cells[index] = new Cell(block, pos);
	}
}
