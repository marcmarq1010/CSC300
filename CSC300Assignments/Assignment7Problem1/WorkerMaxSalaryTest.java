import java.util.ArrayList;
import java.util.Collections;

public class WorkerMaxSalaryTest
{

	public static void main(String[] args)
	{
		ArrayList<Worker> workers = new ArrayList<Worker>();

		Worker worker1 = new Worker(10, "Maya", 25000, "Engineer");
		Worker worker2 = new Worker(120, "Jose", 45000, "Programmer");
		Worker worker3 = new Worker(210, "Abdul", 14000, "Analyst");
		Worker worker4 = new Worker(150, "Elissa", 24000, "Manager");
		
		workers.add(worker1);
		workers.add(worker2);
		workers.add(worker3);
		workers.add(worker4);
		
		Collections.sort(workers);
		
		Worker maxSalaryWorker = workers.getFirst();
		
		System.out.printf("Worker with max salary: ");
		
		System.out.printf("%s\n", maxSalaryWorker);
		
	}
	
}
