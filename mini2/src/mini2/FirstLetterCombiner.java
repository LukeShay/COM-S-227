package mini2;

import api.Combiner;

/**
 * Combiner that appends the first letter of a string onto the
 * accumulator. If the string is empty, returns the accumulator.
 */
public class FirstLetterCombiner implements Combiner<String> {
	public static void main(String[] args) {

	}

	public FirstLetterCombiner() {

	}

	@Override
	public String combine(String obj, String s) {
		if (s.trim().length() != 0) {

			return obj + s.trim().charAt(0);
		}
		return obj;
	}
}
