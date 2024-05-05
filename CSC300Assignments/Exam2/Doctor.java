
public class Doctor
{
	public static int doctorCounter = 0; 	//	Has a static int variable doctorCounter set to 0
	private boolean isFree;					//	Has the boolean instance variable isFree
	
	//	Has the int instance variables doctorIDNumber, totalPatientsSeenByDoctor, timeRemainingForExam
	private int doctorIDNumber;
	private int totalPatientsSeenByDoctor;
	private int timeRemainingForExam;
	
	//	Has the reference variable assignedPatient of type Patient
	private Patient assignedPatient;

	//	Has a single default constructor 
	public Doctor()
	{
		setDoctorIDNumber(); 	//	Calls setDoctorIDNumber with no parameters
		setIsFree(true);		//	Calls setIsFree with true as the value of the parameter
	}
	
	/**	There are simple accessor (getXXX) methods
		for each of the five instance variables
	*/

	public boolean getIsFree()
	{
		return isFree;
	}

	//	setIsFree has a boolean parameter and a void return
	public void setIsFree(boolean isFree)
	{
		this.isFree = isFree;	//It sets isFree to the value of the parameter
	}

	public int getDoctorIDNumber()
	{
		return doctorIDNumber;
	}

	//	setDoctorIDNumber has no parameters and a void return
	public void setDoctorIDNumber()
	{
		doctorCounter++;						//	It increments the doctorCounter by 1
		doctorIDNumber = doctorCounter;			//	It sets the doctorIDNumber equal to the doctorCounter
	}

	public int getTotalPatientsSeenByDoctor()
	{
		return totalPatientsSeenByDoctor;
	}

	public void setTotalPatientsSeenByDoctor(int totalPatientsSeenByDoctor)
	{
		this.totalPatientsSeenByDoctor = totalPatientsSeenByDoctor;
	}

	public int getTimeRemainingForExam()
	{
		return timeRemainingForExam;
	}

	//	setTimeRemainingForExam has an int parameter and a void return
	public void setTimeRemainingForExam(int timeRemainingForExam)
	{
		this.timeRemainingForExam = timeRemainingForExam; 	//	set timeRemainingForExam to the value of the parameter
	}

	public Patient getAssignedPatient()
	{
		return assignedPatient;
	}

	//	setAssignedPatient has a reference to a Patient as the parameter and a void return
	public void setAssignedPatient(Patient assignedPatient)
	{
		this.assignedPatient = assignedPatient;	//	It sets the reference variable assignedPatient to the value of the parameter
		
		setIsFree(false);						//	It calls setIsFree with false as the parameter
	}
	
	//	removeAssignedPatient has no parameters and returns a reference to the assignedPatient
	public Patient removeAssignedPatient()
	{
		//	Create a temporary Patient reference variable tempPatient equal to the current assignedPatient for this Doctor
		Patient tempPatient = assignedPatient;
		
		//	Set the assignedPatient variable to null
		assignedPatient = null;
		
		//	Call setIsFree with the parameter true
		setIsFree(true);
		
		//	Increment totalPatientsSeenByDoctor by 1
		totalPatientsSeenByDoctor++;
		
		//	Return the value in the tempPatient reference variable
		return tempPatient;
	}
	
	//	decrementTimeRemainingForExam has no parameters and a void return
	public void decrementTimeRemainingForExam()
	{
		//	It decrements timeRemainingForExam by 1
		timeRemainingForExam--;
	}
	
	//	toString has no parameters and returns a String – (normal override)
	public String toString()
	{
		//	String should look like this (of course the numbers will be different)
		//	Doctor 17 examines 21 patients
		String str = String.format("Doctor %d examines %d patients", getDoctorIDNumber(), getTotalPatientsSeenByDoctor());
		
		return str;
	}
	
}
