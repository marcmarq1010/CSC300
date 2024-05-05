import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class EmergencyFacility
{
	//	This class has the following instance variables:
	private Random randy; 							//	A Random variable randy
	private PriorityQueue<Patient> waitingQ; 		//	A PriorityQueue of type Patient called waitingQ
	private ArrayList<Patient> processedPatients = new ArrayList<Patient>();	//	An ArrayList of type Patient called processedPatients - may be instantiated in variable declaration or in the constructor)
	private Doctor[] doctors;						//	An array of type Doctor called doctors (remember this is an array, not an ArrayList))
	private String facilityName; 					//	A String variable facilityName
	private int currentTime = 0;					//	An int variable currentTime set to 0
	
	//	It has a single constructor with three parameters: 
	//	String name, int seed, int numDoctors
	public EmergencyFacility(String name, int seed, int numDoctors)
	{
		//	It simple sets facilityName to name (You can do this without calling a mutator)
		facilityName = name;
		
		PatientPriority patientPriority = new PatientPriority();
		
		//	It creates the waitingQ object using a new instance of PatientPriority as the parameter, 
		//	ensuring that waitingQ prioritizes according to PatientPriority rules
		waitingQ = new PriorityQueue<Patient>(patientPriority);
		
		//	It creates a Random object called randy based on the seed
		randy = new Random(seed);
		
		//	It calls createDoctors with numDoctors as the parameter
		createDoctors(numDoctors);
	}
	
	//	createDoctors has a single int parameter called numDoctors and a void return
	public void createDoctors(int numDoctors)
	{
		//	It creates the doctors array with a length equal to the value of numDoctors
		doctors = new Doctor[numDoctors];
		
		//	For each reference in the array it creates a Doctor (Remember that the Doctor constructor has no parameters)
		for(int i = 0; i < doctors.length; i++)
			doctors[i] = new Doctor();
	}
	
	//	openEmergencyFacility has no parameters and a void return
	public void openEmergencyFacility()
	{
		while(currentTime < 10) //This simulates early arriving Patients
		{
			//	Generate a random number of type int from 1 to 20
			//	(inclusive meaning all of 1 through 20 using randy) 
			//	and use it below 
			int number = randy.nextInt(1,21);
			
			if(number < 8)
			{
				//	Create and add an UrgentPatient to the waitingQ with the currentTime 
				UrgentPatient urgentPatient = new UrgentPatient(currentTime);
				waitingQ.add(urgentPatient);
			}
			else if(number < 16)
			{
				//	Create and add a SeverePatient to the waitingQ with the currentTime 
				SeverePatient severePatient = new SeverePatient(currentTime);
				waitingQ.add(severePatient);
			}
			else
			{
				//	Create and add a NominalPatient to the waitingQ with the currentTime
				NominalPatient nominalPatient = new NominalPatient(currentTime);
				waitingQ.add(nominalPatient);
			}
			currentTime++;	
		}
	}
	
	//	operateEmergencyFacility has a parameter int called durationForArriving and a void return
	public void operateEmergencyFacility(int durationForArriving)
	{
		
		//	Create an int variable endArrivalsTime and set it equal to the sum of the currentTime and durationForArriving
		int endArrivalsTime = currentTime + durationForArriving;
		
		//	TODO: Create any necessary temporary variables for this method i.e. tempPatient
		
		//	while the size of processedPatients does not equal the Patient.idCounter or the currentTime is less than the endArrivalsTime (note: all arrivals get processed this way)
		while(processedPatients.size() != Patient.idCounter || currentTime < endArrivalsTime)
		{
			//if the currentTime is less than the endArrivalsTime 
			//This simulates arriving Patients until the office doors close
			if(currentTime < endArrivalsTime)
			{	
				//	TODO: Do 6 times 
				for(int i = 0; i < 6; i++)
				{
					//	Generate a random number of type int from 1 to 20 (inclusive meaning all of 1 through 20 using randy) and use it below
					int randomNumber = randy.nextInt(1, 21);
					
					//	if the random number is less than 7
					if(randomNumber < 7)
					{
						//	Create and add an UrgentPatient to the waitingQ with the currentTime
						UrgentPatient tempPatient = new UrgentPatient(currentTime);
						waitingQ.add(tempPatient);
					}
					//	else if the random number is less than 14
					else if(randomNumber < 14)
					{
						//	Create and add an SeverePatient to the waitingQ with the currentTime 
						SeverePatient tempPatient = new SeverePatient(currentTime);
						waitingQ.add(tempPatient);
					}
					else
					{
						//	Create and add an NominalPatient to the waitingQ with the currentTime	
						NominalPatient tempPatient = new NominalPatient(currentTime);
						waitingQ.add(tempPatient);
					}
				}
				//	Now check on the busy Doctors
				
				//	for each Doctor referenced in the doctors array
				for(Doctor doctor : doctors)
				{
					//	if the Doctor isn’t free (i.e. getIsFree returns false)
					if(!doctor.getIsFree())
					{
						//	Call decrementTimeRemainingForExam() for this Doctor
						doctor.decrementTimeRemainingForExam();
						
						//	if the timeRemainingForExam for this Doctor is 0
						if(doctor.getTimeRemainingForExam() == 0)
						{
							//	Retrieve the reference to the Patient currently assigned to this Doctor
							//	(use a tempPatient variable to capture the reference and the method getAssignedPatient())
							Patient tempPatient = doctor.getAssignedPatient();
							
							//`Add that tempPatient to the processedPatients ArrayList
							processedPatients.add(tempPatient);
							
							//	Call setTotalTimeAtEmergencyFacility for this tempPatient with the currentTime
							tempPatient.setTotalTimeAtEmergencyFacility(currentTime);
							
							// `Call removeAssignedPatient() for this Doctor
							doctor.removeAssignedPatient();
						}
					}
				}
			
				//Now Assign Patients to free Doctors. Note: this section must come after the above section
		
				//	for each Doctor referenced in the doctors array
				for(Doctor doctor : doctors)
				{
					//	if isFree is true for the Doctor (i.e. getIsFree returns true) and the waitingQ is not empty
					if(doctor.getIsFree() && !waitingQ.isEmpty())
					{
						//	Remove a Patient from the waitingQ (use a tempPatient variable to capture  the reference)
						Patient tempPatient = waitingQ.remove();
						
						//	Call setDoctorStartTime for tempPatient with the currentTime
						tempPatient.setDoctorStartTime(currentTime);
		
						//	For this Doctor call setAssignedPatient with a reference tempPatient just removed from the waitingQ
						doctor.setAssignedPatient(tempPatient);
						
						//	Use randy to help get a number from 10 to 25 minutes (inclusive) calling it examDuration 
						int examDuration = randy.nextInt(10, 26);
						
						//	Call setExamDuration for the tempPatient with examDuration as the parameter
						tempPatient.setExamDuration(examDuration);
						
						//	Call setTimeRemainingForExam for this Doctor with this examDuration as the value the parameter
						doctor.setTimeRemainingForExam(examDuration);
					}
				}
			}
			
			//	Increment currentTime by 1.  Note this happens inside the while loop just before looping
			currentTime++;
		}
		
	}
	
	//	generateEmergencyFacilityResults has a String parameter representing the physical output file and returns a void (remember the throws IOException)
	public void generateEmergencyFacilityResults(String fileName) throws IOException
	{
		// Create a PrintWriter based on the physical output file name in the method’s parameter list.
	    PrintWriter writer = new PrintWriter(fileName);

	    // Print the title (i.e., Data For Emergency Facility)
	    writer.printf("Data For Emergency Facility %s\n", facilityName);

	    // Print the summary data
	    writer.println("Summary Data");
	    for (Doctor doctor : doctors)
		        writer.printf("Doctor %d examines %d patients\n", doctor.getDoctorIDNumber(), doctor.getTotalPatientsSeenByDoctor());

	    // Calculate and print the average total time per patient for each type and for all patients
	    double totalUrgentTime = 0;
	    double totalSevereTime = 0;
	    double totalNominalTime = 0;
	    double totalTime = 0;
	    int urgentPatientsCount = 0;
	    int severePatientsCount = 0;
	    int nominalPatientsCount = 0;
	    int totalPatientsCount = 0;

	    for (Patient patient : processedPatients)
	    {
	        if(patient instanceof UrgentPatient)
	        {
	        	totalUrgentTime += patient.getTotalTimeAtEmergencyFacility();
	        	urgentPatientsCount++;
	        } 
	        else if(patient instanceof SeverePatient)
	        {
	        	totalSevereTime += patient.getTotalTimeAtEmergencyFacility();
	            severePatientsCount++;    
	        }
	        else if(patient instanceof NominalPatient)
	        {
	        	totalNominalTime += patient.getTotalTimeAtEmergencyFacility();
	            nominalPatientsCount++;   
	        }    
	        
	        totalTime += patient.getTotalTimeAtEmergencyFacility();
        	totalPatientsCount++;	
	    }

		    // Calculate averages
		    double averageUrgentTime = totalUrgentTime / urgentPatientsCount;
		    double averageSevereTime = totalSevereTime / severePatientsCount;
		    double aveageNominalTIme = totalNominalTime / nominalPatientsCount;
		    double averageTotalTime = totalTime / totalPatientsCount;

		    writer.printf("Average total time at Emergency Facility per Urgent Patient: %.2f minutes\n", averageUrgentTime);
		    writer.printf("Average total time at Emergency Facility per Severe Patient: %.2f minutes\n", averageSevereTime);
		    writer.printf("Average total time at Emergency Facility per Nominal Patient: %.2f minutes\n", aveageNominalTIme);
		    writer.printf("Average total time at Emergency Facility per Patient: %.2f minutes\n", averageTotalTime);

		    // Print the table of all patients
		    writer.printf("%-15s, %-15s, %-15s, %-15s, %-15s, %-15s\n"
		    			 ,"Patient ID"
		    			 ,"Patient Type"
		    			 ,"Arrival Time"
		    			 ,"Wait Time"
		    			 ,"Exam Time"
		    			 ,"Total Time");
		    
		    Iterator<Patient> iterator = processedPatients.iterator();
		    
		    while (iterator.hasNext())
		    {
		        Patient patient = iterator.next();
		        writer.printf("%-15s %-15s %-15d %-15d %-15d %-15d\n"
		        			 , patient.getPatientID()
		        			 , patient.getPatientType()
		        			 , patient.getArrivalTimeAtEmergencyFacility()
		        			 , patient.getWaitTime()
		        			 , patient.getExamDuration()
		        			 , patient.getTotalTimeAtEmergencyFacility());
		    }

		    // Close the PrintWriter
		    writer.close();
		}
	
}
