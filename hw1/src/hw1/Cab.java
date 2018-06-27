package hw1;

public class Cab
{

	// Declare private variables for the class
	private double fare;
	private double rate;
	private double miles;
	private double totalCash;
	private double totalMiles;
	private double currentRate = 0;
	private double meter;

	/**
	 * Constructs a cab base fare and rate are given in the program
	 */
	public Cab(double givenBaseFare, double givenPerMileRate)
	{
		fare = givenBaseFare;
		rate = givenPerMileRate;
	}

	/**
	 * Adds miles to the current drive Calculates the meter and the total
	 * miles and total cash
	 */
	public void drive(double givenMiles)
	{
		miles += givenMiles;
		totalMiles += givenMiles;
	}

	/**
	 * "Drops off" the passenger Sets meter and current rate to 0
	 */
	public void dropOff()
	{
		totalCash += miles * currentRate + fare;
		miles = 0;
		currentRate = 0;
		meter = 0;
	}

	/**
	 * Calculates and returns the average income per mile driven
	 * 
	 * @return total cash divided by total miles
	 */
	public double getAverageIncomePerMile()
	{
		return totalCash / totalMiles;
	}

	/**
	 * Returns current rate
	 * 
	 * @return
	 */
	public double getCurrentRate()
	{
		return currentRate;
	}

	/**
	 * Calculates and returns the current cost for the ride
	 * 
	 * @return Displays what is on the meter
	 */
	public double getMeter()
	{
		return meter += miles * currentRate;
	}

	/**
	 * Returns the total cash that the cab has earned
	 * 
	 * @return
	 */
	public double getTotalCash()
	{
		return totalCash;
	}

	/**
	 * Returns the total miles that the cab has driven
	 * 
	 * @return
	 */
	public double getTotalMiles()
	{
		return totalMiles;
	}

	/**
	 * Returns whether the cab has a passenger
	 * 
	 * @return
	 */
	public boolean hasPassenger()
	{
		return currentRate != 0;
	}

	/**
	 * "Picks up" a passenger Sets current rate to the rate and the meter
	 * to the initial fare
	 */
	public void pickUp()
	{
		currentRate = rate;
		miles = 0;
		meter = fare;
	}
}
