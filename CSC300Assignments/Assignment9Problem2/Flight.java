import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Flight
{
	private String flightName;
	private int seats;
	private int seatsSold;
	private Random randy; 
	
	PassengerComparator pComp = new PassengerComparator();
	
	private LinkedList<Passenger> passBooked  = new LinkedList<Passenger>();	
	private PriorityQueue<Passenger> boardingQueue = new PriorityQueue<Passenger>(pComp);
	
	public Flight()
	{
		
	}
	
	public Flight(String flightName, int seed)
	{				
		setFlightName(flightName);
		randy = new Random(seed);
		setSeats();
	}
	
	public void sellSeats()
	{	
		seatsSold = (seats / 2) + (randy.nextInt(0, 2 + seats / 2));

	    for (int i = 0; i < seatsSold; i++)
	    {
	        int randomNum = randy.nextInt(5);
	        
	        if (randomNum == 0)
	            passBooked.add(new FirstClassPassenger());
	        else
	            passBooked.add(new CoachPassenger());
	    }

	}
	
	public void lineUpCall()
	{
		Iterator <Passenger> iterator = passBooked.iterator();
		 
		while(iterator.hasNext())
		{
			//Passenger passenger = iterator.next();
			boardingQueue.add(iterator.next());
		}
	}
	
	public void boarding(PrintWriter outputWriter)
	{
	    outputWriter.printf("The boarding order for Flight %s with %s seats and %s seats sold is:\n", getFlightName(), getSeats(), getSeatsSold());

	    int columnCount = 0;

	    for (Passenger passenger : boardingQueue)
	    {
	        // Output passenger's seat information
	        outputWriter.printf("%-15s\t", passenger);

	        columnCount++;

	        if (columnCount % 3 == 0)
	        {
	            outputWriter.println();
	        }
	    }
	    outputWriter.println();
	}


	public String getFlightName()
	{
		return flightName;
	}

	public void setFlightName(String fName)
	{
		flightName = fName;
	}

	public int getSeats()
	{
		return seats;
	}

	public void setSeats()
	{
		seats = randy.nextInt(75,151);
	}

	public int getSeatsSold()
	{
		return seatsSold;
	}

	public void setSeatsSold(int seatsSold)
	{
		this.seatsSold = seatsSold;
	}

	public Random getRandy()
	{
		return randy;
	}

	public void setRandy(Random randy)
	{
		this.randy = randy;
	}

	public LinkedList<Passenger> getPassBooked()
	{
		return passBooked;
	}

	public void setPassBooked(LinkedList<Passenger> passBooked)
	{
		this.passBooked = passBooked;
	}

	public PriorityQueue<Passenger> getBoardingQueue()
	{
		return boardingQueue;
	}

	public void setBoardingQueue(PriorityQueue<Passenger> boardingQueue)
	{
		this.boardingQueue = boardingQueue;
	}
	
}
