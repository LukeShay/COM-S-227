package mini2;

import api.Selector;

/**
 * Selector whose <code>select</code> method returns false for strings
 * whose first non-whitespace text is "//", and true for all other
 * strings.
 */
public class NonLineCommentSelector implements Selector {

	@Override
	public boolean select(String s) {
		String t = s.trim();
		if (t.length() == 0 || t.length() == 1) {
			return true;
		}

		if (t.charAt(0) == '/' && t.charAt(1) == '/') {
			return false;
		}
		return true;
	}
	// TODO
}