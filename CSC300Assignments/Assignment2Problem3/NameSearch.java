import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class NameSearch 
{
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.printf("Please enter the name of the boy's file: \n");
		String boysFileName = keyboard.nextLine();
		
		String[] boyNames = getArray(boysFileName);
		
		System.out.printf("Please enter the name of the girl's file: \n");
		String girlsFileName = keyboard.nextLine();
		
		String[] girlNames = getArray(girlsFileName);
		
		System.out.printf("Do you want to search for names? Enter Y or N: \n");
        String searchChoice = keyboard.nextLine().toUpperCase();
        
       do{
    	   System.out.printf("Enter a boy's name, or N if you do not wish to enter a boy's name: \n");
           String boyToSearch = keyboard.nextLine();

           System.out.printf("Enter a girl's name, or N if you do not wish to enter a girl's name: \n");
           String girlToSearch = keyboard.nextLine();
            
            if(!boyToSearch.equals("N") || !boyToSearch.equals("n"))
            {
            	if(isFound(boyToSearch, boyNames))
            	{
            		System.out.printf("%s is one of the most popular boy's names.\n",boyToSearch);
            	}
            	else
            	{
            		System.out.printf("%s is NOT one of the most popular boy's names.\n",boyToSearch);
            	}
            }
            if(!girlToSearch.equals("N") || !girlToSearch.equals("n"))
            {
            	if(isFound(girlToSearch, girlNames))
            	{
            		System.out.printf("%s is one of the most popular girl's names.\n", girlToSearch);
            	}
            	else 
            	{
            		System.out.printf("%s is NOT one of the most popular girl's names.\n", girlToSearch);
            	}
            }
            
            System.out.printf("Do you want to search for names? Enter Y or N: \n");
            searchChoice = keyboard.nextLine().toUpperCase();
            
        }while(searchChoice.equals("Y"));
       
       System.out.printf("Closing the program.");
       
       keyboard.close();
       
       System.exit(0);
	}
	
	public static String[] getArray(String fileName) throws IOException
	{
		//	Create a File object.
		File inputFile = new File(fileName);
		
		if(!inputFile.exists())
		{
			System.out.printf("%s not found.\nClosing the program.", inputFile);
			System.exit(0);
		}
		
		//	Call getNumNames to determine the number of items in the file with a reference to the File object as the parameter.
		int numberOfLines = getNumNames(inputFile);
		
		//	Create a separate Scanner based on the File object
		Scanner fileReader = new Scanner(inputFile);
		
        String[] listOfNames = new String[numberOfLines];
		
		//	Read the list of names using the Scanner into an array
		int index = 0;
		
        while(fileReader.hasNext())
        {
            listOfNames[index++] = fileReader.nextLine();
        }	
        
		//	Close the Scanner
		fileReader.close();
		
		//	Return a reference to the Array
		return listOfNames;
		
	}
	
	public static int getNumNames(File file) throws IOException
	{
		//	Create a Scanner based on this File object 
		Scanner readFile = new Scanner(file);
		
		int numOfLines = 0;
		
		while(readFile.hasNext())
		{
			//	Read in the lines one by one (this is a dummy read) in order to count the number of lines in the file (since I have one name per line). 
			readFile.nextLine();
			numOfLines++;
		}
		
		//	Close the Scanner
		readFile.close();
		
		//	Return the number of items in the file.
		return numOfLines;
		
	}
	
	public static boolean isFound(String name, String[] array)
    {
        for (String arrayName : array)
        {
            if (arrayName.equalsIgnoreCase(name))
            {
                return true;
            }
        }
        return false;
    }
	
}