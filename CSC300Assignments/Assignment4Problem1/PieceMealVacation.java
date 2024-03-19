import java.util.Arrays;

public class PieceMealVacation extends Vacation
{
	
	private String[] items;	//	the list of items on the vacation
	private double[] costs;	//	the corresponding price of each item

    public PieceMealVacation(String destination, double budget, String[] items, double[] costs)
	{
		super(destination, budget);
		setItems(items);
        setCosts(costs);
	}

	public String[] getItems() 
	{
		return items;
	}

	public void setItems(String[] items) 
	{
	    this.items = new String[items.length];
	    
	    for (int i = 0; i < items.length; i++) 
	    {
	        this.items[i] = items[i];
	    }
	}

	public double[] getCosts()
	{
		return costs;
	}

	public void setCosts(double[] newCosts) 
	{
		this.costs = new double[items.length];
		
        for (int i = 0; i < items.length; i++) 
        {
        	if (i < newCosts.length)
        	{
        		this.costs[i] = newCosts[i];
        	}
            else 
            {
                this.costs[i] = 0.0;
            }
        }
	}
	
	@Override
    public double overBudget() 
	{
        double totalCost = 0.0;
        
        for (double cost : costs) 
        {
            totalCost += cost;
        }
        
        return totalCost - getBudget();
    }

	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
		if (!(obj instanceof PieceMealVacation))
		{
			return false;
		}
		
		PieceMealVacation vacation = (PieceMealVacation) obj;
		
		if (!Arrays.equals(items, vacation.items))
		{
			return false;
		}
		
		// Compare costs with tolerance of 0.0001
		for (int i = 0; i < costs.length; i++) 
		{
			if (Math.abs(costs[i] - vacation.costs[i]) >= 0.0001)
			{
				return false;
			}
		}
		
		return true;
	}
	@Override
	public String toString() 
	{
	    String result = super.toString() + "\n";
	    
	    for (int i = 0; i < items.length; i++) 
	    {
	        result += items[i] + ": $" + String.format("%.2f", costs[i]) + "\n";
	    }
	    
	    return result;
	}	
}
