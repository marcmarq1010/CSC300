
//	class Nominal is a subclass of Patient
public class NominalPatient extends Patient
{
	private String patientID;	//	Has a String instance variable patientID

	//	Has a single constructor with an int parameter indicating the arrivalTime
	public NominalPatient(int arrivalTime)
	{
		super(arrivalTime);			//	Calls super with arrivalTime as the parameter
		setPatientType("NOMINAL");	//	Calls setPatientType  with “NOMINAL ” as the parameter
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
			Note: a patientID might look like this NOMINAL 196 
		 */
		patientID = String.format("%s %d", getPatientType(), idCounter);

	}
	
}
