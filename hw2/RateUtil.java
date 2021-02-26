package hw2;

/**
 * This is a "utility" class, that is, it has no instance variables, is never instantiated, and
	serves only as a container for one or more static methods. (Similar to the class Math.)
 * @author hannahashley
 *
 */
public class RateUtil {
	
	/**
	 * Constructor that remains private since this class should never be instantiated
	 */
	private RateUtil() {
		
	}
	
	/**
	 * Constant variable that represents maximum time user is allowed to exit before having to pay again
	 */
	public static final int EXIT_TIME_LIMIT = 15;
	
	/**
	 * Returns the cost of parking for the given total number of minutes, based on the
	current rates for the MU garage. See the section "Current parking rates", below,
	for details.
	 * @param minutes
	 * @return
	 * 		cost owed for the amount of minutes stayed
	 */
	public static double calculateCost(int minutes)
	{
		double finalCost;
		int numDays = 0;
		
		if (minutes <= 30)
		{
			finalCost = 1.00;
		}
		
		else if (minutes > 30 && minutes <= 60)
		{
			finalCost = 2.00;
		}
		
		else if (minutes > 60 && minutes <= 300)
		{
			finalCost = 2.00 + ((int)Math.ceil(minutes / 60.0) - 1) * 1.50;
		}
		
		else if (minutes > 300 && minutes <= 480)
		{
			finalCost = 8.00 + ((int)Math.ceil(minutes / 60.0) - 5) * 1.25;
		}
		
		else if (minutes > 480 && minutes <= 1440)
		{
			finalCost = 13.00;
		}
		
		else 
		{
			numDays += 1;
			int remainingMinutes = (minutes - 1440) ;
			finalCost = numDays * 13.00 + calculateCost(remainingMinutes);
		}
		
		return finalCost;
	
	}
}
