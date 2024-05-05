import java.io.IOException;
import java.util.Scanner;

//	class ModelEmergencyFacility (throws an IOException)
public class ModelEmergencyFacility
{
	public static void main(String[] args) throws IOException
	{
		//	Create a Scanner to read keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		String name, fileName;
		int seed, numDoctors, durationForArriving;
		
		//	Request and read in the name of the EmergencyFacility ( using nextLine()), a seed, and the number of Doctors
		System.out.printf("Please enter the name of the Emergency Facility:\n");
		name = keyboard.nextLine();
		
		System.out.printf("Please enter a seed value as an int:\n");
		seed = keyboard.nextInt();
		
		System.out.printf("Please enter the number of doctors as an int:\n");
		numDoctors = keyboard.nextInt();
				
		//	Create a new EmergencyFacility with those 3 values as parameters
		EmergencyFacility emergencyFacility = new EmergencyFacility(name, seed, numDoctors);
		
		//	Call openEmergencyFacility for the just created EmergencyFacility with no parameters
		emergencyFacility.openEmergencyFacility();
		
		//	Request and read in the number of minutes to keep the EmergencyFacility open for newly arriving Patients (durationForArriving).
		System.out.printf("Please enter the number of minutes to keep the Emergency Facility open:\n");
		durationForArriving = keyboard.nextInt();
		
		keyboard.nextLine();

		//	Call operateEmergencyFacility for the EmergencyFacility created with durationForArriving in minutes as the parameter
		emergencyFacility.operateEmergencyFacility(durationForArriving);
		
		//	Request and read in the name of the output file (a String)
		System.out.printf("Please enter the name of the output file for Emergency Facility results:\n");
		fileName = keyboard.nextLine();
		
		//	Call generateEmergencyFacilityResults for the EmergencyFacility created with the name of the output file as a parameter
		emergencyFacility.generateEmergencyFacilityResults(fileName);
		
		keyboard.close();
	}
	
}

/**


Sample Interactive Input:
Please enter the name of the Emergency Facility: 
6 
Please enter a seed value as an int: 
6
Please enter the number of doctors as an int: 
50
Please enter the number of minutes to keep the Emergency Facility open: 
60
Please enter the name of the output file for Emergency Facility results: 
efoutput.txt
*/

