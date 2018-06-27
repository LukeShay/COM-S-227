package mini2;

import api.Combiner;

/**
 * Combiner whose <code>combine</code> method, given an Integer n and
 * a string, returns n if the string is a blank line or a line
 * containing a single curly brace; otherwise returns n + 1. (A curly
 * brace on a line whose only other text is an end-of-line comment is
 * treated as just a curly brace.) Using a SlocCounter in the reduce
 * method has the general effect of counting the number of "source
 * lines of code" that are actual program statements, assuming that
 * line comments and javadoc comments have already been filtered out.
 */
public class SlocCounter implements Combiner<Integer> {
	public SlocCounter() {

	}

	@Override
	public Integer combine(Integer obj, String s) {
		int brace = 0;
		if (s.trim().length() == 0 || s.trim().charAt(0) == '}' && s.trim().length() == 1) {
			return obj;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				brace++;
			}
		}
		/*
		 * for(int i = 0; i < s.length(); i++) { if(open && s.charAt(i) ==
		 * '}') { return obj + 1; } }
		 */

		if (brace == 1 || s.trim().charAt(0) == '/' && s.trim().charAt(1) == '/') {
			return obj;
		}

		return obj + 1;
	}
}