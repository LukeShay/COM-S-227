package mini2;

import api.Selector;

/**
 * Selector that returns false for a strings that are empty, that are
 * all whitespace, or whose first non-whitespace character is the '#'
 * character.
 */
public class ValidLineSelector implements Selector {

	public ValidLineSelector() {

	}

	@Override
	public boolean select(String s) {
		String str = s.trim();

		if (str.length() == 0 || str.charAt(0) == '#') {
			return false;
		}
		return true;
	}
}
