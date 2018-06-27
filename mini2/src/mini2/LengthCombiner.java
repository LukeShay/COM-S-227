package mini2;

import api.Combiner;

/**
 * Adds the length of the given string to the accumulator and returns
 * the result.
 */
public class LengthCombiner implements Combiner<Integer> {
	public static void main(String[] args) {
		LengthCombiner len = new LengthCombiner();

		System.out.println(len.combine(4, "Hello"));
	}

	public LengthCombiner() {

	}

	@Override
	public Integer combine(Integer obj, String s) {
		int num = s.length();
		return obj + num;
	}
}