import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Supermarket 
{
	private String superName;
	private Random randy;
	private int bigCheckerOccupied = 0;
	private int fastCheckerOccupied = 0;
	
	private ArrayList<Shopper> currentShoppers = new ArrayList<Shopper>();
	private ArrayList<BigShopper> bigCheckOut = new ArrayList<BigShopper>();
	private ArrayList<FastShopper> fastCheckOut = new ArrayList<FastShopper>();
	private ArrayList<Shopper> doneShopping = new ArrayList<Shopper>();
	
	public Supermarket(String superName, int randySeed)
	{
		setSuperName(superName);
		randy = new Random(randySeed);
	}

	public String getSuperName() 
	{
		return superName;
	}

	public void setSuperName(String superName) 
	{
		this.superName = superName;
	}

	public void openSupermarket()
	{
		for(int i = 0; i < 14; i++)
		{
			if(i % 3 == 0)
			{
                currentShoppers.add(new BigShopper(0));
			}
			else
			{
                currentShoppers.add(new FastShopper(0));
			}
		}
	}
	
	public void operateSupermarket(int minutes) 
	{
		int minCounter = 1;
		
		while(!currentShoppers.isEmpty() || !bigCheckOut.isEmpty() || !fastCheckOut.isEmpty())
		{
			if(minCounter <= minutes && minCounter % 5 == 0)
			{
				for(int i = 0; i < 9; i++)
				{
					if(i % 3 == 0)
					{
                        currentShoppers.add(new BigShopper(minCounter));
					}
					else
					{
                        currentShoppers.add(new FastShopper(minCounter));
					}
				}
			}
			
			for(int i = 0; i < currentShoppers.size(); i++)
			{
                Shopper tempShopper = currentShoppers.get(i);
                
                tempShopper.setShoppingTimeRemaining(tempShopper.getShoppingTimeRemaining() - 1);
                
                if (tempShopper.getShoppingTimeRemaining() == 0)
                {
                    if (tempShopper instanceof BigShopper)
                    {
                        BigShopper tempBig = (BigShopper) tempShopper;
                        tempBig.setTimeIntoCheckoutLine(minCounter);
                        bigCheckOut.add(tempBig);
                    }
                    else
                    {
                        FastShopper tempFast = (FastShopper) tempShopper;
                        tempFast.setTimeIntoCheckoutLine(minCounter);
                        fastCheckOut.add(tempFast);
                    }
                    
                    currentShoppers.remove(tempShopper);
                    i--;
                }
			}	
			
			if(!bigCheckOut.isEmpty() && bigCheckerOccupied == 0) 
			{
	            BigShopper tempBig = bigCheckOut.remove(0);
	            tempBig.setTimeOutOfCheckoutLine(minCounter);
	            doneShopping.add(tempBig);
	            bigCheckerOccupied = BigShopper.TIMEWITHCHECKER;
	        }
			else if(bigCheckerOccupied != 0) 
			{
	            bigCheckerOccupied--;
	        }

	        if(!fastCheckOut.isEmpty() && fastCheckerOccupied == 0) 
	        {
	            FastShopper tempFast = fastCheckOut.remove(0);
	            tempFast.setTimeOutOfCheckoutLine(minCounter);
	            doneShopping.add(tempFast);
	            fastCheckerOccupied = FastShopper.TIMEWITHCHECKER;
	        }
	        else if(fastCheckerOccupied != 0)
	        {
	            fastCheckerOccupied--;
	        }

	        minCounter++;
		}
	}
		
	public void generateSupermarketResults(String nameOfFile) throws IOException
	{
        PrintWriter writer = new PrintWriter(nameOfFile);
        
        writer.printf("Data For Supermarket %s\n", superName);
        writer.printf("Shopper ID      Start Time   End Time   Time Shopping   Checkout Time   Time In Store\n");

        int bigShopperTotalTime = 0;
        int fastShopperTotalTime = 0;
        int bigShopperCount = 0;
        int fastShopperCount = 0;

        Iterator<Shopper> iterator = doneShopping.iterator();
        
        while (iterator.hasNext())
        {
            Shopper shopper = iterator.next();
            writer.println(shopper);
            if(shopper instanceof BigShopper)
            {
                bigShopperTotalTime += shopper.getTotalTimeCheckingOut();
                bigShopperCount++;
            }
            else if(shopper instanceof FastShopper)
            {
                fastShopperTotalTime += shopper.getTotalTimeCheckingOut();
                fastShopperCount++;
            }
        }
        
        double avgBigShopperTime = bigShopperCount != 0 ? (double) bigShopperTotalTime / bigShopperCount : 0;
        double avgFastShopperTime = fastShopperCount != 0 ? (double) fastShopperTotalTime / fastShopperCount : 0;

        writer.printf("\nThe average time checking out on the Big Queue for %d Shoppers is %.2f minutes", bigShopperCount, avgBigShopperTime);
        writer.printf("\nThe average time checking out on the Fast Queue for %d Shoppers is %.2f minutes\n", fastShopperCount, avgFastShopperTime);

        writer.close();
	}

}
