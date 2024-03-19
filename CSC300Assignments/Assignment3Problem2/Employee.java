
public class Employee 
{
	private String name;		//	NO BLANKS
	private String jobTitle;	//	NO BLANKS
	private int idNumber;		//	An Employee ID has a value of 1 to 2000.
	private int age;			
	private double salary; 
	
	public Employee()
	{
		
	}
	
	public Employee(String name, String jobTitle, int idNumber, int age, double salary)
	{
		this.name = name;
		this.jobTitle = jobTitle;
		this.idNumber = idNumber;
		this.age = age;
		this.salary = salary;
	}
	
	public void changeSalary(double percentageForChange)
	{
		setSalary((getSalary() + (getSalary() * percentageForChange/100.0)));
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getJobTitle() 
	{
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) 
	{
		this.jobTitle = jobTitle;
	}

	public int getIdNumber() 
	{
		return idNumber;
	}

	public void setIdNumber(int idNumber) 
	{
		this.idNumber = idNumber;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary) 
	{
		this.salary = salary;
	}

	@Override
	public String toString() 
	{
	    return String.format("%-20s%-20s%-10s%-10s%-10s", getName(), getJobTitle(), getIdNumber(), getAge(), getSalary());
	}


}
