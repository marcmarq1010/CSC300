import java.util.Comparator;

public class ComparatorSortLocation implements Comparator<Contractor>
{

	@Override
	public int compare(Contractor con1, Contractor con2)
	{
        return con1.getLocation().compareTo(con2.getLocation());
	}

}
