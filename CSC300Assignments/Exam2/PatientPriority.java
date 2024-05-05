import java.util.Comparator;

//	class PatientPriority implements the Comparator interface for Patient
public class PatientPriority implements Comparator<Patient>
{

	public int compare(Patient p1, Patient p2)
	{
		// Cast p to UrgentPatient to access its specific fields/methods

	    // Reverse the natural order of patientType
	    // Compare "URGENT" with "SEVERE" and "NOMINAL"
		
		if(p1.getPatientType().equals(p2.getPatientType()))
			return p1.compareTo(p2);
		else if(p1.getPatientType().equals("URGENT"))
			return 1; // URGENT should precede other types 
	    else if(p1.getPatientType().equals("SEVERE"))
	    {
	        if (p1.getPatientType().equals("URGENT"))
	        {
	            return -1; // SEVERE should come after URGENT
	        }
	        else
	        {
	            return 1; // SEVERE should precede NOMINAL
	        }
	    }
	    else
	    	return -1; // NOMINAL should come after SEVERE and URGENT
	}

	/**
		Note: The idea is that an UrgentPatient has higher priority than SeverePatient who has higher priority than a Nominal.
		This class has one method compare with two parameters, both of which are references to Patient objects.
		
		If the two Patients are of the same patientType (you can use compareTo you wrote for each Patient here),
		the one who arrived earlier has a higher priority. This means return a negative,
		0 or positive value based on the difference in the arrivalTimeAtEmergencyFacility between the first and second Patient. 
		
		Otherwise use the result of compareTo for the two Patients to obtain the return value
	 */


}
