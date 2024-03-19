import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContractorSortTest
{

	public static void main(String[] args) throws IOException
	{
		
		ArrayList<Contractor> contractorList = new ArrayList<Contractor>();
		
		Scanner keyboard = new Scanner(System.in);
				
		System.out.printf("Enter the name of the file to read from: \n");
		String inputFileName = keyboard.nextLine();
				
		File inputFile = new File(inputFileName);
				
		if (!inputFile.exists()) 
		{
			System.out.printf("%s not found.\nClosing the program.", inputFileName);
			System.exit(0);
		}
		
		Scanner fileToBeRead = new Scanner(inputFile);
		
		while(fileToBeRead.hasNext())
		{
			Contractor contractor = new Contractor(fileToBeRead.next(), fileToBeRead.next(), fileToBeRead.nextInt());
			
			contractorList.add(contractor);
		}
		
		keyboard.close();
		
		fileToBeRead.close();
		
		System.out.printf("\nList Sorted By Contractor Name:\n");
		Collections.sort(contractorList, new ComparatorSortName());
        printArrayList(contractorList);
		
		
		System.out.printf("\nList Sorted By Location:\n");
		Collections.sort(contractorList, new ComparatorSortLocation());
        printArrayList(contractorList);
		
		System.out.printf("\nList Sorted By OwnerID:\n");
		Collections.sort(contractorList, new ComparatorSortOwnerID());;
        printArrayList(contractorList);
		
		System.out.printf("\nList Sorted By MultiSorted:\n");
		Collections.sort(contractorList, new ComparatorMultiSort());
        printArrayList(contractorList);
		
	}
	
	public static void printArrayList(ArrayList<Contractor> list)
	{
		for(Contractor con : list)
		{	
			System.out.println(con);
		}
	}

}
