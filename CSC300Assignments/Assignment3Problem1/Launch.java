import java.io.IOException;
import java.util.Scanner;

public class Launch 
{
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		String nameOfCountry, nameOfSatConstellation;
		
		System.out.printf("Please enter the name of the Country:\n");
		nameOfCountry = keyboard.nextLine();
		
		
		System.out.printf("Please enter the name of the Satellite Constellation:\n");
		nameOfSatConstellation = keyboard.nextLine();
		
		SatConstellation sat = new SatConstellation(nameOfSatConstellation,  nameOfCountry);
		
		System.out.print(sat);
		
		for(int i = 0; i < sat.getNumSatellites(); i++)
		{
			System.out.print(sat.getSatellite(i));
		}
		
		
		boolean matchingSatellites = false;
		
		if(sat.getNumSatellites() > 1)
		{
			
			for(int j = 1; j < sat.getNumSatellites(); j++)
			{
				
				if(sat.getSatellite(0).getSatelliteOrbitHeight() == sat.getSatellite(j).getSatelliteOrbitHeight())
				{
					matchingSatellites = true;
					
					System.out.printf("The satellite named %s has a maximum orbital height of %d miles "
									 +"and equals the first satellite in the ArrayList.\n"
									 , sat.getSatellite(j).getSatelliteName(), sat.getSatellite(j).getSatelliteOrbitHeight());
				}

			}
			
			if(matchingSatellites == false)
			{
				System.out.printf("There is no satellite that matches the first satellite.\n");
			}
			
			sat.getSatellite(sat.getNumSatellites() - 1).setSatelliteName(sat.getSatellite(0).getSatelliteName());
			sat.getSatellite(sat.getNumSatellites() - 1).setSatelliteOrbitHeight((sat.getSatellite(0).getSatelliteOrbitHeight()));
			
			if(sat.getSatellite(0).getSatelliteOrbitHeight() == sat.getSatellite(sat.getNumSatellites() - 1).getSatelliteOrbitHeight())
			{
				
				System.out.printf("The satellite named %s has a maximum orbital height of %d miles "
								 +"and equals the first satellite in the ArrayList.\n"
								 , sat.getSatellite(0).getSatelliteName(), sat.getSatellite(sat.getNumSatellites() - 1).getSatelliteOrbitHeight());
			}
			
		}
		else
		{
			System.out.printf("There are no satellites to compare.\n");
		}
		

		keyboard.close();
	}
	
}
