import java.util.Random;

public class Satellite 
{
	private static Random randy = new Random(6);
	private String satelliteName;	
	private int satelliteOrbitHeight;	
	
	public Satellite()
	{
		setSatelliteName("unknown");
	}
	
	public Satellite(String name)
	{
		setSatelliteName(name);
		setSatelliteOrbitHeight(randy.nextInt(150, 261));
	}
	
	//	An equals method that compares two satellites based on both name and orbital height.

	public String getSatelliteName()
	{
		return satelliteName;
	}

	public void setSatelliteName(String satelliteName) 
	{
		this.satelliteName = satelliteName;
	}

	public int getSatelliteOrbitHeight() 
	{
		return satelliteOrbitHeight;
	}

	public void setSatelliteOrbitHeight(int satelliteOrbitHeight) 
	{
		this.satelliteOrbitHeight = satelliteOrbitHeight;
	}

	@Override
	public String toString() 
	{
		return "The satellite named " + satelliteName +" has an orbital height of " + satelliteOrbitHeight + " miles.\n";
	}
	
}
