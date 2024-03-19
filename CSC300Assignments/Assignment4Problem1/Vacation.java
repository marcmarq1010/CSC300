
abstract class Vacation 
{
	protected String destination;
	private double budget;
	
	public Vacation(String destination, double budget)
	{
		setDestination(destination);
		setBudget(budget);
	}

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination) 
	{
		this.destination = destination;
	}

	public double getBudget() 
	{
		return budget;
	}

	public void setBudget(double budget) 
	{
		if(budget >= 0 )
		{
			this.budget = budget;
		}
		else
		{
			throw new IllegalArgumentException("Budget must be >= 0.0");
		}
	}
	
	public abstract double overBudget();

	@Override
	public boolean equals(Object obj) 
	{
	    if(!(obj instanceof Vacation))
	    {
	    	return false;
	    }
	    
	    Vacation vac = (Vacation) obj;
	    return destination.equalsIgnoreCase(vac.destination) && Math.abs(budget - vac.budget) < 0.0001;
	}

	@Override
	public String toString() 
	{
	    return String.format("Destination: %s; Budget: $%.2f", destination, budget);
	}
}

/*
The equals() is overridden with a value of true if the destinations are the same (ignore the case) and the budgets are within 0.0001.
*/