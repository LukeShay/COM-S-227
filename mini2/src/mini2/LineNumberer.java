package mini2;

import api.Transformation;

/**
 * Transformation whose <code>apply</code> method prepends a line
 * number to each string. For a newly created LineNumberer, the line
 * numbers start at 1 and increase on each successive call. The line
 * number is left-justified in a field 5 spaces wide.
 */
public class LineNumberer implements Transformation {

	private int c = 0;

	public LineNumberer() {

	}

	@Override
	public String apply(String s) {
		c++;
		return String.format("%-5d", c) + s;
	}
}
