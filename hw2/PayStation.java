package hw2;

/**
 * A PayStation has methods allowing a ParkingCard object to be updated to show when
payment is made. In addition, the PayStation
includes an accumulator that records the total amount of money paid into the machine
since it was initialized.
 * @author hannahashley
 *
 */
public class PayStation {
	
	/**
	 * variable of type TimeClock so that methods from that class can be called on from the PayStation class
	 */
	private TimeClock currentTime;
	
	/**
	 * variable of type ParkingCard so that methods from the ParkingCard class can be called on from the PayStation class
	 */
	private ParkingCard currentCard;
	
	/**
	 * double variable that keeps track of the total payments made into this pay station
	 */
	private double totalPayments;
	
	/**
	 * boolean variable that keeps track of whether a transaction is in progress or not
	 */
	private boolean cardInMachine;

	
	/**
	 * Constructs a PayStation that uses the given clock. Initially, total payments are
		0.0.
	 * @param givenClock
	 */
	public PayStation(TimeClock givenClock)
	{
		currentTime = givenClock;
		totalPayments =  0.0;
	}
	
	/**
	 * Simulates inserting the given card into this machine. This method does not
	modify the ParkingCard object or perform any calculation with it. After calling
	this method, the inProgress() method returns true until a subsequent call to
	ejectCard(). Calling insertCard() while a transaction is in progress has no
	effect.
	 * @param t
	 */
	public void insertCard(ParkingCard t)
	{
		currentCard = t;
		cardInMachine = true;
	}
	
	/**
	 * Returns a reference to the card currently in this machine, or null if no transaction
		is in progress.
	 * @return
	 * 		whether or not a card is in the machine
	 */
	public ParkingCard getCurrentCard()
	{
		if (cardInMachine)
		{
			return currentCard;
		}
		
		else 
		{
			return null;
		}
	}
	
	/**
	 * Returns true if there is currently a card in this machine, false otherwise.
	public double
	 * @return
	 * 		whether or not a transaction is currently in progress
	 */
	public boolean inProgress()
	{
		 return cardInMachine;
	}
	
	/**
	 * Returns the payment due for the card currently in the machine. If no transaction
	is in progress, returns 0.0. This method does not modify the ParkingCard object
	or update this machine's total payments. The payment due is based the current
	time (according to this machine's clock) and on the start time and payment time
	for the current card. The basic amount due is the result of calling
	RateUtil.calculateCost() for the difference current time - start time.
	However, if the payment time is nonzero (indicating that some payment was
	already made), the cost of parking from start time to payment time (i.e., the
	amount that must have already been paid) is subtracted from the amount due.
	 * @return
	 * 		payment that is due
	 */
	
	public double getPaymentDue()
	{
		double paymentDue = 0.0;
		
		if(cardInMachine)
		{
			if(currentCard.getPaymentTime() > 0)
			{	
			//paymentDue = RateUtil.calculateCost(currentTime.getTime() - currentCard.getStartTime()) - RateUtil.calculateCost((currentCard.getPaymentTime() - currentCard.getStartTime()));
			paymentDue = RateUtil.calculateCost(currentTime.getTime() - currentCard.getStartTime()) - RateUtil.calculateCost((currentCard.getPaymentTime() - currentCard.getStartTime()));
				return paymentDue;
			}
			
			else
			{
				paymentDue = RateUtil.calculateCost((currentTime.getTime() - currentCard.getStartTime()));
				return paymentDue;
			}
		}
		
		else 
		{
			return paymentDue;
		}	
	}
	
	/**
	 * Updates the current card with the payment time and adds the payment amount to
	this machine's total. If there is no transaction in progress, this method has no
	effect
	 */
	public void makePayment()
	{
		if (cardInMachine)
		{
			totalPayments += getPaymentDue();
			currentCard.setPaymentTime(currentTime.getTime());
		}
	}
	
	/**
	 * Simulates ejecting a card from this machine, after which another card can be
	inserted. This method does not modify the current card object or update this
	machine's total payments. If there is no transaction in progress, this method has
	no effect.
	 */
	public void ejectCard()
	{
		cardInMachine = false;
	}
	
	/**
	 * Returns the total payments that have been made at this machine.
	 * @return
	 * 		total payments made to this paystation
	 */
	public double getTotalPayments()
	{
		return totalPayments;
	}
}
