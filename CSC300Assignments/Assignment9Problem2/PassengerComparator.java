import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger>
{

	@Override
	public int compare(Passenger p1, Passenger p2)
	{
		if(p1.getTicketClass().equalsIgnoreCase(p2.getTicketClass()))
			return Integer.compare(p1.getTicketNumber(), p2.getTicketNumber());
		
		else if(p1.getTicketClass().equals("First"))
			return -1;

		else if(p2.getTicketClass().equals("First"))
			return 1;
		else
			return 0;
	}

}