import java.util.Comparator;

public class WorkerMultiSortComparator implements Comparator<Worker>
{

	@Override
	public int compare(Worker w1, Worker w2)
	{		
		if(w1.getJobTitle().compareTo(w2.getJobTitle()) == 0)
			return Integer.compare(w1.getName().length(), w2.getName().length());
		else
			return w1.getJobTitle().compareTo(w2.getJobTitle());
	}

}
