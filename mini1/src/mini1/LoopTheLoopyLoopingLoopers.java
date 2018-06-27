package mini1;

public class LoopTheLoopyLoopingLoopers {
	
	private LoopTheLoopyLoopingLoopers() {
		// do nothing
	}

	public static int countIterations(double x, double err) {
		double answer = x;
		int i;

		for (i = 0; Math.abs((answer * answer) - x) >= err; i++) {
			answer = (answer + (x / answer)) / 2.0;
		}

		return i;
	}

	public static int countOccurrences(java.lang.String t, java.lang.String s, boolean allowOverlap) {
		int c = 0;
		String str = "";

		if (allowOverlap) {
			for (int i = 0; i < s.length() - 1; i++) {
				for (int j = 0; j < t.length(); j++) {
					if (i + j >= s.length()) {
						break;
					}

					str = str + s.charAt(i + j);
				}

				if (str.equals(t)) {
					c++;
				}

				str = "";
			}
		}
		else {
			for (int i = 0; i + t.length() < s.length(); i++) {

				for (int j = 0; j < t.length(); j++) {
					str = str + s.charAt(j + i);
				}

				if (str.equals(t)) {
					c++;
					i += t.length() - 1;
				}

				str = "";
			}
		}

		return c;
	}

	public static String eliminateRuns(String s) {
		if (s.length() == 0) {
			return "";
		}

		String str = "";
		char last = s.charAt(0);

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == last) {

			}
			else {
				str = str + last;
				last = s.charAt(i);
			}
		}

		str += s.charAt(s.length() - 1);
		return str;
	}

	public static char findMostFrequentCharacter(String s) {
		int count = 0;

		char mostFreqChar = ' ';

		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			int c = 0;

			for (int j = s.indexOf(x); j != -1; j = s.indexOf(x, j + 1)) {
				c++;
			}

			if (c > count) {
				count = c;
				mostFreqChar = x;
			}
		}
		return mostFreqChar;
	}

	public static int findSecondLargest(String text) {

		// Takes string of ints and turns them into an integer array
		String[] parts = text.split(" ");
		int[] ints = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			ints[i] = Integer.parseInt(parts[i]);
		}

		int temp;

		for (int i = 0; i < ints.length; i++) {
			for (int j = i + 1; j < ints.length; j++) {
				if (ints[i] > ints[j]) {
					temp = ints[i];
					ints[i] = ints[j];
					ints[j] = temp;
				}
			}
		}
		return ints[ints.length - 2];
	}

	public static boolean isLucasSequence(String text) {
		String[] parts = text.split(" ");
		int[] ints = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			ints[i] = Integer.parseInt(parts[i]);
		}

		for (int i = 0; i < ints.length - 2; i++) {
			if (ints[i] + ints[i + 1] != ints[i + 2]) {
				return false;
			}
		}

		return true;
	}

	public static String mergePreservingRuns(String t, String s) {
		if (s == "") {
			return t;
		}
		else if (t == "") {
			return s;
		}

		int countt = 1;
		int counts = 1;

		String strt[] = new String[100];
		String strs[] = new String[100];

		for (int i = 0; i < 100; i++) {
			strt[i] = "";
			strs[i] = "";
		}

		int j = 0;
		int k = 0;

		for (int i = 0; i < 100; i++) {
			strt[i] = "" + t.charAt(j);
			while (j < t.length() - 1) {
				j++;
				if (t.charAt(j - 1) == t.charAt(j)) {
					strt[i] += t.charAt(j);
				}
				else {
					countt++;
					break;
				}
			}

			strs[i] = "" + s.charAt(k);
			while (k < s.length() - 1) {
				k++;
				if (s.charAt(k - 1) == s.charAt(k)) {
					strs[i] += s.charAt(k);
				}
				else {
					counts++;
					break;
				}
			}
		}

		String str = "";
		for (int i = 0; i < 100; i++) {
			if (i < countt) {
				str += strt[i];
			}

			if (i < counts) {
				str += strs[i];
			}
		}
		return str;

	}

	public static String takeApartPreservingRuns(String s) {
		if (s == "") {
			return " ";
		}

		String runs[] = new String[100];

		for (int i = 0; i < 100; i++) {
			runs[i] = "";
		}
		int count = 0;
		int j = 0;

		for (int i = 0; i < 100; i++) {
			runs[i] = "" + s.charAt(j);
			while (j < s.length() - 1) {
				j++;
				if (s.charAt(j - 1) == s.charAt(j)) {
					runs[i] += s.charAt(j);
				}
				else {
					count++;
					break;
				}
			}
		}

		String one = "";
		String two = "";

		for (int i = 0; i <= count; i += 2) {
			one += runs[i];
		}

		for (int i = 1; i <= count; i += 2) {
			two += runs[i];
		}

		return one + " " + two;
	}
}
