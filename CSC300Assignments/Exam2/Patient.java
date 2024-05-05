
//	abstract class Patient implements the Comparable interface for Patient
public abstract class Patient implements Comparable<Patient>
{
	public static int idCounter = 0;	//	Has a public static int variable idCounter set to 0.
	
	//	Has int instance variables arrivalTimeAtEmergencyFacility,
	//	doctorStartTime, waitTime, examDuration, totalTimeAtEmergencyFacility
	private int arrivalTimeAtEmergencyFacility;
	private int doctorStartTime;
	private int waitTime;
	private int examDuration;
	private int totalTimeAtEmergencyFacility;
	
	private String patientType;			//	Has a String instance variable patientType
	
	//	Has a single constructor with a parameter for arrivalTime which
	//	Calls setArrivalTimeAtEmergencyFacility with the arrivalTime from the constructor as the parameter
	public Patient(int arrivalTime)
	{
		setArrivalTimeAtEmergencyFacility(arrivalTime);
	}
	
	/**
		There are the following 3 abstract methods
	 */
	
	//	setPatientID has no parameters and a void return
	public void setPatientID()
	{
		
	}
	//	getPatientID has no parameters and returns a String
	public String getPatientID()
	{
		return "";
	}
	
	public int compareTo(Patient p)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**	There are simple accessor (getXXX) methods 
		for each of the six instance variables
	 */

	public int getArrivalTimeAtEmergencyFacility()
	{
		return arrivalTimeAtEmergencyFacility;
	}

	//	The mutator method for setArrivalTimeAtEmergencyFacility accepts an int parameter and has a void return
	//	It sets the arrivalTimeAtEmergencyFacility equal to the input parameter value
	public void setArrivalTimeAtEmergencyFacility(int arrivalTimeAtEmergencyFacility)
	{
		this.arrivalTimeAtEmergencyFacility = arrivalTimeAtEmergencyFacility;
	}

	public int getDoctorStartTime()
	{
		return doctorStartTime;
	}

	//	The setDoctorStartTime accepts an int with the doctorStartTime as the parameter and has a void return
	//	It sets the doctorStartTime equal to the input parameter
	//	It sets the waitTime as the difference between the doctorStartTime and the arrivalTimeAtEmergencyFacility
	public void setDoctorStartTime(int doctorStartTime)
	{
		this.doctorStartTime = doctorStartTime;
		setWaitTime(getDoctorStartTime() - getArrivalTimeAtEmergencyFacility());
	}

	public int getWaitTime()
	{
		return waitTime;
	}
				
	public void setWaitTime(int waitTime)
	{
		this.waitTime = waitTime;
	}

	public int getExamDuration()
	{
		return examDuration;
	}
	
	//	The mutator method for setExamDuration accepts an int parameter and has a void return
	//	It sets the examDuration equal to the input parameter value
	public void setExamDuration(int examDuration)
	{
		this.examDuration = examDuration;
	}

	public int getTotalTimeAtEmergencyFacility()
	{
		return totalTimeAtEmergencyFacility;
	}

	//	The setTotalTimeAtEmergencyFacility method accepts an int with the endTime as a parameter and has a void return
	//	It sets the totalTimeAtEmergencyFacility to the difference between the endTime and the arrivalTimeAtEmergencyFacility
	public void setTotalTimeAtEmergencyFacility(int endTime)
	{
		totalTimeAtEmergencyFacility = endTime - getArrivalTimeAtEmergencyFacility();
	}

	public String getPatientType()
	{
		return patientType;
	}

	//	The setPatientType method accepts a String reference to the patientType as the parameter and has a void return
	//	It sets patientType to the parameter (a reference variable)
	public void setPatientType(String patientType)
	{
		this.patientType = patientType;
	}

}
