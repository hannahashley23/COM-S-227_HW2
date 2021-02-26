package hw2;

/**
 * Simulates an exit gate that tales in a parking card and reads it's payment time. 
 * If payment time exceeds exit time limit, user will be denied the ability to exit and be sent back to the pay station
 * Amount of total exits is also kept track of within this class
 * @author hannahashley
 *
 */
public class ExitGate {
	
	/**
	 * TimeClock variable that allows the exit gate to access the current time and compare it to the parking card's payment time
	 */
	private TimeClock currentTime;
	
	/**
	 * Keeps track of exitCount that is constantly updated whenever a user has a successful exit
	 */
	private int exitCount;

	/**
	 * Constructs an ExitGate that uses the given clock and has an initial count of zero
	 * @param givenClock
	 */
	public ExitGate(TimeClock givenClock)
	{
		currentTime = givenClock;
		exitCount = 0;
	}
	
	/**
	 * Simulates inserting a card into this machine. If the card's payment time is within
	RateUtil.EXIT_TIME_LIMIT minutes of this machine's clock time (and is greater
	than zero), the method returns true. Otherwise the method returns false. The
	ParkingCard object is not modified. If the method returns true, this machine's exit count is incremented. (Note that this method is a mutator method that also
	returns a value.)
	 * @param c
	 * @return
	 * 		returns whether or not the user has exceeded the exit time limit
	 */
	public boolean insertCard(ParkingCard c)
	{
		int timeOfPayment = c.getPaymentTime();
		
		if ((currentTime.getTime() - timeOfPayment)  < RateUtil.EXIT_TIME_LIMIT)
		{
			exitCount += 1;
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	/**
	 * Returns a count of the total number of successful exits. A "successful exit" is
	defined to be a call to insertCard() that returns true.
	 * @return
	 * 		total number of successful exits
	 */
	public int getExitCount()
	{
		return exitCount;
	}
}
