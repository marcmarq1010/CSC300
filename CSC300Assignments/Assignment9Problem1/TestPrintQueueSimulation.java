import java.io.IOException;
import java.util.Scanner;

public class TestPrintQueueSimulation
{
	
	public static void main(String[]args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		
		int numOfPrinters, numOfJobs, seed;
		
		System.out.printf("Please enter the number of printers for the simulation: ");
		numOfPrinters = keyboard.nextInt();
		
		System.out.printf("\nPlease enter the number of printer jobs for the simulation: ");
		numOfJobs = keyboard.nextInt();
		
		System.out.printf("\nPlease enter a random number seed for the simulation: ");
		seed = keyboard.nextInt();
		
		System.out.println();
		
		PrintQueueSimulation sim = new PrintQueueSimulation(numOfJobs, numOfPrinters, seed);
		
		sim.simulate();
		
		sim.displayStatistics();

		keyboard.close();
	}
	
}
