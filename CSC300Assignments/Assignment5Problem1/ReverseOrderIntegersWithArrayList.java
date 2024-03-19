import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ReverseOrderIntegersWithArrayList 
{
	
	static Scanner keyboard = new Scanner(System.in);
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException
	{
		
		OpenAndReadFile();
		
		sortArray();
						
		System.out.printf("Output Using Enhanced For:\n");
		
		printArrayEcnhancedFor();
		
		System.out.printf("Output Using The Iterator:\n");
		
		printArrayIterator();
		
		keyboard.close();
	
	}
	
	public static void OpenAndReadFile() throws IOException
	{
		
		File inputFile;
		String nameOfFileToBeRead;
		
		do{
			System.out.printf("Please enter the file name containing a list of integers: \n");
			nameOfFileToBeRead = keyboard.next();
		
			inputFile = new File(nameOfFileToBeRead);
		
		}while((!inputFile.exists()));	
		
		Scanner fileReader = new Scanner(inputFile);
		
		while(!(fileReader.hasNext()))
		{
			System.out.printf("There is no data in the file.\n"
					 		 +"Please enter the file name containing a list of integers:\n");
		}

		while(fileReader.hasNext())
		{
			list.add(fileReader.nextInt());
		}
		
		fileReader.close();		
		
	}
	
	public static void sortArray()
	{
		
		for(int i = 0; i < list.size(); i++)
		{
			for (int j = 0; j < list.size() - i - 1; j++)
			{
                // Swap if the current element is less than the next element
                if (list.get(j) < list.get(j + 1))
                {
                    // Swap list[j] and list[j+1]
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
		}
		
	}
	
	public static void printArrayEcnhancedFor()
	{
		for(int numbers : list)
		{
			System.out.println(numbers);
		}
	}
	
	public static void printArrayIterator()
	{
		Iterator<Integer> numbers = list.iterator();
		
		while(numbers.hasNext())
		{
			System.out.println(numbers.next());
		}
	}
	
}


/*
Hints: 
You will need to use a Wrapper class.
Read the first element into the ArrayList.
Read in additional integers until you reach the end of the file, inserting each number into the array list as you read it in. 
This is a true insertion sorting.
Do Not use the Collections.sort method for this problem, use the add method of ArrayList

Sample input/output:
Please enter the file name containing a list of integers: integerlist.txt
Output Using Enhanced For:
74
11
11
8
7
5
4
3
0
-1
Output Using The Iterator:
74
11
11
8
7
5
4
3
0
-1

*/