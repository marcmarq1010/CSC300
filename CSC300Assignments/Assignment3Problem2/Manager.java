import java.util.ArrayList;

public class Manager extends Employee	
{
	private int idNumber;		//	A Manager ID number ranges from 2001 to 3000.
	private ArrayList<Employee> managedEmployees = new ArrayList<Employee>();
	
	public Manager(String name, String jobTitle, int idNumber, int age, double salary)
    {
        super(name, jobTitle, idNumber, age, salary);
    }
	
	public void addsManagedEmployee(Employee employee)
	{
		managedEmployees.add(employee);
	}
	
	public int getManagedEmployeesListSize()
	{
		return managedEmployees.size();
	}
	
	public Employee getManagedEmployeeAtIndex(int i)
	{
		return managedEmployees.get(i);
	}

	@Override
	public String toString() 
	{
	    return String.format("%-20s%-20s%-10s%-10s%-10s", getName(), getJobTitle(), getIdNumber(), getAge(), getSalary());
	}

}
