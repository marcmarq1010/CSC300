
public class Executive extends Manager	//	Executive extends Manager, but an Executive only supervises an Employee who is a manager
{
	private int idNumber;		 //	An Executive ID number ranges from 3001 to 3500. 
	private double totalComp = 0.0;
	
	 public Executive(String name, String jobTitle, int idNumber, int age, double salary)
	 {
		 super(name, jobTitle, idNumber, age, salary);
	 }
	
	public void setTotalComp(double companyProfits, double bonusPercentage)
	{
		double bonus = companyProfits * (1 + bonusPercentage/100);
        totalComp = getSalary() + bonus;
	}
	
	public double getTotalComp()
	{
		return totalComp;
	}

	@Override
	public String toString() 
	{
	    return String.format("%-20s%-20s%-10s%-10s%-10s%-10s", getName(), getJobTitle(), getIdNumber(), getAge(), getSalary(), getTotalComp());
	}
	
}
