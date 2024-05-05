
public class Worker implements Comparable<Worker>
{
	private int id;
	private String name;
	private int salary;
	private String jobTitle;
	
	public Worker(int id, String name, int salary, String jobTitle)
	{
		setId(id);
		setName(name);
		setSalary(salary);
		setJobTitle(jobTitle);
	}

	public int compareTo(Worker w)
	{
		return w.getSalary() - this.getSalary();
	}

	public String toString()
	{
		return String.format("ID: %d Name: %5s Salary: $%,d Job Title: %s\n", getId(), getName(), getSalary(), getJobTitle());
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(Integer salary)
	{
		this.salary = salary;
	}

	public String getJobTitle()
	{
		return jobTitle;
	}

	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}

}
