
public class Country 
{
	private String countryName;
	
	public Country()
	{
		setCountryName("unknown");
	}
	
	public Country(String name)
	{
		setCountryName(name);
	}
	
	public String getCountryName() 
	{
		return countryName;
	}

	public void setCountryName(String countryName) 
	{
		this.countryName = countryName;
	}

	@Override
	public String toString() 
	{
		return "The Country for the Constellation is " + countryName + ".\n";
	}
	
}
