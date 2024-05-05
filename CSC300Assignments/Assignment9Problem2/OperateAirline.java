import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OperateAirline
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		
		Scanner keyboard = new Scanner(System.in);
		
		String flightName, fileName;
		int seed;
		
		for(int i = 0; i < 3; i++)
		{
			System.out.printf("Please enter the Flight Name:\n");
			flightName = keyboard.nextLine();
			
			System.out.printf("Please enter an integer seed from 1 to 50:\n");
			seed = keyboard.nextInt();
			
			keyboard.nextLine();
			
			Flight flight = new Flight(flightName, seed);
			
			flightList.add(flight);
		}
		
		System.out.printf("Please enter the name of the output file: \n");
		fileName = keyboard.nextLine();
		
		PrintWriter outputFile = new PrintWriter(fileName);
		
		for (Flight flight : flightList)
		{
		    flight.sellSeats();
		    flight.lineUpCall();
		    flight.boarding(outputFile);
		    outputFile.println();
		    outputFile.println();
		}
		
		keyboard.close();
		
		outputFile.close();
	}
}
