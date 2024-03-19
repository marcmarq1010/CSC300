import java.util.Random;

public class FastShopper extends Shopper
{	
	private int startTime, 
				timeShopping, 
				shoppingTimeRemaining, 
				timeIntoCheckoutLine, 
				timeOutOfCheckoutLine, 
				endTime, 
				totalTimeCheckingOut, 
				totalTimeInStore;
	
	public static int fastShopperCounter = 0,
			  		  TIMEWITHCHECKER = 1;
	
	private String fastShopperID;
	private Random randy;
	
	public FastShopper(int startTime)
{
		super("FastShopper");
		randy = new Random(fastShopperCounter);
		setFastShopperID();
		setStartTime(startTime);
		setTimeShopping();
		setShoppingTimeRemaining(timeShopping);
	}

	public int getStartTime() 
	{
		return startTime;
	}

	public void setStartTime(int startTime) 
	{
		this.startTime = startTime;
	}

	public int getTimeShopping()
	{
		return timeShopping;
	}

	public void setTimeShopping() 
	{
		timeShopping = randy.nextInt(1, 7);
	}

	public int getShoppingTimeRemaining() 
	{
		return shoppingTimeRemaining;
	}

	public void setShoppingTimeRemaining(int shoppingTimeRemaining) 
	{
		this.shoppingTimeRemaining = shoppingTimeRemaining;
	}

	public int getTimeIntoCheckoutLine() 
	{
		return timeIntoCheckoutLine;
	}

	public void setTimeIntoCheckoutLine(int timeIntoCheckoutLine) 
	{
		this.timeIntoCheckoutLine = timeIntoCheckoutLine;
	}

	public int getTimeOutOfCheckoutLine() 
	{
		return timeOutOfCheckoutLine;
	}

	public void setTimeOutOfCheckoutLine(int timeOutOfCheckoutLine) 
	{
		this.timeOutOfCheckoutLine = timeOutOfCheckoutLine;
		calculateFinalDurations();
	}

	public int getEndTime() 
	{
		return endTime;
	}

	public void setEndTime(int endTime) 
	{
		this.endTime = endTime;
	}

	public int getTotalTimeCheckingOut() 
	{
		return totalTimeCheckingOut;
	}

	public void setTotalTimeCheckingOut(int totalTimeCheckingOut) 
	{
		this.totalTimeCheckingOut = totalTimeCheckingOut;
	}

	public int getTotalTimeInStore()
	{
		return totalTimeInStore;
	}

	public void setTotalTimeInStore(int totalTimeInStore)
	{
		this.totalTimeInStore = totalTimeInStore;
	}

	public String getFastShopperID() 
	{
		return fastShopperID;
	}

	public void setFastShopperID() 
	{
		fastShopperCounter += 1;
		fastShopperID = getShopperType() + fastShopperCounter;
	}
	
	public void calculateFinalDurations()
	{
		endTime = timeOutOfCheckoutLine + TIMEWITHCHECKER;
		totalTimeCheckingOut = Math.abs(endTime - timeIntoCheckoutLine);
		totalTimeInStore = Math.abs(endTime - startTime);
	}

	@Override
	public String toString() 
	{
	    return String.format("%-13s %13d %13d %13d %13d %13d",
	            getFastShopperID(), getStartTime(), getEndTime(), getTimeShopping(), getTotalTimeCheckingOut(), getTotalTimeInStore());
	}

}
