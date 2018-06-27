package hw2;

/**
 * Simplified model of American baseball. THIS CODE WILL NOT COMPILE UNTIL YOU HAVE ADDED STUBS FOR
 * ALL METHODS SPECIFIED IN THE JAVADOC
 * @author Robert Shay
 */
public class CS227Baseball {
	/**
	 * Constant indicating that a pitch results in a ball.
	 */
	public static final int BALL = 0;

	/**
	 * Constant indicating that a pitch results in a strike.
	 */
	public static final int STRIKE = 1;

	/**
	 * Constant indicating that a pitch results in an out from a fly ball.
	 */
	public static final int POP_FLY = 2;

	/**
	 * Number of strikes causing a player to be out.
	 */
	public static final int MAX_STRIKES = 3;

	/**
	 * Number of balls causing a player to walk.
	 */
	public static final int MAX_BALLS = 4;

	/**
	 * Number of outs before the teams switch.
	 */
	public static final int MAX_OUTS = 3;

	// Keeps track of the max number of innings for the game
	private int innings;

	// Keeps track of the inning that the game is currently on
	private int currentInning = 1;

	/**
	 * The following two variables keep track of balls and strikes for the current batter.
	 */
	private int balls;
	private int strikes;

	// Keeps track of the outs for the current inning.
	private int outs;

	/**
	 * The following two variables store the score of each team.
	 */
	private int scoreTeam0;
	private int scoreTeam1;

	/**
	 * Variables first, second, third, and home keep track of whether somebody is on the base. True if
	 * someone is on base, false if not.
	 */
	private boolean first;
	private boolean second;
	private boolean third;
	private boolean home;

	/**
	 * Variable to keep track of whether the inning is in the top or bottom. True if top, false if not.
	 */
	private boolean atTop = true;

	/**
	 * Variable that keeps track of whether the game is over. True if the game is over, false if not.
	 */
	private boolean gameOver;

	/**
	 * Constructs a game that has the given number of innings and starts. at the top of inning 1
	 * @param givenNumInnings The number of innings of the game that is given when the game is created.
	 */
	public CS227Baseball(int givenNumInnings) {
		innings = givenNumInnings;
	}

	/**
	 * Returns the number of balls for the current batter.
	 * @return
	 */
	public int getBalls() {
		return balls;
	}

	/**
	 * Returns the current inning.
	 * @return
	 */
	public int getInning() {
		return currentInning;
	}

	/**
	 * Returns the number of outs for the current batter.
	 * @return
	 */
	public int getOuts() {
		return outs;
	}

	/**
	 * Returns the score of the indicated team, where an argument of true indicates team 0 (batting in
	 * the top of the inning) and an argument of false indicates team 1 (batting in the bottom of the
	 * inning).
	 * @param team0 True for team that bats first, false for team that batted second.
	 * @return
	 */
	public int getScore(boolean team0) {
		if (team0) {
			return scoreTeam0;
		}
		else {
			return scoreTeam1;
		}
	}

	/**
	 * Returns the number of strikes for the current batter.
	 * @return
	 */
	public int getStrikes() {
		return strikes;
	}

	/**
	 * Returns true if the game is over, false otherwise.
	 * @return
	 */
	public boolean isOver() {
		return gameOver;
	}

	/**
	 * Returns true if it's the first half of the inning (team 0 is at bat).
	 * @return
	 */
	public boolean isTop() {
		return atTop;
	}

	/**
	 * Pitch not resulting in a hit.
	 * @param outcome Outcome 0 is a ball, outcome 1 is a strike, and outcome 3 is a pop fly.
	 */
	public void pitch(int outcome) {
		if (!isOver()) {
			if (outcome == BALL) {
				balls++;

				if (balls == MAX_BALLS) {
					advanceRunners(true);
				}
			}
			if (outcome == STRIKE) {
				strikes++;

				if (strikes == MAX_STRIKES) {
					outs++;
					strikes = 0;
					balls = 0;
				}
			}
			if (outcome == POP_FLY) {
				outs++;
				strikes = 0;
				balls = 0;
			}
		}

		if (outs == MAX_OUTS) {
			if (!isTop())
				currentInning++;
			outs = 0;
			first = false;
			second = false;
			third = false;
			atTop = !atTop;
		}

		if (currentInning > innings)
			gameOver = true;
	}

	/**
	 * Pitch resulting in a hit where no player is out.
	 * @param numBases The number of bases that the batter runs. Given when the method is called.
	 */
	public void pitchWithHit(int numBases) {
		if (numBases == 1) {
			advanceRunners(true);
		}

		if (numBases == 2) {
			advanceRunners(true);
			advanceRunners(false);
		}

		if (numBases == 3) {
			advanceRunners(true);
			advanceRunners(false);
			advanceRunners(false);
		}

		if (numBases == 4) {
			advanceRunners(true);
			advanceRunners(false);
			advanceRunners(false);
			advanceRunners(false);
		}
	}

