package mini2;

import api.Selector;

/**
 * Selector that returns false if the current string is within a
 * javadoc comment, true otherwise. Using a NonJavadocSelector in the
 * filter method of a StringList has the effect of removing all
 * javadoc comments. Note that we are assuming that javadoc comments
 * always start and end on different lines, and that no executable
 * code ever appears on the same line as a javadoc comment.
 */
public class NonJavadocSelector implements Selector {
	private boolean YeeHaw = true;

	public NonJavadocSelector() {

	}

	@Override
	public boolean select(String s) {
		String t = s.trim();
		if (t.length() == 0) {
			return true;
		}
		if (t.charAt(0) == '/' && t.charAt(1) == '*' && t.charAt(2) == '*' && YeeHaw) {
			YeeHaw = false;
			return false;
		}
		if (t.charAt(t.length() - 1) == '/' && t.charAt(t.length() - 2) == '*' && !YeeHaw) {
			YeeHaw = true;
			return false;
		}
		if (!YeeHaw) {
			return false;
		}

		return true;
	}
}
