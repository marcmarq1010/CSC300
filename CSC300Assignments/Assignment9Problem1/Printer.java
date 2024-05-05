
public class Printer
{
	private Job printJob;
	private String printerName;
	private int startIdleTime;
	private int startInUseTime;
	private int totalIdleTime;
	private int totalInUseTime;
	private int totalJobsProcessed;
	
	public Printer()
	{
		
	}
	
	public Printer(String printerName)
	{
		setPrinterName(printerName);
	}

	public Job getPrintJob()
	{
		return printJob;
	}

	public void setPrintJob(Job printJob)
	{
		this.printJob = printJob;
	}

	public String getPrinterName()
	{
		return printerName;
	}

	public void setPrinterName(String printerName)
	{
		this.printerName = printerName;
	}

	public int getStartIdleTime()
	{
		return startIdleTime;
	}

	public void setStartIdleTime(int startIdleTime)
	{
	    this.totalInUseTime += (startIdleTime - this.startIdleTime);
	    
	    this.startIdleTime = startIdleTime;
	}

	public int getStartInUseTime()
	{
		return startInUseTime;
	}

	public void setStartInUseTime(int startInUseTime)
	{
	    totalJobsProcessed++;
	    
	    this.startInUseTime = startInUseTime;
	}


	public int getTotalIdleTime(int currentTime)
	{
	    totalIdleTime = currentTime - totalInUseTime;
	    
	    return totalIdleTime;
	}

	public void setTotalIdleTime(int totalIdleTime)
	{
		this.totalIdleTime = totalIdleTime;
	}

	public int getTotalInUseTime()
	{
		return totalInUseTime;
	}

	public void setTotalInUseTime(int totalInUseTime)
	{
		this.totalInUseTime = totalInUseTime;
	}

	public int getTotalJobsProcessed()
	{
		return totalJobsProcessed;
	}

	public void setTotalJobsProcessed(int totalJobsProcessed)
	{
		this.totalJobsProcessed = totalJobsProcessed;
	}
	
}
