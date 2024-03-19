import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class URL 
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
        String originalURL;
        String extractedName;
        
        //	Prompt the user to enter the name of the file to read from
     	System.out.printf("Enter the name of the file to write to: \n");
     	String outputFileName = keyboard.nextLine();

        // Create a PrintWriter to write to the output file
        PrintWriter outputWriter = new PrintWriter(outputFileName);

        // Iterate through each line in the input file
        while (inputReader.hasNext()) 
        {
            // Read the original URL from the file
            originalURL = inputReader.nextLine();

            // Call extractName with a reference to the URL and accept the returned reference String value
            extractedName = extractName(originalURL);

            // Print out the original URL and the returned value to the output file
            outputWriter.printf("Original URL: %s, Extracted Name: %s%n", originalURL, extractedName);
            
            System.out.printf("Original URL: %s, Extracted Name: %s%n", originalURL, extractedName);
        }

        // Close the input and output file scanners
        inputReader.close();
        outputWriter.close();
        
        keyboard.close();
	}
	
	public static String extractName(String URL)
	{
		// Assuming the URL format is www.name.com, extract the name
        String[] parts = URL.split("\\.");

        return parts[1];
	}
}
