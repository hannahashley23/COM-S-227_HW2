package hw2;

/**
 * Simulates a card dispenser that creates a new parking card object when called on. 
 * this parking card object has a start time time stamp initialized on it that uses the time taken from the TimeClock class
 * @author hannahashley
 *
 */
public class CardDispenser {
	
	/**
	 * TimeClock instance variable that allows the method to initialize the start time on the parking card to the current time on the TimeClock
	 */
	private TimeClock startTime;

	/**
	 * Constructs a CardDispenser that uses the given clock.
	 * @param givenClock
	 */
	public CardDispenser(TimeClock givenClock)
	{
		startTime = givenClock;
	}
	
	/**
	 * Constructs and returns a new ParkingCard object. The constructed card will
	have a start time based on the current value of the card dispenser's clock and a
	payment time of zero.
	 * @return
	 * 		new parking card object
	 */	
	public ParkingCard takeCard()
	{
		ParkingCard p = new ParkingCard(startTime.getTime());
		p.setPaymentTime(0);
		return p;
	}
}
