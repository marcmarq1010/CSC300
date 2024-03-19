import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SatConstellation 
{
	private String satConstellationName;
	private Country country;
	private ArrayList<Satellite> satelliteList = new ArrayList<Satellite>();

	public SatConstellation() 
	{
		setSatConstellationName("unknown");
		country = new Country();
	}
	
	public SatConstellation(String SatConstellationName, String countryName) throws IOException
	{
		setSatConstellationName(SatConstellationName);
		country = new Country(countryName);
		createSatellites();
	}
	
	public void createSatellites() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.printf("Please enter file to read in Satellite List from:\n");
		String satelliteNamesFile = keyboard.nextLine();
		
		File inputFile = new File(satelliteNamesFile);
		
		if(!inputFile.exists())
		{
			System.out.printf("%s not found.\nClosing the program.", inputFile);
			System.exit(0);
		}
		
		Scanner fileReader = new Scanner(inputFile);
		
		while(fileReader.hasNext())
		{
			String name = fileReader.nextLine();
			
			Satellite satellite = new Satellite(name);
			
			satelliteList.add(satellite);
		}
		
		keyboard.close();
		fileReader.close();
	}
	
	public int getNumSatellites()
	{
		return satelliteList.size();
	}
	
	public Satellite getSatellite(int index)
	{
		
		if(index >= satelliteList.size())
		{
			System.out.printf("Satellite doesn't exist.\n");
			return null;
		}
		else
		{
			return satelliteList.get(index);
		}
		
	}

	public String getSatConstellationName() 
	{
		return satConstellationName;
	}

	public void setSatConstellationName(String satConstellationName) 
	{
		this.satConstellationName = satConstellationName;
	}

	public Country getCountry()
	{
		return country;
	}

	public void setCountry(Country country) 
	{
		this.country = country;
	}

	@Override
	public String toString() 
	{
		return "The name of " + getCountry().getCountryName() + "'s satellite constellation is " +  getSatConstellationName() + ".\n";
	}
	
}