	/**
	 * Pitch resulting in a hit and a possible out.
	 * @param numBases The number of bases that the batter runs. Given when the method is called.
	 * @param whichBaseFielded The base at which the ball was thrown too. There is an out if somebody is
	 * 		on the base the ball is thrown too.
	 */
	public void pitchWithHitAndOut(int numBases, int whichBaseFielded) {
		pitchWithHit(numBases);

		if (whichBaseFielded == 1 && first) {
			first = false;
			outs++;
		}
		if (whichBaseFielded == 2 && second) {
			second = false;
			outs++;
		}
		if (whichBaseFielded == 3 && third) {
			third = false;
			outs++;
		}
		if (whichBaseFielded == 4 && home) {
			if (isTop()) {
				scoreTeam0--;
			}
			else {
				scoreTeam1--;
			}
			outs++;
		}

		if (outs == MAX_OUTS) {
			if (!isTop())
				currentInning++;
			outs = 0;
			first = false;
			second = false;
			third = false;
			atTop = !atTop;
		}

		if (currentInning > innings)
			gameOver = true;
	}

	/**
	 * Advances all players on base by one base, updating the score if there is currently a player on
	 * third. If the argument newPlayerOnFirst is true, a player (i.e. the batter) is placed on first
	 * base. Parameters:
	 * @param newPlayerOnFirst True if a new player is on first, false if not.
	 */
	public void advanceRunners(boolean newPlayerOnFirst) {
		if (!isOver()) {
			strikes = 0;
			balls = 0;
			home = third;
			third = second;
			second = first;

			if (newPlayerOnFirst) {
				first = true;
			}
			else {
				first = false;
			}

			if (home) {
				{
					if (isTop()) {
						scoreTeam0++;
					}
					else {
						scoreTeam1++;
					}
				}
			}
		}
	}

	/**
	 * Returns whether there is a player on first base.
	 * @return
	 */
	public boolean playerOnFirst() {
		return first;
	}

	/**
	 * Returns whether there is a player on second base.
	 * @return
	 */
	public boolean playerOnSecond() {
		return second;
	}

	/**
	 * Returns whether there is a player on third base.
	 * @return
	 */
	public boolean playerOnThird() {
		return third;
	}

	/**
	 * Returns a three-character string representing the players on base, in the order first, second,
	 * and third, where 'X' indicates a player is present and 'o' indicates no player. For example, the
	 * string "XXo" means that there are players on first and second but not on third.
	 * @return three-character string showing players on base
	 */

	public String getBases() {
		return (playerOnFirst() ? "X" : "o") + (playerOnSecond() ? "X" : "o") + (playerOnThird() ? "X" : "o");
	}

	/**
	 * Returns a one-line string representation of the current game state. The format is:
	 *
	 * <pre>
	 *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
	 * </pre>
	 *
	 * The first three characters represent the players on base as returned by the
	 * <code>getBases()</code> method. The 'T' after the inning number indicates it's the top of the
	 * inning, and a 'B' would indicate the bottom.
	 * @return one-line string representation of the game state
	 */

	public String toString() {
		String bases = getBases();
		String topOrBottom = (isTop() ? "T" : "B");
		String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
		return String.format(fmt, bases, getInning(), topOrBottom, getScore(true), getScore(false), getBalls(),
				getStrikes(), getOuts());
	}

	/**
	 * Returns a multi-line string representation of the current game state. The format is:
	 *
	 * <pre>
	 *     o - o    Inning:1 (T)
	 *     |   |    Score:0-0
	 *     o - H    Balls:0 Strikes:0 Outs:0
	 * </pre>
	 *
	 * The 'T' after the inning number indicates it's the top of the inning, and a 'B' would indicate
	 * the bottom.
	 * @return multi-line string representation of current game state
	 */
	public String toDisplayString() {
		String firstChar = (playerOnFirst() ? "X" : "o");
		String secondChar = (playerOnSecond() ? "X" : "o");
		String thirdChar = (playerOnThird() ? "X" : "o");
		String topOrBottom = (isTop() ? "T" : "B");
		String firstLine = String.format("%s - %s    Inning:%d (%s)\n", secondChar, firstChar, getInning(),
				topOrBottom);
		String secondLine = String.format("|   |    Score:%d-%d\n", getScore(true), getScore(false));
		String thirdLine = String.format("%s - H    Balls:%d Strikes:%d Outs:%d\n", thirdChar, getBalls(), getStrikes(),
				getOuts());
		return firstLine + secondLine + thirdLine;
	}
}