import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class PrintQueueSimulation
{
	private PriorityQueue<Job> waitQueue;	
	private Queue<Job> finishedQueue;	
	
	private ArrayList<Printer> printers;	
	
	private int totalWaitTime; 			
	private int currentTime;			
	private int numberOfPrinters;
	private int numberOfPrintJobs;
	private Random randy;

	public PrintQueueSimulation()
	{
		
	}
	
	public PrintQueueSimulation(int numberOfPrintJobs, int numberOfPrinters, int seed)
	{
	    this.numberOfPrintJobs = numberOfPrintJobs;
	    this.numberOfPrinters = numberOfPrinters;
	    
	    randy = new Random(seed);
	    
	    waitQueue = new PriorityQueue<>(numberOfPrintJobs);
	    finishedQueue = new PriorityQueue<>(numberOfPrintJobs);
	    
	    // Create printer array
	    printers = new ArrayList<>();
	    
	    // Create printers
	    for (int i = 0; i < numberOfPrinters; i++)
	        printers.add(new Printer("Printer" + i));
	}
	
	public void simulate()
	{
	    boolean flagDone = false;

	    int jobNumber = 0;

	    while (!flagDone)
	    {
	        if (currentTime % 80 == 0 && jobNumber < numberOfPrintJobs)
	        {
	            int jobTime = randy.nextInt(10, 1101);
	            int jobPriority = randy.nextInt(1, 12);
	            
	            Job newJob = new Job(currentTime, jobTime, jobPriority);
	            waitQueue.add(newJob);
	            
	            jobNumber++;
	        }

	        for (Printer printer : printers)
	        {
	            if (printer.getPrintJob() != null)
	            {
	                if (printer.getPrintJob().getStartTime() + printer.getPrintJob().getTimeForJob() <= currentTime)
	                {
	                    printer.getPrintJob().setEndTime(currentTime);
	                    
	                    finishedQueue.add(printer.getPrintJob());
	                    
	                    printer.setPrintJob(null);
	                    
	                    printer.setStartIdleTime(currentTime);
	                }
	            }
	        }

	        for (Printer printer : printers)
	        {
	            if (printer.getPrintJob() == null)
	            {
	                if (!waitQueue.isEmpty())
	                {
	                    Job nextJob = waitQueue.poll();
	                    
	                    nextJob.setStartTime(currentTime);
	                    
	                    printer.setPrintJob(nextJob);
	                    
	                    printer.setStartInUseTime(currentTime);
	                    
	                    totalWaitTime += nextJob.getWaitTime();
	                }
	            }
	        }

	        currentTime++;

	        if (jobNumber >= numberOfPrintJobs && waitQueue.isEmpty())
	        	flagDone = true;

	        for (Printer printer : printers)
	        {
	            if (printer.getPrintJob() != null)
	            {
	                flagDone = false;
	                break;
	            }
	        }
	    }
	}

	
	public void displayStatistics() throws IOException
	{
	    Scanner scanner = new Scanner(System.in);

	    System.out.printf("Enter the name of your output file for the results:\n");
	    String outputFile = scanner.nextLine();

	    PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

	    writer.printf("Simulation Results:\n");
	    
	    writer.printf("Simulation with %s printers lasted %s seconds and processed %d jobs\n"
	    				 ,numberOfPrinters, totalWaitTime, numberOfPrintJobs);
	    
	    double averageWaitTime = (double) totalWaitTime / numberOfPrintJobs;
	    
	    writer.printf("The average time in the wait queue for a job is %.2f seconds\n", averageWaitTime);

	    writer.printf("\nPrinter Statistics\n");
	    
	    String statsHeader1 = String.format("%-10s%-12s%-10s%-7s", " ", "Jobs", "Time", "Idle");
	    String statsHeader2 = String.format("%-10s%-12s%-10s%-7s", "Name", "Processed", "In Use", "Time");

	    
	    writer.printf("%s\n",statsHeader1);
	    writer.printf("%s\n",statsHeader2);

	    
	    for (int i = 0; i < numberOfPrinters; i++)
	    {
	        Printer printer = printers.get(i);
	        
	        int idleTime = printer.getTotalIdleTime(currentTime);
	        int inUseTime = printer.getTotalInUseTime();
	        
	        String stats = String.format("%-10s%-12d%-10d%-7d\n", printer.getPrinterName(), printer.getTotalJobsProcessed(), inUseTime, idleTime);
	        
	        writer.printf("%s", stats);
	    }
	    
	    writer.printf("\n");

	    writer.printf("\nJob Statistics\n");
	    
	    String jobHeader = String.format("%-8s%-10s%-10s%-15s", "Job No.", "Priority", "Wait Time", "Length Of Job");
	    
	    writer.printf("%s\n", jobHeader);
	    
	    for (Job job : finishedQueue)
	    {	        
	        String aJob = String.format("%-8d%-10d%-10d%-15d", job.getId(), job.getPriority(), job.getWaitTime(), job.getTimeForJob());
	        
	        writer.printf("%s\n", aJob);
	    }
	    
	    scanner.close();
	    writer.close();
	}

}
