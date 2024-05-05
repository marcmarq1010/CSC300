
public class Job implements Comparable<Job>
{
	private int id;
	private int arrivalTime;
	private int timeForJob;
	private int priority;
	private int startTime; 
	private int waitTime; 
	private int endTime;
	private static int idCounter = 1;
	
	public Job()
	{
		
	}
	
	public Job(int arrivalTime, int timeForJob, int priority)
	{
		setId();
		setArrivalTime(arrivalTime);
		setTimeForJob(timeForJob);
		setPriority(priority);
	}
	
	@Override
	public int compareTo(Job job)
	{
	    return this.priority - job.priority;
	}


	public int getId()
	{
		return id;
	}

	public void setId()
	{
		this.id = idCounter;
		idCounter++;
	}

	public int getArrivalTime()
	{
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}

	public int getTimeForJob()
	{
		return timeForJob;
	}

	public void setTimeForJob(int timeForJob)
	{
		this.timeForJob = timeForJob;
	}

	public int getPriority()
	{
		return priority;
	}

	public void setPriority(int priority)
	{
		this.priority = priority;
	}

	public int getStartTime()
	{
		return startTime;
	}

	public void setStartTime(int startTime)
	{
	    this.waitTime = startTime - this.arrivalTime;
	    
	    this.startTime = startTime;
	}

	public int getWaitTime()
	{
		return waitTime;
	}

	public void setWaitTime(int waitTime)
	{
		this.waitTime = waitTime;
	}

	public int getEndTime()
	{
		return endTime;
	}

	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
	}

	public static int getIdCounter()
	{
		return idCounter;
	}

	public static void setIdCounter(int idCounter)
	{
		Job.idCounter = idCounter;
	}
	
}
