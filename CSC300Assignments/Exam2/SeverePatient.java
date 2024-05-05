
//	class SeverePatient is a subclass of Patient
public class SeverePatient extends Patient
{
	private String patientID;	//	Has a String instance variable patientID
	
	//	Has a single constructor with an int parameter indicating the arrivalTime
	public SeverePatient(int arrivalTime)
	{
		super(arrivalTime);			//	Calls super with arrivalTime as the parameter
		setPatientType("SEVERE");	//	Calls setPatientType  with “SEVERE ” as the parameter
		setPatientID();				//	Calls setPatientID with no parameters
	}
	
	public int compareTo(Patient p)
	{
        return this.getArrivalTimeAtEmergencyFacility() - p.getArrivalTimeAtEmergencyFacility();
	}
	
	//	There is a normal accessor getPatientID that overrides the abstract version of this method
	public String getPatientID()
	{
		return patientID;
	}

	//	setPatientID has no parameters and a void return – this is an override of the abstract method setPatientID
	public void setPatientID()
	{
		Patient.idCounter++;		//	It increments the static variable idCounter declared in Patient
		
		/**
			It sets patientID to the concatenation of  the patientType, and the Patient.idCounter 
			Note: a patientID might look like this SEVERE 15 
		 */
		patientID = String.format("%s %d", getPatientType(), idCounter);
	}
	
}
