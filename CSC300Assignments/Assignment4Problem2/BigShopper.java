import java.util.Random;

public class BigShopper extends Shopper
{
	private int startTime, 
	timeShopping, 
	shoppingTimeRemaining, 
	timeIntoCheckoutLine, 
	timeOutOfCheckoutLine, 
	endTime, 
	totalTimeCheckingOut, 
	totalTimeInStore;

	public static int bigShopperCounter = 0,
	  		  		  TIMEWITHCHECKER = 2;
	
	private String bigShopperID;
	private Random randy;
	
	public BigShopper(int startTime)
	{
	super("BigShopper");
	randy = new Random(bigShopperCounter);
	setBigShopperID();
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
		timeShopping = randy.nextInt(5, 16);
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
	
	public String getBigShopperID() 
	{
		return bigShopperID;
	}
	
	public void setBigShopperID() 
	{
		bigShopperCounter += 1;
		bigShopperID = getShopperType() + bigShopperCounter;
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
	            getBigShopperID(), getStartTime(), getEndTime(), getTimeShopping(), getTotalTimeCheckingOut(), getTotalTimeInStore());
	}

}
