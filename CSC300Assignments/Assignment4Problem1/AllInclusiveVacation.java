
public class AllInclusiveVacation extends Vacation
{
	
	private String brand;
	private int rating;		//	from 1 to 5
	private double price;

	public AllInclusiveVacation(String destination, double budget, String brand, int rating, double price) 
	{
		super(destination, budget);
		setBrand(brand);
		setRating(rating);
		setPrice(price);
	}

	public String getBrand() 
	{
		return brand;
	}

	public void setBrand(String brand) 
	{
		this.brand = brand;
	}

	public int getRating() 
	{
		return rating;
	}

	public void setRating(int rating)
	{
		if(rating >= 1 && rating <= 5)
		{
			this.rating = rating;
		}
		else
		{
			throw new IllegalArgumentException( "Rating must be > 0 and <= 5");
		}	
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		if(price >= 0.0)
		{
			this.price = price;
		}
		else
		{
			throw new IllegalArgumentException( "Price must be >= 0.0");
		}
	}

	@Override
	public double overBudget() 
	{
		return getPrice() - getBudget();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
	    if (!super.equals(obj)) 
	    {
	        return false;
	    }

	    if (!(obj instanceof AllInclusiveVacation))
	    {
	        return false;
	    }

	    AllInclusiveVacation vac = (AllInclusiveVacation) obj;

        return rating == vac.rating && Double.compare(vac.price, price) == 0 && brand.equalsIgnoreCase(vac.brand);
	}


	@Override
	public String toString()
	{
	    return super.toString() + String.format("\nBrand: %s; Rating: %d; Price: $%.2f", brand, rating, price);
	}

}
