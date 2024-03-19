import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class CreditCardTransactions 
{
	public static void main(String[] args) throws IOException
	{
		// Set up a Scanner to get input from the user
		Scanner keyboard = new Scanner(System.in);
		
		// Prompt the user to enter the name of the file to read from
		System.out.printf("Enter the name of the file to read from: \n");
		String inputFileName = keyboard.nextLine();
		
		// Create a File object with the specified filename
		File inputFile = new File(inputFileName);
		
		// Check if the file exists
		if (!inputFile.exists()) 
		{
			// If the file does not exist, print a message and exit the program
			System.out.printf("%s not found.\nClosing the program.", inputFileName);
			System.exit(0);
		}
		
		// Create a Scanner to read from the input file
		Scanner inputReader = new Scanner(inputFile);

		// Initialize variables to store the most expensive purchase information
		String mostExpensivePurchase = "";
		double maxAmount = Double.MIN_VALUE;

		// Iterate through each line in the input file
		while (inputReader.hasNext()) 
		{
			// Read a line from the file
			String line = inputReader.nextLine();
			
			// Split the line into parts using whitespace as a delimiter
			String[] parts = line.split("\\s+");

			// Check if there are exactly two parts (item and amount)
			if (parts.length == 2) 
			{
				// Extract the item and amount from the parts
				String purchase = parts[0];
				double amount = Double.parseDouble(parts[1]);

				// Check if the current purchase is more expensive than the previous maximum
				if (amount > maxAmount) 
				{
					// If yes, update the maximum purchase information
					maxAmount = amount;
					mostExpensivePurchase = purchase;
				}
			}
		}

			// Print the result of the most expensive purchase
			System.out.printf("The most expensive purchase was %s with an amount of %.2f.%n", mostExpensivePurchase, maxAmount);
			
		// Close the input file scanner
		inputReader.close();
		
		keyboard.close();
	}
}
