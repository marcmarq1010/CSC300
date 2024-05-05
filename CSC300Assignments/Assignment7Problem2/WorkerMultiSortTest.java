import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class WorkerMultiSortTest
{

	public static void main(String[] args)
	{
		ArrayList<Worker> workers = new ArrayList<Worker>();
		
		Worker worker1 = new Worker(10, "Javier", 25000, "Programmer");
		Worker worker2 = new Worker(120, "Kwame", 45000, "Analyst");
		Worker worker3 = new Worker(210, "Teressa", 14000, "Programmer");
		Worker worker4 = new Worker(150, "Richard", 24000, "Engineer");
		Worker worker5 = new Worker(10, "Luis", 29000, "Programmer");
		Worker worker6 = new Worker(120, "Ali", 46000, "Analyst");
		Worker worker7 = new Worker(210, "Brenda", 9000, "Programmer");
		Worker worker8 = new Worker(150, "Patel", 22000, "Engineer");
		
		workers.add(worker1);
		workers.add(worker2);
		workers.add(worker3);
		workers.add(worker4);
		workers.add(worker5);
		workers.add(worker6);
		workers.add(worker7);
		workers.add(worker8);
		
		Collections.sort(workers);
		
		Iterator<Worker> iterWorkers = workers.iterator();
		
		while(iterWorkers.hasNext())
		{
			System.out.printf("%s",iterWorkers.next());
		}

		
	}

}
/*	
This class consists of the main method, as described below:
Create an ArrayList of type Worker
Add the following Workers to the ArrayList:
Worker(10, "Javier", 25000, “Programmer”)
Worker(120, "Kwame", 45000, “Analyst”)
Worker(210, "Teressa", 14000, “Programmer”))
Worker(150, "Richard", 24000, “Engineer)”
Worker(10, "Luis", 29000, “Programmer”))
Worker(120, "Ali", 46000, “Analyst”)
Worker(210, "Brenda", 9000, “Programmer”))
Worker(150, "Patel", 22000, “Engineer”)


Sort using the  WorkerMultiSortComparator.
Create an Iterator and print out the ArrayList using the Iterator
Output would look like this:
ID: 120  Name: Ali Salary: $46000 Job Title: Analyst
ID: 120  Name: Kwame Salary: $45000 Job Title: Analyst
ID: 150  Name: Patel Salary: $22000 Job Title: Engineer
ID: 150  Name: Richard Salary: $24000 Job Title: Engineer
ID: 10  Name: Luis Salary: $29000 Job Title: Programmer
ID: 10  Name: Javier Salary: $25000 Job Title: Programmer
ID: 210  Name: Brenda Salary: $9000 Job Title: Programmer
ID: 210  Name: Teressa Salary: $14000 Job Title: Programmer
*/
