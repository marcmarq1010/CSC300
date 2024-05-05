
public class Passenger  
{
	private String passengerID;
	private String ticketClass;
	private int ticketNumber;
	
	private static int ticketCounter = 0;
	
	public Passenger()
	{
	
	}
	
	public Passenger(String ticketClass)
	{
		setTicketClass(ticketClass);
		setTicketNumber();
		setPassengerID();
	}
	
	@Override
	public String toString()
	{
		return getPassengerID();
	}

	public String getPassengerID()
	{
		return passengerID;
	}

	public void setPassengerID()
	{
		String PID = "PID_";
		
		PID = PID.concat(getTicketClass());
		
		passengerID = String.format("%s %d", PID, getTicketNumber());
	}

	public String getTicketClass()
	{
		return ticketClass;
	}

	public void setTicketClass(String tClass)
	{
		ticketClass = tClass;
	}

	public int getTicketNumber()
	{
		return ticketNumber;
	}

	public void setTicketNumber()
	{
		ticketCounter++;
		ticketNumber = ticketCounter;
	}

	public static int getTicketCounter()
	{
		return ticketCounter;
	}

	public static void setTicketCounter(int ticketCounter)
	{
		Passenger.ticketCounter = ticketCounter;
	}
	
}
