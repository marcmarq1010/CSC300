import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class BusinessTest 
{
	private static ArrayList<Employee> employeeAL = new ArrayList<Employee>();
	private static ArrayList<Manager> managerAL = new ArrayList<Manager>();
	private static ArrayList<Executive> executiveAL = new ArrayList<Executive>();
	
	static Scanner keyboard = new Scanner(System.in);

	
	public static void main(String[] args) throws IOException
	{
		
		File inputFile = OpenInputFile();
		readFile(inputFile);
		assignEmployees();
				
		System.out.printf("Please enter the total company profit for the year: \n");
        double profits = keyboard.nextDouble();

		System.out.printf("Please enter the executive bonus percentage for the year correct to 1 decimal place: \n");
        double bonus = keyboard.nextDouble();
        
        keyboard.nextLine();
		
		System.out.printf("Please enter the name of the output file: \n");
        String outputFileName = keyboard.nextLine();

		writeFile(profits, bonus, outputFileName);
		
		System.out.printf("Please enter the salary change for a Manager as a percentage: \n");
        double salaryChangePercentage = keyboard.nextDouble();
       
        raiseManagerSalaries(salaryChangePercentage);
        
		printManagerRaises(managerAL);
	
        keyboard.close();
        
	}
	
	public static File OpenInputFile() throws IOException
	{		
		System.out.printf("Please enter the name of the input file with employee name and data: \n");
		String inputFileName = keyboard.nextLine();
		
		File inputFile = new File(inputFileName);
		
		if(!inputFile.exists())
		{
			System.out.printf("%s not found.\nClosing the program.", inputFileName);
			keyboard.close();
			System.exit(0);
		}
				
		return inputFile;
	}
	
	public static void readFile(File inputFile) throws IOException
	{
		Scanner inputReader = new Scanner(inputFile);
		
		while (inputReader.hasNextLine()) 
		{	
			String name = inputReader.next();
			String jobTitle = inputReader.next();
			int idNumber = inputReader.nextInt();
			int age = inputReader.nextInt();
			Double salary = inputReader.nextDouble();
			//inputReader.next();
		    
		    if (idNumber >= 1 && idNumber <= 2000) 
		    {
		    	Employee employee = new Employee(name, jobTitle, idNumber, age, salary);
                employeeAL.add(employee);
		    } 
		    else if (idNumber >= 2001 && idNumber <= 3000) 
		    {
		    	Manager manager = new Manager(name, jobTitle, idNumber, age, salary);
		    	managerAL.add(manager);
		    } 
		    else if (idNumber >= 3001 && idNumber <= 3500) 
		    {
		    	Executive executive = new Executive(name, jobTitle, idNumber, age, salary);
		    	executiveAL.add(executive);
		    }
		}
		
		inputReader.close();
	}
	
	public static void writeFile(double profits, double bonus, String outputFileName) throws IOException
	{
		PrintWriter writer = new PrintWriter(outputFileName);
		
		double totalPayroll = 0;
		
		writer.printf("The total payroll for the business is %,.2f\n\n", totalPayroll);
		
		writer.printf("Compensation Table\n");
		
		// Call the method for each type of employee
		printEmployeeDetails(executiveAL, "Executives", writer);
		writer.printf("\n");
		printEmployeeDetails(managerAL, "Managers", writer);
		writer.printf("\n");
		printEmployeeDetails(employeeAL, "Employees", writer);
		writer.printf("\n");
		writer.printf("\nReporting Structure\n");
		writer.printf("\n");
		printDirectReports(executiveAL, "Executive", writer);
		writer.printf("\n");
		printDirectReports(managerAL, "Manager", writer);
		
		writer.close();
	}
	
	public static void printEmployeeDetails(ArrayList<? extends Employee> employees, String rank, PrintWriter writer)
	{
		writer.printf("%s\n", rank);
		writer.printf("%-20s%-20s%-10s%-10s%-10s%-10s\n", "Name", "Title", "ID", "Age", "Salary", "Total Comp");
	    for (Employee emp : employees) 
	    {
	    	writer.println(emp);
	    }
	}
	
	public static void printDirectReports(ArrayList<? extends Employee> employees, String rank, PrintWriter writer) 
	{
		writer.printf("Direct Reports To %s\n", rank);
		
		if (rank.equalsIgnoreCase("Executive"))	
	    {	    	
	    	for (Employee emp : employees) 
		    {
		    	Executive executiveBoss = (Executive) emp;
		    	writer.printf("%s %s has the following direct reports:\n", rank, emp.getName());
	
		        for (int i = 0; i < executiveBoss.getManagedEmployeesListSize(); i++) 
		        {
		        	writer.printf(executiveBoss.getManagedEmployeeAtIndex(i) + "\n");
		        }
		        
		        writer.printf("\n");
		    }
	    } 
	    else if (rank.equalsIgnoreCase("Manager"))
	    {	    	
	    	for (Employee emp : employees) 
		    {
		    	Manager executiveBoss = (Manager) emp;
		    	writer.printf("%s %s has the following direct reports:\n", rank, emp.getName());
	
		        for (int i = 0; i < executiveBoss.getManagedEmployeesListSize(); i++) 
		        {
		            writer.printf(executiveBoss.getManagedEmployeeAtIndex(i) + "\n");
		        }
		        
		        writer.printf("\n");

		    }
	    } 
	}
		
	public static void printManagerRaises(ArrayList<Manager> managerAL)
	{
		for (Manager man : managerAL) 
	    {
	        System.out.printf("The manager name and title are %s %s.\n", man.getName(), man.getJobTitle());
	        
	        System.out.printf("The manager ID is %d. The manager age is %d.\n", man.getIdNumber(), man.getAge());
	        
	        System.out.printf("The manager salary is $%,.2f\n\n", man.getSalary());
	    }
	}
			
	public static void assignEmployees()
	{
		int index = 0;
		
		for (Employee employee : employeeAL) 
		{
			managerAL.get(index % managerAL.size()).addsManagedEmployee(employee);
			index++;
		}
		
		index = 0;
		
		for (Manager manager : managerAL) 
		{
			executiveAL.get(index % executiveAL.size()).addsManagedEmployee(manager);
			index++;
		}
	}
	
	public static void raiseManagerSalaries(double salaryChangePercentage)
	{
		for(Manager man : managerAL)
		{
			man.changeSalary(salaryChangePercentage);
		}

	}
	
}
